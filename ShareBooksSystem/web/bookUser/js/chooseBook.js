function chooseBook(ensureBook){
    // console.log(ensureBook);
    // debugger
    isbn=sessionStorage.isbn;
    console.log(isbn);
    $.ajax({
        type:"POST",
        dataType:'JSONP',
        // contentType:"application/json;charset=utf-8",
        url:"https://api.douban.com/v2/book/isbn/"+isbn,
        // url:"https://api.douban.com/v2/book/isbn/9787115226266",
        success:function (msg) {
            // msg=eval("("+msg+")");
            var author=msg.author[0];
            if(msg.translator.length>0){
                author=author.substring(3);
            }
            var endIndex = msg.price.lastIndexOf("元");
            msg.price=msg.price.substring(0,endIndex);
            var book= {
                    "book.bookName": msg.title,
                    "book.bookAuthor": msg.author[0],
                    "book.bookPicture": msg.image,
                    "book.bookPublish": msg.publisher,
                    "book.bookPrice": msg.price,
                    "book.bookCategory": msg.tags[0].name,
            };

            //     book.bookName:msg.title,
            // book.bookAuthor:author,
            // book.bookPicture:msg.image,
            // book.bookPublic:msg.publisher,
            // book.bookPrice:msg.price,
            // book.bookCategory:msg.tags[7].name

            // book=eval(book);
            // book=JSON.stringify(book);
            // mybook=mybook.toString();
            // mybook=JSON.stringify(mybook);
            // console.log(typeof mybook+"aa");
            // var a="大鹏";
            // var b=['大鹏1','b','c'];
            // var c=new Array(msg.title,author,msg.image,msg.publisher,msg.price,msg.tags[7].name);
            // var c=msg.title+","+author+","+msg.image+","+msg.publisher
            //     +","+msg.price+","+msg.tags[7].name;
            // c=JSON.stringify(c);
            // console.log(c);
            // console.log(typeof c);
            // debugger
            console.log(typeof msg);
            console.log(msg);
            console.log(msg.author[0]);
            console.log(msg.image);
            console.log(msg.translator);
            console.log(msg.title);
            console.log(msg.publisher);
            console.log(msg.tags[7].name);
            console.log(msg.price);
            // sessionStorage.isbn="9787115275790";
            // encodeURI(encodeURI(author));
            console.log(typeof author);
            console.log(author);
            // location.href="ensureAddBookAction?book="+book;
            // mybook=JSON.stringify(mybook);
            // targetForm=document.forms[0];
            // console.log("test");
            // targetForm.action="addBookAction.action?mybook="+encodeURIComponent(mybook);
            // console.log("test11");
            // debugger
            console.log(book);
            $.ajax({
                type:"POST",
                url:"ensureAddBookAction",
                data:book,
                async:false,
                // contentType:"application/json",
                // dataType:"json",
                success:function (msg) {
                    // msg=eval("("+msg+")");
                    // console.log()
                    console.log(msg);
                    console.log(msg.result);
                    sessionStorage.shareCode=msg.shareCode;
                    if(msg.result=="YES"){
                        location.href="ensureBookSuccess.jsp"
                    }else{
                        location.href="addBook.jsp";
                    }

                },
                error:function (errmsg) {
                    console.log(errmsg);
                }

            });

        },
        error:function (errmsg) {
            console.log(errmsg);
        }
    });

    // location.href="ensureAddBookAction?book="+ensureBook;
}