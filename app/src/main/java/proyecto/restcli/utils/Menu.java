
package proyecto.restcli.utils;

public class Menu{

    public void menuAyuda() {
        // indicaciones de uso
        System.out.println("\n\n\tUso: java -jar rest-client.jar <verbo_http> [opciones]");
        
        System.out.print("\n\tVerbos http disponibles: "); 
        // Verbo "GET"
        System.out.printf("\n\n\t%-7s%5s%s", "get", " " ,"Realiza una petición GET para traer datos");
        System.out.printf("\n\t%12s%s", " ", "Uso: get <ruta>");
        // Verbo "POST"
        System.out.printf("\n\n\t%-7s%5s%s", "post", " " ,"Realiza una petición POST para enviar datos");
        System.out.printf("\n\t%12s%s", " ", "Uso: post <ruta> <datos_json>");
        // Verbo "PUT"
        System.out.printf("\n\n\t%-7s%5s%s", "put", " " ,"Realiza una petición PUT para actualizar datos");
        System.out.printf("\n\t%12s%s", " ", "Uso: put <ruta> <datos_json>");
        // Verbo "DELETE"
        System.out.printf("\n\n\t%-7s%5s%s", "delete", " " ,"Realiza una petición PUT para actualizar datos");
        System.out.printf("\n\t%12s%s", " ", "Uso: Delete <ruta>");

        System.out.println("\n\n\tOpciones adicionales: ");
        
        // Ayuda
        System.out.printf("\n\t-h, --help %5s%s", " ", "Muestra una ayuda del uso de la herramienta");
        
        // file
        System.out.printf("\n\n\t-f, --file %5s%s", " ", "Envía los datos desde un archivo");
        System.out.printf("\n\t\t  %5s Uso: <post o put> <ruta> -f <ruta_del_archivo>", " "); 
        
        // output -> salida del resultado a un archivo
        System.out.printf("\n\n\t-o, --output %4s%s", " ", "Los datos recibidos los guarda en un archivo"); 
        System.out.printf("\n\t\t %5s  Uso: <get> <ruta> -o <ruta_archivo>\n", " ");  
    }
}