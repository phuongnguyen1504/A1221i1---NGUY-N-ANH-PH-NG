$(document).ready(function () {
    const valid_id_object=/^[Bb][aA]-\d{3}$/;
    const validEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    $('.btn-delete').click(function () {
        let id = $(this).data("id");
        $('.btn-confirm-delete').attr("href", "/application?action=delete&id=" + id);
    });
    // tao button edit
    $('.btn-edit').click(function () {
        let object = $(this).data("object");
        let people = $(this).data("people");
        let datein = $(this).data("datein");
        let dateout = $(this).data("dateout");
        let reason = $(this).data("reason");
        $("#id-object").val(object);
        $("#id-object-disable").val(object);
        $("#id-patience").val(people);
        $("#id-patience-disable").val(people);
        $("div .set-select select").val(people);
        $("#date-in").val(datein);
        $("#date-out").val(dateout);
        $("#reason-input").val(reason);
    })
    $('.confirm-edit').click(function () {
        $('#form_edit').attr("action", "/application?action=edit&id=" + object);
    });
    //tao function search
    $('.btn-search').click(function () {
        let key = $('#select-sort').val();
        let value = $('#input-search').val();
        $('.btn-search').attr('type', 'submit');
        debugger;
        if (value == null || value == "") {
            $('#form-search').attr('action', '/application');

        } else if (value != null && key == "All") {
            var val = value.toLowerCase();
            $("#myTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
            });
            $('#form-search').attr('action', '/application?action=');
            $('.btn-search').attr('type', 'button');

        } else {
            $('#form-search').attr('action', '/application?action=search&key=' + key + '&value=' + value);
        }
    });
    $('.id-object').on('input',function (){
       let id=$(this).val();
       if(id.length==0){
           $('.object-msg').addClass('invalid-msg').text("ID is required");
           $(this).addClass('invalid-input').removeClass('valid-input');
       }
       else if(!id.match(valid_id_object)){
           $('.object-msg').addClass('invalid-msg').text("ID is required start BA- and three number behind");
           $(this).addClass('invalid-input').removeClass('valid-input');
       }else {
           $('.object-msg').empty();
           $(this).addClass('valid-input').removeClass('invalid-input');

       }
    });


    // validation to submit the form
    $('input').on('input',function(e){
        if($('#myForm').find('.valid-input').length==1){
            $('#submit-btn').removeClass('allowed-submit');
            $('#submit-btn').removeAttr('disabled');
        }
        else{
            e.preventDefault();
            $('#submit-btn').attr('disabled','disabled')

        }
    });

});
