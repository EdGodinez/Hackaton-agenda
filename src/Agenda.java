public class Agenda {

    private Contacto[] contactos;
    private int capacidadMaxima = 10;
    private int totalContactos;

    public Agenda() {
        this.contactos = contactos;
        this.capacidadMaxima = capacidadMaxima;
        this.totalContactos = totalContactos;
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
        return (espacioLibres() >= this.capacidadMaxima);
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
    public void eliminarContacto(Contacto c){

    }

    //Metodo para modificar número de un contacto
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono){

    }

    //Metodo para mostrar cuantos espacios libres hay
    public int espacioLibres(){
        return 10;
    }

}
