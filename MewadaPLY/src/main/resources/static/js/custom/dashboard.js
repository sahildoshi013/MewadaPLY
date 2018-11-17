</script>
$.widget.bridge('uibutton', $.ui.button);
<!-- /.content-wrapper -->
<script type="text/javascript">
    function add_reward(event) {
    event.preventDefault();
    event.stopPropagation();

    if (typeof FormData !== 'undefined') {

        // send the formData
        var formData = new FormData($("#reward_form")[0]);

        var url = 'main/add_reward/';
        $.ajax({
            url: url, // Controller URL
            type: 'POST',
            data: formData,
            async: true,
            cache: false,
            contentType: false,
            processData: false,
            dataType: "json",
            success: function(data) {
                if (data["status"]) {
                    location.reload(true);
                } else {
                    console.log(data);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
                alert('Error adding / update data');
            }
        });

    } else {
        alert("Your Browser Don't support FormData API! Use IE 10 or Above!");
    }
}
$("body").addClass("fixed");
</script>