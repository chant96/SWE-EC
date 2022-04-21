function pageSize(opcion){
		
		var pageSize;

		switch(opcion){
			case 1: //Estudiante
				 pageSize=$('#cmbtamanioPaginaEstudiante').val();
				 window.location.replace("/Estudiante/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
			case 2: //Instructor
				pageSize=$('#cmbtamanioPaginaInstructor').val();
				 window.location.replace("/Instructor/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
			case 3: //Curso
				pageSize=$('#cmbtamanioPaginaCurso').val();
				 window.location.replace("/Curso/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
			case 4: //Certificado
				pageSize=$('#cmbtamanioPaginaCertificado').val();
				 window.location.replace("/Certificado/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
			case 5: //Maquina
				pageSize=$('#cmbtamanioPaginaMaquina').val();
				 window.location.replace("/Maquina/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
		}
	
	}
	

	//ELIMINACION 
	
	$(document).on('click', '#borrarEstudiante', function (event) {
		
		var dniEstudiante='';
		$(this).parents("tr").find("#dniEstudiante").each(function() {
			dniEstudiante = $(this).html();
	    });
		
		event.preventDefault();
		swal({
			  title: "¿Desea eliminar este registro?",
			  text: "No podras volver a visualizar este registro",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  
				  $.ajax({
				        type: 'POST',
				        url: "Eliminar",
				        data:{
				        	dni:dniEstudiante},
				        datatype: 'json',
				        success: function (response) {
				        	
				        	  swal("El registro se ha removido correctamente!", {
				        		  title: "Correcto",
				           	      icon: "success",
				           	   	  timer: 2000
			    				}).then(	
		  						function () {
		  							  if (true) {
		  								window.location.reload();
		  							  }
		  						})
				        },
			            error : function() {
			                //alert("error");
			            }
				  });  
			  } 
			});

	});
	
	
	$(document).on('click', '#borrarInstructor', function (event) {
			
			var dniEstudiante='';
			$(this).parents("tr").find("#dniInstructor").each(function() {
				dniInstructor = $(this).html();
		    });
			
			event.preventDefault();
			swal({
				  title: "¿Desea eliminar este registro?",
				  text: "No podras volver a visualizar este registro",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
					  
					  $.ajax({
					        type: 'POST',
					        url: "Eliminar",
					        data:{
					        	dni:dniInstructor},
					        datatype: 'json',
					        success: function (response) {
					        	
					        	  swal("El registro se ha removido correctamente!", {
					        		  title: "Correcto",
					           	      icon: "success",
					           	   	  timer: 2000
				    				}).then(	
			  						function () {
			  							  if (true) {
			  								window.location.reload();
			  							  }
			  						})
					        },
				            error : function() {
				                //alert("error");
				            }
					  });  
				  } 
				});
	
		});
	
	$(document).on('click', '#borrarCurso', function (event) {
		
		var idCurso='';
		$(this).parents("tr").find("#idCurso").each(function() {
			idCurso = $(this).html();
	    });
		event.preventDefault();
		swal({
			  title: "¿Desea eliminar este registro?",
			  text: "No podras volver a visualizar este registro",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  
				  $.ajax({
				        type: 'POST',
				        url: "Eliminar",
				        data:{
				        	id:idCurso},
				        datatype: 'json',
				        success: function (response) {
				        	
				        	  swal("El registro se ha removido correctamente!", {
				        		  title: "Correcto",
				           	      icon: "success",
				           	   	  timer: 2000
			    				}).then(	
		  						function () {
		  							  if (true) {
		  								window.location.reload();
		  							  }
		  						})
				        },
			            error : function() {
			                //alert("error");
			            }
				  });  
			  } 
			});
		});
	
	$(document).on('click', '#borrarCertificado', function (event) {
			
			var idCertificado='';
			$(this).parents("tr").find("#idCertificado").each(function() {
				idCertificado = $(this).html();
		    });
			event.preventDefault();
			swal({
				  title: "¿Desea eliminar este registro?",
				  text: "No podras volver a visualizar este registro",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
					  
					  $.ajax({
					        type: 'POST',
					        url: "Eliminar",
					        data:{
					        	id:idCertificado},
					        datatype: 'json',
					        success: function (response) {
					        	
					        	  swal("El registro se ha removido correctamente!", {
					        		  title: "Correcto",
					           	      icon: "success",
					           	   	  timer: 2000
				    				}).then(	
			  						function () {
			  							  if (true) {
			  								window.location.reload();
			  							  }
			  						})
					        },
				            error : function() {
				                //alert("error");
				            }
					  });  
				  } 
				});
			});
	
		$(document).on('click', '#borrarMaquina', function (event) {
				
				var idMaquina='';
				$(this).parents("tr").find("#idMaquina").each(function() {
					idMaquina = $(this).html();
			    });
				event.preventDefault();
				swal({
					  title: "¿Desea eliminar este registro?",
					  text: "No podras volver a visualizar este registro",
					  icon: "warning",
					  buttons: true,
					  dangerMode: true,
					})
					.then((willDelete) => {
					  if (willDelete) {
						  
						  $.ajax({
						        type: 'POST',
						        url: "Eliminar",
						        data:{
						        	id:idMaquina},
						        datatype: 'json',
						        success: function (response) {
						        	
						        	  swal("El registro se ha removido correctamente!", {
						        		  title: "Correcto",
						           	      icon: "success",
						           	   	  timer: 2000
					    				}).then(	
				  						function () {
				  							  if (true) {
				  								window.location.reload();
				  							  }
				  						})
						        },
					            error : function() {
					                //alert("error");
					            }
						  });  
					  } 
					});
				});