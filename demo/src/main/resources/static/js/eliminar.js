function eliminar(id) {
	$("#IDLibro").val(id);
	$("#eliminarRegistro").modal("show");
}

function eliminarRegistro(){
	$.ajax({
		type: "GET",
		url:"/delete/"+$("#IDLibro").val(),
		success: function(res){
			console.log(res);
			if(res == "-1"){
				location.reload();
			}
			$("#eliminarRegistro").modal("hide");
		}
	})
}