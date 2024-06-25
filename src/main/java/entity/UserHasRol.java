package entity;

public class UserHasRol{

	private UserHasRolPK userHasRolPk;
	private User user;
	private Rol rol;

	//getters and setters
	public UserHasRolPK getUserHasRolPk(){
			  return userHasRolPk;
	}
	public void setUserHasRolPk(UserHasRolPK userHasRolPk){
			  this.userHasRolPk = userHasRolPk;
	}
	public User getUser(){
			  return user;
	}
	public void setUser(User user){
			  this.user = user;
	}
	public Rol getRol(){
			  return rol;
	}
	public void setRol(Rol rol){
			  this.rol = rol;
	}
	

}
