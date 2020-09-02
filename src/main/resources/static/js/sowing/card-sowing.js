

function save(){	
	var dataForm = objectifyForm($("#frmSowing").serializeArray());	
	var requestBody = JSON.stringify(dataForm);
	console.log(requestBody);			
	$.ajax({
		url : developURL + "sowing/save",
		method : 'POST',
		contentType : "application/json",
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},		
		data : requestBody,
		success : function(response){
			console.log(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
	
}

function create(){
	var id = $("#idplant").val();	
	$.ajax({
		url : "/sowing/create/" + id,
		method : 'GET',
		success : function(response){			
			$("#contentSowing").empty();
			$("#contentSowing").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}

function list(){
	var id = $("#idplant").val();
	$.ajax({
		url : "/sowing/list/" + id,
		method : 'GET',
		success : function(response){
			$("#listSowing").empty();
			$("#listSowing").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});	
}

$(document).ready(function(){
	
	console.log("Página cargada...");
	
	$("#btnAdd").click(function(){
		create();		
	});
	
	$("#btnSubmit").click(function(){
		save();		
	});
	
	$("#tab--2").click(function(){
		list();		
	});
	
});
