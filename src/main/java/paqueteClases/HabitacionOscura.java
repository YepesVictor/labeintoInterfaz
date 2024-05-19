/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteClases;

/**
 *
 * @author z16
 */
public class HabitacionOscura extends Habitacion {

    private boolean oscuro;

    /**
     *
     * @param descripcion
     */
    public HabitacionOscura(String descripcion) {
        super(descripcion);
        this.oscuro = true;
    }
    
    /**
     *
     * @return
     */
    public boolean isOscuro() {
        return oscuro;
    }

    /**
     *
     * @return
     */
    @Override
    public String getStringDeSalidas() {
        if (oscuro) {
            return "-----------------------------\nNo puede ver las salidas porque esta oscuro. No puedes salir.";
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
        if (oscuro) {
            getStringDeSalidas();
            return null;
        } else {
            return super.getSalida(direccion);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getDescripcionLarga() {
        if (oscuro) {
            return "No puede ver las salidas porque esta oscuro";
        } else {
            return super.getDescripcionLarga();
        }
    }
    
    /**
     *
     */
    public String iluminar(){
        if (this.oscuro) {
            this.oscuro=false;
            return "Ahora la habitacion esta iluminada";
        }else{
            return "La habitacion ya esta iluminada";
        }
    }

}
