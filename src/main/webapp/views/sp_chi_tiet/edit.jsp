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
        <input type="text" name="maSpct" value="${spct.maSpct}" disabled>
    </div>
    <div>
        <lable>id kích thước</lable>
        <input type="text" name="idKichThuoc" value="${spct.idKichThuoc}" >
    </div>
    <div>
        <lable>id màu sắc</lable>
        <input type="text" name="idMauSac" value="${spct.idMauSac}" >
    </div>
    <div>
        <lable>id sản phẩm</lable>
        <input type="text" name="idSanPham" value="${spct.idSanPham}" >
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