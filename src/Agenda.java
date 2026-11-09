public class Agenda {

    private Contacto[] contactos;

    public Agenda() {
        this.contactos = new Contacto[10];

    }

    //Funcioon para verificar si un contacto existe | Realizado por Eduardo Godinez
    public Boolean existeContacto(Contacto c){

        for (Contacto contacto : contactos){
            if(contacto != null &&
                    contacto.getNombre().equals(c.getNombre()) &&
                    contacto.getApellido().equals(c.getApellido())){
                return true;
            }
        }
        return false;
    }

    public Boolean agendaLlena(){
        return espacioLibres() == 0;
    }

    //Metodo para añadir un contacto nuevo
    public void añadirContacto(Contacto c){

    }

    //Metodo para listar todos los contactos
    public Contacto[] contactos(){
        return contactos;
    }

    //Metodo para buscar un contacto en especifico
    public Contacto buscarContacto(String nombre, String apellido) {
        for (int i = 0; i < contactos.length; i++) {
            Contacto c = contactos[i];
            if (c != null) {
                if (c.getNombre().equalsIgnoreCase(nombre)
                && c.getApellido().equalsIgnoreCase(apellido)) {
                    return c;
                }
            }
        }
    return null;
    }

    //Metodo para eliminar un contacto
    public void eliminarContacto(Contacto c){

    }

    //Metodo para modificar número de un contacto
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono){

    }

    //Metodo para mostrar cuantos espacios libres hay
    public int espacioLibres(){

        int espacios = 0;

        for(Contacto c : contactos){
            if(c == null){
                espacios++;
            }
        }
        return espacios;
    }

}
