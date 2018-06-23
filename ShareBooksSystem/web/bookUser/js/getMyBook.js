function getMyBook(personalBookId,bookStatus){
    // var bookStatus=document.getElementById("storeStatus").innerText;
    alert(bookStatus);
    if(bookStatus=="在库"){
        location.href="getMyBookAction?personalBookId="+personalBookId;
    }else {
        alert("该书已被借出！！");
        location.href="beforeGetMyBookAction?personalBookId="+personalBookId;
    }

}