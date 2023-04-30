/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_grupo29;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class LecturaFichero {
    private ArrayList<ArrayList> torres;
    private File archivo= null;
    private FileReader fr = null;
    private BufferedReader br = null;
    
    LecturaFichero(){
        torres = new ArrayList();
    }
    
    public void lectura(){
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
            archivo = new File ("entrada.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
         // Lectura del fichero
            String linea;
            int contador = 0;
            while((linea=br.readLine())!=null){
                ArrayList<Integer> torre = new ArrayList();
                if(contador == 0){
                    contador++;
                }else{
                    String[] datos = linea.split(" ");
                    for(String item : datos){
                        torre.add(Integer.valueOf(item));
                    }
                    if(contador == 2){
                        contador = -1;
                    }
                    torres.add(torre);
                    contador++;
                }  
            }
        }
        catch(IOException | NumberFormatException e){
        }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
        try{                    
            if( null != fr ){   
               fr.close();     
            }                  
        }catch (IOException e2){ 
        }
      }
    }
    public ArrayList getTorres(){
        return torres;
    }
    
}
