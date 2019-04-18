$(function(){
    var n="1";//随便给值
    $.ajax({
        type:"post",
        url:"remote/"+ $("#id").val() +"/modifyRemoteReportPatDetail",
        data:{hosname1: n},//随便给值只是因为用不到这个值，这个值是给书写报告和审核报告用的
        dataType:"html",
        async:false,
        success:function(data){
            alert(data);
            var pro=null;
            pro = eval("("+data+")");
            $("#hosName").text(pro.hosNamewrite);
            $("#deptName").val(pro.deptName);
            $("#clinicId").val(pro.clinicId);
            $("#bedNo").val(pro.bedNo);
            $("#jcbw").val(pro.jcbw);
            $("#sfyangxing").val(pro.sfyangxing);
            $("#examDesc").val(pro.examDesc);
            $("#examDiagnosis").val(pro.examDiagnosis);
            $("#imagePath").attr("href","DrViewerBoot://" + pro.imagePath);
        }
    });
});
