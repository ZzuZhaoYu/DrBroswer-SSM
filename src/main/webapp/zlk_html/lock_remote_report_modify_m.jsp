<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="zlk_js/lock_remote_report_modify_m.js"></script>
    <link rel="stylesheet" href="jsTree/theme/style.min.css" />
    <link rel="stylesheet" href="zlk_css/report_write_m.css" />
</head>
<body>
<div class="bjui-pageContent">
    <div class="writeReport">
        <input id="id" type="hidden" value="${param.id}" />
        <div class="reportHead">
            <div class="icon"><img src="images/redcross.png" /></div>
            <div class="hostitle"><span id="hosName"></span></div>

            <div style="float: right;margin-right: 320px"><input id="modality" style="width: 32px;border-top-width: 0px;padding-top: 0px;border:none;margin-bottom: 2px;"/>检查报告单</div>
            <input type="hidden" id="hosname1" value="${param.hosName}">

        </div>
        <hr width="750" align="center">
        <div class="patientInfo">
            <div class="row_1">
                <div class="patName">姓名：<input id="pat_name" type="text" value="${param.patName}" size="10" readonly="" /></div>
                <div class="patGender">性别：<input id="pat_gender" type="text" value="${param.patGender}" size="10" readonly="" /></div>
                <div class="patAge">年龄：<input id="pat_age" type="text" value="${param.patAge}" size="10" readonly="" /></div>
                <div class="patCheckNum">检查号：<input id="pat_checknum" type="text" value="${param.checknum}" size="10" readonly="" /></div>
                <div class="keshi">科室：<input id="deptName" type="text" size="10" readonly=""/></div>
            </div>
            <div class="row_2">
                <div class="zhuyuanhao">住院号：<input id="clinicId" type="text" size="10" readonly=""/></div>
                <div class="chuanghao">床号：<input id="bedNo" type="text" size="10" readonly=""/></div>
                <div class="jcbw">检查部位：<input id="jcbw" type="text" size="15" readonly=""/></div>
                <div class="yinoryangxing">阴/阳性：<input id="sfyangxing" type="text" size="15" readonly=""/></div>
            </div>
        </div>
        <hr width="750" align="center">
        <div style="margin-left:12%;">
            <label class="row-label">影像所见：</label><br/>
            <textarea id="examDesc" rows="12" cols="65" readonly=""></textarea><br/>
            <label class="row-label">印象：</label><br/>
            <textarea id="examDiagnosis" rows="12" cols="65" readonly=""></textarea>
        </div>

        <div style="margin-right: 55px;margin-top: 20px ;float: right">报告日期：<input id="z" type="text"  size="10" readonly="" /></div>
        <div style="margin-left: 100px;margin-top: 20px ;float: left">报告医师：<input id="x" type="text"  size="10" readonly="" /></div>
        <div style="margin-left: 340px;margin-top: 20px">审核医师：<input id="c" type="text"  size="10" readonly="" /></div>
    </div>
</div>
</body>
</html>

