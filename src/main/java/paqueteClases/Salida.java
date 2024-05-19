/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package paqueteClases;

/**
 *
 * @author z16
 */
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public enum Salida {

    /**
     *
     */
    NORTE,

    /**
     *
     */
    SUR,

    /**
     *
     */
    ESTE,

    /**
     *
     */
    OESTE;

    /**
     *
     * @return
     */
    public static Salida randomSalida() {
        return Salida.values()[new Random().nextInt(Salida.values().length)];

    }
}
