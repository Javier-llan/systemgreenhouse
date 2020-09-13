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
					backgroundColor: getRandomColor(),
					borderColor: getRandomColor(),
					borderWidth: 1,
					data: toData
				}]

			};

			
				var ctx = document.getElementById('reporteSiembras').getContext('2d');
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
						text: 'Cantidad de siembras por planta'
					},
					scales: {
				        yAxes: [{
				            ticks: {
				                beginAtZero: true
				            }
				        }]
				    }
				 }
				});

				
			
		},
		error : function(err){
			console.log(err);
		}		
	});	
}



$(document).ready(function(){
	
	setTimeout(function() {
		report();
	},1000)

	
});

