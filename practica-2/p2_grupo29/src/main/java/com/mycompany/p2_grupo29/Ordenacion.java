/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_grupo29;

import java.util.ArrayList;

/**
 *
 * @author alvdela
 */
public class Ordenacion {
    
    private ArrayList<Integer> torre1;
    private ArrayList<Integer> torre2;
    private ArrayList<Integer> solucion;
    private int [][]matrizIntermedia;
    
    public Ordenacion(ArrayList torre1, ArrayList torre2){
        this.torre1 = torre1;
        this.torre2 = torre2;
        solucion = new ArrayList<Integer>();//solucion del problema
        matrizIntermedia = new int [torre1.size() + 1][torre2.size() + 1];//la matriz intermedia para programacion dinamica
    }
    
    
    public ArrayList<Integer> solucion(){
        int tam1 = torre1.size();
        int tam2 = torre2.size();
        boolean igual = false;
        //tenemos que rellenar la primera fila y columna de la matriz con 1's o 0's
        for(int col = 1; col <= tam1; col++){//columna
            if(igual){
                matrizIntermedia[col][1] = 1;
            }else if(torre1.get(col - 1 ) == torre2.get(0)){
                matrizIntermedia[col][1] = 1;
                igual = true;
            }else{
                matrizIntermedia[col][1] = 0;
            }
        }
        igual = false;
        for(int fil = 1; fil <= tam2; fil++){//fila
            if(igual){
                matrizIntermedia[1][fil] = 1;
            }else if(torre2.get(fil - 1 ) == torre1.get(0)){
                matrizIntermedia[1][fil] = 1;
                igual = true;
            }else{
                matrizIntermedia[1][fil] = 0;
            }
        }
        //completamos el resto de la matriz de resultados
        for(int col = 2; col <= tam1; col++){
            for(int fil = 2; fil <= tam2; fil++){
                int max = Math.max(matrizIntermedia[col - 1][fil], matrizIntermedia[col][fil - 1]);
                //obtenemos el maximo entre la posicion de arriba y la dcha.
                if(torre1.get(col -1) == torre2.get(fil - 1)){
                    matrizIntermedia[col][fil] = Math.max(max, matrizIntermedia[col - 1][fil - 1] + 1);
                    //si son iguales sumamos 1 al numero anterior de la diagonal
                }else{
                    matrizIntermedia[col][fil] = max;
                }
            }
        }
        //con todo esto tendriamos la matriz de resultados intermedios, queda obtener el resultado
        
        //printMatrix();
        return resultado();
    }
    
    private ArrayList<Integer> resultado(){
        int col = torre1.size();
        int fil = torre2.size();
        int max;
        //recorremos la matriz desde atras buscando cuando se incrementa en 1
        while(col > 0 && fil > 0){
            max = Math.max(matrizIntermedia[col - 1][fil], matrizIntermedia[col][fil - 1]);
            if(matrizIntermedia[col][fil] > max){
                solucion.add(0,torre1.get(col - 1));
                col--;
                fil--;
            }else{
                if(matrizIntermedia[col - 1][fil] > matrizIntermedia[col][fil - 1]){
                    col--;
                }else{
                    fil--;
                }
            }
        }
        return solucion;
    }
    
    private void printMatrix(){
        for(int col = 0; col <= torre1.size(); col++){
            for(int fil = 0; fil <= torre2.size(); fil++){
                System.out.print(matrizIntermedia[col][fil] + "|");
            }
            System.out.println("");
        }
    }
}
