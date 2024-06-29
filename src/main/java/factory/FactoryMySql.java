package factory;

import dao.imp.MySqlUserDAO;
import dao.UsuarioDAO;

public class FactoryMySql extends Factory{
		  
		  public UsuarioDAO getUsuarioDAO(){
					 return new MySqlUserDAO();
		  }
}
