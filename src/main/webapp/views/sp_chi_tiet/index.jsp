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
<a href="/a">list index</a>
<a href="/sp-chi-tiet/create">Thêm mới</a>
<br>
<form method="GET" action="/sp-chi-tiet/index">
    <div>
        <label>Tìm theo mã SPCT</label>
        <input type="text" name="maSpct"/>
    </div>
    <div>
        <button>Tìm kiếm</button>
    </div>
</form>
<br>
<form method="GET" action="/sp-chi-tiet/index">
    <div>
        <label>Tìm theo tên</label>
        <input type="text" name="keyword"/>
    </div>
    <div>
        <button>Tìm kiếm</button>
    </div>
</form>
<br>
<table border="1">
    <thead>
    <tr>
        <th>ID SPCT</th>
        <th>Mã sản phẩm chi tiết</th>
        <th>Tên kích thước</th>
        <th>Tên màu sắc</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageSPCT.content}" var="spct">
        <tr>
            <td>${ spct.id }</td>
            <td>${ spct.maSpct }</td>
            <td>${ spct.tenKT }</td>
            <td>${ spct.tenMS }</td>
            <td>${ spct.tenSP }</td>
            <td>${ spct.soLuong }</td>
            <td>${ spct.donGia }</td>
            <td>${ spct.trangThai }</td>
            <td>
                <a href="/sp-chi-tiet/edit/${spct.id}">update</a>
            </td>
            <td>
                <a href="/sp-chi-tiet/delete/${spct.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<c:choose>
    <c:when test="${param.maSpct ne null}">
        <nav>
            <ul>
                <c:if test="${pageSPCT.totalPages <= 0}">
                    <p>No pages available</p>
                </c:if>
                <c:forEach begin="0" end="${pageSPCT.totalPages-1}" var="page">
                    <c:if test="${page eq pageSPCT.number}">
                        ${page+1}
                    </c:if>
                    <c:if test="${page ne pageSPCT.number}">
                        <a href="/sp-chi-tiet/index?page=${page}&maSpct=${param.maSpct}&keyword=${param.keyword}">${page+1}</a>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </c:when>
    <c:when test="${param.keyword ne null}">
        <nav>
            <ul>
                <c:if test="${pageSPCT.totalPages <= 0}">
                    <p>No pages available</p>
                </c:if>
                <c:forEach begin="0" end="${pageSPCT.totalPages-1}" var="page">
                    <c:if test="${page eq pageSPCT.number}">
                        ${page+1}
                    </c:if>
                    <c:if test="${page ne pageSPCT.number}">
                        <a href="/sp-chi-tiet/index?page=${page}&maSpct=${param.maSpct}&keyword=${param.keyword}">${page+1}</a>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </c:when>
    <c:otherwise>
        <nav>
            <ul>
                <c:if test="${pageSPCT.totalPages <= 0}">
                    <p>No pages available</p>
                </c:if>
                <c:forEach begin="0" end="${pageSPCT.totalPages-1}" var="page">
                    <c:if test="${page eq pageSPCT.number}">
                        ${page+1}
                    </c:if>
                    <c:if test="${page ne pageSPCT.number}">
                        <a href="/sp-chi-tiet/index?page=${page}&keyword=${param.keyword}">${page+1}</a>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </c:otherwise>
</c:choose>


<%--<nav>--%>
<%--    <ul>--%>
<%--        <c:forEach begin="0" end="${pageSPCT.totalPages-1}" var="page">--%>
<%--            <a href="/sp-chi-tiet/index?page=${page}&keyword=${param.keyword}">${page+1}</a>--%>
<%--        </c:forEach>--%>
<%--    </ul>--%>
<%--</nav>--%>
</body>
</html>