<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>view mau sac</title>
</head>
<body>
<a href="/a">list index</a>
<a href="/mau-sac/create">thêm mới</a>
<br>
<form method="GET" action="/mau-sac/index">
    <div>
        <label>Tìm theo tên</label>
        <input type="text" name="keyword" />
    </div>
    <div>
        <button>Tìm kiếm</button>
    </div>
</form>
<br>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ pageMS.content }" var="ms">
        <tr>
            <td>${ ms.id }</td>
            <td>${ ms.ma }</td>
            <td>${ ms.ten }</td>
            <td>${ ms.trangThai }</td>
            <td>
                <a href="/mau-sac/edit/${ms.id}">Update</a>
            </td>
            <td>
                <a href="/mau-sac/delete/${ms.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<nav>
    <ul>
        <c:forEach begin="0" end="${pageMS.totalPages-1}" var="page" >
                    <a href="/mau-sac/index?page=${page}&keyword=${param.keyword}">${page+1}</a>
        </c:forEach>
    </ul>
</nav>

</body>
</html>