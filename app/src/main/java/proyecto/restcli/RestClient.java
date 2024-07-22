
package proyecto.restcli;

import proyecto.restcli.commads.DeleteCommand;
import proyecto.restcli.commads.GetCommand;
import proyecto.restcli.commads.PostCommand;
import proyecto.restcli.commads.PutCommand;
import proyecto.restcli.utils.Menu;

public class RestClient{

    private String[] args; 

    public RestClient(String... args){
        this.args = args; 
    }

    public void gestorPeticiones(){
        Menu menu = new Menu(); 
        GetCommand get = new GetCommand();
        PostCommand post = new PostCommand(); 
        PutCommand put = new PutCommand(); 
        DeleteCommand delete = new DeleteCommand(); 

        if (this.args.length == 0) {
            menu.menuAyuda();
            return; 
        }

        switch(this.args[0]){
            case "-h": case "--help": 
                menu.menuAyuda(); 
                break; 
            case "get": case "GET": 
                get.peticionGet(this.args);
                break; 
            case "post": case "POST": 
                post.peticionPost(this.args);
                break; 
            case "put": case "PUT":
                put.peticionPut(this.args);
                break; 
            case "delete": case "DELETE":
                delete.peticionDelete(args);
                break; 
            default: 
                System.out.println("\n\n\t\t:: Opción no disponible ::\n"); 
        }
    }
    
}

