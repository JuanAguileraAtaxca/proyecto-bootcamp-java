
package org.example;

import org.example.commads.GetCommand;
import org.example.commads.PostCommand;
import org.example.utils.Formateador;
import org.example.utils.Menu;

public class RestClient{

    private String[] args; 

    public RestClient(String... args){
        this.args = args; 
    }

    public void gestorPeticiones(){
        Menu menu = new Menu(); 
        Formateador format = new Formateador(); 
        GetCommand get = new GetCommand();
        PostCommand post = new PostCommand(); 

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
            default: 
                System.out.println("\n\n\t\t::Opción no disponible\n"); 
        }
    }
    
}

