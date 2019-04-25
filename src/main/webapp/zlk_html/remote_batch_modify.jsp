<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    $("#ok").click(function (){
        BJUI.ajax('doajax',{
            url: "remote/save_modify?patName=" + $("#pat_name").val()+"&patGender="+$("#pat_gender").val()+"&patient_Age="+$("#pat_age").val()+
                "&examItemName="+$("#pat_checknum").val()+"&hosName="+$("#hosName").val()+"&CheckNum="+$("#checkNum").val()+"&checkDate="+$("#checkDate").val(),
            okalert:false,
            loadingmask:true,
            callback: function(data) {
                alert(data);
                var pro = null;
                pro = eval("(" + data + ")");
                // var info = pro.info;
                // var url_path = pro.url;
                if (data == 0) {
                    BJUI.alertmsg('error', '未操作成功！请重新尝试！');
                } else {
                    BJUI.alertmsg('ok', '提交成功！');
                    alert("123");
                    // $("#batch").attr("href", url_path);
                    // alert(url_path);
                }
            }
        });
    });
</script>

<div class="patientInfo" style="margin-left: 85px;margin-top: 30px">
    <div class="row_1">
        <div class="checkNum">检查号：<input id="checkNum" type="text" value="${param.checkNum}" size="15" readonly="" style="margin-left: 15px"/></div>
        <div class="patName">姓名：<input id="pat_name" type="text" value="${param.patName}" size="15" style="margin-left: 30px"/></div>
        <div class="patGender">性别：<input id="pat_gender" type="text" value="${param.patGender}" size="15" style="margin-left: 30px"/></div>
        <div class="patAge">年龄：<input id="pat_age" type="text" value="${param.patient_Age}" size="15" style="margin-left: 30px"/></div>
        <div class="patCheckNum">检查项目：<input id="pat_checknum" type="text" value="${param.examItemName}" size="15" style="margin-left: 3px"/></div>
        <div class="keshi">所属医院：<input id="hosName" type="text"  value="${param.hosName}" size="15"style="margin-left: 3px"/></div>
        <div class="checkDate">检查日期：<input id="checkDate" type="text" value="${param.checkDate}" size="15" readonly="" style="margin-left: 3px"/></div>
        <button type="button" class="btn-orange" id="ok">确认更改</button>
    </div>
</div>
