<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
  <title>Aplikasi Perpus</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="/">PERPUS</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="/">List Buku</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="addBook">Add Buku</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
<div class="container">
  <br>
    <c:choose>
    	<c:when test="${mode == 'BOOK_VIEW'}">
    	<table class="table table-bordered">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Nama Buku</th>
			        <th>Author</th>
			        <th>Tanggal Beli</th>
			        <th>Aksi</th>
			      </tr>
			    </thead>
			    <tbody>
	    	<c:forEach var="book" items="${books}">
		        <tr>
		          <td>${book.id}</td>
		          <td>${book.bookName}</td>
		          <td>${book.author}</td>
		          <td>${book.purchaseDate}</td>
		          <td>
					  <a href="updateBook?id=${book.id}"> <i class="fa fa-edit"></i></a>
					  &ensp;
					  <a href="deleteBook?id=${book.id}"> <i class="fa fa-trash"></i></a>
				  </td>
		        </tr>
	      	</c:forEach>
	      		</tbody>
  			</table>
    	</c:when>
    	
    	<c:when test="${mode == 'BOOK_EDIT' || mode == 'BOOK_NEW'}">
    		<form action="saveBook" method="POST">
    			<input type="hidden" class="form-control" value="${books.id}" name="id" id="id">
			    <div class="form-group">
			      <label for="bookName">Nama Buku :</label>
			      <input type="text" class="form-control" value="${books.bookName}" id="bookName" name="bookName">
			    </div>
			    <div class="form-group">
			      <label for="author">Author :</label>
			      <input type="text" class="form-control" value="${books.author}" id="author" name="author">
			    </div>
			    <div class="form-group">
			      <label for="purchaseDate">Tanggal Pembelian :</label>
			      <input type="date" class="form-control" value="${books.purchaseDate}" id="purchaseDate" name="purchaseDate">
			    </div>
			    <button type="submit" class="btn btn-primary">Submit</button>
			</form>
    	</c:when>
    </c:choose>
	</div>
</div>

</body>
</html>
