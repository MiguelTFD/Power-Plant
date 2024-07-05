package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import dao.UsuarioDAO;
import entity.Usuario;
import entity.Opcion;
import factory.Factory;

@WebServlet("/login")
public class LoginController extends HttpServlet {

   private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String usuario = req.getParameter("usuario");
            String password = req.getParameter("password");

            Usuario bean = new Usuario();
            bean.setLogin(usuario);
            bean.setPassword(password);

            Factory factory = Factory.getFactory(Factory.MYSQL);
            UsuarioDAO dao = factory.getUsuarioDAO();

            try{
                Usuario usuario1 = dao.login(bean);
                    if(usuario1 == null){

                        String mensaje = "El usuario no existe";
                        req.setAttribute("mensaje", mensaje);
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                    }
                    else {
                        HttpSession session = req.getSession();
                        session.setAttribute("Objusuario", usuario1);
                        List<Opcion> menus = dao.getUserLink(usuario1.getIdUsuario());
                        session.setAttribute("Objmenus", menus);
                        resp.sendRedirect("home.jsp");

                    }
            }catch(Exception e){
                e.printStackTrace();
            }
    }
}
