/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ada;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

/**
 *
 * @author javier
 * @author alvdela
 */

public class Main {
    public static void main(String[] args){  
        CrearExcel excel = new CrearExcel();
        //excel.excelInicialK();
        //calculoDeK(excel, 1000000);
        excel.excelInicialComp();
        compararAlgoritmos(excel);
    
    }
    
    private static ArrayList<Integer> crearArray(ArrayList<Integer> lista, int tam){
        lista.clear();
        for (int i = 0; i < tam; i++) {    
            lista.add(i);
        }
        
        //for(int i = 0; i < tam/10; i++){
        for(int i = 0; i < tam/10; i++){
            int x = (int) (Math.random() * tam);
            int y = (int) (Math.random() * tam);
            int temporal = lista.get(y);
            lista.set(y, lista.get(x));
            lista.set(x, temporal);
        }
        return lista;
    }
    
    /**
     * Calcula el valor de k más optimo
     * @param excel
     * @param tam 
     */
    private static void calculoDeK(CrearExcel excel, int tam){
        ArrayList<Integer> lista = new ArrayList(tam); 
        QuicksortModificadoPivote algoritmoK = new QuicksortModificadoPivote();
        for(int k = 3; k <= 30; k++){
            System.out.println("VALOR DE K: "+ k);
            int mediaAsignaciones = 0;
            int mediaComparaciones = 0;
            for(int i=0; i < 40; i++){
                lista = crearArray(lista, tam);
                algoritmoK.quickSort(lista, 0, tam-1, k);
                
                if(!comprobarArray(lista)){
                    System.out.println("ARRAY MAL ORDENADO");;
                }
                
                
                mediaAsignaciones = mediaAsignaciones + algoritmoK.resultadosAsignaciones();
                mediaComparaciones = mediaComparaciones +algoritmoK.resultadosComparaciones();
            }
            
            mediaAsignaciones = mediaAsignaciones/40;
            mediaComparaciones = mediaComparaciones/40;
            
            excel.cearExcelK(k, mediaAsignaciones, mediaComparaciones);
        }
        
        excel.cerrarExcel();
        
    }
    
    /**
     * Compara los dos algoritmos
     * @param excel 
     */
    private static void compararAlgoritmos(CrearExcel excel){
        int tam = 100000;
        int mediaAsignacionesNormal;
        int mediaComparacionesNormal;
        long mediaTiempoNormal; 
        
        int mediaAsignacionesModificado;
        int mediaComparacionesModificado;
        long mediaTiempoModificado;
        
        ArrayList<Integer> lista = new ArrayList(tam); 
        QuicksortModificadoPivote algoritmoK = new QuicksortModificadoPivote();
        Quicksort algoritmoNormal = new Quicksort();
        
        Instant start;
        Instant finish;
        for(int j = 0 ; j < 10; j++){
            tam = tam +10000;
            mediaTiempoNormal=0;
            mediaTiempoModificado=0;
            mediaAsignacionesNormal=0;
            mediaComparacionesNormal=0;
            mediaAsignacionesModificado=0;
            mediaComparacionesModificado=0;
            System.out.println("Tamaño: "+ tam );
            for(int i = 0; i<40; i++){
                lista = crearArray(lista, tam);
                
                start = Instant.now();
                algoritmoNormal.quickSort(lista, 0, tam-1);
                finish = Instant.now();
                
                mediaTiempoNormal = mediaTiempoNormal + Duration.between(start, finish).toNanos();
                mediaAsignacionesNormal = mediaAsignacionesNormal + algoritmoNormal.resultadosAsignaciones();
                mediaComparacionesNormal = mediaComparacionesNormal + algoritmoNormal.resultadosComparaciones();                
                
                
                lista = crearArray(lista, tam);
                
                start = Instant.now();
                algoritmoK.quickSort(lista, 0, tam-1, 15);
                finish = Instant.now();
                
                mediaTiempoModificado = mediaTiempoModificado + Duration.between(start, finish).toNanos();
                mediaAsignacionesModificado = mediaAsignacionesModificado + algoritmoK.resultadosAsignaciones();
                mediaComparacionesModificado = mediaComparacionesModificado + algoritmoK.resultadosComparaciones();
            }
            mediaTiempoNormal = mediaTiempoNormal/40;
            mediaAsignacionesNormal = mediaAsignacionesNormal/40;
            mediaComparacionesNormal = mediaComparacionesNormal/40;
            
            mediaTiempoModificado = mediaTiempoModificado/40;
            mediaAsignacionesModificado = mediaAsignacionesModificado/40;
            mediaComparacionesModificado = mediaComparacionesModificado/40;
            
            excel.cearExcelComp(tam, mediaAsignacionesNormal,mediaAsignacionesModificado,mediaComparacionesNormal,mediaComparacionesModificado, mediaTiempoNormal, mediaTiempoModificado );
        }
        excel.cerrarExcel();
    }
    
    /**
     * 
     * Comprueba que el array esté ordenado
     */
    private static boolean comprobarArray(ArrayList<Integer> lista){
        boolean ordenado = true;
        for(int i = 0; i < (lista.size() - 1); i++){
            if(lista.get(i)>=lista.get(i + 1)){
                ordenado = false;
            }
        }
        return ordenado;
    }
}