function goPage(pno,psize){
    var itable = document.getElementById("idda");
    var num = itable.rows.length;//表格所有行数(所有记录数)

    var totalPage = 0;//总页数
    var pageSize = psize;//每页显示行数
    //总共分几页
    if(num/pageSize > parseInt(num/pageSize)){
        totalPage=parseInt(num/pageSize)+1;
    }else{
        totalPage=parseInt(num/pageSize);
    }
    var currentPage = pno;//当前页数
    var startRow = (currentPage - 1) * pageSize+1;//开始显示的行
    var endRow = currentPage * pageSize;//结束显示的行
    endRow = (endRow > num)? num : endRow;

    //遍历显示数据实现分页
    for(var i=1;i<(num+1);i++){
        var irow = itable.rows[i-1];//表格的某一行
        if(i>=startRow && i<=endRow){
            irow.style.display = "block";
        }else{
            irow.style.display = "none";
        }
    }
    var tempStr = "";
    if(currentPage>1){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+")\">上一页</a>"
    }else{
        tempStr += "<span>首页</span>";
        tempStr += "<span>上一页</span>";
    }

    if(currentPage<totalPage){
        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页</a>";
        tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
    }else{
        tempStr += "<span>下一页</span>";
        tempStr += "<span>尾页</span>";
    }

    document.getElementById("barcon").innerHTML = tempStr;

}