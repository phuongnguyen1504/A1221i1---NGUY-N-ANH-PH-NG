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
    <script src="/application/list.js"></script>
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
               data-bs-target="#createObjectModal" href="">Add</a>
            <%--      <a class="btn btn-danger btn-delete" style="margin-left: 15px" data-bs-toggle="modal" data-bs-target="#deleteModal">Xóa</a>--%>
        </div>
        <div class="col-md-6">
            <form action="" method="post" id="form-search" class="d-flex" style="margin-bottom: 0">
                <div class="col-4">
                    <select class="form-select" id="select-sort" aria-label="Default select example">
                        <option value="All" selected>All</option>
                        <option value="name">Ma benh an</option>
                        <option value="price">Ma benh nhan</option>
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
                        <button type="submit" class="btn btn-outline-primary btn-search"
                                style="font-family:Arial, FontAwesome;margin-left:1%" href="">&#xF002 Search
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <c:if test='${not empty m}'>
            <script>
                const t =${m};
                iziToast.success({
                    position: "topRight",
                    message: t == 1 ? "Deleted successfully" : t == 2 ? "Update successfully" : t == 3 ? "Created successfully" : "Not success",
                    timeout: 2000
                });
            </script>
        </c:if>
        <c:if test="${empty objectList}">
            <p>Empty List Object/Not Found</p>
        </c:if>
        <c:if test="${not empty objectList}">
            <table class="table table-dark table-striped table-hover" id="myTable">
                <thead class="table table-info">
                <tr>
                        <%--                    <th>STT</th>--%>
                        <%--                    <th>Ma benh an</th>--%>
                        <%--                    <th>Ma benh nhan</th>--%>
                        <%--                    <th>Ten benh nhan</th>--%>
                        <%--                    <th>Ngay nhap vien</th>--%>
                        <%--                    <th>Ngay ra vien</th>--%>
                        <%--                    <th>Ly do nhap vien</th>--%>
                        <%--                    <th>Action</th>--%>
                    <c:forEach var="th" items="${listColumn}">
                        <th><c:out value="${th}"/></th>
                    </c:forEach>
                </tr>
                </thead>
                <tbody class="table-group-divider table-warning" style="border-top-color:red">
                <c:forEach var="object" items='${requestScope["objectList"]}' varStatus="c">

                    <tr>
                        <td><c:out value="${c.count}"/></td>
                        <td id="id_object"><c:out value="${object.id_object}"/></td>
                        <td id="id_patience"><c:out value="${object.id_patience}"/></td>
                        <td id="name_patience"><c:out value="${object.name_patience}"/></td>
                        <td id="date_in"><c:out value="${object.date_in}"/>
                        </td>
                        <td id="date_out"><c:out value="${object.date_out}"/></td>
                        <td id="reason"><c:out value="${object.reason}"/></td>
                        <td>
                            <a class="btn btn-primary btn-edit" data-bs-toggle="modal" data-object="${object.id_object}"
                               data-people="${object.id_patience}" data-name="${object.name_patience}"
                               data-datein="${object.date_in}"
                               data-dateout="${object.date_out}" data-reason="${object.reason}"
                               data-bs-target="#editObjectModal"
                               href="" type="button">Edit</a>
                            <a class="btn btn-danger btn-delete" data-bs-toggle="modal" data-id="${object.id_object}"
                               data-bs-target="#deleteObjectModal" href="" type="button">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<!-- Create Modal -->
<div id="createObjectModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/application?action=create" method="post" id="">
                <div class="modal-header">
                    <h4 class="modal-title">Create Object</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="modal-body">
                        <div class="modal-body">

                            <div class="form-group">
                                <label>Ma benh an</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Ma benh nhan</label>
                                <input type="text" class="form-control" name="id_patience">
                            </div>
                            <div class="form-group">
                                <label>Ten benh nhan</label>
                                <select class="form-select" name="name_patience"
                                        aria-label="Default select example" required>
                                    <c:forEach items="${peopleList}" var="p" varStatus="c">
                                        <option value="${p.id}"><c:out value="${p.name}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Ngay nhap vien</label>
                                <input type="date" class="form-control" name="date_in"
                                       required>
                            </div>
                            <div class="form-group">
                                <label>Ngay ra vien</label>
                                <input type="date" class="form-control" name="date_out"
                                       required>
                            </div>
                            <div class="form-group">
                                <label>Ly do nhap vien</label>
                                <input type="text" class="form-control" name="reason"
                                       required>
                            </div>


                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                                <input type="submit" class="btn btn-primary confirm-edit" value="Xác nhận">
                            </div>
                            <%--                        <input type=datetime-local step=any /> Step any--%>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal -->
<div class="modal fade" id="deleteObjectModal">
    <div class="modal-dialog">
        <div class="modal-content" id="form-confirm-delete">
            <div class="modal-header">
                <h5 class="modal-title">Delete Object</h5>
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
                <a type="button" class="btn btn-danger btn-confirm-delete" href="">Delete</a>
            </div>
        </div>
    </div>
</div>
<!-- Edit Modal -->
<div id="editObjectModal" class="modal fade">
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
                            <input type="text" class="form-control" name="id_object" id="id-object" hidden>
                            <input type="text" class="form-control" name="id_patience" id="id-patience" hidden>
                        </div>
                        <div class="form-group">
                            <label>Ma benh an</label>
                            <input type="text" class="form-control" id="id-object-disable" disabled>
                        </div>
                        <div class="form-group">
                            <label>Ma benh nhan</label>
                            <input type="text" class="form-control" name="id_patience" id="id-patience-disable"
                                   disabled>
                        </div>
                        <div class="form-group">
                            <label>Ten benh nhan</label>
                            <select class="form-select" name="name_patience" id="name-patience"
                                    aria-label="Default select example" required>
                                <c:forEach items="${peopleList}" var="p" varStatus="c">
                                    <option value="${p.id}"><c:out value="${p.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Ngay nhap vien</label>
                            <input type="number" step="any" class="form-control" name="date_in" id="date-in"
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Ngay ra vien</label>
                            <input type="number" class="form-control" name="date_out" id="date-out"
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Ly do nhap vien</label>
                            <input type="text" class="form-control" name="reason" id="reason-input"
                                   required>
                        </div>


                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                            <input type="submit" class="btn btn-primary confirm-edit" value="Xác nhận">
                        </div>
                        <%--                        <input type=datetime-local step=any /> Step any--%>
                    </div>
                </div>
            </form>
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