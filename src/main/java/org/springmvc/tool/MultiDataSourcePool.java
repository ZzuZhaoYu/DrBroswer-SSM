package org.springmvc.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springmvc.dao.SourceMapper;
import org.springmvc.pojo.Source;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MultiDataSourcePool {

    /**
     * @Filed： 使用HashMap维护数据库连接，每个数据源对应一个LinkedList数据连接。
     * */
    private static HashMap<String, LinkedList<Connection>> linkConnectionsMap = new HashMap<>();

    private static int connectionsCount;

    @Autowired
    private SourceMapper sourceMapper;  //自动装载数据源dao

    public Connection getConnection(final String id) throws SQLException, ClassNotFoundException{
        if(linkConnectionsMap == null || linkConnectionsMap.size() <= 0){
            System.out.println("初始化数据源连接池......");
            if(initConnectionsMap() == 0)
                return null;
        }
        final LinkedList<Connection> sources = linkConnectionsMap.get(id);    //向数据源中获取相应ID的数据连接
        if(sources == null) {
            System.out.println("数据源中无SourceID: " + id);
            return null;
        }else if (sources.size() > 0){
            final Connection conn = sources.removeFirst();
            return (Connection) Proxy.newProxyInstance(MultiDataSourcePool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(!method.getName().equals("close")){
                        return method.invoke(conn, args);
                    }else {
                        if(conn != null){
                            sources.add(conn);
                            System.out.println("Conn中断连接，SourceID：" + id + "数据库连接池获取空闲连接，当前可用连接数：" + sources.size());
                        }
                        return null;
                    }
                }
            });
        }else{
            System.out.println("数据库源中SourceID: " + id + "的连接已被占用完，请稍后再试");
            return null;
        }
    }

    /**
     * @return: 如果数据库连接中没有可用数据源，返回int 0; 如果有连接，则尝试建立连接，并返回建立成功个数
     * */
    private int initConnectionsMap() throws ClassNotFoundException{
        List<Source> sourceList = sourceMapper.getAllSource();  //从数据库获取所有可用数据源连接
        if(sourceList.size() <= 0){
            System.out.println("数据源配置库中无可用数据源，中止初始化......");
            return 0;
        }else {
            for(Source source : sourceList){
                LinkedList<Connection> l = new LinkedList<Connection>();
                System.out.println("正常尝试建立SourceID: " + source.getId() + "; SourceIP: " + source.getIp() + "的连接池");
                try{
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://" + source.getIp() + ":1433;DatabaseName=zhilikangDrPacs";
                    for(int i = 0; i < 10; i++){
                        Connection conn = DriverManager.getConnection(url, source.getAccount(), source.getPwd());
                        System.out.println("SourceID: " + source.getId() + ",已建立连接数：" + i);
                        l.add(conn);
                    }
                    ++connectionsCount;
                }catch (SQLException e){
                    e.printStackTrace();
                }
                linkConnectionsMap.put(source.getId(), l);
            }
            return connectionsCount;
        }
    }
}
