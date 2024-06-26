/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteClases;

/**
 *
 * @author z16
 */
public class HabitacionMonstruo extends Habitacion {

    private boolean vivo;
    private String tipo;

    /**
     *
     * @param descripcion
     * @param tipo
     */
    public HabitacionMonstruo(String descripcion, String tipo) {
        super(descripcion);
        this.vivo = true;
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public String ataqueMonstruo() {
        if (vivo) {
           if (tipo.equals("jefe")) {
                vivo = false;
                return "Mataste al monstruo jefe\n";
            }else{
               vivo= false;
               return "Mataste a un monstruo\n";
           }
        }
        return "No hay monstruo vivo\n";
    }

    /**
     *
     * @return6
     */
    @Override
    public String getDescripcionLarga() {
        if (vivo) {
            return "Habitacion con un monstruo. Para salir debes matar al monstruo\n";
        } else {
            return super.getDescripcionLarga()  ;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getStringDeSalidas() {
        if (vivo) {
            return "No puedes salir hasta que el monstruo sea derrotado\n";
        } else {
            return super.getStringDeSalidas();
        }

    }

    /**
     *
     * @param direccion
     * @return
     */
    @Override
    public Habitacion getSalida(String direccion) {
        if (vivo) {
           this.getStringDeSalidas();
            return null;
        } else {
            return super.getSalida(direccion);
        }
    }

    
    

}
