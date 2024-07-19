
package org.example.commads; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.example.utils.Formateador;

public class PutCommand{

    public void peticionPut(String... args){

        Formateador format = new Formateador(); 

        if(args.length < 2){
            System.out.println("Debe especificar la url");
            return; 
        }

        try{
            URL url = new URL(args[1]); 
            HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()){
                byte[] parametros = args[2].getBytes("utf-8"); 
                os.write(parametros, 0, parametros.length);
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {

                StringBuilder response = new StringBuilder();

                String responseLine;

                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                format.formatear(response.toString());
            }
        } catch(Exception e){
            System.out.println(e.getMessage()); 
        }
    }
}

