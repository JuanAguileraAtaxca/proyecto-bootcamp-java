
package proyecto.restcli.utils; 

import org.json.JSONArray;
import org.json.JSONException; 
import org.json.JSONObject; 

public class Formateador{

    public void formatear(String json) throws JSONException{
        String format = ""; 
        if (json.charAt(0) == '{') {
            JSONObject jsonObject = new JSONObject(json);
            format = jsonObject.toString(4);  
            System.out.println(format); 
            return; 
        }

        JSONArray jsonArray = new JSONArray(json);
        format = jsonArray.toString(4);
        System.out.println(format);

    }
}