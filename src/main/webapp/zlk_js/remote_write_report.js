$(function(){
    // alert("5");
    // alert($("#bgCode").val());
    alert("222");
    var n=document.getElementById("hosname1").value;
    var m=document.getElementById("pat_checknum").value;
    // alert(data);
    $.ajax({
        type:"post",
        url:"remote/"+ $("#bgCode").val() +"/backedModifyRemoteReportPatDetail",
        data:{hosname1: n,checknum:m},
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
            $("#suggestion_text_p").text(pro.suggestion);


            $("#modality").val(pro.modality);
            $("#x").val(pro.docName);
            $("#c").val(pro.verifyDocName);
            $("#z").val(pro.reportDate);

        }
    });
});



$("#submitReport").click(function(){
    // alert($("#hosName").val());
    BJUI.ajax('doajax',{
        url:"remote/submitReport?examDesc=" + $("#examDesc").val()
        + "&examDiagnosis=" + $("#examDiagnosis").val()
        + "&pat_checknum=" + $("#pat_checknum").val()
        + "&deptName=" + $("#deptName").val()
        + "&clinicId=" + $("#clinicId").val()
        + "&bedNo=" + $("#bedNo").val()
        + "&jcbw=" + $("#jcbw").val()
        + "&sfyangxing=" + $("#sfyangxing").val()
        + "&hosName=" + $("#hosname1").val()
        + "&pat_name=" + $("#pat_name").val()
        + "&pat_gender=" + $("#pat_gender").val()
        + "&pat_age=" + $("#pat_age").val()
        +"&suggestion=" +$("#suggestion_text_p").val()
        +"&id=" +$("#bgCode").val() +"&hosNameWrite="+ $("#hosName").text(),
        okalert:false,
        loadingmask:true,
        callback: function(data) {
            alert(data);
            if(data == 1){
                BJUI.alertmsg('ok', '提交成功！');
            }else{
                BJUI.alertmsg('error','未操作成功！请重新尝试！');
            }
        }
    });
});
$("#qingkong").click(function(){
    // $("#examDesc").empty();
    // $("#examDiagnosis").empty();
    $("#examDesc").val("");
    $("#examDiagnosis").val("");
});
$("#tihuan").click(function(){
    var examDesc = $("#examDesc_text_p").text();
    var examDiagnosis = $("#examDiagnosis_text_p").text();
    // $("#examDesc").empty();
    // $("#examDiagnosis").empty();
    // $("#examDesc").append(examDesc);
    // $("#examDiagnosis").append(examDiagnosis);
    $("#examDesc").val("");
    $("#examDiagnosis").val("");
    $("#examDesc").val(examDesc);
    $("#examDiagnosis").val(examDiagnosis);
});
$("#zhuijia").click(function(){
    var examDesc_old = $("#examDesc").val();
    var examDiagnosis_old = $("#examDiagnosis").val();
    var examDesc = $("#examDesc_text_p").text();
    var examDiagnosis = $("#examDiagnosis_text_p").text();
    $("#examDesc").val(examDesc_old+"\r\n" + examDesc);
    $("#examDiagnosis").val(examDiagnosis_old+"\r\n" + examDiagnosis);
});