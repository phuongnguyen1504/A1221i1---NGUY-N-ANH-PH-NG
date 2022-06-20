<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>List Products</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
</head>
<body>
<h1>Products</h1>
<p>
    <a class="btn btn-primary btn-create" data-toggle="modal" data-id="${product.id}" data-target="#createProductModal" href="" type="button">Add new Product</a>
</p>
<p>
    <a href="/product?action=view">View Product</a>
</p>
<p>
<%--<form class="form-group" action="/product">--%>
    <button type="button" class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off">
        <select class="ui-button" name="selectFind" id="selectItem">
            <option>All</option>
            <option>ID</option>
            <option>Name</option>
            <option>Manufacturer</option>
        </select>
    </button>
    <input type="text" placeholder="Enter value to find:" name="value">
    <button class="btn btn-primary btn-find">Find</button>

    <script>
        $(function () {
            $('.btn-find').click(function () {
                let key=$('#selectItem').val();
                let id= $('#idFind').val();
                $('.btn-find').attr("href","/product?q=:abc");

            })
        })
    </script>
</p>
<c:if test="${empty products}">
    <h1 style="color: red">Product List Empty</h1>
</c:if>
<c:if test="${not empty products}">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Manufacture</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items='${requestScope["products"]}'>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.manufacturer}</td>
                <td>
<%--                    <a class="btn btn-primary" href="/product?action=edit&id=${product.id}" role="button" name="Edit">Edit</a>--%>
<%--                    <a class="btn btn-danger"  href="/product?action=delete&id=${product.id}" onclick="return confirm('Are you sure you want to delete?')" role="button" name="Delete">Delete</a>--%>
                    <!-- Button trigger modal -->

                    <a class="btn btn-primary btn-edit" data-toggle="modal" data-id="${product.id}" data-target="#editProductModal" href="" type="button">Edit</a>
                    <a class="btn btn-danger btn-delete" data-toggle="modal" data-id="${product.id}" data-target="#deleteProductModal" href="" type="button">Delete</a>


    <script>
        $(function () {
            $('.btn-delete').click(function () {
                let id=$(this).data("id");
                $('.btn-confirm-delete').attr("href","/product?action=delete&id="+id);
            })
        });
    </script>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

    <!-- Edit Modal -->
    <div id="createProductModal" class="modal fade">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <form action="/product?action=create" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title">Thêm mới sản phẩm</h4>
                        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close">X</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" class="form-control idProduct" name="id" required>
                        </div>
                        <div class="form-group">
                            <label>Tên sản phẩm</label>
                            <input type="text" class="form-control nameProduct" name="name" required>
                        </div>
                        <div class="form-group">
                            <label>Gía sản phẩm</label>
                            <input type="number" class="form-control priceProduct" name="price"  required>
                        </div>
                        <div class="form-group">
                            <label>Mô tả</label>
                            <textarea class="form-control descriptionProduct" name="description"
                                      required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Nhà sản xuất</label>
                            <input type="text" class="form-control manufacturer" name="manufacture"  required>
                        </div>
                        <%--                        <div class="form-group">--%>
                        <%--                            <label>Hình ảnh</label>--%>
                        <%--                            <input type="file" class="form-control imgProduct" name="imgProduct" value="a">--%>
                        <%--                        </div>--%>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                        <input type="submit" class="btn btn-primary" value="Xác nhận">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Delete Modal -->
    <div class="modal fade" id="deleteProductModal">
        <div class="modal-dialog">
            <div class="modal-content" id="form-confirm-delete">
                <div class="modal-header">
                    <h5 class="modal-title">Delete Product</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    </button>
                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        Are you sure to delete?
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <a type="button" class="btn btn-danger btn-confirm-delete" href="">Delete</a>
                </div>
            </div>
        </div>
    </div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>