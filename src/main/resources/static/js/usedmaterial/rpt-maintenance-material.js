function report(){	
	$.ajax({
		url : "/usedmaterial/dataRptUserMaintenanceCreadoPor",
		method : 'GET',
		success : function(response){
			console.log(response);
			
			var data = {};
			var labels = response.map((item) => item.mantenimiento);
			labels = labels.filter((item, i) => labels.indexOf(item) == i);
			
			response.forEach(function(item) {
				if(typeof data[item.creadoPor] === 'undefined') {
					data[item.creadoPor] = {
							mantenimientos: [],
							creadoPor: item.creadoPor,
							stdmantenimientos: [],
					}
				}
				
				data[item.creadoPor].mantenimientos.push(item.mantenimiento);
				data[item.creadoPor].stdmantenimientos.push(item.stdmantenimientos);
			});
			
			
			var datasets = [];
			
			for(let key in data) {
				let item = data[key];
				
				datasets.push({
					label: item.creadoPor,
					backgroundColor: Color(getRandomColor()).alpha(0.5).rgbString(),			
					borderWidth: 1,
					minBarLength: 2,
					data: item.stdmantenimientos
				})
			}
			
									
			var barChartData = {
				labels: labels,
				datasets: datasets

			};

			var ctx = document.getElementById('canvas2').getContext('2d');
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
						text: 'Mantenimientos creados por usuario logeado'
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