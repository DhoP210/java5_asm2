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
<form action="/san-pham/update/${sp.id}" method="post">
    <div>
        <lable>Mã</lable>
        <input type="text" name="ma" value="${sp.ma}">
    </div>
    <div>
        <lable>Tên</lable>
        <input type="text" name="ten" value="${sp.ten}">
    </div>
    <div>
        <lable>Trạng thái</lable>
        <input type="radio" id="tt-hd" name="trangThai" value="1" ${ sp.trangThai == 1 ? "checked":""}>
        <lable id="tt-hd">Đang hoạt động</lable>
        <input type="radio" id="tt-nhd" name="trangThai" value="0" ${ sp.trangThai == 0 ? "checked":""}>
        <lable id="tt-nhd">Ngừng hoạt động</lable>
    </div>
    <div><button>Sửa</button></div>
</form>
</body>
</html>