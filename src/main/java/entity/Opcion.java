package entity;

public class Opcion{

	private int idRol;
	private String estado;
	
	//Setters and Getter
	public void setIdRol(int idRol){
			  this.idRol=idRol;
	}
	public int getIdRol(){
		return idRol;
	}
	
	public void setEstado(String estado){
			  this.estado = estado;
	}
	public String getEstado(){
			  return estado;
	}
	public Opcion(int idRol, String estado){
			  this.idRol=idRol;
			  this.estado=estado;
	}

	}
