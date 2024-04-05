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

<a href="/a">list index</a>

<a href="/nhan-vien/create">thêm mới</a>
<br>
<form method="GET" action="/nhan-vien/index">
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
            <th>id</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${pageNV.content}" var="nv">
                <tr>
                    <td>${ nv.id }</td>
                    <td>${ nv.ma }</td>
                    <td>${ nv.ten }</td>
                    <td>${ nv.tenDangNhap }</td>
                    <td>${ nv.matKhau }</td>
                    <td>${ nv.trangThai }</td>
                    <td>
                        <a href="/nhan-vien/edit/${nv.id}">update</a>
                    </td>
                    <td>
                        <a href="/nhan-vien/delete/${nv.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<nav>
    <ul>
        <c:forEach begin="0" end="${pageNV.totalPages-1}" var="page">
            <a href="/nhan-vien/index?page=${page}&keyword=${param.keyword}">${page+1}</a>
        </c:forEach>
    </ul>
</nav>

</body>
</html>