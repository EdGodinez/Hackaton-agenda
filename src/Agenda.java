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

    //Metodo para añadir un contacto nuevo / Realizado por Elizabeth Candelario
    public void anadirContacto(Contacto c){
        if(existeContacto(c)){
            return;
        }

        if(agendaLlena()){
            return;
        }

        for(int i=0 ; i< contactos.length; i++){
            if(contactos[i] ==null){
                contactos[i]=c;
                break;
            }
        }
    }

    //Metodo para listar todos los contactos / Realizado por Elizabeth Candelario
    public Contacto[] contactos(){
        return contactos;
    }

    //Metodo para buscar un contacto en especifico
    public void buscarContacto(String nombre){

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
