function chooseBook(){
    // console.log(ensureBook);
    // debugger
    isbn=sessionStorage.isbn;
    console.log(isbn);

    if(isbn) {
        if(confirm("确定添加该图书吗？")) {
            $.ajax({
                type: "POST",
                dataType: 'JSONP',
                // contentType:"application/json;charset=utf-8",
                url: "https://api.douban.com/v2/book/isbn/" + isbn,
                // url:"https://api.douban.com/v2/book/isbn/9787115226266",
                success: function (msg) {
                    // msg=eval("("+msg+")");
                    var author = msg.author[0];
                    if (msg.translator.length > 0) {
                        author = author.substring(3);
                    }
                    // if()
                    var endIndex = msg.price.lastIndexOf("元");
                    if (endIndex > 0) {
                        msg.price = msg.price.substring(0, endIndex);
                    }
                    if (msg.subtitle.length > 0) {
                        msg.title = msg.title + " " + msg.subtitle;
                    } else {
                        msg.title = msg.title;
                    }
                    msg.price = msg.price.replace(/[^\d.]/g, "");
                    var book = {
                        "book.bookName": msg.title,
                        "book.bookAuthor": msg.author[0],
                        "book.bookPicture": msg.image,
                        "book.bookPublish": msg.publisher,
                        "book.bookPrice": msg.price,
                        "book.bookCategory": msg.tags[0].name,
                        "book.bookSummary": msg.summary,

                    };
                    console.log(typeof msg);
                    console.log(msg);
                    console.log(msg.author[0]);
                    console.log(msg.image);
                    console.log(msg.translator);
                    console.log(msg.title);
                    console.log(msg.publisher);
                    // console.log(msg.tags[7].name);
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
                        type: "POST",
                        url: "ensureAddBookAction",
                        data: book,
                        async: false,
                        // contentType:"application/json",
                        // dataType:"json",
                        success: function (msg) {
                            // msg=eval("("+msg+")");
                            // console.log()
                            console.log(msg);
                            console.log(msg.result);
                            sessionStorage.shareCode = msg.shareCode;
                            console.log(sessionStorage.shareCode);
                            // debugger
                            if (msg.result == "YES") {
                                location.href = "ensureBookSuccess.jsp"
                            } else if (msg.result == "NO") {
                                location.href = "addBook.jsp";
                            } else if (msg.result == "not") {
                                alert("书籍已存在！！！");
                            }

                        },
                        error: function (errmsg) {
                            console.log(errmsg);
                        }

                    });

                },
                error: function (errmsg) {
                    console.log(errmsg);
                }
            });
        }else {
            alert("你取消了添加！")
        }
    }else{
        alert("请输入isbn码");
    }

    // location.href="ensureAddBookAction?book="+ensureBook;
}