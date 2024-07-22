
package proyecto.restcli.commads; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import proyecto.restcli.utils.Formateador;
import proyecto.restcli.utils.LecturaArchivo;

public class PostCommand{

    public String peticionPost(String... args){
        Formateador format = new Formateador(); 
        String respuesta = null; 
        if (args.length < 3) {
            System.out.println("\n\n\t\t:: Debe ingresar la url ::\n");
            return null; 
        }

        try {
            URL url = new URL(args[1]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
            con.setRequestMethod("POST");

            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);

            boolean opcionArchivo = Arrays.asList(args).stream().anyMatch(x -> x.equals("-f") || x.equals("--file")); 

            String body = ""; 

            if(args.length == 4 && opcionArchivo){
                LecturaArchivo lectura = new LecturaArchivo(); 
                body = lectura.leerArchivo(args[args.length - 1]); 
            } else{
                body = args[2]; 
            }

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = body.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8")); 
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            format.formatear(response.toString());
            respuesta = response.toString(); 

        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }

        return respuesta; 
    }
}

