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
    <table border="1">
        <thead>
        <tr>
<%--            <th>Mã hóa đơn chi tiết</th>--%>
            <th>id hóa đơn</th>
            <th>id sản phẩm chi tiết</th>
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
<%--                    <td>${ hc.maHDCT }</td>--%>
                    <td>${ hc.idHoaDon }</td>
                    <td>${ hc.idSpct }</td>
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

    <nav>
        <ul>
            <c:forEach begin="1" end="${pageHC.totalPages}" varStatus="pTrang">
                <a href="/hoa-don-ct/index?page=${pTrang.count-1}">${pTrang.count-1}</a>
            </c:forEach>
        </ul>
    </nav>
</body>
</html>