package dao.imp;

import dao.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;
import entity.User;
import util.MySqlDBConnection;





public class MySqlUserDAO implements UserDAO{

	private static Logger log = Logger.getLogger(MySqlUserDAO.class.getName());

	@Override
	public User login(User bean) throws Exception{
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User obj = null;
		
			try{
					  cn = MySqlDBConnection.getCn();
					  String query = "select * from user where login = ? and password = ? ";
					  ps = cn.prepareStatement(query);
					  ps.setString(1, bean.getLogin());
					  ps.setString(2,bean.getPassword());
					  log.info(">>" + ps);
					  rs = ps.executeQuery();

					  		while(rs.next()){
									  obj = new User();
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
}
