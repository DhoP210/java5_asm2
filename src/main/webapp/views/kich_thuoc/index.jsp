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

    <a href="/kich-thuoc/create">thêm mới</a>

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
            <c:forEach items="${pageKT.content}" var="kt">
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

    <nav>
        <ul>
            <li><a href="#">Previous</a></li>
            <c:forEach begin="1" end="${pageKT.totalPages}" varStatus="pTrang" >
<%--                <c:if test="${ pTrang.count < 3 || pTrang.count > pageKT.totalPages - 3}">--%>
<%--                    <li>--%>
                        <a href="/kich-thuoc/index?page=${pTrang.count-1}">${pTrang.count-1}</a><br>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${ pTrang.count == 2 }">--%>
<%--                    <li>--%>
<%--                        <a href="#">...</a>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
            </c:forEach>
            <li><a href="#">Next</a></li>
        </ul>
    </nav>
</body>
</html>