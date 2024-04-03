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
<h2>Thêm hoa don ct</h2>
<form action="/hoa-don-ct/store" method="post">
    <div>
        <lable>id hóa đơn chi tiết</lable>
        <input type="text" name="id">
    </div>
    <div>
        <lable>id hóa đơn - ngày mua hàng</lable>
        <select name="idHoaDon">
            <c:forEach items="${hd}" var="kt">
                <option value="${kt.id}">${kt.id} - ${kt.ngayMuaHang}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>ID - Mã sản phẩm chi tiết</lable>
        <select name="idSpct">
            <c:forEach items="${sp}" var="kt">
                <option value="${kt.id}">${kt.id} - ${kt.maSpct}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>Số lượng</lable>
        <input type="text" name="soLuong">
    </div>
    <div>
        <lable>Đơn giá</lable>
        <input type="text" name="donGia">
    </div>

    <div>
        <lable>Thời gian</lable>
        <input type="datetime-local" name="thoiGianString">
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