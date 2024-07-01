package dao.imp;

import java.util.List;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;
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
					  String query = "select * from Usuario where login = ? and password = ? ";
					  ps = cn.prepareStatement(query);
					  ps.setString(1, bean.getLogin());
					  ps.setString(2,bean.getPassword());
					  log.info(">>" + ps);
					  rs = ps.executeQuery();

					  		while(rs.next()){
									  obj = new Usuario();
									  obj.setIdUsuario(rs.getInt(1));
									  obj.setNombres(rs.getString(2));
									  obj.setApellidos(rs.getString(3));
									  obj.setDni(rs.getString(4));
									  obj.setLogin(rs.getString(5));
									  obj.setPassword(rs.getString(6));
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
}
