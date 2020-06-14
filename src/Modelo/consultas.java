/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class consultas extends Conexion{
    
    
    public void insertar(DB db,datos dato) {
        //Recoge datos de la tabla
        DBCollection table = db.getCollection("Registro");
 
        //Crea un objecto básico y le añade elementos
        BasicDBObject document = new BasicDBObject();
        document.put("Buque Tanque", dato.getD_buque());
        document.put("Procedencia", dato.getD_proce());
        document.put("Volumen Natural Buque", dato.getD_vol_nat());
        document.put("Volumen a grados", dato.getD_vol_20());
        document.put("Toneladas Metricas", dato.getD_tone_M());
        document.put("Toneladas Largas", dato.getD_tone_L());
        document.put("Calados Iniciales", dato.getD_calado_in());
        document.put("Calados Finales", dato.getD_calado_fin());
        document.put("Descarga Anual N°", dato.getD_descarga_anual());
        document.put("Descarga por Contrato N°", dato.getD_descarga());
        document.put("Boya N°", dato.getD_boya());
        document.put("Memo N°", dato.getD_memo());
        document.put("Densidad", dato.getD_densidad());
        document.put("Api", dato.getD_api());
        document.put("Temperatura", dato.getD_temp());
        document.put("Remanente", dato.getD_remanente());
        
        document.put("Arribo del Buque-Tanque", dato.getF_arribo());
        document.put("Fondeo Buque Tanque", dato.getF_fondeo());
        document.put("Vira Ancla", dato.getF_vira());
        document.put("Piloto de Puerto Abordo", dato.getF_i_piloto());
        document.put("Desembarca", dato.getF_d_piloto());
        document.put("Firme Remolcador", dato.getF_i_remolcador());
        document.put("Libre remolcador", dato.getF_libre_remolcador());
        document.put("Alineado Sistema", dato.getF_alineado());
        document.put("Abiertas Valvulas Piem Boya", dato.getF_A_valvula());
        document.put("Amarrado a Boya", dato.getF_amarrado());
        document.put("Firme Barco abastecedor", dato.getF_abastece());
        document.put("Conexion de Mangueras", dato.getF_manguera());
        document.put("Colocacion de Barrera", dato.getF_colo_barrera());
        document.put("Inicia Descarga", dato.getF_ini_descarga());
        document.put("Tapon desplazado", dato.getF_tapon());
        document.put("Termina Descarga", dato.getF_ter_descarga());
        document.put("Libre Barco Abastecedor", dato.getF_libre_abastece());
        document.put("Barrera a bordo", dato.getF_barrera_bordo());
        document.put("Cerradas las valvulas", dato.getF_cierre_valvula());
        document.put("Desconexion de Mangueras", dato.getF_desconexion());
        document.put("Desamarrado Buque", dato.getF_desamarro_buque());
        document.put("Cuadrilla a bordo", dato.getF_cuadrilla_bordo());
        document.put("Desembarca Cuadrilla", dato.getF_desembarca_cuadrilla());
        
        //Inserta la tabla
        table.insert(document);
    }
    
    public void eliminarRegistro(DB db, String Dato){
        DBCollection table = db.getCollection("Registro");

    // Create the document to specify find criteria
    BasicDBObject document = new BasicDBObject();
    document.put("Descarga por Contrato N°", Dato);

    // Find one person and delete
    table.remove(document);
    }
    
    public void verConsulta(DB db, String Dato) throws FileNotFoundException{
        
        DBCollection collection = db.getCollection("Registro");
        BasicDBObject buscar = new BasicDBObject();
        buscar.put("Descarga por Contrato N°", Dato); 
        DBCursor cursor = collection.find(buscar);
        String buque = null;
        String proce = null;
        String vol_nat = null;
        String vol_20 = null;
        String tone_M = null;
        String tone_L = null;
        String calado_in = null;
        String calado_fin = null;
        String densidad = null;
        String descarga = null;
        String boya = null;
        String descarga_anual = null;
        String memo = null;
        String api = null;
        String temp = null;
        String remanente = null;


        String arribo = null;
        String fondeo = null;
        String vira = null;
        String i_piloto = null;
        String d_piloto = null;
        String i_remolcador = null;
        String libre_remolcador = null;
        String alineado = null;
        String A_valvula = null;
        String amarrado = null;
        String abastece = null;
        String manguera = null;
        String colo_barrera = null;
        String ini_descarga = null;
        String tapon = null;
        String ter_descarga = null;
        String libre_abastece = null;
        String barrera_bordo = null;
        String cierre_valvula = null;
        String desconexion = null;
        String desamarro_buque = null;
        String cuadrilla_bordo = null;
        String desembarca_cuadrilla = null;
        while(cursor.hasNext()){
            DBObject obj = cursor.next();
            
            //OBTENER LOS DATOS DE MONGODB
            buque = (String)obj.get("Buque Tanque");
            proce = (String)obj.get("Procedencia");
            vol_nat = (String)obj.get("Volumen Natural Buque");
            vol_20 = (String)obj.get("Volumen a grados");
            tone_M = (String)obj.get("Toneladas Metricas");
            tone_L = (String)obj.get("Toneladas Largas");
            calado_in = (String)obj.get("Calados Iniciales");
            calado_fin = (String)obj.get("Calados Finales");
            
            
            densidad = (String)obj.get("Densidad");
            descarga = (String)obj.get("Descarga por Contrato N°");
            boya = (String)obj.get("Boya N°");
            descarga_anual = (String)obj.get("Descarga Anual N°");
            memo = (String)obj.get("Memo N°");
            api = (String)obj.get("Api");
            temp = (String)obj.get("Temperatura");
            remanente = (String)obj.get("Remanente");


            arribo = (String)obj.get("Arribo del Buque-Tanque");
            fondeo = (String)obj.get("Fondeo Buque Tanque");
            vira = (String)obj.get("Vira Ancla");
            i_piloto = (String)obj.get("Piloto de Puerto Abordo");
            d_piloto = (String)obj.get("Desembarca");
            i_remolcador = (String)obj.get("Firme Remolcador");
            libre_remolcador = (String)obj.get("Libre remolcador");
            alineado = (String)obj.get("Alineado Sistema");
            A_valvula = (String)obj.get("Abiertas Valvulas Piem Boya");
            amarrado = (String)obj.get("Amarrado a Boya");
            abastece = (String)obj.get("Firme Barco abastecedor");
            manguera = (String)obj.get("Conexion de Mangueras");
            colo_barrera = (String)obj.get("Colocacion de Barrera");
            ini_descarga = (String)obj.get("Inicia Descarga");
            tapon = (String)obj.get("Tapon desplazado");
            ter_descarga = (String)obj.get("Termina Descarga");
            libre_abastece = (String)obj.get("Libre Barco Abastecedor");
            barrera_bordo = (String)obj.get("Barrera a bordo");
            cierre_valvula = (String)obj.get("Cerradas las valvulas");
            desconexion = (String)obj.get("Desconexion de Mangueras");
            desamarro_buque = (String)obj.get("Desamarrado Buque");
            cuadrilla_bordo = (String)obj.get("Cuadrilla a bordo");
            desembarca_cuadrilla = (String)obj.get("Desembarca Cuadrilla");
        }
        
        //ARMAR EL PDF
        //creamos el documento
        Document documento = new Document();
        
        try {
            //Creamos el OutputStream con la ruta a guardar el pdf
            FileOutputStream archivo = new FileOutputStream("archivo.pdf");
            
            PdfWriter writer = PdfWriter.getInstance(documento, archivo);
            
            documento.open();
            
            PdfContentByte cb = writer.getDirectContent();
            
            try {
                BaseFont bf = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                cb.setFontAndSize(bf, 12);
                //Empezar a escribir
                cb.beginText();
                //Posisionamiento del texto
                cb.setTextMatrix(250,820);
                cb.showText("DIRECCION DE OPERACIONES");
                cb.setTextMatrix(250, 815);
                cb.showText("Sistema Ingetral de Gestion");
                cb.setTextMatrix(100, 800);
                cb.showText("BITACORA DE MANIOBRAS DE COMBUSTIBLE AÑO ___");
                cb.setTextMatrix(50, 780);
                cb.showText("Buque-Tanque \t"+buque);
                cb.setTextMatrix(300, 780);
                cb.showText("Descarga Anual N° \t"+descarga_anual);
                cb.setTextMatrix(50, 770);
                cb.showText("Procedencia \t"+proce);
                cb.setTextMatrix(300, 770);
                cb.showText("Descarga por contrato N° \t"+descarga);
                cb.setTextMatrix(50, 760);
                cb.showText("Volumen Natural Buque: \t"+vol_nat);
                cb.setTextMatrix(300, 760);
                cb.showText("Boya N° \t"+boya);
                cb.setTextMatrix(50, 750);
                cb.showText("Volumen a 20° C Buque: \t"+vol_20);
                cb.setTextMatrix(300, 750);
                cb.showText("Mamo N° \t"+memo);
                cb.setTextMatrix(50, 740);
                cb.showText("Toneladas Métricas \t"+tone_M);
                cb.setTextMatrix(300, 740);
                cb.showText("Densidad° \t"+densidad);
                cb.setTextMatrix(50, 730);
                cb.showText("Toneladas Largas \t"+tone_L);
                cb.setTextMatrix(300, 730);
                cb.showText("Api \t"+api);
                cb.setTextMatrix(50, 720);
                cb.showText("Calados Iniciales "+calado_in);
                cb.setTextMatrix(300, 720);
                cb.showText("Temperatura \t"+temp);
                cb.setTextMatrix(50, 710);
                cb.showText("Calados Finales "+calado_fin);
                cb.setTextMatrix(300, 710);
                cb.showText("Remanente "+remanente);
                cb.setTextMatrix(250, 680);
                cb.showText("HORARIO DE MANIOBRAS");
                cb.setTextMatrix(50, 660);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                cb.setTextMatrix(50, 800);
                cb.showText("El BUQUE "+buque);
                
                
                
                //Terminar de Escribir
                cb.endText();
            } catch (IOException ex) {
                Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            documento.close();
        } catch (DocumentException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    }
