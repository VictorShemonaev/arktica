<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update book page</title>
</head>
<body>


<form name="book" action="/UpdateBook" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id" value="${book.id}">
    <p>Book Name</p>
    <input title="BookName" type="text" name="bookName" value="${book.bookName}">
    <p>Book Title</p>
    <input title="BookTitle" type="text" name="bookTitle" value="${book.bookTitle}">
    <p>Book Short Title</p>
    <input title="BookShortTitle" type="text" name="bookShortTitle" value="${book.bookShortTitle}">
    <p>Book Author</p>
    <input title="BookAuthor" type="text" name="bookAuthor" value="${book.bookAuthor}">
    <p>Book Price</p>
    <input title="BookPrice" type="text" name="bookPrice" value="${book.bookPrice}">
    <input type="submit" value="OK">
</form>

</body>
</html>