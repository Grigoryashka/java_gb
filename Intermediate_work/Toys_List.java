package Intermediate_work;

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Toys_List {
    private HashMap<Integer, Toy> toy_list;
    private ArrayList<Toy> chosenToy_list;// список с выйгранными игрушками
    private ArrayList<Integer> id; //список для рандомайзера
    Random random = new SecureRandom();
    public Toys_List(){
        toy_list = new HashMap<>();
        chosenToy_list = new ArrayList<>();
        id = new ArrayList<>();
    }
    public void make_id_list(){
        for (Toy toy : toy_list.values()) {
            for (int i = 0; i < toy.get_count(); i++)
                id.add(toy.get_id());
        }
    }
    public Integer count_all(){
        Integer count = Integer.parseInt("0");
        for (Toy toy : toy_list.values()) {
            count += toy.get_count();
        }
        return count;
    }
    public void set_frequency(){
        for (Toy toy : toy_list.values()) {
            toy.set_frequency((float)toy.get_count()/this.count_all()*100);
        }
    }
    public boolean add(Toy toy){
        toy_list.put(toy.get_id(), toy);
        return true;
    }
    public ArrayList<Toy> choose_toy(){
        //Integer rand_id = random.nextInt(id.size());
        //System.out.println(rand_id);
        //System.out.println(id.get(rand_id));
        Integer random_id = id.get(random.nextInt(id.size()));
        chosenToy_list.add(toy_list.get(random_id));
        toy_list.get(random_id).count_less();
        id.remove(random_id);
        System.out.println(id);
        System.out.println(chosenToy_list);
        return chosenToy_list;
    }
    public void get_toy(Toy toy){
        try (FileWriter fw = new FileWriter("Intermediate_work/Got_toys.txt", true)){
            if (toy.get_count() > 0){
                fw.write(toy.toy_toString());
                chosenToy_list.remove(toy);
            }
            else {
                toy_list.remove(toy.get_id());
            }
            
        }
        catch (IOException e) {
            // TODO: handle exception
        }
    }
    public void print(){
        for (Toy toy : toy_list.values()) {
            System.out.println(toy.toy_toString());
        }
    }
}
