
package proyecto.restcli.commads; 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

import proyecto.restcli.utils.Colores;
import proyecto.restcli.utils.Formateador;

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
                System.out.printf("\n\n\t\t%s:: Error -> No hubo respuesta ::%s\n\n", Colores.ANSI_RED, Colores.ANSI_RESET);
                return;  
            }

            StringBuilder sb = new StringBuilder();

            Scanner sc = new Scanner(url.openStream());

            while(sc.hasNext()){
                sb.append(sc.nextLine());
            }

            boolean opcionArchivo = Arrays.asList(args).stream().anyMatch(x -> x.equals("-o") | x.equals("--output"));

            if (opcionArchivo && args.length == 4) {
                File file = new File(args[args.length -1 ]);

                if (!file.exists()) {
                    file.createNewFile(); 
                    System.out.printf("\n\n\t\t%s:: Archivo creado correctamente ::%s\n", Colores.ANSI_GREEN,Colores.ANSI_RESET); 
                } 

                FileWriter fw = new FileWriter(file); 
                BufferedWriter bw = new BufferedWriter(fw); 
                bw.write(sb.toString());
                bw.close();
                return; 
            }

            format.formatear(sb.toString());
        } catch (Exception e) {

        } finally {

        }

    }
}

