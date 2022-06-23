$(function () {
    $('.btn-delete').click(function () {
        let id=$(this).data("id");
        $('.btn-confirm-delete').attr("href","/users?action=delete&id="+id);
    })
});