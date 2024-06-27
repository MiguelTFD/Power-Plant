package entity;

public class RolHasOpcion{
		  private RolHasOpcionPK rolHasOpcionPk;
		  private Rol rol;
		  private Opcion opcion;

		  //setters and getters
		  public void setRolHasOpcionPk(RolHasOpcionPK rolHasOpcionPk){
				this.rolHasOpcionPk = rolHasOpcionPk;
		  }
		  public RolHasOpcionPK getRolHasOpcionPk(){
				return rolHasOpcionPk;
		  }

		  public void setRol(Rol rol){
					 this.rol=rol;
		  }
		  public Rol getRol(){
					 return rol;
		  }

		  public void setOpcion(Opcion opcion){
					 this.opcion=opcion;
		  }
		  public Opcion getOpcion(){
					 return opcion;
		  }
}
