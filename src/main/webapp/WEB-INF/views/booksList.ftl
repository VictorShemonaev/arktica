<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Books</title>
</head>
<body>
<div class="form-group" >
    <h1>Search to Books list</h1>
    <input type="text" class="form-control pull-right" id="search" placeholder="Search" >
</div>
<h1>Books list</h1>
<table class="table table-striped" id="mytable" cellspacing="0" style="width: 60%;">
    <tr>
        <th>Id</th>
        <th>Book Name</th>
        <th>Book Title</th>
        <th>Book Author</th>
        <th>Book Price</th>
    </tr>
<#list books as book>
    <tr>
        <td><a href="/book/${book.id}">${book.id}</a></td>
        <td>${book.bookName}</td>
        <td>${book.bookTitle}</td>
        <td>${book.bookAuthor}</td>
        <td>${book.bookPrice}</td>
        <td><a href="/delete/${book.id}">Delete</a></td>
        <td><a href="/update/${book.id}">Update</a></td>
    </tr>
</#list>
</table>

<a href="/addBook">Create book</a>
<script>
    $(document).ready(function(){
        $("#search").keyup(function(){
            _this = this;
            $.each($("#mytable tr"), function() {
                if($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                    $(this).hide();
                else
                    $(this).show();
            });
        });
    });
</script>
<script type="text/javascript">
    var pager = new Imtech.Pager();
    $(document).ready(function() {
        pager.paragraphsPerPage = 1; // Устанавливаем количество элементов на странице
        pager.pagingContainer = $('#mytable tr'); // Устанавливаем основной контейнер
        pager.paragraphs = $('p', pager.pagingContainer); // Подсчитываемые элементы
        pager.showPage(1); // Начинаем просмотр с первой страницы
    });
</script>
</body>
</html>