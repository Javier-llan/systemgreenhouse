function report(){	
	$.ajax({
		url : "/usedmaterial/dataRptGreenHouseUsedMaterial",
		method : 'GET',
		success : function(response){
			console.log(response);
			
			var data = {};
			var labels = response.map((item) => "Invernadero: "+ item.nombre);
			labels = labels.filter((item, i) => labels.indexOf(item) == i);
			
			response.forEach(function(item) {
				if(typeof data[item.tipomaterial] === 'undefined') {
					data[item.tipomaterial] = {
							ids: [],
							tipomaterial: item.tipomaterial,
							cantidad: [],
					}
				}
				
				data[item.tipomaterial].ids.push(item.nombre);
				data[item.tipomaterial].cantidad.push(item.cantidad);
			});
			
			
			var datasets = [];
			
			for(let key in data) {
				let item = data[key];
				
				datasets.push({
					label: item.tipomaterial,
					backgroundColor: Color(getRandomColor()).alpha(0.5).rgbString(),			
					borderWidth: 1,
					minBarLength: 2,
					data: item.cantidad
				})
			}
			
									
			var barChartData = {
				labels: labels,
				datasets: datasets

			};

			var ctx = document.getElementById('rptinvernaderoMaterial').getContext('2d');
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
						text: 'Materiales usados por Invernadero'
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