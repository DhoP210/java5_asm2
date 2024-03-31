<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
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
<%--    <h3>Tìm kiếm</h3>--%>
<%--    <form action="/kich-thuoc/search" method="get">--%>
<%--        <input type="text" name="ma" placeholder="Tìm theo mã">--%>
<%--        <input type="text" name="ten" placeholder="Tìm theo tên">--%>
<%--        <button>tìm</button>--%>
<%--    </form>--%>
<%--    <form action="/kich-thuoc/loc" method="get">--%>
<%--        <h3>Lọc</h3>--%>
<%--        <lable>Trạng thái</lable>--%>
<%--        <select name="trangThai" >--%>
<%--            <option value="1">Đang hoạt động</option>--%>
<%--            <option value="0">Ngừng hoạt động</option>--%>
<%--        </select>--%>
<%--        <button>Lọc</button>--%>
<%--    </form>--%>
<%--    <br>--%>
    <a href="/kich-thuoc/create">thêm mới</a>
<%--            <input type="text" name="ma" >--%>
<%--            <button><a href="/kich-thuoc/search" methods="get">Tìm</a></button>--%>
    <h3>Danh sách kích thước</h3>
    <table border="1">
        <thead>
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${listKT}" var="kt">
                <tr>
                    <td>${ kt.ma }</td>
                    <td>${ kt.ten }</td>
                    <td>${ kt.trangThai }</td>
                    <td>
                        <a href="/kich-thuoc/edit/${kt.id}">update</a>
                    </td>
                    <td>
                        <a href="/kich-thuoc/delete/${kt.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>