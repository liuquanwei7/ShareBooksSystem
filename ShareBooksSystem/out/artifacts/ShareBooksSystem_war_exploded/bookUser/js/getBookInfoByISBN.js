function getBookInfo() {
    // var ISBNData=document.getElementById("isbndata");
    $.ajax({
        type:"GET",
        dataType:'JSONP',
        // contentType:"application/json;charset=utf-8",
        url:"https://api.douban.com/v2/book/isbn/9787115275790",
        success:function (msg) {
            // msg=eval("("+msg+")");
            console.log(msg);
            console.log(msg.author[0]);
            console.log(msg.image);
            console.log(msg.translator);
            console.log(msg.title);
            console.log(msg.publisher);
            console.log(msg.summary);

        },
        error:function (errmsg) {
            console.log(errmsg);
        }
    });
    $.getJSON("https://api.douban.com/v2/book/isbn/9787115275790",
        function (data) {
            alert(data);
        }
    );
    // var xmlhttp;
    // if (window.XMLHttpRequest)
    // {
    //     // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    //     xmlhttp=new XMLHttpRequest();
    // }
    // else {
    //     // IE6, IE5 浏览器执行代码
    //     xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    // }
    // xmlhttp.onreadystatechange=function()
    // {
    //     if (xmlhttp.readyState==4 && xmlhttp.status==200)
    //     {
    //         console.log(xmlhttp.responseText)
    //         // document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
    //     }
    //
    // }
    // xmlhttp.open("POST","/try/ajax/demo_post.php",true);
    // xmlhttp.send();

}