<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>index</title>
</head>
<body>


<a href="/san-pham/create">thêm mới</a>
<br>
<form method="GET" action="/san-pham/index">
    <div>
        <label>Tìm theo tên</label>
        <input type="text" name="keyword" />
    </div>
    <div>
        <button>Tìm kiếm</button>
    </div>
</form>
<br>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Trạng thái</th>
                <th colspan="2">Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pageSP.content}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.trangThai}</td>
                    <td><a href="/san-pham/edit/${sp.id}">update</a></td>
                    <td><a href="/san-pham/delete/${sp.id}">delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<nav>
    <ul>
        <c:forEach begin="0" end="${pageSP.totalPages-1}" var="page">
            <a href="/san-pham/index?page=${page}&keyword=${param.keyword}">${page+1}</a>
        </c:forEach>
    </ul>
</nav>
</body>
</html>