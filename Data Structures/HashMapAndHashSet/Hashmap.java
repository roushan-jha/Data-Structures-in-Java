import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmap {
    public static void main(String[] args) {
        // Map<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        //Insert - put
        map.put("English", 80);
        map.put("Science", 98);
        map.put("Maths", 100);
        System.out.println(map);

        //Update
        map.put("English", 88);
        System.out.println(map);

        //Search - get
        System.out.println(map.get("Maths"));

        //Search - containsKey
        System.out.println(map.containsKey("Hindi"));

        //Delete - remove
        map.remove("English");
        
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            // System.out.println(e);
            System.out.println(e.getKey() + "=" + e.getValue());
        }

        System.out.println("Size: " + map.size());

        Set<String> keys = map.keySet();
        for(String key : keys) {
            System.out.println(key + "=" + map.get(key));
        }

    }
}
