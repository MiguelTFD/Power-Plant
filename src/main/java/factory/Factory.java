package factory;

import dao.UserDAO;

public abstract class Factory{

		  public static final int MYSQL=1;
		  public static final int SQLSERVER=2;

		  public abstract UserDAO getUserDAO();

		  //Factory method static constructor
			public static Factory getFactory(int type){
					  Factory out = null;
					  switch(type){
								 case MYSQL:
											out = new FactoryMySql();
											break;
					  }
					  return out;
			}
}
