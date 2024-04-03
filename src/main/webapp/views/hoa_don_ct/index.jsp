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


<a href="/hoa-don-ct/create">thêm mới</a>
<br>
<form method="GET" action="/hoa-don-ct/index">
    <div>
        <label>Tìm theo mã SPCT</label>
        <input type="text" name="maSpct" />
    </div>
    <div>
        <button>Tìm kiếm</button>
    </div>
</form>
<br>
<br>
<form method="GET" action="/hoa-don-ct/index">
    <div>
        <label>Tìm theo ngày</label>
        <input type="date" name="ngayMuaHang" />
    </div>
    <div>
        <button>Tìm kiếm</button>
    </div>
</form>
<br>
    <table border="1">
        <thead>
        <tr>
            <th>ID hóa đơn chi tiết</th>
            <th>Ngày mua hàng</th>
            <th>Mã sản phẩm chi tiết</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Thời gian</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${pageHC.content}" var="hc">
                <tr>
                    <td>${ hc.id }</td>
                    <td>${ hc.ngayMuaHang }</td>
                    <td>${ hc.maSpct }</td>
                    <td>${ hc.soLuong }</td>
                    <td>${ hc.donGia }</td>
                    <td>${ hc.thoiGian }</td>
                    <td>${ hc.trangThai }</td>
                    <td>
                        <a href="/hoa-don-ct/edit/${hc.id}">update</a>
                    </td>
                    <td>
                        <a href="/hoa-don-ct/delete/${hc.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<%--    <nav>--%>
<%--        <ul>--%>
<%--            <c:forEach begin="0" end="${pageHC.totalPages-1}" var="page">--%>
<%--                <a href="/hoa-don-ct/index?page=${page}&maSpct=${param.keyword}">${page+1}</a>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </nav>--%>

<c:choose>
    <c:when test="${param.maSpct ne null}">
        <nav>
            <ul>
                <c:forEach begin="0" end="${pageHC.totalPages-1}" var="page">
                    <c:if test="${page eq pageHC.number}">
                        <li>${page+1}</li>
                    </c:if>
                    <c:if test="${page ne pageHC.number}">
                        <li><a href="/hoa-don-ct/index?page=${page}&maSpct=${param.maSpct}">${page+1}</a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </c:when>
    <c:when test="${param.ngayMuaHang ne null}">
        <nav>
            <ul>
                <c:forEach begin="0" end="${pageHC.totalPages-1}" var="page">
                    <c:if test="${page eq pageHC.number}">
                        <li>${page+1}</li>
                    </c:if>
                    <c:if test="${page ne pageHC.number}">
                        <li><a href="/hoa-don-ct/index?page=${page}&ngayMuaHang=${param.ngayMuaHang}">${page+1}</a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </c:when>
    <c:otherwise>
        <nav>
            <ul>
                <c:forEach begin="0" end="${pageHC.totalPages-1}" var="page">
                    <c:if test="${page eq pageHC.number}">
                        <li>${page+1}</li>
                    </c:if>
                    <c:if test="${page ne pageHC.number}">
                        <li><a href="/hoa-don-ct/index?page=${page}">${page+1}</a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </c:otherwise>
</c:choose>

</body>
</html>