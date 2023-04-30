/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_grupo29;

import java.util.ArrayList;

/**
 *
 * @author alvdela, fradujo
 */
public class Torre {

    private ArrayList<Integer> torre1;
    private ArrayList<Integer> torre2;
    private ArrayList<Integer> solucion;

    public Torre(ArrayList<Integer> torre1, ArrayList<Integer> torre2) {
        this.torre1 = torre1;
        this.torre2 = torre2;
        solucion = new ArrayList<>();
    }

    public ArrayList<Integer> solucionar() {
        int distT1, distT2;
        boolean igualesT1;
        boolean igualesT2;
        while (!torre1.isEmpty() && !torre2.isEmpty()) {
            System.out.println("Torre1:" +torre1.toString());
            System.out.println("Torre2:" +torre2.toString());
            System.out.println("");
            igualesT1 = false;
            igualesT2 = false;
            if (torre1.get(0) == torre2.get(0)) {
                solucion.add(torre1.get(0));
                torre1.remove(0);
                torre2.remove(0);
            } else {
                distT1 = 0;
                distT2 = 0;
                while (!igualesT1 && distT1<torre2.size()) {
                    if (torre1.get(0) == torre2.get(distT1)) {
                        distT1--;
                        igualesT1 = true;
                    }
                    distT1++;
                }
                igualesT2 = false;
                while (!igualesT2 && distT2<torre1.size()) {
                    if (torre2.get(0) == torre1.get(distT2)) {
                        distT2--;
                        igualesT2 = true;
                    }
                    distT2++;
                }
                if(igualesT2 && igualesT1){
                    if (distT1 == distT2) {
                        if (torre1.size() < torre2.size()) {
                            solucion.add(torre1.get(0));
                            while (torre2.get(0) != torre1.get(0)) {
                                torre2.remove(0);
                            }
                            torre2.remove(0);
                            torre1.remove(0);
                        } else {
                            solucion.add(torre2.get(0));
                            while (torre1.get(0) != torre2.get(0)) {
                                torre1.remove(0);
                            }
                            torre2.remove(0);
                            torre1.remove(0);
                        }
                    } else {
                        if (distT1 < distT2) {
                            solucion.add(torre1.get(0));
                            while (torre2.get(0) != torre1.get(0)) {
                                torre2.remove(0);
                            }
                            torre2.remove(0);
                            torre1.remove(0);
                        } else {
                            solucion.add(torre2.get(0));
                            while (torre1.get(0) != torre2.get(0)) {
                                torre1.remove(0);
                            }
                            torre2.remove(0);
                            torre1.remove(0);
                        }
                    }  
                }else{
                    if(igualesT1){
                        solucion.add(torre1.get(0));
                        while (torre2.get(0) != torre1.get(0)) {
                            torre2.remove(0);
                        }
                        
                        torre2.remove(0);
                        torre1.remove(0);
                    }
                    
                    if(igualesT2){
                        solucion.add(torre2.get(0));
                        while (torre1.get(0) != torre2.get(0)) {
                            torre1.remove(0);
                        }
                        
                        torre2.remove(0);
                        torre1.remove(0);
                    }
                   
                }
                
                if(!igualesT2 && !igualesT1){
                    torre2.remove(0);
                    torre1.remove(0);
                }
                
            }
        }
        return solucion;
    }
}
