import java.util.*;
import java.io.*;


public class hashMap_5_hw {
    public static void main(String[] args) {
        HashMap<String, List<String>> phone_Map = new HashMap<>();

        File file = new File("phonebook.txt");


        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String element = scanner.nextLine();
                //List<String> phone_numbers = Arrays.asList(element.split(", "));
                List<String> phone_numbers = new ArrayList<>(Arrays.asList(element.split(", ")));
                String name = phone_numbers.get(0);
                phone_numbers.remove(0);
                if(phone_Map.containsKey(name)){
                    phone_Map.get(name).add(phone_numbers.get(0));
                }
                else {
                    phone_Map.put(name, phone_numbers);

                }
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(phone_Map);
        print(phone_Map);
        

    }
    public static void print(HashMap<String, List<String>> map){
        ArrayList<Integer> phone_count = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            // get value
            int value_size = entry.getValue().size();
            if(!phone_count.contains(value_size)){
                phone_count.add(value_size);
            }
        }
        Collections.sort(phone_count);
        Collections.reverse(phone_count);
        //System.out.println(phone_count);
        for (int i = 0; i < phone_count.size(); i++){
            for (Map.Entry<String, List<String>> entry: map.entrySet()){
                if (entry.getValue().size() == phone_count.get(i)){
                    System.out.print(entry.getKey() + ": " + entry.getValue() + " ");
                }
            }
        }
    }
}


