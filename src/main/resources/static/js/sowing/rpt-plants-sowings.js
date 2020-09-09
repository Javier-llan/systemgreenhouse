function report(){	
	$.ajax({
		url : "/sowing/dataRptPlantadosSiembras",
		method : 'GET',
		success : function(response){
			console.log(response);
			
			var toData = [];
			var toLabels = [];
			var toColors = [];
			
			$.each(response, function(i, item){
				console.log(item);
				toData.push(item.siembras);
				toLabels.push(item.nombre_planta);						
				toColors.push(getRandomColor());
			});
									
			var barChartData = {
				labels: toLabels,
				datasets: [{
					label: 'Plantas',
					backgroundColor: Color(getRandomColor()).alpha(0.5).rgbString(),
					borderColor: Color(getRandomColor()).alpha(0.5).rgbString(),
					borderWidth: 1,
					data: toData
				}]

			};

			window.onload = function() {
				var ctx = document.getElementById('canvas').getContext('2d');
				window.myBar = new Chart(ctx, {
					type: 'bar',
					data: barChartData,
					options: {
						responsive: true,
						legend: {
							position: 'top',
						},
						title: {
							display: true,
							text: 'Reporte de plantas sembradas'
						}
					}
				});

			};		
			
		},
		error : function(err){
			console.log(err);
		}		
	});	
}



$(document).ready(function(){
	
	report();		

	
});

