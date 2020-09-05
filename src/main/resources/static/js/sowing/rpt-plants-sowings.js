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
				toLabels.push(item.planta);						
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
							text: 'Matrículas por materia y por usuario'
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

function report2(){
	
	
	
	
	var color = Chart.helpers.color;
	var barChartData = {
		labels: ['Certificación I', 'Ingeniería Web', 'Métodos numéricos', 'Estructura de datos', 'Metodología'],
		datasets: [{
			label: 'diegoismael',
			backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),			
			borderWidth: 1,
			data: [
				10,
				2,
				5,
				9,
				8				
			]
		}, {
			label: 'dsanchez',
			backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),			
			borderWidth: 1,
			data: [
				16,
				12,
				4,
				0,
				9
			]
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
					text: 'Matrículas por materia y por usuario'
				}
			}
		});

	};		
}

$(document).ready(function(){
	
	report();		

	
});

