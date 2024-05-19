/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteClases;

/**
 *
 * @author Diurno
 */
public class PalabraComando {

    private Palabra com;

    /**
     *
     */
    public PalabraComando() {
    }

    /**
     *
     * @param com
     */
    public PalabraComando(String com) {
        if (esComando(com)) {
            this.com =  Palabra.valueOf(com);
        }
    }

    /**
     *
     * @return
     */
    public Palabra getCom() {
        return com;
    }

    /**
     *
     * @param coman
     * @return
     */
    public boolean esComando(String coman) {
        if (coman == null) {
            return false;
        }else{
            for (Palabra value : Palabra.values()) {
                if (coman.equalsIgnoreCase(value.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    public static String comandoDisponible(){
        return Palabra.AYUDA+" - "+Palabra.IR+" +direccion - "+Palabra.LUZ+" - "+Palabra.ATACAR+" - "+Palabra.SALIR;
    }

    /**
     *
     * @return
     */
    public static String mostrarComandos() {
        return "\n" + Palabra.AYUDA + ":Permite ver los comandos\n" + 
                Palabra.IR + "("+Salida.NORTE+" - "+Salida.SUR+" - "+Salida.ESTE+" - "+Salida.OESTE+"):Para indicar a donde moverse\n" + 
                Palabra.LUZ + ":Iluminar una habitacion oscura\n" + 
                Palabra.ATACAR + ":Ataca al monstruo de la habitacion\n" + 
                Palabra.SALIR + ":Finalizar partida";
    }

}
