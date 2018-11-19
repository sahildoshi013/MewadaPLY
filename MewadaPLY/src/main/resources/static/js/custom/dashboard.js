$(".js-example-data-ajax").select2({
    ajax: {
        url: function (params) {
        		var url = 'http://localhost:8080/admin/userlist/'+ params.term;
                return url;
              },
        type: 'GET',
        dataType: 'json',
        delay: 250,
        processResults: function (data, params) {
            return {
                results: data.results
            };
        },
        cache: true
    },
    placeholder: 'Enter Name or Number',
    escapeMarkup: function (markup) { 
    		return markup; 
    	}, // let our custom formatter work
    templateResult: formatRepo,
    templateSelection: formatRepoSelection,
    width: 'resolve'
});

function formatRepo (repo) {
    if (repo.loading) {
        return repo.text;
    }
    
    var markup = "<div class=\"row\" style=\"width: 95%;\">"+
        "<div class=\"col-md-2 center-block \">"+
            "<img src=\"/images/users/"+ repo.data.profilePic + "\" class=\"img-circle\" style=\"width:30px; height: 30px;\">"+
        "</div>"+
        "<div class=\"col-md-9\">"+
            "<div>"+
                "<b>"+ repo.data.firstName + " " + repo.data.lastName +"</b>"+
            "</div>"+
            repo.data.phoneNo +
        "</div>"+
    "</div>";

    return markup;
}

function formatRepoSelection (repo) {
    return repo.text;
}


function add_reward(event) {
    event.preventDefault();
    event.stopPropagation();

    if (typeof FormData !== 'undefined') {

        // send the formData
        var formData = new FormData($("#reward_form")[0]);

        var url = '/admin/transaction';
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