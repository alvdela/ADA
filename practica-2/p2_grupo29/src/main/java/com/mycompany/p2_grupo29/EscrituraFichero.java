/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_grupo29;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author javier
 */
public class EscrituraFichero {
    FileWriter fichero;
    PrintWriter pw;
    
    EscrituraFichero(){
        try{
            fichero = new FileWriter("salida.txt");
            pw = new PrintWriter(fichero);
            pw.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    public void EscribirFichero(String escribir){
        try
        {
            fichero = new FileWriter("salida.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(escribir);
            System.out.println(escribir);

        } catch (IOException e) {
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (IOException e2) {
               e2.printStackTrace();
           }
        }
    }
        
}
