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


<a href="/sp-chi-tiet/create">thêm mới</a>
    <table border="1">
        <thead>
        <tr>
            <th>Mã sản phẩm chi tiết</th>
            <th>id kích thước</th>
            <th>id màu sắc</th>
            <th>id sản phẩm</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${pageSPCT.content}" var="spct">
                <tr>
                    <td>${ spct.maSpct }</td>
                    <td>${ spct.idKichThuoc }</td>
                    <td>${ spct.idMauSac }</td>
                    <td>${ spct.idSanPham }</td>
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

<nav>
    <ul>
        <c:forEach begin="1" end="${pageSPCT.totalPages}" varStatus="pTrang">
            <a href="/sp-chi-tiet/index?page=${pTrang.count-1}">${pTrang.count-1}</a>
        </c:forEach>
    </ul>
</nav>
</body>
</html>