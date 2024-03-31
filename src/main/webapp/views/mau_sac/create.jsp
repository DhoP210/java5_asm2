<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form method="post" action="/mau-sac/store">
<%--        <div>--%>
<%--            <lable>ID</lable>--%>
<%--            <input type="text" name="id">--%>
<%--        </div>--%>
        <div>
            <lable>Mã</lable>
            <input type="text" name="ma">
        </div>
        <div>
            <lable>Tên</lable>
            <input type="text" name="ten">
        </div>
        <div>
            <lable>Trạng thái</lable>
            <input type="radio" id="trang_thai_active" name="trangThai" value="1">
            <lable for="trang_thai_active">Đang hoạt động</lable>
            <input type="radio" id="trang_thai_inactive" name="trangThai" value="0">
            <lable for="trang_thai_inactive">Ngừng hoạt động</lable>
        </div>
        <div>
            <button>Thêm</button>
        </div>
    </form>
</body>
</html>