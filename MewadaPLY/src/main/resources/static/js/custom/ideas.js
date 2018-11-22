//Dropzone.option.my-awesome-dropzone.acceptedFiles = "image/*";
Dropzone.options.myAwesomeDropzone = {
		paramName : "image",
		maxFilesize : 2, // MB
		acceptedFiles : "image/*",
		uploadMultiple : true,
		init: function() {
	        this.on("error", function(file, response) {
	            // do stuff here.
	            console.log(response);
	        });
	    }
};

function addCategory() {
	$.ajax({
		url : "ideas/createIdeaType",
		type : "POST",
		dataType : "JSON",
		data : $('#category_form').serialize(),
		success : function(data) {
			if (data['isSuccess']) {
				$("#modal_close").click();
			} else {
				alert('Error adding data');
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Error adding data');
		}
	});
}

function add_image() {
	$('#add_image_model').modal('show'); // show bootstrap modal
}

$('#add_image_model').on('hidden.bs.modal', function() {
	location.reload(true);
});

function delete_image(id) {
	if (confirm('Are you sure delete this data?')) {
		// ajax delete data from database
		var parentdiv = $('#' + id).parent();
		var url = 'http://' +$(location).attr('host')+'/admin/ideas/' + id;
		console.log(url);
		$.ajax({
			url : url,
			type : "DELETE",
			dataType : "JSON",
			success : function(data) {
				parentdiv.fadeOut(300, function() {
					$(this).remove();
					location.reload(true);
				});
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Error deleting data');
				console.log(jqXHR);
				console.log(jqtextStatus);
				console.log(errorThrown);
			}
		});

	}
}