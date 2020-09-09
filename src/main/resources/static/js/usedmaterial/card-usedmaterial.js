function onDelete(id){	
			Swal.fire({
				  title: '¿Estás seguro?',
				  text : "Una vez eliminado no se podrá recuperar el registro" ,
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: 'Eliminar',
				  cancelButtonText: 'Cancelar'
				}).then((result) => {
				  if (result.value) {
				    eliminar(id)
				  }
				})
}

function eliminar(id) {
	$.ajax({
		url : "/usedmaterial/delete/" + id,
		method : 'GET',
		success : function(response){
			Swal.fire(
		      'Material usado eliminado',
		      'Material usado eliminado correctamente.',
		      'success'
		    ).then((result) => {
		    	location.reload();
			})		
		},
		error : function(err){
			Swal.fire(
		      'Ha ocurrido un error',
		      'No se ha podido eliminar el Material usado, intente nuevamente.',
		      'warning'
		    )
			console.error(err);
		}		
	});
}