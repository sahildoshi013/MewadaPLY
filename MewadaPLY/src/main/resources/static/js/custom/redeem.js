$(document).ready(function() {
        $('#pending_requests_table').DataTable();
        $('#process_requests_table').DataTable();
    });

    function update_request(event,id,value) {
        if(confirm('Are you sure?')){
            var url = '/admin/redeem/'+id+'/'+value;
            $.ajax({
                url : url,  // Controller URL
                type : 'PUT',
                async : true,
                cache : false,
                contentType : false,
                processData : false,
                dataType : "json",
                success : function(data) {
                    console.log(data);
                    if(data["status"]){
                        location.reload(true);
                    }else{
                        alert('Error');
                    }
                },
                error: function (jqXHR, textStatus, errorThrown)
                {
                    console.log(jqXHR);
                    console.log(textStatus);
                    console.log(errorThrown);
                    alert('Error');
                }
            });
        }
    }
