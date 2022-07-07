$(document).ready(function () {
    $('.btn-delete').click(function () {
        let id = $(this).data("id");
        $('.btn-confirm-delete').attr("href", "/application?action=delete&id=" + id);
    });
    // tao button edit
    $('.btn-edit').click(function () {
        let object = $(this).data("object");
        let people = $(this).data("id_patience");
        let name = $(this).data("name_patience");
        let datein = $(this).data("date_in");
        let dateout = $(this).data("date_out");
        let reason = $(this).data("reason");
        console.log(category);
        $("#id-object").val(object);
        $("#id-object-disable").val(object);
        $("#id-patience").val(people);
        $("#id-patience-disable").val(people);
        $("#name-patience").val(name);
        $("#date-in").val(datein);
        $("#date-out").val(dateout);
        $("#reason-input").val(reason);
    })
    $('.confirm-edit').click(function () {
        $('#form_edit').attr("action", "/application?action=edit&id=" + object);
    })
});
