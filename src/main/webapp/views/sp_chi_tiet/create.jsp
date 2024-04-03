<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>add</title>
</head>
<body>
<h2>Thêm sản phẩm chi tiết</h2>
<form action="/sp-chi-tiet/store" method="post">
    <div>
        <lable>Mã sản phẩm chi tiết</lable>
        <input type="text" name="maSpct">
    </div>
    <div>
        <lable>Tên kích thước</lable>
        <select name="idKichThuoc" >
            <c:forEach items="${listKT}" var="kt" >
                <option value="${kt.id}">${kt.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>Tên màu sắc</lable>
        <select name="idMauSac" >
            <c:forEach items="${listMS}" var="ms" >
                <option value="${ms.id}">${ms.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>Tên sản phẩm</lable>
        <select name="idSanPham" >
            <c:forEach items="${listSP}" var="sp" >
                <option value="${sp.id}">${sp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>Số lượng</lable>
        <input type="text" name="soLuong">
    </div>
    <div>
        <lable>Đơn giá</lable>
        <input type="text" name="donGia" >
    </div>
    <div>
        <lable>Trạng thái</lable>
        <input type="radio" id="tt-hd" name="trangThai" value="1">
        <lable id="tt-hd">Đang hoạt động</lable>
        <input type="radio" id="tt-nhd" name="trangThai" value="0">
        <lable id="tt-nhd">Ngừng hoạt động</lable>
    </div>
    <div>
    <button>thêm</button>
    </div>
</form>
</body>
</html>