window.onload=function(){
    $("#example-navbar-collapse ul").children("li:eq(1)").attr("class","active");
};
/*查询所有书籍信息*/
$.ajax({
    url:"bookinfoAll",
    data: "pn=1",
    type:"GET",
    success:function (result) {
        showBookinfoAll(result);
        showBookinfopagenva(result);
    }
});

/*跳到自己选的页面*/
function to_page(pn) {
    $.ajax({
        url:"bookinfoAll",
        data: "pn="+pn,
        type:"GET",
        success:function (result) {
            //1.解析并显示员工信息
            showBookinfoAll(result);
            //2.解析并显示分页信息
            //page_emp_info(result);
            //3.解析并显示分页條信息
            showBookinfopagenva(result);
        }
    });
}
function showBookinfoAll(result) {
    $(".bookinfo_table tbody").empty();
    var BookinfoAll =result.extend.bookinfopage.list;
    $.each(BookinfoAll,function (index,itme) {
        /*图书条形码*/
        var barcode = $("<td></td>").append(itme.barcode);
        /*图书名称*/
        var bookname = $("<td></td>").append(itme.bookname);
        /*图书作者*/
        var author = $("<td></td>").append(itme.author);
        /*图书类型*/
        var booktype = $("<td></td>").append(itme.booktype);
        /*出版社*/
        var publish = $("<td></td>").append(itme.publish);
        $("<tr></tr>").append(barcode)
            .append(bookname)
            .append(author)
            .append(booktype)
            .append(publish)
            .appendTo(".bookinfo_table tbody");
    });
};

/*分页按钮的配置*/
function showBookinfopagenva(result) {
    /*清除属性和样式*/
    $("#page_emp_yew").empty();
    /*为ul添加Class属性*/
    var ul = $("<ul></ul>").addClass("pagination");
    /*首页*/
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
    /*上一页*/
    var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
    /*没有上一页就不能使用首页和上一页*/
    if (result.extend.bookinfopage.hasPreviousPage == false) {
        prePageLi.addClass("disabled");
        firstPageLi.addClass("disabled");
    }else {
        firstPageLi.click(function () {
            to_page(1);
        });
        prePageLi.click(function () {
            to_page(result.extend.bookinfopage.pageNum - 1);
        });
    }
    /*下一页*/
    var nextPageLi =$("<li></li>").append($("<a></a>").append("&raquo;"));
    /*最后一页*/
    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
    lastPageLi.click(function () {
        to_page(result.extend.bookinfopage.pages);
    });
    /*没有下一页就不能使用末页和下一页*/
    if (result.extend.bookinfopage.hasNextPage == false) {
        nextPageLi.addClass("disabled");
        lastPageLi.addClass("disabled");
    }else {
        nextPageLi.click(function () {
            to_page(result.extend.bookinfopage.pageNum + 1);
        });
        lastPageLi.click(function () {
            to_page(result.extend.bookinfopage.pages);
        });
    }
    /*把首页和下一页加入ul*/
    ul.append(firstPageLi).append(prePageLi);
    /*把遍历的每一页加入ul*/
    $.each(result.extend.bookinfopage.navigatepageNums,function (index,item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if (result.extend.bookinfopage.pageNum == item){
            numLi.addClass("active");
        }
        numLi.click(function () {
            to_page(item)
        });
        ul.append(numLi);
    });
    /*把下一页和末页加入ul*/
    ul.append(nextPageLi).append(lastPageLi);
    /*把ul加入nva*/
    var navEle =$ ("<nav></nav>").append(ul).appendTo("#page_emp_yew");
};
