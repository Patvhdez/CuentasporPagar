/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuentasporpagar.entradacontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Integracion {
    public static void enviarInformacion(String descripcion,EntradaContable entrada1, EntradaContable entrada2){
        try {
            String requestMessage = "{\n" +
                "    \"auxiliar\":6,\n" +
                "    \"descripcion\":\""+ descripcion +"\",\n" +
                "    \"entradasContables\":[\n" +
                "        {\"entradaContable\": [\n" +
                "            {\n" +
                "                \"cuentaContable\":"+entrada1.cuentaContable+",\n" +
                "                \"tipoMovimiento\":\""+entrada1.tipoMovimiento+"\", \"monto\":"+entrada1.monto+"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cuentaContable\":"+entrada2.cuentaContable+",\n" +
                "                \"tipoMovimiento\":\""+entrada1.tipoMovimiento+"\",\n" +
                "                \"monto\":"+entrada1.monto+"\n" +
                "            }\n" +
                "            ]\n" +
                "           \n" +
                "        }\n" +
                "    ]\n" +
                "   \n" +
                "}";
            
            
            URL url = new URL("https://contabilidad-json.herokuapp.com/contabilidad/crearAsiento");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream outputStream = conn.getOutputStream();
            
            outputStream.write(requestMessage.getBytes());
            outputStream.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
