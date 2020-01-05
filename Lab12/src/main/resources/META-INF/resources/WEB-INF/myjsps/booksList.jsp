<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core/form" prefix="c"%>

<html>
    <body>
<div align="center">
<h2>Add New Book</h2>
<form:form action="addBook" method="post" modelAttribute="mybook">

<table>
<tr>
    <td>Book Name</td>
    <td><form:input path="bname"/></td>
    <td><form:errors path="bname"/></td>
</tr>

<tr>
    <td>Author</td>
    <td><form:input path="author"/></td>
    <td class="errorStyles"><form:errors path="author"/></td>
</tr>

<tr>
    <td>Price</td>
    <td><form:input path="price"/></td>
    <td class="errorStyles"><form:errors path="price"/></td>
</tr>
<tr>
    <td>Publications</td>
    <td><form:input path="price"/></td>
    <td class="errorStyles"><form:errors path="pub"/></td>
</tr>
<tr>
    <td colspan="3"><input type="submit" value="Add Book"></td>
</tr>
</table>
</form:form>
</div>
<div align="center" id="show-books-div">
<h2>Latest Books</h2>
<table>
    <thead class="mytable-head">
<tr>
    <th>Book Id</th>
    <th>Book Name</th>
    <th>Author</th>
    <th>Price</th>
    <th>Publications</th>
</tr>
    </thead>
    <tbody>
<c:forEach var="mybook" items="${myBookList}">
<tr>
<td>${mybook.bid}</td>
<td>${mybook.bname}</td>
<td>${mybook.author}</td>
<td>${mybook.price}</td>
<td>${mybook.pub}</td>
</tr>

</c:forEach>

    </tbody>
</table>

</div></body>
</html>