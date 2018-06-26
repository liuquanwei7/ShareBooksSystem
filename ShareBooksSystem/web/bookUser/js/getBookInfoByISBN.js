function getBookInfo() {
    // var ISBNData=document.getElementById("isbndata");
    // var mybook;
    var ISBN=document.getElementById("isbndata").value;
    console.log(ISBN);
    if(ISBN) {
        $.ajax({
            type: "POST",
            dataType: 'JSONP',
            // contentType:"application/json;charset=utf-8",
            url: "https://api.douban.com/v2/book/isbn/" + ISBN,
            // url:"https://api.douban.com/v2/book/isbn/9787115226266",
            success: function (msg) {
                // msg=eval("("+msg+")");
                var author = msg.author[0];
                if (msg.translator.length > 0) {
                    author = author.substring(3);
                }
                var endIndex = msg.price.lastIndexOf("元");
                if(endIndex>0){
                    msg.price = msg.price.substring(0, endIndex);
                }
                if(msg.subtitle.length>0) {
                    msg.title = msg.title + " "+msg.subtitle;
                }else{
                    msg.title=msg.title;
                }
                // msg.price= msg.price.replace(/[^0-9]/ig,"");
                // msg.price= msg.price.replace(/^\d+\.\d\d$/ig,"");
                // msg.price= msg.price.replace(/^[\d+\.?\d*]/ig,"");
                msg.price= msg.price.replace(/[^\d.]/g,"");

                debugger
                var book = {
                    "book.bookName": msg.title,
                    "book.bookAuthor": msg.author[0],
                    "book.bookPicture": msg.image,
                    "book.bookPublish": msg.publisher,
                    "book.bookPrice": msg.price,
                    "book.bookCategory": msg.tags[0].name,
                    "book.bookSummary": msg.summary,

                };
                // var book={
                //     'bookName':msg.title,
                // 'bookAuthor':author,
                // 'bookPicture':msg.image,
                // 'bookPublic':msg.publisher,
                // 'bookPrice':msg.price,
                // 'bookCategory':msg.tags[7].name,
                // };
                // mybook=mybook.toString();
                // mybook=JSON.stringify(mybook);
                // console.log(typeof mybook+"aa");
                // var a = "大鹏";
                // var b = ['大鹏1', 'b', 'c'];
                // // var c=new Array(msg.title,author,msg.image,msg.publisher,msg.price,msg.tags[7].name);
                // var c = msg.title + "," + author + "," + msg.image + "," + msg.publisher
                //     + "," + msg.price + "," + msg.tags[0].name;
                // c=JSON.stringify(c);
                // console.log(c);
                // console.log(typeof c);
                console.log(typeof msg);
                console.log(msg);
                console.log(msg.summary);
                console.log(msg.author[0]);
                console.log(msg.image);
                console.log(msg.translator);
                console.log(msg.title);
                console.log(msg.publisher);
                // console.log(msg.tags[7].name);
                console.log(msg.price);
                debugger
                // document.getElementById("test").innerHTML=msg.catalog;
                sessionStorage.isbn = ISBN;
                // encodeURI(encodeURI(author));
                console.log(typeof author);
                console.log(author);
                // location.href = "addBookAction?mybook=" + c;
                console.log(book);
                $.ajax({
                    type: "POST",
                    url: "addBookAction",
                    data: book,
                    async: false,
                    // contentType:"application/json",
                    // dataType:"json",
                    success: function (msg) {
                        // msg=eval("("+msg+")");
                        // console.log()
                        console.log(msg);
                        // location.href="bookInfo.jsp";
                        console.log(msg.result);
                        sessionStorage.shareCode = msg.shareCode;
                        console.log(sessionStorage.shareCode);
                        // debugger
                        if (msg.result == "YES") {
                            location.href = "ensureBook.jsp"
                        } else if (msg.result=="NO") {
                            location.href = "addBook.jsp";
                        }else if(msg.result=="not"){
                            alert("书籍已存在！！！");
                        }

                    },
                    error: function (errmsg) {
                        console.log(errmsg);
                    }

                });

                // mybook=JSON.stringify(mybook);
                // targetForm=document.forms[0];
                // console.log("test");
                // targetForm.action="addBookAction.action?mybook="+encodeURIComponent(mybook);
                // console.log("test11");

                // $.ajax({
                //     type:"POST",
                //     url:"addBookAction",
                //     data:mybook,
                //     async:false,
                //     contentType:"application/x-www-form-urlencoded",
                //     dataType:"json",
                //     success:function (msg) {
                //         console.log("success");
                //     },
                //     error:function (errmsg) {
                //         console.log(errmsg);
                //     }
                //
                // });

            },
            error: function (errmsg) {
                // alert(msg.status);
                alert("找不到此书信息");
                console.log(errmsg);
            }
        });
    }else{
        alert("请输入isbn码！！！");
    }

    // $.getJSON("https://api.douban.com/v2/book/isbn/9787115275790",
    //     function (data) {
    //         alert(data);
    //     }
    // );
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