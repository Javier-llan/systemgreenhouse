function alertDeletePlant(id) {
	
	swal.fire({
		  title: '¿Estás seguro?',
		  text : "Una vez eliminado, ¡no podrás recuperar este registro!" ,
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Sí, Eliminar!',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) {
		    deletePlant(id)
		  }
		})
}

function deletePlant(id) {
	$.ajax({
		url : "/plant/delete/" + id,
		method : 'GET',
		success : function(response){
			swal.fire(
		      'PLanta eliminada',
		      'La planta se ha eliminado con exito.',
		      'success'
		    ).then((result) => {
		    	location.reload();
			})		
		},
		error : function(err){
			swal.fire(
		      'Ha ocurrido un error',
		      'No se ha podido eliminar la planta, intente nuevamente.',
		      'warning'
		    )
			console.error(err);
		}		
	});
}