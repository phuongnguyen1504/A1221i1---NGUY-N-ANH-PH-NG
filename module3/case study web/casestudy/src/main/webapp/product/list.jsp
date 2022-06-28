<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Product Manager</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
    <script src="/product/alert.js"></script>
    <link rel="stylesheet" href="/product/style.css"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h2 style="text-align: center;color: red">Product Application</h2>
<p>
    <a class="btn btn-primary btn-create" data-toggle="modal" data-id="${product.id}" data-target="#createProductModal" href="" type="button">Add new Product</a>
</p>
<c:if test="${empty products}">
    <p>Empty List Products</p>
</c:if>
<c:if test="${not empty products}">
    <table class="table">
    <thead>
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
    <tbody>
    <c:forEach var="product" items='${requestScope["products"]}' varStatus="c">
        <tr>
            <td><c:out value="${c.count}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.quantity}"/></td>
            <td><c:out value="${product.color}"/></td>
            <td><c:out value="${product.category}"/></td>
            <td>
                <a class="btn btn-primary btn-edit" data-toggle="modal" data-id="${product.id}" data-name="${product.name}" data-price="${product.price}" data-quantity="${product.quantity}"
                   data-color="${product.color}" data-category="${product.category}" data-target="#editUserModal" href="" type="button">Edit</a>
                <a class="btn btn-danger btn-delete" data-toggle="modal" data-id="${product.id}" data-target="#deleteUserModal" href="" type="button">Delete</a>
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
            <form action="/product?action=create" method="post" id="">
                <div class="modal-header">
                    <h4 class="modal-title">Create Product</h4>
                    <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close">X</button>
                </div>
                <div class="modal-body">
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Product Name</label>
                            <input type="text" class="form-control" name="name" required>
                        </div>
                        <div class="form-group">
                            <label>Product price</label>
                            <input type="text" class="form-control" name="price" required>
                        </div>
                        <div class="form-group">
                            <label>Product Quantity</label>
                            <input type="text" class="form-control" name="quantity"
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
                        <input type="submit"  class="btn btn-primary confirm-edit" value="Xác nhận">
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
                    <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close">X</button>
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
                        <input type="submit"  class="btn btn-primary confirm-edit" value="Xác nhận">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $('.btn-edit').click(function () {
        let id=$(this).data("id");
        let name=$(this).data("name");
        let price=$(this).data("price");
        let quantity=$(this).data("quantity");
        let color=$(this).data("color");
        let category=$(this).data("category");
        $("#product_id").val(id);
        $("#product_name").val(name);
        $("#product_price").val(price);
        $("#product_quantity").val(quantity);
        $("#product_color").val(color);
        $("#product_category").val(category);
    })
    $('.confirm-edit').click(function () {
        $('#form_edit').attr("action","/product?action=edit&id="+id);
    })
</script>
<!-- Delete Modal -->
<div class="modal fade" id="deleteUserModal">
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
                <a type="button" id="ToastDelete" class="btn btn-danger btn-confirm-delete" href="">Delete</a>
            </div>
        </div>
    </div>
</div>
<div class="toast" id="myToast">
    <div class="toast-header">
        <strong class="me-auto"><i class="bi-gift-fill"></i> We miss you!</strong>
        <small>10 mins ago</small>
        <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
    </div>
    <div class="toast-body">
        It's been a long time since you visited us. We've something special for you. <a href="#">Click here!</a>
    </div>
</div>
<script>
    $(function () {
      $('.btn-delete').click(function () {
        let id=$(this).data("id");
        $('.btn-confirm-delete').attr("href","/product?action=delete&id="+id);
      })
    });
    $(function (){
        $('#ToastDelete').click(function () {
            $('#myToast').toast({
                delay:1000
            });
            $("#myToast").toast("show");
        })
    });
</script>

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