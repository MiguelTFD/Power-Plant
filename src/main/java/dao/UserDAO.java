package dao;

import java.util.List;

import entity.User;

public interface UserDAO{

	public abstract User login(User bean) throws Exception;
	

}
