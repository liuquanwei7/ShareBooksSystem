

function deleteBooking(bookId){
    if(confirm("你确定删除该书籍信息吗?请谨慎操作！")){
        location.href="deleteBookAction?bookId="+bookId;
    }
}


function updateBook(bookId){
    location.href="queryBookByIdAction?bookId="+bookId;
}

