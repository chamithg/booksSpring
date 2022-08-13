<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body class="m-5 p-5">
<h1>Books</h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Language</th>
      <th scope="col">Pages</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${books}" var="book">
    <tr>
      <td><c:out value="${book.getId()}"/></td>
      <td><a href="/book/${book.getId()}"><c:out value="${book.getTitle()}"/></a></td>
      <td><c:out value="${book.getLanguage()}"/></td>
      <td><c:out value="${book.getNumberOfPages()}"/></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

<a href="/books/new" class="btn btn-warning">Add new book</a>

</body>
</html>