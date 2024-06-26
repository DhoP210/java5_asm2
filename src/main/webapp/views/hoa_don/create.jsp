<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/hoa-don/store" method="post">
<%--    <div>--%>
<%--        <lable>id hóa đơn</lable>--%>
<%--        <input type="text" name="id">--%>
<%--    </div>--%>
    <div>
        <lable>Tên nhân viên</lable>
        <select name="idNv" >
            <c:forEach items="${listNV}" var="nv" >
                <option value="${nv.id}">${nv.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>Tên khách hàng</lable>
        <select name="idKh" >
            <c:forEach items="${listKH}" var="kh" >
                <option value="${kh.id}">${kh.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>Ngày mua hàng</lable>
        <input type="date" name="ngayMuaHang">
    </div>
    <div>
        <lable>Trạng thái</lable>
        <input type="radio" id="tt-hd" name="trangThai" value="1">
        <lable id="tt-hd">Đang hoạt động</lable>
        <input type="radio" id="tt-nhd" name="trangThai" value="0">
        <lable id="tt-nhd">Ngừng hoạt động</lable>
    </div>
    <div>
        <button>Thêm</button>
    </div>
</form>
</body>
</html>