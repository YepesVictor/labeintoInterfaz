/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteClases;

import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Transformar {

    /**
     *
     */
    public Scanner s = new Scanner(System.in);
    private PalabraComando p;

    /**
     *
     */
    public Transformar() {
        p = new PalabraComando();
    }

    /**
     *
     * @return
     */
    public Comando getCommand(String coman) {
        String[] primera = coman.split(" ");
        String uno = "";
        String dos = "";

        if (p.esComando(primera[0])) {
            uno = primera[0];
        }else{
            System.out.println("Comando incorrecto. Comandos disponibles ("+PalabraComando.comandoDisponible()+")");
        }

        if (primera.length == 2) {

            dos = primera[1];

            return new Comando(uno, dos);
        }
        return new Comando(uno);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Transformar{" + "p=" + p + '}';
    }

}
