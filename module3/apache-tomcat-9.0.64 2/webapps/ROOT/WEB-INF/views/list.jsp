<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

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

<div class="container-fluid">
    <div class="row">
        <h2 style="text-align: center"><b>Tờ khai y tế</b></h2>
        <p>Đây là tài liệu quan trọng, thông tin anh/chị sẽ giúp cơ quan y tế liên lạc khi cần thiết</p>
    </div>
    <form:form modelAttribute="form" method="post">
        <div class="row">
            <label>Họ tên</label><br>
            <form:input path="name" required="required"/>
        </div>
        <div class="row">
            <table>
                <tr>
                    <th>Năm sinh</th>
                    <th>Giới tính</th>
                    <th>Quốc tịch</th>
                </tr>
                <tr>
                    <td><form:input type="number" path="year"  required="required"/></td>
                    <td><form:input path="gender" required="required" /></td>
                    <td><form:input path="national" required="required"/></td>
                </tr>
            </table>
        </div>
        <div class="row">
            <p>Hộ chiếu, CMND</p>
            <form:input type="number" path="identity"/>
        </div>
        <div class="row">
            <p>Thông tin đi lại</p>
            <p>
                <form:radiobutton path="vehicle" value="Tàu bay" label="Tàu bay" required="required"/>
                <form:radiobutton path="vehicle" value="Tàu thuyền" label="Tàu thuyền" required="required"/>
                <form:radiobutton path="vehicle" value="Ô tô" label="Ô tô" required="required"/>
                <form:radiobutton path="vehicle" value="Khác" label="Khác" required="required"/>
            </p>
        </div>
        <div class="row">
            <table>
                <tr>
                    <th>Số hiệu phương tiện</th>
                    <th>Số ghế</th>
                </tr>
                <tr>
                    <td><form:input path="plate" label="VD:VN123"/></td>
                    <td><form:input path="chair"/></td>
                </tr>
            </table>
        </div>
        <div class="row">
            <table>
                <tr>
                    <th>Ngày khởi hành</th>
                    <th>Ngày kết thúc</th>
                </tr>
                <tr>
                    <td><form:input type="date" path="datebegin" required="required"/></td>
                    <td><form:input type="date" path="dateend" required="required"/></td>
                </tr>
            </table>
        </div>
        <div class="row">
            <p>Các anh chị đã đi đâu trong 14 ngày qua</p>
            <form:textarea path="history" required="required"/>
        </div>
        <div class="row">
            <table>
                <tr>
                    <th>Thành phố</th>
                    <th>Quận/Huyện</th>
                    <th>Xã/Phường</th>
                </tr>
                <tr>
                    <td><form:input path="city" required="required"/></td>
                    <td><form:input path="district" required="required"/></td>
                    <td><form:input path="ward" required="required"/></td>
                </tr>
            </table>
        </div>
        <div class="row">
            <p>Địa chỉ nơi ở</p>
            <form:input path="address" required="required"/>
        </div>
        <div class="row">
            <table>
                <tr>
                    <th>Điện thoại</th>
                    <th>Email</th>
                </tr>
                <tr>
                    <td><form:input type="number" path="tel" required="required"/></td>
                    <td><form:input path="mail"/></td>
                </tr>
            </table>
        </div>
        <div class="row">
            <p>Trong vòng 14 ngày qua , anh/chị có dấu hiêu gì không</p>
            <table>
                <tr>
                    <th>Triệu chứng</th>
                    <th>Có</th>
                    <th>Không</th>
                    <th>Triệu chứng</th>
                    <th>Có</th>
                    <th>Không</th>
                </tr>
                <tr>
                    <td>Sốt</td>
                    <td><form:radiobutton path="sot" value="1" required="required"/></td>
                    <td><form:radiobutton path="sot" value="0" required="required"/></td>
                    <td>Buồn nôn</td>
                    <td><form:radiobutton path="non" value="1" required="required"/></td>
                    <td><form:radiobutton path="non" value="0" required="required"/></td>
                </tr>
                <tr>
                    <td>Ho</td>
                    <td><form:radiobutton path="ho" value="1" required="required"/></td>
                    <td><form:radiobutton path="ho" value="0" required="required"/></td>
                    <td>Tiêu chảy</td>
                    <td><form:radiobutton path="tieuchay" value="1" required="required"/></td>
                    <td><form:radiobutton path="tieuchay" value="0" required="required"/></td>
                </tr>
                <tr>
                    <td>Khó thở</td>
                    <td><form:radiobutton path="khotho" value="1" required="required"/></td>
                    <td><form:radiobutton path="khotho" value="0" required="required"/></td>
                    <td>Xuất huyết ngoài da</td>
                    <td><form:radiobutton path="xhngoaida" value="1" required="required"/></td>
                    <td><form:radiobutton path="xhngoaida" value="0" required="required"/></td>
                </tr>
                <tr>
                    <td>Đau họng</td>
                    <td><form:radiobutton path="dauhong" value="1" required="required"/></td>
                    <td><form:radiobutton path="dauhong" value="0" required="required"/></td>
                    <td>Nổi ban ngoài da</td>
                    <td><form:radiobutton path="noiban" value="1" required="required"/></td>
                    <td><form:radiobutton path="noiban" value="0" required="required"/></td>
                </tr>
            </table>
        </div>
        <div class="row">
            <p>Lịch sử phơi nhiểm</p>
            <table>
                <tr>
                    <th> </th>
                    <th>Có</th>
                    <th>Không</th>
                </tr>
                <tr>
                    <td>Đến trang trại nuôi/chợ/cơ sở giết mổ</td>
                    <td><form:radiobutton path="tiepxucdongvat" value="1" required="required"/></td>
                    <td><form:radiobutton path="tiepxucdongvat" value="0" required="required"/></td>
                </tr>
                <tr>
                    <td>Tiếp xúc gần 2 m với người nhiểm COVID</td>
                    <td><form:radiobutton path="tiepxucnguoi" value="1" required="required"/></td>
                    <td><form:radiobutton path="tiepxucnguoi" value="0" required="required"/></td>
                </tr>
            </table>
        </div>
        <div class="row">
            <button type="submit">submit</button>
        </div>
    </form:form>

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