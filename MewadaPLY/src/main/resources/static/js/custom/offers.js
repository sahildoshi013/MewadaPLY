    var save_method; //for save method string

    function add_offer(){
      save_method = 'add';
      $('#offer_form')[0].reset(); // reset form on modals
      $('[type="submit"]').val('Add Offer');
      $('#modal-default').modal('show'); // show bootstrap modal
      $('.modal-title').text('Add Offer'); // Set Title to Bootstrap modal title
    }

    function edit_offer(id){
      save_method = 'update';
      $('#offer_form')[0].reset(); // reset form on modals

      //Ajax Load data from ajax
      $.ajax({
        url : "/admin/offers/" + id,
        type: "GET",
        success: function(data)
        {
        	console.log(data);
        	var offer = data.message;
            if(data!=null){
	            $('[name="offer_id"]').val(offer.offerId);
	            $('[name="offer_name"]').val(offer.offerName);
	            $('[name="offer_description"]').val(offer.offerDescription);
	            $('[name="offer_point"]').val(offer.offerPoint);
	            $('[name="offer_image_name"]').val(offer.offerImage);
	            $('[type="submit"]').val('Update');

            $('#modal-default').modal('show'); // show bootstrap modal when complete loaded
            $('.modal-title').text('Edit Offer'); // Set title to Bootstrap modal title
            }
            else{
                alert('Error get data from ajax');
            }

        },
        error: function (jqXHR, textStatus, errorThrown)
        {
        	console.log(jqXHR);
            alert('Error get data from ajax');
        }
    });
    }

    function save(event)
    {
        event.stopPropagation(); // Stop stuff happening
        event.preventDefault();

        var url;
        var type;
        if(save_method == 'add')
        {
        	url = "/admin/offers";
        	type = 'POST';
        }
        else
        {
        	url = "/admin/offers";
        	type = 'PUT';
        }
        if (typeof FormData !== 'undefined') {

                // send the formData
                var formData = new FormData( $("#offer_form")[0] );

                $.ajax({
                    url : url,  // Controller URL
                    type : type,
                    data : formData,
                    async : true,
                    cache : false,
                    contentType : false,
                    processData : false,
                    dataType : "json",
                    success : function(data) {
                        if(data["status"]){
                            $('#modal-default').modal('hide');
                            location.reload(true);
                        }else{
                            console.log(data);
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown)
                    {
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

    function delete_offer(id)
    {
      if(confirm('Are you sure delete this data?'))
      {
        // ajax delete data from database
            var parentdiv = $('#'+id).parent().parent().parent();
          $.ajax({
            url : "/admin/offers/"+id,
            type: "DELETE",
            success: function(data)
            {
            	if(data['status']){
            		parentdiv.fadeOut(300, function(){ $(this).remove(); location. reload(true); });
                 }else{
                	   alert('Error while deleting offer');
                 }
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                alert('Error deleting data');
                console.log(jqXHR);
            }
        });

      }
    }

    function toggleOffer(id) {
        $.ajax({
              url : "/admin/offers/"+id+"/toggle_offer",
              type: "PUT",
              success: function(data)
              {
                    if(!data['status']){
                    	location.reload(true);
                        alert('Error while toggling offer');
                    }
                        
              },
              error: function (jqXHR, textStatus, errorThrown)
              {
                  alert('Error while toggling offer');
              }
          });
    }