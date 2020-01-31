window.onload=function(){
    $("#example-navbar-collapse ul").children("li:eq(2)").attr("class","active");
};

/*获得时间范围*/

//获取当前的分秒
var currentTime=new Date()
var currentyear=currentTime.getFullYear();   //获取当前年
var currentmonth=currentTime.getMonth()+1;   //获取当前月
var currentdate=currentTime.getDate();       //获得天
/*获得三天后归还的分秒*/
var returntimes = new Date(new Date().getTime()+3*24*60*60*1000);
var returnyear=returntimes.getFullYear();   //获取当前年
var returnmonth=returntimes.getMonth()+1;   //获取当前月
var returndate=returntimes.getDate();       //获得天

var current=currentyear+"-"+currentmonth+"-"+currentdate;
var repay=returnyear+"-"+returnmonth+"-"+returndate;

/*读者搜索*/
$(".btn_query_reader").click(function () {
    var barcode = $("#reader_search_box input[name=barcode]").val()
    if (barcode != ""){
        $.ajax({
            url:"readeronebarcode/"+barcode,
            type:"GET",
            success:function (result) {
                showQueryReader(result);
            }
        });
    }else {
        alert("数据不能为空！请重新输入输入")
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


/*书籍搜索*/
$(".btn_query_bookinfo").click(function () {
    var wordsandnumbers = $("#booksearchbox input[type=text]").val();
    if (wordsandnumbers!=""){
        $.ajax({
            url:"bookinfoOne/"+$("#booksearchbox input[type=text]").val(),
            type:"GET",
            /*data:{"wordsandnumbers":},*/
            success:function (result) {
                showQueryBookinfo(result);
            }
        });
    }else {
        alert("数据不能为空！请重新输入输入")
    }

});

/*隐书籍信息藏*/
$("#bookinfo").css("display","none");
/*显示书籍信息*/
function showQueryBookinfo(result) {
    $("#bookinfo").css("display","block");
    var bookinfo=result.extend.bookifoOne;
    $("#bookinfo tbody").empty();

    /*表单体*/
    $.each(bookinfo,function (index,item) {
        /*图书名称*/
        var bookname =$("<td></td>").append(item.bookname).attr("bookinfo_id",item.bid);
        /*借阅时间*/
        var current1 =$("<td></td>").append(current);
        /*应还时间*/
        var repay2 =$("<td></td>").append(repay);
        /*出版社*/
        var publish =$("<td></td>").append(item.publish);
        /*图书类型*/
        var booktype =$("<td></td>").append(item.booktype);
        /*价格*/
        var price =$("<td></td>").append(item.price);
        $("<tr></tr>")
            .append(bookname)
            .append(current1)
            .append(repay2)
            .append(publish)
            .append(booktype)
            .append(price).appendTo("#bookinfo tbody")
    })

};
/*完成借阅*/
$(".btn_lend_booinfo").click(function () {
    var reader_id= $("#name").attr("reader_id");
    var bookinfo_id = $("#bookinfo tbody").children("tr").find("td:eq(0)").attr("bookinfo_id");
    var borrowtime =$("#bookinfo tbody").children("tr").find("td:eq(1)").text();
    var repaytime =$("#bookinfo tbody").children("tr").find("td:eq(2)").text();
    if (reader_id!=null&&bookinfo_id!=null){
        $.ajax({
            url:"borrow_reader/"+reader_id,
            type:"post",
            data:{"rid":reader_id,"bid":bookinfo_id,"borrowtime":borrowtime,"repaytime":repaytime},
            success :function (result) {
                if(result.code==100){
                    alert(result.msg)
                }else {
                    alert(result.msg+",您不能再借书了或不能借同一本书")
                }
            }

        });
    }else {
        alert("数据不完整");
    }


});