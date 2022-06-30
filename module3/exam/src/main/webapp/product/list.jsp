<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EXAM MODULE 3</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
    <script src="webjars/jquery/3.6.0/dist/jquery.slim.min.js"></script>
    <script src="/product/script.js"></script>
    <link rel="stylesheet" href="webjars/izitoast/1.4.0/dist/css/iziToast.min.css"/>
    <script src="webjars/izitoast/1.4.0/dist/js/iziToast.min.js"></script>
</head>

<body>

<div class="container">
    <div class="row">
        <h2 style="text-align:center">Application</h2>
    </div>
    <div class="row mb-2">
        <div class="col-md-6 mb-2">
            <a type="button" class="btn btn-success btn-create" data-bs-toggle="modal"
               data-bs-target="#createProductModal" data-id="${product.id}" href="">Add</a>
            <%--      <a class="btn btn-danger btn-delete" style="margin-left: 15px" data-bs-toggle="modal" data-bs-target="#deleteModal">Xóa</a>--%>
        </div>
        <div class="col-md-6">
            <form action=""  id="form-search" class="d-flex" style="margin-bottom: 0">
                <div class="col-4">
                    <select class="form-select" id="select-sort" aria-label="Default select example">
                        <option value="All" selected>All</option>
                        <option value="name">Product Name</option>
                        <option value="price">Price</option>
                        <option value="quantity">Quantity</option>
                        <option value="color">Color</option>
                        <option value="category">Category</option>
                    </select>
                </div>
                <div class="col-8">
                    <div class="input-group">
                        <input type="search" class="form-control border-end-0 border rounded-pill" id="input-search"
                               placeholder="&#xF002; Search" aria-label="Username" aria-describedby="basic-addon1"
                               style="font-family:Arial, FontAwesome;margin-left:1%">
                        <a type="submit" class="btn btn-outline-primary btn-search"
                           style="font-family:Arial, FontAwesome;margin-left:1%" href="">&#xF002 Search</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <c:if test='${not empty m}'>
            <script>
            const t=${m};
            iziToast.success({position: "topRight", message: t == 1 ? "Deleted successfully" : t == 2 ? "Update successfully" :"Created successfully",timeout:2000});
            </script>
        </c:if>
        <c:if test="${empty products}">
            <p>Empty List Products/Not Found</p>
        </c:if>
        <c:if test="${not empty products}">
            <table class="table table-dark table-striped table-hover" id="myTable">
                <thead class="table table-info">
                <tr>
                    <th>STT</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Category</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody class="table-group-divider table-warning" style="border-top-color:red">
                <c:forEach var="product" items='${requestScope["products"]}' varStatus="c">
                    <tr>
                        <td><c:out value="${c.count}"/></td>
                        <td id="name"><c:out value="${product.name}"/></td>
                        <td id="price"><c:out value="${product.price}"/></td>
                        <td id="quantity"><c:out value="${product.quantity}"/></td>
                        <td id="color"><c:out value="${product.color}"/></td>
                        <td id="category"><c:out value="${product.category}"/></td>
                        <td>
                            <a class="btn btn-primary btn-edit" data-bs-toggle="modal" data-id="${product.id}"
                               data-name="${product.name}" data-price="${product.price}"
                               data-quantity="${product.quantity}"
                               data-color="${product.color}" data-category="${product.category}"
                               data-bs-target="#editUserModal"
                               href="" type="button">Edit</a>
                            <a class="btn btn-danger btn-delete" data-bs-toggle="modal" data-id="${product.id}"
                               data-bs-target="#deleteUserModal" href="" type="button">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<!-- Create Modal -->
<div id="createProductModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/product?action=create" method="post" id="">
                <div class="modal-header">
                    <h4 class="modal-title">Create Product</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Product Name</label>
                            <input type="text" class="form-control" name="name" required>
                        </div>
                        <div class="form-group">
                            <label>Product price</label>
                            <input type="number" class="form-control" name="price" required>
                        </div>
                        <div class="form-group">
                            <label>Product Quantity</label>
                            <input type="number" class="form-control" name="quantity"
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Product color</label>
                            <input type="text" class="form-control" name="color"
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Product Quantity</label>
                            <input type="text" class="form-control" name="category"
                                   required>
                        </div>
                        <%--                        <div class="form-group">--%>
                        <%--                            <label>Hình ảnh</label>--%>
                        <%--                            <input type="file" class="form-control imgProduct" name="imgProduct" value="a">--%>
                        <%--                        </div>--%>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                        <input type="submit" class="btn btn-primary confirm-edit" value="Xác nhận">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal -->
<div id="editUserModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/product?action=edit" method="post" id="form_edit">
                <div class="modal-header">
                    <h4 class="modal-title">Update Product</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="modal-body">
                        <div class="form-group">
                            <label>ID Product</label>
                            <input type="text" class="form-control" name="id" id="product_id" hidden>
                        </div>
                        <div class="form-group">
                            <label>Product Name</label>
                            <input type="text" class="form-control" name="name" id="product_name" required>
                        </div>
                        <div class="form-group">
                            <label>Product price</label>
                            <input type="text" class="form-control" name="price" id="product_price" required>
                        </div>
                        <div class="form-group">
                            <label>Product Quantity</label>
                            <input type="text" class="form-control" name="quantity" id="product_quantity"
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Product color</label>
                            <input type="text" class="form-control" name="color" id="product_color"
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Product category</label>
                            <input type="text" class="form-control" name="category" id="product_category"
                                   required>
                        </div>
                        <%--                        <div class="form-group">--%>
                        <%--                            <label>Hình ảnh</label>--%>
                        <%--                            <input type="file" class="form-control imgProduct" name="imgProduct" value="a">--%>
                        <%--                        </div>--%>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                        <input type="submit" class="btn btn-primary confirm-edit" value="Xác nhận">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal -->
<div class="modal fade" id="deleteUserModal">
    <div class="modal-dialog">
        <div class="modal-content" id="form-confirm-delete">
            <div class="modal-header">
                <h5 class="modal-title">Delete Product</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    Are you sure to delete?
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <a type="button" id="ToastDelete" class="btn btn-danger btn-confirm-delete" href="">Delete</a>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
        crossorigin="anonymous"></script>
</body>

</html>