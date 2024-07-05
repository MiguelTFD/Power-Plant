package entity;
import java.sql.Date; 

public class Usuario{
	private int idUsuario;
	private String nombres;
	private String apellidos;
	private String dni;
	private String login;
	private String password;
	private String image;
	private String correo;
	private Date fechaRegistro;
	private Date fechaNacimiento;
	private String direccion;

	private Rol rol;

	//func nombre+apellidos
	public String getNombreCompleto(){
		return nombres.concat(" ").concat(apellidos);
	}

	//getters and setters
	public int getIdUsuario(){
			  return idUsuario;
	}

	public void setIdUsuario(int idUsuario){
			  this.idUsuario = idUsuario;
	}

	public String getNombres(){
			  return nombres;
	}

	public void setNombres(String nombres){
			  this.nombres = nombres;
	}

	public String getApellidos(){
			  return apellidos;
	}

	public void setApellidos(String apellidos){
			  this.apellidos = apellidos;
	}

	public String getDni(){
			  return dni;
	}
	
	public void setDni(String dni){
			  this.dni = dni;
	}

	public String getLogin(){
			  return login;
	}

	public void setLogin(String login){
			  this.login=login;
	}

	public String getPassword(){
			  return password;
	}

	public void setPassword(String password){
			  this.password=password;
	}
	public String getImage(){
			  return image;
	}

	public void setImage(String image){
			  this.image=image;
	}

	public String getCorreo(){
			  return correo;
	}
	
	public void setCorreo(String correo){
			  this.correo=correo;
	}

	public Date getFechaRegistro(){
			  return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro){
			  this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaNacimiento(){
			  return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento){
			  this.fechaNacimiento=fechaNacimiento;
	}
	public String getDireccion(){
			  return direccion;
	}
	public void setDireccion(String direccion){
			  this.direccion = direccion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
