/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteClases;

/**
 *
 * @author z16
 */
public class Habitacion {

    private Habitacion sNorte, sSur, sEste, sOeste;
    private String descripcion;

    /**
     *
     */
    public Habitacion() {
    }

    /**
     *
     * @param descripcion
     */
    public Habitacion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     * @param habitacion
     */
    public void setSalida(String descripcion, Habitacion habitacion) {

        switch (descripcion.toLowerCase()) {
            case "norte":
                this.sNorte = habitacion;
                break;
            case "sur":
                this.sSur = habitacion;
                break;
            case "oeste":
                this.sOeste = habitacion;
                break;
            case "este":
                this.sEste = habitacion;
                break;
            default:
                System.out.println("La habitacion no existe");
                break;
        }
    }

    /**
     *
     * @return
     */
    public String getDescripcionLarga() {
        return "---------------------------------------------\nEstas en " + getDescripcion() + " y las " + getStringDeSalidas();
    }

    /**
     *
     * @param direccion
     * @return
     */
    public Habitacion getSalida(String direccion) {
        direccion = direccion.toLowerCase();

        if (direccion.equals("norte")) {
            return sNorte;
        } else if (direccion.equals("sur")) {
            return sSur;
        } else if (direccion.equals("este")) {
            return sEste;
        } else if (direccion.equals("oeste")) {
            return sOeste;
        } else {
            return null;
        }

    }

    /**
     *
     * @return
     */
    public String getStringDeSalidas() {
        String aux = "salidas disponibles son:\n";
        if (sNorte != null) {
            aux += "Norte ";
        }
        if (sSur != null) {
            aux += "Sur ";
        }

        if (sEste != null) {
            aux += "Este ";
        }

        if (sOeste != null) {
            aux += "Oeste ";
        }
        return aux;
    }

}
