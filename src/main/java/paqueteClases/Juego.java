/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteClases;

import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author z16
 */
public class Juego {

    private Habitacion habitacionActual;
    private Transformar transformar;
    private boolean terminar = false;

    /**
     *
     */
    public Scanner s = new Scanner(System.in);

    /**
     *
     */
    public Juego() {
        crearHabitaciones();
        this.transformar = new Transformar();

    }

    public boolean isTerminar() {
        return terminar;
    }

   
    

    /**
     *
     */
    public void crearHabitaciones() {
        Habitacion h0 = new Habitacion("Piso 0 - Principal");
        Habitacion h1 = new Habitacion("Piso 1- Desierto");
        Habitacion h2 = new Habitacion("Piso 2- Jungla");
        HabitacionOscura h3 = new HabitacionOscura("Piso 3- Cueva");
        Habitacion h4 = new Habitacion("Piso 4- Pueblo");
        HabitacionOscura h5 = new HabitacionOscura("Piso 5- Amanecer");
        Habitacion h6 = new Habitacion("Piso 6- Oceano");
        Habitacion h7 = new HabitacionMonstruo("Piso 7- Coliseo", "normal");
        HabitacionOscura h8 = new HabitacionOscura("Piso 8- Espacio");
        HabitacionMonstruo h9 = new HabitacionMonstruo("Piso 9- Guerra", "normal");
        HabitacionMonstruo h10 = new HabitacionMonstruo("Piso 10- Juicio", "jefe");
        Habitacion h11 = new Habitacion("Salida");
        Habitacion h12 = new Habitacion("Salida secreta");

        this.habitacionActual = h0;

        h0.setSalida(Salida.NORTE.toString(), h1);

        h1.setSalida(Salida.NORTE.toString(), h3);
        h1.setSalida(Salida.ESTE.toString(), h4);
        h1.setSalida(Salida.OESTE.toString(), h2);

        h2.setSalida(Salida.ESTE.toString(), h1);
        h2.setSalida(Salida.NORTE.toString(), h7);

        h3.setSalida(Salida.NORTE.toString(), h7);
        h3.setSalida(Salida.OESTE.toString(), h8);
        h3.setSalida(Salida.ESTE.toString(), h6);
        h3.setSalida(Salida.SUR.toString(), h1);

        h4.setSalida(Salida.ESTE.toString(), h5);
        h4.setSalida(Salida.OESTE.toString(), h1);
        h4.setSalida(Salida.NORTE.toString(), h9);

        h5.setSalida(Salida.OESTE.toString(), h4);
        h5.setSalida(Salida.NORTE.toString(), h6);

        h6.setSalida(Salida.NORTE.toString(), h9);
        h6.setSalida(Salida.SUR.toString(), h5);
        h6.setSalida(Salida.ESTE.toString(), h0);
        h6.setSalida(Salida.OESTE.toString(), h3);

        h7.setSalida(Salida.NORTE.toString(), h10);
        h7.setSalida(Salida.SUR.toString(), h2);
        h7.setSalida(Salida.ESTE.toString(), h3);
        h7.setSalida(Salida.OESTE.toString(), h0);

        h8.setSalida(Salida.ESTE.toString(), h3);
        h8.setSalida(Salida.OESTE.toString(), h12);

        h9.setSalida(Salida.NORTE.toString(), h10);
        h9.setSalida(Salida.ESTE.toString(), h6);
        h9.setSalida(Salida.OESTE.toString(), h0);
        h9.setSalida(Salida.SUR.toString(), h4);

        h10.setSalida(Salida.ESTE.toString(), h11);
        h10.setSalida(Salida.SUR.toString(), h9);
        h10.setSalida(Salida.OESTE.toString(), h7);
    }

//    public void setHabitacion(int i) {
//        this.habitacionActual = ;
//    }
  
    public String juego(String com) {
        
            System.out.println(com);
            Comando c = transformar.getCommand(com);

            if (procesarComando(c)) {

                 if (c.getComando().equalsIgnoreCase(Palabra.IR.toString())) {
                   return irA(c);
                } else if (c.getComando().equalsIgnoreCase(Palabra.LUZ.toString())) {
                   return luz();
                } else if (c.getComando().equalsIgnoreCase(Palabra.ATACAR.toString())) {
                  return  atacar();
                }
            }
           return "-------------------";
 
    }
    
    public String habitaciono(){
        return this.habitacionActual.getDescripcionLarga();
    }

    /**
     *
     */
    public String bienvenido() {
        return "Bienvenido a la Torre Laberinto"
                + "\nPara salir debes matar el jefe o encontrar la salida secreta\n"
                + "Los comando disponibles son " + PalabraComando.mostrarComandos()
                + "\n-------------------------------------------------";
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean procesarComando(Comando c) {
        for (int i = 0; i < Palabra.values().length; i++) {
            if (c.getComando().equalsIgnoreCase(Palabra.values()[i].toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean procesarSegundaPalabra(Comando c) {
        for (int i = 0; i < Salida.values().length; i++) {
            if (c.getSegundaPalabra().equalsIgnoreCase(Salida.values()[i].toString())) {
                return true;
            }

        }
        return false;
    }

    /**
     *
     * @param c
     */
    public String irA(String c) {

        System.out.println(c);
        Habitacion h = this.habitacionActual.getSalida(c);
        if (h == null) {
            return "No hay salida en esa direccion\n";
        } else {
            this.habitacionActual = h;
            if (this.habitacionActual.getDescripcion().equals("Salida")
                    || this.habitacionActual.getDescripcion().equals("Salida secreta")) {
                terminar = true;
                return "Has encontrado la salida. FELICIDADES!";
            }
        }

        return this.habitacionActual.getDescripcionLarga();
    }

     public String irA(Comando c) {
        
            String d = c.getSegundaPalabra();
            Habitacion h = this.habitacionActual.getSalida(d);
            if (h == null) {
               return "No hay salida en esa direccion\n";
            } else {
                this.habitacionActual = h;
                if (this.habitacionActual.getDescripcion().equals("Salida")
                        || this.habitacionActual.getDescripcion().equals("Salida secreta")) {
                    terminar = true;
                    return "Has encontrado la salida. FELICIDADES!";
                }
            }
            return this.habitacionActual.getDescripcionLarga();
    }

    public String luz() {
        if (this.habitacionActual instanceof HabitacionOscura) {
            HabitacionOscura h = (HabitacionOscura) this.habitacionActual;
           return h.iluminar()+"\n"+this.habitacionActual.getDescripcionLarga();
        } else {
            return "La habitacion ya esta iluminada\n";
        }
    }

    public String atacar() {
        if (this.habitacionActual instanceof HabitacionMonstruo) {
            HabitacionMonstruo h = (HabitacionMonstruo) this.habitacionActual;
           return h.ataqueMonstruo()+"\n"+this.habitacionActual.getDescripcionLarga();
        } else {
            return "No hay mostruos en esta habitacion\n";
        }
    }
}
