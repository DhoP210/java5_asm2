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

<h3>Tìm kiếm</h3>
<form action="/nhan-vien/search" method="get">
    <input type="text" name="ma" placeholder="Tìm theo mã">
    <input type="text" name="ten" placeholder="Tìm theo tên">
    <input type="text" name="tenDangNhap" placeholder="Tìm theo tenDangNhap">
    <input type="text" name="matKhau" placeholder="Tìm theo matKhau">
    <button>tìm</button>
</form>
<form action="/nhan-vien/loc" method="get">
    <h3>Lọc</h3>
    <lable>Trạng thái</lable>
    <select name="trangThai" >
        <option value="1">Đang hoạt động</option>
        <option value="0">Ngừng hoạt động</option>
    </select>
    <button>Lọc</button>
</form>
<br>

<a href="/nhan-vien/create">thêm mới</a>
    <table>
        <thead>
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${listNV}" var="nv">
                <tr>
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
</body>
</html>