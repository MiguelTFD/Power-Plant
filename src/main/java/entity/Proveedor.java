package entity;

public class Proveedor {

        private int idProveedir;
      private String nombre;
        private String contacto ;
          private String telefono;

          private String Direccion;

    public int getIdProveedir() {
        return idProveedir;
    }

    public void setIdProveedir(int idProveedir) {
        this.idProveedir = idProveedir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
