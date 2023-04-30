/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ada;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author javier
 * @author alvdela
 */
public class QuicksortModificadoK {
    
    private static int comparaciones = 0;
    private static int asignaciones = 0;
    //private static int k = 10;
    
    public QuicksortModificadoK(){
       
    }
    
    public void quickSort(ArrayList<Integer> vector, int izquierda, int derecha, int k) {
        
        int pivote = vector.get(izquierda);
        //vector.indexOf(pivote);
        //Vector izq de izq a pivote
        //vector derecha de pivote a derecha
        int i = izquierda;
        int j = derecha;
        int auxIntercambio;
        while (i < j) {
            comparaciones = comparaciones + 2;
            while (i < j && vector.get(i) <= pivote) {
                comparaciones = comparaciones + 2;
                i++;
            }
            if(i >= j){
                comparaciones--;               
            }
            
            comparaciones++;
            while (vector.get(j) > pivote) {
                comparaciones++;
                j--;
            }
           
            if (i < j) {
                auxIntercambio = vector.get(i);
                vector.set(i, vector.get(j));
                vector.set(j, auxIntercambio);
                asignaciones = 3 + asignaciones;
            }
        }
        vector.set(izquierda, vector.get(j));
        vector.set(j, pivote);
        asignaciones = 2 + asignaciones;
        
        comparaciones++;
        if (izquierda < j - 1) {
            if(((j-1)-izquierda)<k){
                insercionDirecta(vector, izquierda, j-1);
            }else{
                quickSort(vector, izquierda, j - 1, k);
            }
            
        }
        comparaciones++;
        if (j + 1 < derecha) {
            if((derecha-(j+1))<k){
                insercionDirecta(vector,j+1, derecha);
            }else{
                quickSort(vector, j + 1, derecha, k);
            } 
        }
    }   
    
    public static void insercionDirecta(ArrayList<Integer> vector, int inicial, int end){                                            
    int p, j;
    int aux;
    for (p = inicial; p <= end; p++){                             // desde el segundo elemento hasta
              aux = vector.get(p);                                   // el final, guardamos el elemento y
              j = p - 1;                                             // empezamos a comprobar con el anterior
              while ((j >= 0) && (aux < vector.get(j))){             // mientras queden posiciones y el                                
                                                                     // valor de aux sea menor que los
                             vector.set((j+1),vector.get(j));        // de la izquierda, se desplaza a
                             j--;                                    // la derecha
              }
              vector.set(j+1,aux);                                           // colocamos aux en su sitio
    }
}
    
    public static void resultados(){
        System.out.println("Comparaciones:" + comparaciones + "\n" + "Asignaciones: " + asignaciones);
    }
}
 
