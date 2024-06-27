package entity;

public class UsuarioHasRol{


	private UsuarioHasRolPK usuarioHasRolPk;
	private Usuario usuario;
	private Rol rol;

	//getters and setters
	public UsuarioHasRolPK getUsuarioHasRolPk(){
			  return usuarioHasRolPk;
	}
	public void setUsuarioHasRolPk(UsuarioHasRolPK usuarioHasRolPk){
			  this.usuarioHasRolPk = usuarioHasRolPk;
	}
	public Usuario getUser(){
			  return usuario;
	}
	public void setUser(Usuario usuario){
			  this.usuario= usuario;
	}
	public Rol getRol(){
			  return rol;
	}
	public void setRol(Rol rol){
			  this.rol = rol;
	}
	

}


