$(document).ready(function() {
    $('#generate').click(function() {
        var values = ["dog", "cat", "parrot", "rabbit"];

        var select = $('<select>').prop('id', 'pets')
            .prop('name', 'pets');

        $(values).each(function() {
            select.append($("<option>")
                .prop('value', this)
                .text(this.charAt(0).toUpperCase() + this.slice(1)));
        });

        var label = $("<label>").prop('for', 'pets')
            .text("Choose your pets: ");

        var br = $("<br>");

        $('#container').append(label).append(select).append(br);
    })
});