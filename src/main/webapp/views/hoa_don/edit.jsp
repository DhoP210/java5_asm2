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
<form action="/hoa-don/update/${hd.id}" method="post">
<%--    <div>--%>
<%--        <lable>Mã hóa đơn</lable>--%>
<%--        <input type="text" name="maHoaDon" value="${hd.maHoaDon}" disabled>--%>
<%--    </div>--%>
    <div>
        <lable>ID nhân viên</lable>
        <select name="idNv" >
            <c:forEach items="${listNV}" var="nv" >
                <option value="${nv.id}">${nv.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>ID khách hàng</lable>
        <select name="idKh" >
            <c:forEach items="${listKH}" var="kh" >
                <option value="${kh.id}">${kh.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <lable>Ngày mua hàng</lable>
        <input type="date" name="ngayMuaHang" value="${hd.ngayMuaHang}">
    </div>
    <div>
        <lable>Trạng thái</lable>
        <input type="radio" id="tt-hd" name="trangThai" value="1" ${hd.trangThai == 1 ? "checked":""}>
        <lable id="tt-hd">Đang hoạt động</lable>
        <input type="radio" id="tt-nhd" name="trangThai" value="0" ${hd.trangThai == 0 ? "checked":""}>
        <lable id="tt-nhd">Ngừng hoạt động</lable>
    </div>
    <div>
        <button>Sửa</button>
    </div>
</form>
</body>
</html>