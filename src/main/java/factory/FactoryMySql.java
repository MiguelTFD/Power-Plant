package factory;

import dao.UsuarioDAO;
import dao.imp.MySqlUsuarioDAO;

public class FactoryMySql extends Factory{
		  
		  public UsuarioDAO getUsuarioDAO(){
					 return new MySqlUsuarioDAO();
		  }
}
