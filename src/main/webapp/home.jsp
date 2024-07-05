<jsp:include page="validacion.jsp"/>
<!DOCTYPE html>
<html lang="esS">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Home</title>

   	<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>


    <style>
        .layout{
            height: 100vh;
            align-content: center;
        }
        .userdata{
            margin: auto;
        }

/* General table styles */
table {
  width: 100%;
  border-collapse: collapse;
}

table th,
table td {
  padding: 10px;
  border: 1px solid #ccc;
}

/* Vertical table styles */
table.vertical {
  display: block;
}

table.vertical thead {
  display: none;
}

table.vertical tr {
  display: block;
  margin-bottom: 10px;
}

table.vertical td {
  display: block;
  text-align: right;
  padding-left: 50%;
  position: relative;
}

table.vertical td::before {
  content: attr(data-label);
  position: absolute;
  left: 10px;
  width: calc(50% - 20px);
  text-align: left;
  font-weight: bold;
  color: #333;
}



    </style>

</head>
<body>
<%

    session.setAttribute("includeNavs", true);
%>
<jsp:include page="navs.jsp"/>

<%
    session.removeAttribute("includeNavs");
%>

<div class="container" >
<div class="layout">
<table id="id_table" class="userdata" >

   <tr>
    <th>Nombres:</th>
    <td>${sessionScope.Objusuario.nombreCompleto}</td>
  </tr>

  <tr>
    <th>DNI:</th>
    <td>${sessionScope.Objusuario.dni}</td>
  </tr>

  <tr>
    <th>Username:</th>
    <td>${sessionScope.Objusuario.login}</td>
  </tr>

    <tr>
    <th>Password:</th>
    <td>${sessionScope.Objusuario.password}</td>
  </tr>

  <tr>
    <th>Correo:</th>
    <td>${sessionScope.Objusuario.correo}</td>
  </tr>

   <tr>
    <th>F.Nacimiento:</th>
    <td>${sessionScope.Objusuario.fechaNacimiento}</td>
  </tr>

  <tr>
    <th>Direccion:</th>
    <td>${sessionScope.Objusuario.direccion}</td>
  </tr>

<button type="button" class="btn btn-info btn-sm" onClick="verFormularioActualiza(
                    '${sessionScope.Objusuario.idUsuario}',
                    '${sessionScope.Objusuario.login}',
                    '${sessionScope.Objusuario.password}',
                    '${sessionScope.Objusuario.correo}',
                    '${sessionScope.Objusuario.direccion}',
                );">Editar</button>
</table>

 <!-- INICIO MODAL DE ACTUALIZA -->
        <div class="modal fade" id="id_div_modal_actualiza" >
            <div class="modal-dialog" style="width: 60%">
                <div class="modal-content">
                    <div class="modal-header" >
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4><span class="glyphicon glyphicon-ok-sign"></span> Actualizacion de datos</h4>
                    </div>

                    <div class="modal-body" >
                        <div class="panel-group" id="steps">
                            <div class="panel panel-default">
                                <div id="stepOne" class="panel-collapse collapse in">

                                    <form id="id_form_actualiza">

                                        <input type="hidden" name="metodo" value="crActualiza">
                                        <input type="hidden" name="idUsuario" id="idUsuario">
                                        <div class="panel-body">


                                            <!--Recursos-->
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label" for="id_act_loggin">Loggin</label>
                                                <div class="col-lg-8">
                                                    <input class="form-control" id="id_act_loggin" type="text" name="username"/>
                                                </div>
                                            </div>
                                            <!--FRegistro-->
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label" for="id_act_password">Password</label>
                                                <div class="col-lg-8">
                                                    <input class="form-control" id="id_act_password" type="text" name="password"/>
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <label class="col-lg-3 control-label" for="id_act_correo">Correo</label>
                                                <div class="col-lg-8">
                                                    <input class="form-control" id="id_act_correo" type="text" name="correo"/>
                                                </div>
                                            </div>


                                                <!--FRegistro-->
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label" for="id_act_dir">Direccion</label>
                                                <div class="col-lg-8">
                                                    <input class="form-control" id="id_act_dir" type="text" name="direccion"/>
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <div class="col-lg-12" align="center">
                                                    <button type="button" style="width: 80px" id="id_btn_actualiza"   class="btn btn-primary btn-sm ">Actualizar</button>
                                                    <button type="button" style="width: 80px" id="id_btn_act_cancelar" class="btn btn-primary btn-sm" data-dismiss="modal" >Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- FIN MODAL DE ACTUALIZA -->




