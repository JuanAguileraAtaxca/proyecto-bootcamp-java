
package proyecto.restcli.commads; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import proyecto.restcli.utils.Formateador;
import proyecto.restcli.utils.LecturaArchivo;

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

            boolean opcionArchivo = Arrays.asList(args).stream().anyMatch(x -> x.equals("-o") || x.equals("--output"));
            String body = ""; 
            if (args.length == 4 && opcionArchivo) {
                
                LecturaArchivo lectura = new LecturaArchivo(); 
                body = lectura.leerArchivo(args[args.length - 1]);
            } else {
                body = args[2]; 
            }

            try (OutputStream os = con.getOutputStream()){
                byte[] parametros = body.getBytes("utf-8"); 
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

