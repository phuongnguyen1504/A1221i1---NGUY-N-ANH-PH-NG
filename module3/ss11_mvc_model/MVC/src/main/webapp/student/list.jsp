<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/bootstrap-5.1.3/css/bootstrap.css">
</head>
<body>
<div class="container">
    <a name="" id="" class="btn btn-success" href="/student?action=create" role="button">Create</a>
    <h1>Student List</h1>
    <c:if test="${empty studentList}">
        <h1 style="color: red">Student List Empty</h1>
    </c:if>

    <c:if test="${not empty studentList}">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Point</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td>${student.name}</td>
                    <td>
                        <c:choose>
                            <c:when test="${student.gender == 0}">Female</c:when>
                            <c:when test="${student.gender == 1}">Male</c:when>
                            <c:otherwise>LGBT</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${student.point}</td>
                    <td>
                        <img src="/static/img/${student.image}" width="50px">
                    </td>
                    <td>
                        <a class="btn btn-danger" href="/student?action=delete&id=${student.id}" role="button">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>