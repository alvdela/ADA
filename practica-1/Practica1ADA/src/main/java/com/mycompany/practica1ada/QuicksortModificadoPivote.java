/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ada;

import java.util.ArrayList;

/**
 *
 * @author javier
 * @author alvdela
 */
public class QuicksortModificadoPivote {
    
    private  int comparaciones = 0;
    private  int asignaciones = 0;
    
    public QuicksortModificadoPivote(){
       
    }
    
    public int mediana(int valorInicial, int valorMedio, int valorFinal){
        if(((valorInicial>valorMedio)&&(valorInicial<valorFinal))||((valorInicial<valorMedio)&&(valorInicial>valorFinal))){
            return valorInicial;
        }
        
        if(((valorMedio>valorInicial)&&(valorMedio<valorFinal))||((valorMedio<valorInicial)&&(valorMedio>valorFinal))){
            return valorMedio;
        }
        return valorFinal;
    }
    
    public void quickSort(ArrayList<Integer> vector, int izquierda, int derecha,int k) {
        
        int pivote = mediana(vector.get(izquierda), vector.get(((derecha-izquierda)/2)+1), vector.get(derecha));
        
        comparaciones++; 
           if(pivote == vector.get(derecha)){
                vector.set(derecha,vector.get(izquierda));
                vector.set(izquierda, pivote);
                asignaciones = asignaciones +2;
            }else{
                comparaciones++;
                if(pivote != vector.get(izquierda)){
                    vector.set((((derecha-izquierda)/2)+1), vector.get(izquierda));
                    vector.set(izquierda, pivote);
                    asignaciones = asignaciones +2;
                }
           }
        
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
        vector.set(izquierda, vector.get(j));//TODO: esta parte es critica
        vector.set(j, pivote);
        asignaciones = 2 + asignaciones;
        
        
        if (izquierda < j - 1) {
            if(((j-1)-izquierda) < k){
                insercionDirecta(vector, izquierda, j-1);
            }else{
                quickSort(vector, izquierda, j-1, k);
            } 
        }
        
        if (j + 1 < derecha) {
            if((derecha-(j+1))<k){
                insercionDirecta(vector,j+1, derecha);
            }else{
                quickSort(vector, j + 1, derecha, k);
            } 
        }
    }   
    
    public void insercionDirecta(ArrayList<Integer> vector, int inicial, int end){                                            
    int p, j;
    int aux;
    for (p = inicial; p <= end; p++){                             // desde el segundo elemento hasta
              aux = vector.get(p);                                   // el final, guardamos el elemento y
              asignaciones++;
              j = p - 1;                                             // empezamos a comprobar con el anterior
              comparaciones++;
              while ((j >= 0) && (aux < vector.get(j))){             // mientras queden posiciones y el                                
                comparaciones++;                                       // valor de aux sea menor que los
                vector.set((j+1),vector.get(j));        // de la izquierda, se desplaza a
                asignaciones++;
                j--;                                    // la derecha
              }
              if(j<0){
                  comparaciones--;
              }
              vector.set(j+1,aux);                                           // colocamos aux en su sitio
              asignaciones++;
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
 
