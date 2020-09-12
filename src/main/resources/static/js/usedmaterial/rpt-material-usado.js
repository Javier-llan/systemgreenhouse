function reportmu(){	
	$.ajax({
		url : "/usedmaterial/dataRptMaterialesUsados",
		method : 'GET',
		success : function(response){
			console.log(response);
			
			var toData = [];
			var toLabels = [];
			var toColors = [];
			
			$.each(response, function(i, item){
				console.log(item);
				toData.push(item.cantidad);
				toLabels.push(item.nombre);						
				toColors.push(getRandomColor());
			});
									
			var datos = {
				labels: toLabels,
				datasets: [{
					label: 'Materiales',
					backgroundColor: getRandomColor(),
					borderColor: getRandomColor(),
					borderWidth: 1,
					data: toData
				}]

			};

			
				var ctx = document.getElementById('rptmaterialUsado').getContext('2d');
				window.myPieChart = new Chart(ctx, {
					type: 'pie',
					data: datos,
					
				});

				
			
		},
		error : function(err){
			console.log(err);
		}		
	});	
}



$(document).ready(function(){
	
	setTimeout(function() {
		reportmu();
	},1000)

	
});