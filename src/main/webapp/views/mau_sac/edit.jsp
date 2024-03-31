<%@page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>edit</title>
</head>
<body>
<h2>Edit Form</h2>
<form method="post" action="/mau-sac/update/${ms.id}" >
    <div>
        <lable>Mã</lable>
        <input type="text" name="ma" value="${ms.ma}" >
    </div>
    <div>
        <lable>Tên</lable>
        <input type="text" name="ten" value="${ms.ten}">
    </div>
    <div>
        <lable>Trạng thái</lable>
        <input type="radio" id="trang_thai_active" name="trangThai" value="1"
        ${ms.trangThai == 1 ? "checked" : ""}
        />
        <lable for="trang_thai_active">Đang hoạt động</lable>
        <input type="radio" id="trang_thai_inactive" name="trangThai" value="0"
        ${ms.trangThai == 0 ? "checked":""}
        />
        <lable for="trang_thai_inactive">Ngừng hoạt động</lable>
    </div>
    <div>
        <button>Sửa</button>
    </div>
</form>
</body>
</html>