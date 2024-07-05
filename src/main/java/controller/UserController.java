package controller;

import com.google.gson.Gson;

import dao.UsuarioDAO;

import entity.Respuesta;
import entity.Rol;
import entity.Usuario;

import factory.Factory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/datosUsuario")
public class UserController extends HttpServlet  {

     private static final long serialVersionUID = 1L;

     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String metodo = req.getParameter("metodo");
        switch (metodo){
            case "crLista": {lista(req,resp);break;}
            case "crActualiza": {actualiza(req,resp);}
        }
    }

     protected void lista(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[ini] lista");

        // Obtener la sesión
        HttpSession session = req.getSession(false);

        if (session != null) {
            // Obtener el usuario de la sesión
            Usuario usuario = (Usuario) session.getAttribute("Objusuario");

            if (usuario != null) {
                // Obtener el ID del usuario
                int idUsuario = usuario.getIdUsuario();
                System.out.println("ID del usuario: " + idUsuario);

                Factory factory = Factory.getFactory(Factory.MYSQL);

                UsuarioDAO daoUsuario = factory.getUsuarioDAO();

                List<Usuario> lstUsuario = daoUsuario.listarUsuario(idUsuario);

                Gson gson = new Gson();
                String json = gson.toJson(lstUsuario);
                resp.setContentType("application/json;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.println(json);
                System.out.println("[fin] lista");
            } else {
                System.out.println("No se encontró el usuario en la sesión.");
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No se encontró el usuario en la sesión.");
            }
        } else {
            System.out.println("No se encontró una sesión activa.");
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No se encontró una sesión activa.");
        }
	 }

    private void actualiza(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[ini] actualiza");

		Factory subFabrica = Factory.getFactory(Factory.MYSQL);
		UsuarioDAO daoUsuario = subFabrica.getUsuarioDAO();

		String _idU =req.getParameter("idUsuario");


		String _cor = req.getParameter("correo");

		String _usr = req.getParameter("username");
		String _pas = req.getParameter("password");
		String _dir = req.getParameter("direccion");




		Usuario usuario_= new Usuario();

		usuario_.setIdUsuario(Integer.parseInt(_idU));
		usuario_.setLogin(_usr);
		usuario_.setPassword(_pas);
		usuario_.setCorreo(_cor);
		usuario_.setDireccion(_dir);

		Respuesta objRespuesta = new Respuesta();
		int salida = daoUsuario.actualizarUsuario(usuario_);
		if (salida>0) {
			List<Usuario>  lstDatos = daoUsuario.listarUsuario(usuario_.getIdUsuario()) ;
			objRespuesta.setDatos(lstDatos);
			objRespuesta.setMensaje("Actualizaci\u00f3n existosa");
		}

		Gson gson = new Gson();
		String json = gson.toJson(objRespuesta);
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println(json);

		System.out.println("[fin] actualiza");
	}






}
