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

          String id = req.getParameter("id");

        Factory factory = Factory.getFactory(Factory.MYSQL);

        UsuarioDAO daoUsuario = factory.getUsuarioDAO();

        List<Usuario> lstUsuario = daoUsuario.listarUsuario(Integer.parseInt(id));

        Gson gson = new Gson();
        String json = gson.toJson(lstUsuario);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        System.out.println("[fin] lista");
    }
    private void actualiza(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[ini] actualiza");

		Factory subFabrica = Factory.getFactory(Factory.MYSQL);
		UsuarioDAO daoUsuario = subFabrica.getUsuarioDAO();

		String _idU =req.getParameter("idUsuario");
        String _nom = req.getParameter("nombres");

		String _cor = req.getParameter("correo");
		String _dni = req.getParameter("dni");
		String _usr = req.getParameter("username");
		String _pas = req.getParameter("password");
		String _dir = req.getParameter("direccion");
		String _fna = req.getParameter("nacimiento");




		Usuario usuario_= new Usuario();

		usuario_.setIdUsuario(Integer.parseInt(_idU));
		usuario_.setNombres(_nom);
		usuario_.setDni(_dni);
		usuario_.setLogin(_usr);
		usuario_.setPassword(_pas);
		usuario_.setCorreo(_cor);
		usuario_.setDireccion(_dir);

    if (_fna != null && !_fna.isEmpty()) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(_fna);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            usuario_.setFechaNacimiento(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();

        }
    }

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
