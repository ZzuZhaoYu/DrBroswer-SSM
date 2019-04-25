$(function(){
    var n=document.getElementById("hosname1").value;
    alert(document.getElementById("hosname1").value);
    $.ajax({
        type:"post",
        url:"remote/"+ $("#id").val() +"/modifyRemoteReportPatDetail",
        data:{hosname1: n},
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


            $("#modality").val(pro.modality);
            $("#x").val(pro.docName);
            $("#c").val(pro.verifyDocName);
            $("#z").val(pro.reportDate);

        }
    });
});
