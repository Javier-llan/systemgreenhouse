function searchByName(){ 
	var filtro = $("#txtMaterialName").val();
	$.ajax({
		url : "/chemicalandmaterial/search/" + filtro,
		method : 'GET',
		success : function(response){
			$("#materialid").empty();			
			var count = Object.keys(response).length;			
			if(count > 0){								
				$("#materialid").addClass('visible').removeClass('invisible');
				$.each( response, function(index, chemicalAndMaterial ) {					
					$("#materialid").append("<option value='"+ chemicalAndMaterial.idchemicalAndMaterial +"'>" + chemicalAndMaterial.nameMaterial + "</option>");		
					
				});
			}
			else{
				$("#materialid").addClass('invisible').removeClass('visible');
				console.log("No hay Materiales o quimicos ingresado con el nombre: " + filtro);				
			}			
		},
		error : function(err){
			console.error(err);
		}		
	});
}


//create
function create(){		
	$.ajax({
		url : "/usedmaterial/create",
		method : 'GET',
		success : function(response){
			console.log(response);
			$("#contentFrmUsedMaterial").empty();
			$("#contentFrmUsedMaterial").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}


//list


function list(){
	$.ajax({
		url: "/maintenancegreenhouse/items",
		method: 'GET',
		success: function(response){
			$("#listMateriales").empty();
			$("#listMateriales").html(response);
		},
		error: function(err){
			console.log(err);
		}
	});
}

//save 

function save(){	
	var dataForm = objectifyForm($("#frmUsedMaterial").serializeArray());	
	var requestBody = JSON.stringify(dataForm);
	console.log(requestBody);			
	$.ajax({
		url : developURL + "maintenancegreenhouse/add",
		method : 'POST',
		contentType : "application/json",
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},		
		data : requestBody,
		success : function(response){
			console.log(response);			 
			list();
		},
		error : function(err){
			console.log(err);
		}		
	});
	
}


//document

$(document).ready(function(){
	
	list();
	
	$("#btnAdd").click(function(){
		create();		
	});
	
	$("#btnSubmit").click(function(){
		save();		
	});
		
});