 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import com.mongodb.MongoClient;
import java.util.List;


public class Conexion {

   public MongoClient conectar(){
       MongoClient mongo = null;
       mongo = new MongoClient("localhost", 27017);
       return mongo;
   }    
}
