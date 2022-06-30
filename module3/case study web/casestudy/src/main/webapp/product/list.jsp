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
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet"/>
    <link href="/libs/toastr.min.css" type="text/css" rel="stylesheet"/>
    <link href="/product/toast.css" type="text/css" rel="stylesheet"/>
    <script src="/product/toast.js"></script>
    <link rel="stylesheet" type="text/css" href="/product/style.css"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- ====== Fontawesome CDN Link ====== -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>

    <link rel="stylesheet" href="/webjars/izitoast/1.4.0/dist/css/iziToast.min.css">
    <script src="/webjars/izitoast/1.4.0/dist/js/iziToast.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <h2 style="text-align: center;color: red">Product Application</h2>
    <div class="row">
        <div class="col-4 bg-success">
            <p style="display: flex; align-content: center; align-items: center; vertical-align: center">
                <a class="btn btn-primary btn-create" data-toggle="modal" data-id="${product.id}" data-target="#createProductModal"
                   href="" type="button">Add new Product</a>
            </p>
        </div >

        <div class="col-8 bg-warning">
            <div >
                <select id="selectValue" class="btn btn-outline-secondary dropdown-toggle">
                    <option value="All" selected>All</option>
                    <option value="name">Product Name</option>
                    <option value="price">Price</option>
                    <option value="quantity">Quantity</option>
                    <option value="color">Color</option>
                    <option value="category">Category</option>
                </select>
            </div>
            <div>
                <i style="flex: 30%" class="fas fa-solid fa-search search-icon"></i>
                <input style="flex: 70%" type="search" id="myInput" class="form-control" placeholder="Search.."
                       aria-label="Text input with dropdown button">
            </div>
            <div>
                <button>Hello</button>
            </div>
<%--            <p>--%>
<%--            <div class="input-group col-6">--%>
<%--                <div class="input-group-prepend select-bar">--%>
<%--                    <select id="selectValue" class="btn btn-outline-secondary dropdown-toggle">--%>
<%--                        <option value="All" selected>All</option>--%>
<%--                        <option value="name">Product Name</option>--%>
<%--                        <option value="price">Price</option>--%>
<%--                        <option value="quantity">Quantity</option>--%>
<%--                        <option value="color">Color</option>--%>
<%--                        <option value="category">Category</option>--%>
<%--                    </select>--%>
<%--                </div>--%>
<%--                <div class="input-icon">--%>
<%--                    <i class="fas fa-solid fa-search search-icon"></i>--%>
<%--                    <input type="search" id="myInput" class="form-control" placeholder="Search.."--%>
<%--                           aria-label="Text input with dropdown button">--%>
<%--                </div>--%>
<%--            </div>--%>



            <%--    <select id="selectValue">--%>
            <%--        <option value="All" selected>All</option>--%>
            <%--        <option value="name">name</option>--%>
            <%--        <option value="price">price</option>--%>
            <%--        <option value="quantity">quantity</option>--%>
            <%--        <option value="color">color</option>--%>
            <%--        <option value="category">category</option>--%>
            <%--    </select>--%>
            <%--    <input class="alert-container" id="myInput" type="text" placeholder="Search..">--%>
<%--            </p>--%>
        </div>
    </div>



<c:if test='${not empty m}'>
    <script>
        const t = ${m};
        iziToast.success({position: "topRight", message: t == 1 ? "Deleted successfully" : t == 2 ? "Update successfully" :"Created successfully"});
    </script>

<%--    ${messageinfo==""};--%>
</c:if>
<c:if test="${empty products}">
    <p>Empty List Products</p>
</c:if>
<c:if test="${not empty products}">
    <table class="table table-hover table-striped" id="myTable">
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
                <td id="name"><c:out value="${product.name}"/></td>
                <td id="price"><c:out value="${product.price}"/></td>
                <td id="quantity"><c:out value="${product.quantity}"/></td>
                <td id="color"><c:out value="${product.color}"/></td>
                <td id="category"><c:out value="${product.category}"/></td>
                <td>
                    <a class="btn btn-primary btn-edit" data-toggle="modal" data-id="${product.id}"
                       data-name="${product.name}" data-price="${product.price}" data-quantity="${product.quantity}"
                       data-color="${product.color}" data-category="${product.category}" data-target="#editUserModal"
                       href="" type="button">Edit</a>
                    <a class="btn btn-danger btn-delete" data-toggle="modal" data-id="${product.id}"
                       data-target="#deleteUserModal" href="" type="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<%--    Tạo filter--%>
<script>
    $(document).ready(function () {
        $("#myInput").on("keyup", function () {
            if ($("#selectValue").val() == "All") {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            } else {
                myFunction();
            }
        });
    });

    function myFunction() {
        var input, filter, selectValue, table, tr, td, i, txtValue, index;
        selectValue = document.getElementById("selectValue").value;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");
        switch (selectValue) {
            case "name":
                index = 1;
                break;
            case "price":
                index = 2;
                break;
            case "quantity":
                index = 3;
                break;
            case "color":
                index = 4;
                break;
            case "category":
                index = 5;
                break;
        }
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[index];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
<!-- Create Modal -->
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
                        <input type="submit" class="btn btn-primary confirm-edit" value="Xác nhận">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $('.btn-edit').click(function () {
        let id = $(this).data("id");
        let name = $(this).data("name");
        let price = $(this).data("price");
        let quantity = $(this).data("quantity");
        let color = $(this).data("color");
        let category = $(this).data("category");
        $("#product_id").val(id);
        $("#product_name").val(name);
        $("#product_price").val(price);
        $("#product_quantity").val(quantity);
        $("#product_color").val(color);
        $("#product_category").val(category);
    })
    $('.confirm-edit').click(function () {
        $('#form_edit').attr("action", "/product?action=edit&id=" + id);
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

<script>
    $(function () {
        $('.btn-delete').click(function () {
            let id = $(this).data("id");
            $('.btn-confirm-delete').attr("href", "/product?action=delete&id=" + id);
        })
    });
</script>
<%--Tạo toast message thanh cong--%>
<div class="toast">
    <div class="toast-content">
        <i class="fas fa-solid fa-check check"></i>

        <div class="message">
            <span class="text text-1">Success</span>
            <span class="text text-2">Your changes has been saved</span>
        </div>
    </div>
    <i class="fa-solid fa-xmark close"></i>

    <div class="progress"></div>
</div>

<button id="myButton">Show Toast</button>


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
<script src="/libs/toastr.min.js"></script>
<script src="/product/toast.js"></script>
</div>
</body>
</html>