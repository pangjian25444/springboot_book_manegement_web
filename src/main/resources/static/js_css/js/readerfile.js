/*修改用户范围*/
$(".btn_update").click(function () {
    /*查询用户类型*/
    getReadtype(".reader_update_type");
    /*查询当前用户信息*/
    getReaderOne($(this).attr("edit-id"));
    $(".readerUpdateModel").modal({
        backdrop :"static",
    });
});
/*查询用户类型*/
function getReadtype(ele) {
    $(ele).empty();
    $.ajax({
        url:"readtype",
        type:"GET",
        success:function (result) {
            var readtype = result.extend.readtypeAll;
            $.each(readtype,function (index,item) {
                $("<option></option>").append(item.typename).attr("value",item.typeid).appendTo(".reader_update_type");
            });
        }
    });
}
/*查询单个用户信息*/
function getReaderOne(id) {
    $.ajax({
        url:"/readerone/"+id,
        type:"GET",
        success:function (result) {
            showReader(result);
        }
    });
};
/*修改单个用户*/
$(".btn_update_reader").click(function () {
    $.ajax({
        url:"readerone/"+$(".btn_update").attr("edit-id"),
        type:"PUT",
        data:  $(".update_reader form").serialize(),
        success:function (result) {
            alert(result.msg)
            $("#readerUpdateModel").modal('hide');
            window.location.href="readerall";
        }

    });
});
/*展示单个读者信息*/
function showReader(result) {
    var reader = result.extend.readers;
    /*rid*/
    $("#reader_update_rid").val(reader.rid);
    /*名字*/
    $("#reader_update_name").val(reader.name)
    /*性别*/
    if (reader.sex==1){
        $("#reader_update_sex1").attr('checked', 'checked');
    }else {
        $("#reader_update_sex2").attr('checked', 'checked');
    }
    /*条码号*/
    $("#reader_update_barcode").val(reader.barcode)
    /*读者类型*/
    $(".reader_update_type").val([reader.typeid])
    /*生日*/
    $("#reader_update_birthday").val(reader.birthday)
    /*有效证件*/
    $("<option></option>").append(reader.papertype).attr("value",reader.papertype).appendTo(".reader_update_papertype");
    /*证件号码*/
    $("#reader_update_paperno").val(reader.paperno)
}

/*删除范围*/
$(".btn_delete").click(function () {
    var name = $(".btn_delete").parents("tr").find("td:eq(1)").text();
    if (confirm("确定要删除"+name+"吗"))
        $.ajax({
            url:"readerone/"+$(".btn_delete").attr("edit-id"),
            type:"DELETE",
            success:function (result) {
                if (result.code==100){
                    alert(result.msg);
                } else {
                    alert(result.msg+"，还有书籍未归还");
                }
            }
        });
});
window.onload=function(){
    $("#example-navbar-collapse ul").children("li:eq(0)").attr("class","active");
};