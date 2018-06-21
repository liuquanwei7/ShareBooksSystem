function borrowBook(personalBookId) {
    var bookstatus=document.getElementById("storeStatus").innerText;
    // alert(bookstatus);
    if(bookstatus=="在库状态：在库"){
        location.href="borrowBookAction?personalBookId="+personalBookId;
    }else{
        alert("该书暂不在库，请选择其他书籍借阅");
    }

}