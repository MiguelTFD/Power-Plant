<jsp:include page="validacion.jsp"/>
<!DOCTYPE html>
<html lang="esS">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Home</title>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>


 <link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/bootstrapValidator.css"/>


    <style>
        .layout{
            height: 100vh;
            align-content: center;
        }
        .userdata{
            margin: auto;
        }

    </style>

</head>
<body>
<%
    // Establece una variable de sesión para indicar que navs.jsp está siendo incluido
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
                    '${sessionScope.Objusuario.nombreCompleto}',
                    '${sessionScope.Objusuario.dni}',
                    '${sessionScope.Objusuario.login}',
                    '${sessionScope.Objusuario.password}',
                    '${sessionScope.Objusuario.correo}',
                    '${sessionScope.Objusuario.fechaNacimiento}',
                    '${sessionScope.Objusuario.direccion}',
                    '${sessionScope.Objusuario.getRol().nombre}'
                );">Editar</button>
    <tr>
    <th>Cargo:</th>
    <td>${sessionScope.Objusuario.getRol().nombre}</td>
  </tr>

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



                                            <div class="form-group">
                                                <label class="col-lg-3 control-label" for="id_act_nombres">Nombre completo</label>
                                                <div class="col-lg-8">
                                                    <input class="form-control" id="id_act_nombres" name="nombres" placeholder="..." type="text" maxlength="100"/>
                                                </div>
                                            </div>

                                            <!--Cantidad de alumnos-->
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label" for="id_act_dni">Dni</label>
                                                <div class="col-lg-8">
                                                    <input class="form-control" id="id_act_dni" type="text" name="dni"/>
                                                </div>
                                            </div>

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
                                                    <input class="form-control" id="id_act_password" type="text" name="dni"/>
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
                                                <label class="col-lg-3 control-label" for="id_act_fnac">Fecha Nacimiento</label>
                                                <div class="col-lg-8">
                                                    <input class="form-control" id="id_act_fnac" type="date" name="nacimiento"/>
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
                                                <label class="col-lg-3 control-label" for="id_act_rol">Cargo</label>
                                                <div class="col-lg-8">
                                                    <input class="form-control" id="id_act_rol" type="text" name="rol"/>
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
       function verFormularioActualiza(idUsuario,nombres, dni, login, password, correo, fnac, direccion, rol){
                console.log(">> verFormularioActualiza >> " + idUsuario);
                $("#id_div_modal_actualiza").modal("show");
                $("#idUsuario").val(idUsuario);
                $("#id_act_nombres").val(nombres);
                $("#id_act_dni").val(dni);

                $("#id_act_loggin").val(login);
                $("#id_act_password").val(password);
                $("#id_act_correo").val(correo);
                $("#id_act_fnac").val(fnac);
                $("#id_act_dir").val(direccion);
                $("#id_act_rol").val(rol);
            }


</script>


</body>
</html>
