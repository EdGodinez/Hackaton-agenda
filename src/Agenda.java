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
    public void buscarContacto(String nombre){

    }

    //Metodo para eliminar un contacto
    // Devuelve true si lo eliminó, false si no lo encontró
    public boolean eliminarContacto(String nombre, String apellido) {
        for (int i = 0; i < contactos.length; i++) {
            //si nombre y apellido son iguales a los que se insertaron
            if (contactos[i] != null &&
                    contactos[i].getNombre().equals(nombre) &&
                    contactos[i].getApellido().equals(apellido)) {

                // borra el contacto dejando el espacio en null
                contactos[i] = null;
                return true; // Éxito
            }
        }
        return false; // No se encontró
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
