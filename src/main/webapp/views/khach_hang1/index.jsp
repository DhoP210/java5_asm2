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
    <title>index</title>
</head>
<body>


<a href="/khach-hang/create">thêm mới</a>
<table border="1">
    <thead>
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Số điện thoại</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageKH.content}" var="kh">
        <tr>
            <td>${ kh.ma }</td>
            <td>${ kh.ten }</td>
            <td>${ kh.sdt }</td>
            <td>${ kh.trangThai }</td>
            <td>
                <a href="/khach-hang/edit/${kh.id}">update</a>
            </td>
            <td>
                <a href="/khach-hang/delete/${kh.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <c:forEach begin="1" end="${pageKH.totalPages}" varStatus="pTrang">
            <a href="/khach-hang/index?page=${pTrang.count-1}">${pTrang.count-1}</a><br>
        </c:forEach>
    </ul>
</nav>
</body>
</html>