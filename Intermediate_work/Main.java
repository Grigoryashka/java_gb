package Intermediate_work;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy(1, "toy1", 3);
        Toy toy2 = new Toy(2, "toy2", 7);
        Toy toy3 = new Toy(3, "toy3", 3);
        Toy toy4 = new Toy(4, "toy4", 3);
        Toy toy5 = new Toy(5, "toy5", 3);
        Toy toy6 = new Toy(6, "toy6", 3);
        Toys_List toy_list = new Toys_List();
        toy_list.add(toy1);
        toy_list.add(toy2);
        toy_list.add(toy3);
        toy_list.add(toy4);
        toy_list.add(toy5);
        toy_list.add(toy6);
        toy_list.make_id_list();
        toy_list.set_frequency();
        ArrayList<Toy> list = toy_list.choose_toy();
        list = toy_list.choose_toy();
        list = toy_list.choose_toy();
        for (int i = 0; i < list.size(); i += 0) { //тут мо;но вообще убрать цикл и вместо i поставть индекс игрушки, которую забрали
            Toy toy = list.get(i);
            System.out.println(list.size());
            System.out.println(i);
            System.out.println(toy);
            toy_list.get_toy(toy);
        }
        
        toy_list.set_frequency();
        //System.out.println(toy_list);
        toy_list.print();
    }
    
}
