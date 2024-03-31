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
    <title>view mau sac</title>
</head>
<body>

<%--<h3>Tìm kiếm</h3>--%>
<%--<form action="/mau-sac/search" method="get">--%>
<%--    <input type="text" name="ma" placeholder="Tìm theo mã">--%>
<%--    <input type="text" name="ten" placeholder="Tìm theo tên">--%>
<%--    <button>tìm</button>--%>
<%--</form>--%>
<%--<form action="/mau-sac/loc" method="get">--%>
<%--    <h3>Lọc</h3>--%>
<%--    <lable>Trạng thái</lable>--%>
<%--    <select name="trangThai" >--%>
<%--        <option value="1">Đang hoạt động</option>--%>
<%--        <option value="0">Ngừng hoạt động</option>--%>
<%--    </select>--%>
<%--    <button>Lọc</button>--%>
<%--</form>--%>
<%--<br>--%>

<a href="/mau-sac/create">thêm mới</a>
<table>
    <thead>
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ pageMS.content }" var="ms">
        <tr>
<%--            <td>${ms.id}</td>--%>
            <td>${ ms.ma }</td>
            <td>${ ms.ten }</td>
            <td>${ ms.trangThai }</td>
            <td>
                <a href="/mau-sac/edit/${ms.id}">Update</a>
            </td>
            <td>
                <a href="/mau-sac/delete/${ms.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<nav>
    <ul>
        <li><a href="#">Previous</a></li>

        <c:forEach begin="1" end="${pageMS.totalPages}" varStatus="pTrang" >
<%--            <c:if test="${ pTrang.count < 3 || pTrang.count > pageMS.totalPages - 3}">--%>
<%--                <li>--%>
<%--                    <a href="/mau-sac/index?page=${pTrang.count}">${pTrang.count}</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>
<%--            <c:if test="${ pTrang.count == 3 }">--%>
<%--                <li>--%>
<%--                    <a href="#">...</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>
            <a href="/mau-sac/index?page=${pTrang.count-1}">${pTrang.count-1}</a>
        </c:forEach>

        <li><a href="#">Next</a></li>
    </ul>
</nav>

</body>
</html>