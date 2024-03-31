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
<h2>Thêm nhân viên</h2>
<form action="/nhan-vien/store" method="post">
    <div>
        <lable>Mã</lable>
        <input type="text" name="ma">
    </div>
    <div>
        <lable>Tên</lable>
        <input type="text" name="ten">
    </div>
    <div>
        <lable>Tên đăng nhập</lable>
        <input type="text" name="tenDangNhap">
    </div>
    <div>
        <lable>mật khẩu</lable>
        <input type="password" name="matKhau">
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