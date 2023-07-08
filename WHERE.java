
import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE  "name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"
*/
public class WHERE {
    public static void main(String[] args) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("name", "Ivanov");
        list.put("country", "Russia");
        list.put("city", "Moscow");
        list.put("age", "null");
        System.out.println(getQuery(list));
       
    }
    public static String getQuery(Map<String, String> params)
    {
       StringBuilder str = new StringBuilder("");
       for (Map.Entry<String, String> item : params.entrySet()){
            if (item.getValue() != null && item.getValue() != "null")
            str.append(item.getKey() + " = '" + item.getValue() + "' and ");
       }
       str.delete(str.length() - 5, str.length());
       return str.toString();
    }

}