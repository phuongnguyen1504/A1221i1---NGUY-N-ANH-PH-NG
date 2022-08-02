$(function () {
    let val=$('#popup').val();
    switch (val){
        case "1":
            $('#detailModal').modal('show');
            break;
        default:
            break;
    }
})