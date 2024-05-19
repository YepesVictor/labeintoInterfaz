package paqueteClases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Diurno
 */
public class Comando {
    private String comando,segundaPalabra;

    /**
     *
     */
    public Comando() {
        this.comando="";
        this.segundaPalabra="";
    }

    /**
     *
     * @param comando
     * @param segundaPalabra
     */
    public Comando(String comando, String segundaPalabra) {
        this.comando = comando.toUpperCase();
        this.segundaPalabra = segundaPalabra;
    }

    /**
     *
     * @param comando
     */
    public Comando(String comando) {
        this.comando = comando;
    }

    /**
     *
     * @return
     */
    public String getComando() {
        return comando;
    }

    /**
     *
     * @return
     */
    public String getSegundaPalabra() {
        return segundaPalabra;
    }
    
    /**
     *
     * @return
     */
    public boolean hayComando(){
        PalabraComando p=new PalabraComando(comando);
        if (getComando()!=null &&
            p.esComando(comando)) {
            return true;
        }
        return true;
    }
    
    /**
     *
     * @return
     */
    public boolean haySegundaPalabra(){
        if (this.segundaPalabra != null) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Comando{" + "comando=" + comando + ", segundaPalabra=" + segundaPalabra + '}';
    }
    
    
    
}
