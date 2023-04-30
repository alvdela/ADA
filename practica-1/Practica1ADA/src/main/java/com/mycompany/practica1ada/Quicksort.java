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
public class Quicksort {
    
    private int comparaciones = 0;
    private int asignaciones = 0;
    
    public Quicksort(){
       
    }
    
    public void quickSort(ArrayList<Integer> vector, int izquierda, int derecha) {
        int pivote = vector.get(izquierda);
        asignaciones++;
        int i = izquierda;
        int j = derecha;
        int auxIntercambio;
        while (i < j) {
            comparaciones = comparaciones + 1;
            while (i < j && vector.get(i) <= pivote) {
                comparaciones = comparaciones + 1;
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
        
        if (izquierda < j - 1) {
            quickSort(vector, izquierda, j - 1);
        }
        
        if (j + 1 < derecha) {
            quickSort(vector, j + 1, derecha);
        }
    }   
    
    public int resultadosComparaciones(){
        int valorDevolver= comparaciones;
        comparaciones=0;
        return valorDevolver;
    }
    
    public int resultadosAsignaciones(){
        int valorDevolver = asignaciones;
        asignaciones=0;
        return valorDevolver;
    }
}
 
