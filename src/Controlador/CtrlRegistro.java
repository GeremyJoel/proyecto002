/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.consultas;
import Modelo.datos;
import Vista.Principal;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class CtrlRegistro implements ActionListener{
    private Principal vista;
    private datos dato;
    private consultas consul;
    
    public CtrlRegistro(Principal vista, datos dato, consultas consul){
        this.vista = vista;
        this.dato = dato;
        this.consul = consul;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnVer.addActionListener(this);
    }
    public void iniciar(){
        vista.setTitle("Registro");
        vista.setLocationRelativeTo(null);
    }
    
    private static String convertir(Date fecha){
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String V_fecha = String.valueOf(f.format(fecha));
        return V_fecha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource() == vista.btnAgregar){
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("Registro");
            dato.setD_buque(vista.txtBuque.getText());
            dato.setD_proce(vista.txtProce.getText());
            dato.setD_vol_nat(vista.txtVolNat.getText());
            dato.setD_vol_20(vista.txtVol20.getText());
            dato.setD_tone_M(vista.txtToneM.getText());
            dato.setD_tone_L(vista.txtToneL.getText());
            dato.setD_calado_in(vista.txtCaladoIn.getText());
            dato.setD_calado_fin(vista.txtCaladoFin.getText());
            dato.setD_densidad(vista.txtDensidad.getText());
            dato.setD_descarga(vista.txtDescarga.getText());
            dato.setD_boya(vista.txtBoya.getText());
            dato.setD_descarga_anual(vista.txtDescargaAnual.getText());
            dato.setD_memo(vista.txtMemo.getText());
            dato.setD_api(vista.txtApi.getText());
            dato.setD_temp(vista.txtTemp.getText());
            dato.setD_remanente(vista.txtRemanente.getText());
            
            dato.setF_arribo(convertir(vista.dateArribo.getDate()));
            dato.setF_fondeo(convertir(vista.dateFondeo.getDate()));
            dato.setF_vira(convertir(vista.dateVira.getDate()));
            dato.setF_i_piloto(convertir(vista.dateIPiloto.getDate()));
            dato.setF_d_piloto(convertir(vista.dateDPiloto.getDate()));
            dato.setF_i_remolcador(convertir(vista.dateIReclamador.getDate()));
            dato.setF_libre_remolcador(convertir(vista.dateIReclamador.getDate()));
            dato.setF_alineado(convertir(vista.dateAlineado.getDate()));
            dato.setF_A_valvula(convertir(vista.dateAValvula.getDate()));
            dato.setF_amarrado(convertir(vista.dateAmarrado.getDate()));
            dato.setF_abastece(convertir(vista.dateAbastece.getDate()));
            dato.setF_manguera(convertir(vista.dateManguera.getDate()));
            dato.setF_colo_barrera(convertir(vista.dateColoBarrera.getDate()));
            dato.setF_ini_descarga(convertir(vista.dateIniDescarga.getDate()));
            dato.setF_tapon(convertir(vista.dateTapon.getDate()));
            dato.setF_ter_descarga(convertir(vista.dateTerDescarga.getDate()));
            dato.setF_libre_abastece(convertir(vista.dateLibreAbastece.getDate()));
            dato.setF_barrera_bordo(convertir(vista.dateBarreraBordo.getDate()));
            dato.setF_cierre_valvula(convertir(vista.dateCierreValvula.getDate()));
            dato.setF_desconexion(convertir(vista.dateDesconexion.getDate()));
            dato.setF_desamarro_buque(convertir(vista.dateDesamarroBuque.getDate()));
            dato.setF_cuadrilla_bordo(convertir(vista.dateCuadrillaBordo.getDate()));
            dato.setF_desembarca_cuadrilla(convertir(vista.dateDesembarcaCuadrilla.getDate()));
            consul.insertar(db, dato);
            vista.ActualizaTabla();
    }

if(e.getSource() == vista.btnEliminar){
    MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("Registro");
    TableModel modelo = (TableModel) vista.MiTabla.getModel();
    boolean avanzar = true;
        int registro = vista.MiTabla.getSelectedRow();
        int columna = vista.MiTabla.getSelectedColumn();
        if (registro == -1) {
            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }
        if (avanzar) {
            String Codigo = modelo.getValueAt(
                    vista.MiTabla.getSelectedRow(),1).toString();
                  //  vista.MiTabla.getSelectedColumn()).toString();
            consul.eliminarRegistro(db,Codigo);
            vista.ActualizaTabla();
            System.out.println("Dato seleccionado : " + Codigo);
        } else {
            System.out.println("No se ha seleccionado un registro");
        }
}

if(e.getSource() == vista.btnVer){
    MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("Registro");
    TableModel modelo = (TableModel) vista.MiTabla.getModel();
    boolean avanzar = true;
        int registro = vista.MiTabla.getSelectedRow();
        int columna = vista.MiTabla.getSelectedColumn();
        if (registro == -1) {
            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }
        if (avanzar) {
            String Codigo = modelo.getValueAt(
                    vista.MiTabla.getSelectedRow(),1).toString();
        try {
            //  vista.MiTabla.getSelectedColumn()).toString();
            consul.verConsulta(db,Codigo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CtrlRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Dato seleccionado : " + Codigo);
        } else {
            System.out.println("No se ha seleccionado un registro");
        }
}

    }
    
    
}
