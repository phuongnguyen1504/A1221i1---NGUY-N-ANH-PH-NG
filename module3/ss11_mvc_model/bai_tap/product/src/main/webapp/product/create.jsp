<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>Create new Product</h1>
<p>
  <c:if test='${requestScope["message"]}'>
      <span>${requestScope["message"]}</span>
  </c:if>
</p>
<p>
    <a href="/product">Back to Product</a>
</p>
<form class="form-group" method="post">
    <label>ID:</label>
    <input type="text" name="id" class="form-control" placeholder="Enter your id:" aria-describedby="helpId">
    <label>Name</label>
    <input type="text" name="name" class="form-control" placeholder="Enter your name:" aria-describedby="helpId">
    <label>Price</label>
    <input type="text" name="price" class="form-control" placeholder="Enter your price:" aria-describedby="helpId">
    <label>Description</label>
    <input type="text" name="description" class="form-control" placeholder="Enter your description:" aria-describedby="helpId">
    <label>Manufacture</label>
    <input type="text" name="manufacture" class="form-control" placeholder="Enter your manufacture:" aria-describedby="helpId">
    <button class="btn btn-primary" type="button">Edit</button>

</form>
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