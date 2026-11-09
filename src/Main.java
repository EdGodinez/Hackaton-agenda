import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        Agenda agenda = new Agenda();

        String[] opciones = {"Agregar contacto",
                "Mostrar todos los contactos",
                "Buscar contacto",
                "Modificar contacto",
                "Verificar espacios libres",
                "Eliminar contacto",
                "Salir"
        };

        String opcion = "";

        while(!opcion.equals("Salir")){
            opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion", "Ménu principal", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {

                case "Agregar contacto":
                        JTextField campoNombre = new JTextField();
                        JTextField campoApellido = new JTextField();
                        JTextField campoNumero = new JTextField();

                        Object[] mensaje = {"Nombre: ", campoNombre, "Apellido: " , campoApellido, "Número:" , campoNumero};

                        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Agregar usuario", JOptionPane.OK_CANCEL_OPTION);

                        if (respuesta == JOptionPane.OK_OPTION) {

                            String nombre = campoNombre.getText().trim();
                            String apellido = campoApellido.getText().trim();
                            String numero = campoNumero.getText().trim();

                            if(nombre.isEmpty()){
                                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
                            } else if(apellido.isEmpty()){
                                JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío.");
                            } else if(numero.isEmpty()){
                                JOptionPane.showMessageDialog(null, "El número no puede estar vacío.");
                            } else {Contacto c =new Contacto(nombre,apellido,numero);
                                agenda.anadirContacto(c);

                            }


                        }

                    break;

                case "Mostrar todos los contactos":

                    break;

                case "Buscar contacto":

                    break;
                case "Modificar contacto":
                    Agenda miAgenda = new Agenda();

                    // Pedir nombre y apellido
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto a modificar:");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del contacto:");

                    // Validar inmediatamente si el usuario presionó "Cancelar"
                    if (nombre == null || apellido == null) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    } else {

                        // Limpiar espacios en blanco
                        nombre = nombre.trim();
                        apellido = apellido.trim();

                        Contacto contactoBuscar = new Contacto(nombre, apellido, "");

                        // Validar si existe en la agenda
                        if (miAgenda.existeContacto(contactoBuscar)) {

                            // SOLO si existe, pedimos el nuevo teléfono
                            String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo número de teléfono:");

                            // Validar que no haya cancelado en este paso también
                            if (nuevoTelefono != null) {
                                nuevoTelefono = nuevoTelefono.trim();

                                // Llamar al metodo modificar contacto
                                miAgenda.modificarTelefono(nombre, apellido, nuevoTelefono);

                                // Mensaje de éxito
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Teléfono modificado correctamente.",
                                        "Éxito",
                                        JOptionPane.INFORMATION_MESSAGE
                                );

                            } else {
                                // El usuario canceló al pedir el teléfono
                                JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Aviso", JOptionPane.WARNING_MESSAGE);
                            }

                        } else {
                            // Si NO existe, mostramos el error y NO pedimos el teléfono
                            JOptionPane.showMessageDialog(
                                    null,
                                    "El contacto " + nombre + " " + apellido + " no existe en la agenda.",
                                    "Contacto no encontrado",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }

                    break;

                case "Verificar espacios libres":
                        JOptionPane.showMessageDialog(null,"A la genda le quedan: " + agenda.espacioLibres() + " libres.");
                    break;

                case "Eliminar contacto":

                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto a eliminar:");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del contacto:");

                    //validar cancelacion inmediata
                    if (nombre == null || apellido == null) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    } else {

                        // Limpiar datos
                        nombre = nombre.trim();
                        apellido = apellido.trim();

                        // Crear objeto temporal para validar existencia
                        Contacto contactoBuscar = new Contacto(nombre, apellido, "");

                        Agenda miAgenda = new Agenda();
                        // Validar si existe
                        if (miAgenda.existeContacto(contactoBuscar)) {

                            // Pedir confirmación antes de borrar
                            int confirmacion = JOptionPane.showConfirmDialog(
                                    null,
                                    "¿Está seguro de que desea eliminar a " + nombre + " " + apellido + "?",
                                    "Confirmar eliminación",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.WARNING_MESSAGE
                            );

                            // Si el usuario presiona "Sí" (YES_OPTION)
                            if (confirmacion == JOptionPane.YES_OPTION) {

                                // Llamar al metodo
                                boolean eliminado = miAgenda.eliminarContacto(nombre, apellido);

                                if (eliminado) {
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "El contacto ha sido eliminado correctamente.",
                                            "Éxito",
                                            JOptionPane.INFORMATION_MESSAGE
                                    );
                                }
                            } else {
                                // El usuario presionó "No" o cerró la ventana de confirmación
                                JOptionPane.showMessageDialog(null, "Eliminación cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                            }

                        } else {
                            // Si NO existe, mostrar error (sin pedir confirmación)
                            JOptionPane.showMessageDialog(
                                    null,
                                    "El contacto " + nombre + " " + apellido + " no existe en la agenda.",
                                    "Contacto no encontrado",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }

                    break;

                case "Salir":
                    JOptionPane.showMessageDialog(null, "Bye!");
                    break;
            }
        }
    }
}
