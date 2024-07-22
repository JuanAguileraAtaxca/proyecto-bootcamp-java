
package proyecto.restcli.commads; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import proyecto.restcli.utils.Formateador;

public class DeleteCommand{

    public String peticionDelete(String... args){

        Formateador format = new Formateador(); 
        String respuesta = ""; 
        if (args.length < 2) {
            System.out.print("\n\n\t\t:: Debe agregar la ruta ::\n");
            return null; 
        }

        try {
            URL url = new URL(args[1]);

            HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
            con.setRequestMethod("DELETE");
            con.setRequestProperty("Accept", "application/json");

            int responseCode = con.getResponseCode(); 

            if (responseCode != 200) {
                System.out.print("\n\n\t\t:: Hubo un error ::\n\n");
                return null; 
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                respuesta = response.toString(); 
                format.formatear(response.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }

        return respuesta; 
    }

}

