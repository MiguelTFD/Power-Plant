package dao;
import entity.Usuario;
import java.util.List;
import entity.Opcion;

public interface UsuarioDAO{

	//Loggin method
	public abstract Usuario login(Usuario bean) throws Exception;
	
	//Enlaces
	public abstract List<Opcion> getUserLink(int idUsuario) throws Exception;
}
