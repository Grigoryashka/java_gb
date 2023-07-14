import java.io.*;
import java.util.*;

public class linked_lists {
    public static void main(String[] args) {
        //task1();
        LinkedList<Integer> list = new LinkedList<>();
        File file = new File("testa.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()){
                Integer element = scanner.nextInt();
                list.add(element);
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nСвязный список: " + list);

        MyQueue<Integer> queue = new MyQueue<>(list);
        
        System.out.println("\nПервый удаленный элемент: " + queue.dequeue());
        System.out.println("Первый не удаленный элемент: " + queue.first());
        System.out.println(queue.enqueue(1000));
        queue.print();

    }
    private static void task1(){
        LinkedList<String> list = new LinkedList<>();
        File file = new File("testa.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String element = scanner.next();
                list.add(element);
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n" + list);

        Collections.reverse(list);
        System.out.println("\n" + list);
    }
}

class MyQueue<E> {
    private LinkedList<E> elements = new LinkedList<>();

    public MyQueue(LinkedList<E> linkedList) {
        this.elements = linkedList;
    }
    public boolean enqueue(E e){
        elements.addLast(e);
        return true;
    }
    public E dequeue() {
        E obj = elements.getFirst();
        elements.removeFirst();
        return obj;
    }
    public E first() {
        E obj = elements.getFirst();
        return obj;
    }
    public void print(){
        System.out.print("\nПолученная очередь: ");
        for(E e:elements){
            System.out.print(e + " ");
        }
    }
}
