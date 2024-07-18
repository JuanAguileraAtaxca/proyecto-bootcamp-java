
package org.example.commads; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL; 

import org.example.utils.Formateador;

public class PostCommand{

    public void peticionPost(String... args){
        Formateador format = new Formateador(); 

        if (args.length < 3) {
            System.out.println("\n\n\t\t:: Debe ingresar la url ::\n");
            return; 
        }

        try {
            URL url = new URL(args[1]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
            con.setRequestMethod("POST");

            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = args[2].getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = con.getResponseCode();

            // Leer la respuesta
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8")); 
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            format.formatear(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

