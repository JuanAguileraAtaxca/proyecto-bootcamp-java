
package proyecto.restcli.utils; 

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LecturaArchivo{

    public String leerArchivo(String path){

        String body = null; 

        try {
            Path file = Paths.get(path); 

            if (!file.toFile().exists()) {
                System.out.printf("\n\n\t\t%s:: Error -> No existe el archivo ::%s\n", Colores.ANSI_RED, Colores.ANSI_RESET); 
                return null; 
            }

            try (Stream<String> line = Files.lines(file)) {
                body = line.reduce((x, y) -> x+y.trim()).orElse(""); 
            } 

        } catch (Exception e) {
            return null; 
        }

        return body; 
    }
}

