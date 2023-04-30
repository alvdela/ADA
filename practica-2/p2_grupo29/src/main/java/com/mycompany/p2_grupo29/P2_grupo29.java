/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.p2_grupo29;

import java.util.ArrayList;

/**
 *
 * @author alvar
 */
public class P2_grupo29 {

    public static void main(String[] args) {
        //ArrayList<Integer> torre1 = new ArrayList<>(Arrays.asList(10 ,20 ,20 ,10 ,20 ,10 ,20 ,10));
        //ArrayList<Integer> torre2 = new ArrayList<>(Arrays.asList(20 ,10 ,20, 10 ,10 ,20 ,10 ,10 ,20));
        
        LecturaFichero lectura = new LecturaFichero();
        EscrituraFichero escritura = new EscrituraFichero();
        lectura.lectura();
        ArrayList<ArrayList> torres = lectura.getTorres();
        
        ArrayList<Integer> torre1;
        ArrayList<Integer> torre2;
        ArrayList<Integer> solucion;
        int contador=1;
        for(int i=0; i<torres.size();i++){
            torre1= torres.get(i);
            torre2= torres.get(i+1);
            i++;
            
            //System.out.println(torre1.toString());
            //System.out.println(torre2.toString());
            
            Ordenacion prueba = new Ordenacion(torre1, torre2);
            //System.out.println((i/2)+": "+prueba.solucion().toString());
            solucion = prueba.solucion();
            escritura.EscribirFichero("Caso de prueba "+ contador);
            escritura.EscribirFichero("Número de piezas: "+ solucion.size());
            escritura.EscribirFichero("Solución: "+ solucion.toString().replaceAll("[^0-9 ]",""));
            escritura.EscribirFichero("");
            
            contador++;
        }
        
    }
}
