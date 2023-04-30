/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ada;

/**
 *
 * @author javier
 * @author alvdela
 */
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 *
 * @author decodigo
 */
public class CrearExcel {
    private Workbook workbook;
    private Sheet sheet;
    
    int numeroRenglon=1;
    
    CrearExcel(){
       workbook = new HSSFWorkbook(); 
       sheet = workbook.createSheet("Hoja de datos");
    }
    
    public void excelInicialK(){
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("K");
        cell = row.createCell(1);
        cell.setCellValue("Asignaciones");
        cell = row.createCell(2);
        cell.setCellValue("Comparaciones");
    }
    
    public void excelInicialComp(){
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Tamaño");
        cell = row.createCell(1);
        cell.setCellValue("AsignacionesNormales");
        cell = row.createCell(2);
        cell.setCellValue("AsignacionesModificado");
        cell = row.createCell(3);
        cell.setCellValue("ComparacionesNormales");
        cell = row.createCell(4);
        cell.setCellValue("ComparacionesModificado");
        cell = row.createCell(5);
        cell.setCellValue("TiempoNormal");
        cell = row.createCell(6);
        cell.setCellValue("TiempoModificado");
    }
    
    public void cearExcelK(int tam, int asignaciones, int comparaciones) {
        Row row = sheet.createRow(numeroRenglon++);
        Cell cell = row.createCell(0);
        cell.setCellValue(tam);
        cell = row.createCell(1);
        cell.setCellValue(asignaciones);
        cell = row.createCell(2);
        cell.setCellValue(comparaciones);
        
    }
    
    
    public void cearExcelComp(int tam, int asignacionesNormal, int asignacionesModificado, int mediaComparacionesNormal, int mediaComparacionesModificado, long mediaTiempoNormal, long mediaTiempoModificado){
        Row row = sheet.createRow(numeroRenglon++);
        Cell cell = row.createCell(0);
        cell.setCellValue(tam);
        cell = row.createCell(1);
        cell.setCellValue(asignacionesNormal);
        cell = row.createCell(2);
        cell.setCellValue(asignacionesModificado);
        cell = row.createCell(3);
        cell.setCellValue(mediaComparacionesNormal);
        cell = row.createCell(4);
        cell.setCellValue(mediaComparacionesModificado);
        cell = row.createCell(5);
        cell.setCellValue(mediaTiempoNormal);
        cell = row.createCell(6);
        cell.setCellValue(mediaTiempoModificado);
    }
    
    
    public void cerrarExcel(){
        try{
            FileOutputStream out = new FileOutputStream(new File("PruebaDefinitivaComparacion.xlsx"));
        workbook.write(out);
        out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
