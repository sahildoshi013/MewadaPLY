$(".js-example-data-ajax").select2({
	ajax : {
		url : function(params) {
			return 'main/get_users/' + params.term;
		},
		dataType : 'json',
		delay : 250,
		processResults : function(data, params) {
			return {
				results : data.results,
			};
		},
		cache : true
	},
	placeholder : 'Enter Name or Number',
	escapeMarkup : function(markup) {
		console.log(markup);
		return markup;
	}, // let our custom formatter work
	templateResult : formatRepo,
	templateSelection : formatRepoSelection,
	width : 'resolve'
});

function formatRepo(repo) {
	if (repo.loading) {
		return repo.text;
	}

	var markup = "<div class=\"row\" style=\"width: 95%;\">"
			+ "<div class=\"col-md-2 center-block \">"
			+ "<img src=\"/images/users/" + repo.profile_pic
			+ "\" class=\"img-circle\" style=\"width:30px; height: 30px;\">"
			+ "</div>" + "<div class=\"col-md-9\">" + "<div>" + "<b>"
			+ repo.first_name + " " + repo.last_name + "</b>" + "</div>"
			+ repo.phone_no + "</div>" + "</div>";

	console.log(markup);
	return markup;
}

function formatRepoSelection(repo) {
	return repo.text;
}
