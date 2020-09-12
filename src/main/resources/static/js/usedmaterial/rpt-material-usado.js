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
					backgroundColor:  ["rgb(255, 99, 132)","rgb(54, 162, 235)","rgb(255, 205, 86)","rgb(255, 60, 50)","rgb(255, 99, 71)","rgb(255, 255, 0)","rgb(0, 255, 0)","rgb(210, 105, 30)"],
					borderColor:  Color(getRandomColor()).alpha(0.5).rgbString(),
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