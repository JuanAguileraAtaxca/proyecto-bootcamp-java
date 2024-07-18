
package org.example.commads; 

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.example.utils.Formateador;

public class GetCommand{

    public void peticionGet(String... args){

        Formateador format = new Formateador();

        if(args.length < 2){
            System.out.println("\n\n\t\t:: Debe especificar la ruta ::\n");
            return;  
        }

        try {
            URL url = new URL(args[1]); 
            HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
            con.setRequestMethod("GET");

            int respuesta = con.getResponseCode(); 

            if(respuesta != 200){
                System.out.print("");
                return;  
            }

            StringBuilder sb = new StringBuilder();

            Scanner sc = new Scanner(url.openStream());

            while(sc.hasNext()){
                sb.append(sc.nextLine());
            }

            format.formatear(sb.toString());
        } catch (Exception e) {

        } finally {

        }

    }
}

