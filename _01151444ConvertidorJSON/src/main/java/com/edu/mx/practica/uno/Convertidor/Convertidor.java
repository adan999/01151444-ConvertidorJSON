package com.edu.mx.practica.uno.Convertidor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.json.XML;
import sun.reflect.annotation.ExceptionProxy;

import javax.swing.*;

public class Convertidor {

    Alumno alumno = new Alumno();
    /**
     * Metodo para convertir Clase a JSON
     * @param  clase texto en formato clase para convertir
     * @return Clase convertida a JSON
     */
    public String convertirClaseToJson(String clase) {
        //Se crea instancia de la Clase Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String resultado = "";
        try {
            //Se separa la cadena por saltos de linea
            String[] variables = clase.split("\n");
            //Condicion para comprobar la longitud del objeto
            if(variables.length < 6) {
                alumno.setNombre(variables[0]);
                alumno.setApellidoPaterno(variables[1]);
                alumno.setApellidoPaterno(variables[2]);
                alumno.setCorreoElectronico(variables[3]);
                //Integer para transformar de cadena a entero
                alumno.setMatricula(Integer.parseInt(variables[4]));
                //El objeto de Java se transforma a Json
                resultado = gson.toJson(alumno);
            }
            else{
                JOptionPane.showMessageDialog(null,"Error: El texto introducido no es JAVA");
                resultado = "";
            }
        }catch(Exception e){
            //Exception en caso de error
            JOptionPane.showMessageDialog(null,"Error: El texto introducido no es JAVA");
        }
        return resultado;
    }

    /**
     * Metodo para convertir XML a JSON
     * @param  xml texto en formato XML para convertir
     * @return XML convertida a JSON
     */
    public String convertirXmlToJson(String xml) {
        String resultado = "";
        try {
            //Se crea instancia de JSONObject
            JSONObject xmlJSONObj = XML.toJSONObject(xml);
            resultado = xmlJSONObj.toString(4);
            if(resultado.compareTo("{}")== 0){
                resultado = "";
                JOptionPane.showMessageDialog(null,"Error: El texto introducido no es XML");
            }
        }catch (Exception e){
            //Exception en caso de error
            JOptionPane.showMessageDialog(null,"Error: El texto introducido no es XML");
        }
        return resultado.toString();
    }
}
