$(document).ready(function () {
    $('.btn-delete').click(function () {
        let id = $(this).data("id_object");
        $('.btn-confirm-delete').attr("href", "/product?action=delete&id=" + id);
    });
    // tao button edit
    $('.btn-edit').click(function () {
        let id_object = $(this).data("id-object");
        let id_patience = $(this).data("id-patience");
        let name_patience = $(this).data("name-patience");
        let date_in = $(this).data("date-in");
        let date_out = $(this).data("date-out");
        let reason = $(this).data("reason");
        console.log(category);
        $("#id-object").val(id_object);
        $("#id-object-disable").val(id_object);
        $("#id-patience").val(id_patience);
        $("#id-patience-disable").val(id_patience);
        $("#name-patience").val(name_patience);
        $("#date-in").val(date_in);
        $("#date-out").val(date_out);
        $("#reason-input").val(reason);
    })
    $('.confirm-edit').click(function () {
        $('#form_edit').attr("action", "/product?action=edit&id=" + id_object);
    })
});
