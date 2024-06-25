package factory;

import dao.imp.MySqlUserDAO;
import dao.UserDAO;

public class FactoryMySql extends Factory{
		  
		  public UserDAO getUserDAO(){
					 return new MySqlUserDAO();
		  }
}