</div>
</div>

<script type="text/javascript">
       function verFormularioActualiza(idUsuario,login, password, correo, direccion){
                console.log(">> verFormularioActualiza >> " + idUsuario);
                $("#id_div_modal_actualiza").modal("show");
                $("#idUsuario").val(idUsuario);
                $("#id_act_loggin").val(login);

                $("#id_act_password").val(password);
                $("#id_act_correo").val(correo);
                $("#id_act_dir").val(direccion);

       }


		function agregarGrilla(lista){
			 $('#id_table').DataTable().clear();
			 $('#id_table').DataTable().destroy();
			 $('#id_table').DataTable({
					data: lista,
					language: IDIOMA,
					searching: false,
					ordering: false,
					processing: true,
					pageLength: 1,
					lengthChange: false,
					info:true,
					scrollY: 305,
			        scroller: {
			            loadingIndicator: true
			        },
					columns:[
						{data: "usuario",className:'text-center'},
						{data: "dni",className:'text-center'},
						{data: "login",className:'text-center'},
						{data: "password",className:'text-center'},
						{data: "correo", className:'text-center'},
						{data: "fechaNacimiento",className:'text-center'},
                        {data: "direccion", className:'text-center'},
                        {data: "rol.nombre", className:'text-center'},
					]
			    });
		}




		$("#id_btn_actualiza").click(function() {
			var validator = $('#id_form_actualiza').data('bootstrapValidator');
		    validator.validate();

		    if (validator.isValid()) {
		        $.ajax({
			          type: "POST",
			          url: "datosUsuario",
			          data: $('#id_form_actualiza').serialize(),
			          success: function(data){
			        	  mostrarMensaje(data.mensaje);
                          agregarGrilla(data.datos);
			        	  validator.resetForm();
			        	  $('#id_div_modal_actualiza').modal("hide");
			          },
			          error: function(){
			        	  mostrarMensaje(MSG_ERROR);
			          }
			    });
		    }
		});


		$(document).ready(function() {
		    $('#id_form_actualiza').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },

		        fields:{
		        	correo : {
		        		selector: "#id_act_correo",
		        		validators : {
		        			notEmpty: {
		                        message: 'El correo es un campo requerido'
		                    },
		        		}
		        	},
		        	direccion : {
		        		selector: "#id_act_direccion",
		        		validators : {
		        			notEmpty: {
		                        message: 'La Direccion es requerida'
		                    },
		                    stringLength: {
		                        min: 4,
		                        max: 40,
		                        message: 'la direccion deve de tener entre 4-40 Caracteres (Av. Lima Lim�n 78487)'
		                    },
		        		}
		        	},
		        	login : {
		        		selector: "#id_act_loggin",
		        		validators : {
		        			notEmpty: {
		                        message: 'Debes tener un Username'
		                    },
		                    stringLength: {
		                        max: 15,
		                        message: 'Username muy largo'
		                    },
		        		}
		        	},
		        	password : {
		        		selector: "#id_act_password",
		        		validators : {
		        			notEmpty: {
		                        message: 'El password es requerido'
		                    },
		        		}
		        	},

		        }
		    });
		});


        $(document).ready(function() {
        $.ajax({
            url: 'datosUsuario',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                agregarGrilla(data);
                console.log(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al cargar los datos: ' + error);
            }
        });
    });

</script>


</body>
</html>
