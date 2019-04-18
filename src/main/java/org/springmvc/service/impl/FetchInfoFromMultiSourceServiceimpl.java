package org.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmvc.pojo.RegisterInfo;
import org.springmvc.pojo_inner.RegisterInfoInner;
import org.springmvc.pojo_junior.RegisterInfoJunior;
import org.springmvc.service.FetchInfoFromMultiSourceService;
import org.springmvc.tool.MultiDataSourcePool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class FetchInfoFromMultiSourceServiceimpl implements FetchInfoFromMultiSourceService {
    @Autowired
    private MultiDataSourcePool multiDataSourcePool;

    @Override
    public List<RegisterInfoJunior> getCheckedListByHosId(String id) {
        if(id == null){
            return null;
        }
        try (Connection c = multiDataSourcePool.getConnection(id)) {
            if(c != null){
                List<RegisterInfoJunior> l = new ArrayList<>();
                PreparedStatement p = (PreparedStatement) c.prepareStatement("select * from register_info");
                ResultSet rs = p.executeQuery();
                while (rs.next()){
                    RegisterInfoJunior r = new RegisterInfoJunior(rs.getString("CheckNum"),
                            rs.getString("RecordID"), rs.getDate("RegisterTime"),
                            rs.getString("OperatorCode"), rs.getBoolean("PayFlag"),
                            rs.getBigDecimal("PayCount"), rs.getInt("PatTypeCode"),
                            rs.getString("ClinicID"), rs.getString("PatientID"),
                            rs.getString("PatName"), rs.getString("PatNamePy"),
                            rs.getString("PatGender"), rs.getDate("PatBirthdate"),
                            rs.getString("Address"), rs.getString("YiBaoID"),
                            rs.getString("IdentityID"), rs.getString("Telephone"),
                            rs.getString("PatRoomCode"), rs.getString("BedNo"),
                            rs.getString("ExamItemCode"), rs.getString("Flag"),
                            rs.getString("DeptCode"), rs.getBoolean("NewPatient"),
                            rs.getInt("Age"), rs.getString("PatRoomName"),
                            rs.getString("DeptName"), rs.getString("ExamItemName"),
                            rs.getString("AgeType"), rs.getDate("PhotoDate"),
                            rs.getString("MakerCode"), rs.getString("MakerName"),
                            rs.getString("ExamNameCode"), rs.getString("ExamNameName"),
                            rs.getString("DevCode"), rs.getString("DevName"),
                            rs.getBoolean("IfUsingFlag"), rs.getString("IsDicomFlag"),
                            rs.getString("cardno"),rs.getString("jcbw"),
                            rs.getString("jclb"), rs.getString("sjmd"),
                            rs.getString("jcsf"), rs.getString("lczd"),
                            rs.getString("sqdbh"), rs.getString("isRegist"),
                            rs.getString("xuhao"), rs.getString("isPrint"),
                            rs.getString("StudyID"), rs.getString("district"),
                            rs.getString("nowOperator"));
                    l.add(r);
                }
                return l;
            }else {
                return null;
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateJuniorHosReport() {
        return 0;
    }
}
