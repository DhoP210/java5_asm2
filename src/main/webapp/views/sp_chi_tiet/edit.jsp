<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>update</title>
</head>
<body>
<form action="/sp-chi-tiet/update/${spct.id}" method="post">
    <div>
        <lable>Mã sản phẩm chi tiết</lable>
        <input type="text" name="maSpct" value="${spct.maSpct}" >
    </div>
    <div>
        <lable>id kích thước</lable>
        <select name="idKichThuoc" >
            <c:forEach items="${listKT}" var="kt" >
                <option value="${kt.id}">${kt.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>id màu sắc</lable>
        <select name="idMauSac" >
            <c:forEach items="${listMS}" var="ms" >
                <option value="${ms.id}">${ms.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>id sản phẩm</lable>
        <select name="idSanPham" >
            <c:forEach items="${listSP}" var="sp" >
                <option value="${sp.id}">${sp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>Số lượng</lable>
        <input type="text" name="soLuong" value="${spct.soLuong}" >
    </div>
    <div>
        <lable>Đơn giá</lable>
        <input type="text" name="donGia" value="${spct.donGia}" >
    </div>
    <div>
        <lable>Trạng thái</lable>
        <input type="radio" id="tt-hd" name="trangThai" value="1" ${ spct.trangThai == 1 ? "checked" : ""}>
        <lable id="tt-hd">Đang hoạt động</lable>
        <input type="radio" id="tt-nhd" name="trangThai" value="0" ${ spct.trangThai ==0 ? "checked" : ""}>
        <lable id="tt-nhd">Ngừng hoạt động</lable>
    </div>
    <div>
        <button>sửa</button>
    </div>
</form>
</body>
</html>