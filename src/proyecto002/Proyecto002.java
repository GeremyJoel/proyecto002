/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto002;

import Controlador.CtrlRegistro;
import Modelo.consultas;
import Modelo.datos;
import Vista.Principal;

public class Proyecto002 {


    public static void main(String[] args){
        Principal vista = new Principal();
        datos dato = new datos();
        consultas consul = new consultas();
        CtrlRegistro ctrl = new CtrlRegistro(vista, dato, consul);
        ctrl.iniciar();
        vista.setVisible(true);
    }
    
}
