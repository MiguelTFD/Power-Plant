package dao.imp;

import java.util.List;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

import entity.Rol;
import entity.Usuario;
import util.MySqlDBConnection;
import entity.Opcion;

public class MySqlUsuarioDAO implements UsuarioDAO{

	private static Logger log = Logger.getLogger(MySqlUsuarioDAO.class.getName());

	@Override
	public Usuario login(Usuario bean) throws Exception{
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario obj = null;

			try{
					  cn = MySqlDBConnection.getCn();
					  String query = "select  U.*,R.* from Usuario U  JOIN Usuario_Has_Rol UH ON U.idUsuario = UH.idUsuario Join Rol R on UH.idRol =R.idRol where login = ? and password = ? ";
					  ps = cn.prepareStatement(query);
					  ps.setString(1, bean.getLogin());
					  ps.setString(2,bean.getPassword());
					  log.info(">>" + ps);
					  rs = ps.executeQuery();
					  Rol rol;
					  		while(rs.next()){
									  obj = new Usuario();
									  obj.setIdUsuario(rs.getInt(1));
									  obj.setNombres(rs.getString(2));
									  obj.setApellidos(rs.getString(3));
									  obj.setDni(rs.getString(4));
									  obj.setLogin(rs.getString(5));
									  obj.setPassword(rs.getString(6));
									  obj.setImage(rs.getString(7));
									  obj.setCorreo(rs.getString(8));
									  obj.setFechaNacimiento(rs.getDate(10));
									  obj.setDireccion(rs.getString(11));


									rol = new Rol();
									rol.setIdRol(rs.getInt(12));
									rol.setEstado(rs.getInt(13));
									rol.setNombre(rs.getString(14));
									obj.setRol(rol);

							}
				}catch(Exception e){
						  e.printStackTrace();
				}finally{
						  try{
						  		if(rs != null) rs.close();
								if(ps != null) ps.close();
								if(cn != null) cn.close();
						  }catch(Exception f){
									 f.printStackTrace();
						  }
				}
			 	return obj; 
	}


	public List<Opcion> getUserLink(int idUsuario) throws Exception{
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Opcion> data = new ArrayList<Opcion>();
		Opcion obj = null;

			try{
				 cn = MySqlDBConnection.getCn();
				 String query="select p.idOpcion, p.nombre, p.ruta, p.estado, p.tipo from Opcion p inner join Rol_Has_Opcion r on p.idOpcion = r.idOpcion inner join Rol c on r.idRol = c.idRol inner join Usuario_Has_Rol h on c.idRol=h.idRol where idUsuario=? order by 2;";
				 ps=cn.prepareStatement(query);
				 ps.setInt(1,idUsuario);
				 log.info(">>" + ps);
				 rs = ps.executeQuery();
				 while(rs.next()){
				obj = new Opcion();
				obj.setIdOpcion(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setRuta(rs.getString(3));
				obj.setEstado(rs.getInt(4));
				obj.setTipo(rs.getInt(5));
				data.add(obj);
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					if(rs!= null) rs.close();
					if(ps!= null) ps.close();
					if(cn!= null) cn.close();
			} catch (Exception e2) {

			}
				return data;
			}
	}

	@Override
	public List<Usuario> listarUsuario(int id)  {

		Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
		List<Usuario> lstUsuario = new ArrayList<Usuario>();

		 try{
            //obtener la conexion
            cn= MySqlDBConnection.getCn();

            //Crear la query
            String sql = "SELECT U.*,R.nombre FROM Usuario U  JOIN Usuario_Has_Rol UH ON U.idUsuario = UH.idUsuario Join Rol R on Uh.idRol =R.idRol where U.idUsuario = ?";
            //que el preparedsTATEMENT sea de la conexion
            ps = cn.prepareStatement(sql);
            ps.setInt(1,id);
            System.out.println(" Datos Usuario Query ==> "+ ps);

            //el resultSet sera  la respoesta de preparement Ejecutado (comluna1, columna2, ...)
            rs = ps.executeQuery();
            //Ahora que temos los datos de la consulta en el resultSet estas pasarana a cada objeto de su tipo,
            //vamos a creear los objetos que posseran estos datos
            Usuario usuario;

            Rol rol;

            while(rs.next()){

                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombres(rs.getString(2));
                usuario.setApellidos(rs.getString(3));
                usuario.setDni(rs.getString(4));
                usuario.setLogin(rs.getString(5));
                usuario.setPassword(rs.getString(6));
                usuario.setImage(rs.getString(7));
                usuario.setCorreo(rs.getString(8));
				usuario.setFechaRegistro(rs.getDate(9));
				usuario.setFechaNacimiento(rs.getDate(10));
				usuario.setDireccion(rs.getString(11));



                rol = new Rol();
				rol.setIdRol(rs.getInt(12));
				rol.setEstado(rs.getInt(13));
                rol.setNombre(rs.getString(14));
				usuario.setRol(rol);
                lstUsuario.add(usuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(cn != null){
                    cn.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }

		return lstUsuario;
	}

	@Override
	public int actualizarUsuario(Usuario bean) {
		Connection cn = null;
        PreparedStatement ps = null;

        int out=-1;
		try {

			cn = MySqlDBConnection.getCn();
			String query = "UPDATE Usuario set login = ?, password = ?, correo = ?, direccion = ? where idUsuario = ? ";
			ps = cn.prepareStatement(query);
			ps.setString(1, bean.getLogin());
			ps.setString(2, bean.getPassword());
			ps.setString(3, bean.getCorreo());
			ps.setString(4, bean.getDireccion());
			ps.setInt(5, bean.getIdUsuario());

			out=ps.executeUpdate();
			System.out.println("Usuario Actualizado Exitosamente"+query);

		}catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
		return out;
	}


}
