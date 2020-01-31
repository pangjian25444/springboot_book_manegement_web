window.onload=function(){
    $("#example-navbar-collapse ul").children("li:eq(4)").attr("class","active");
};
/*隐藏一些div*/
$(".show_reader").parents("div").css("display","none");
$("#bookinfo").css("display","none");

/*查询范围*/
/*查询读者信息并且携带图书信息*/
$(".btn_query_reader").click(function () {
    var barcode = $("#reader_search_box input[name=barcode]").val();
    if (barcode != ""){
        $.ajax({
            url:"/readeronebarcode/"+barcode,
            type:"GET",
            success:function (result) {
                if (result.extend.reader!=null){
                    /*展示隐藏框*/
                    $(".show_reader").parents("div").css("display","block");
                    $("#bookinfo").css("display","block");
                    /*显示读者信息*/
                    showQueryReader(result);
                    /*查询读者所借书籍*/
                    queryReaderBookinfo(result.extend.reader.rid);
                }
            }
        });
    } else {
        alert("文本框没有数据");
    }
});

/*展示读者信息*/
function showQueryReader(result){
    var reader =result.extend.reader;
    $("#name").val(reader.name).attr("reader_id",reader.rid);
    $("#sex").val(reader.sex=1?"男":"女");
    $("#readtype").val(reader.readtype.typename);
    $("#papertype").val(reader.papertype);
    $("#paperno").val(reader.paperno);
    $("#number").val(reader.readtype.number);
}
/*查询读者所借书籍*/

function queryReaderBookinfo(rid){
    $.ajax({
        url:"queryBorrowBookinfo/"+rid,
        type:"GET",
        success:function (result) {
            /*展示读者所借图书信息*/
            showReaderBookinfo(result);
        }
    });
};
/*展示读者所借图书信息*/
function showReaderBookinfo(result){
    $("#bookinfo tbody").empty();
    var bookinfo =result.extend.blist;
    $.each(bookinfo,function (index,item) {
        var bookname = $("<td></td>").append(item.bookinfo.bookname);
        var borrowtime = $("<td></td>").append(item.borrowtime);
        var repaytime = $("<td></td>").append(item.repaytime);
        var publish = $("<td></td>").append(item.bookinfo.publish);
        var booktype = $("<td></td>").append(item.bookinfo.booktype);
        var price = $("<td></td>").append(item.bookinfo.price);
        var btn_renew= $("<td></td>").append($("<button></button>").append("归还").attr("bid",item.bid).attr("class","btn btn-primary btn_return"));
        $("<tr></tr>").append(bookname)
            .append(borrowtime)
            .append(repaytime)
            .append(publish)
            .append(booktype)
            .append(price)
            .append(btn_renew)
            .appendTo("#bookinfo tbody")
    })
}


/*续借范围*/
$(document).on("click",".btn_return",function () {
    var rid = $("#name").attr("reader_id");
    var bid = $(this).attr("bid");
    var borrowtime =  $("#bookinfo tbody").find("tr").children("td:eq(1)").text();
    var repaytime =  $("#bookinfo tbody").find("tr").children("td:eq(2)").text();
    $.ajax({
        url:"borrow_reader/"+rid,
        type:"DELETE",
        data:{"rid":rid,"bid":bid,"borrowtime":borrowtime,"repaytime":repaytime},
        success:function (result) {
            alert(result.msg);
            queryReaderBookinfo(rid)
        }
    });
});