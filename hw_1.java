import java.util.Arrays;
import java.util.Scanner;


public class hw_1
{
    public static void main(String[] args) {
        //String input = System.console().readLine();
        //Scanner in = new Scanner(System.in);
        //in.close();
        task1();
        task2();
        task3();
        task4();
    }
    private static void task1(){
        //Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("Задача 1. Введите число:");
        Integer num = Integer.parseInt(System.console().readLine());
        Integer sum = 0, copy_n = num, prod = 1;
        while (copy_n>0) {
            sum += copy_n;
            prod *= copy_n;
            copy_n--;
        }
        System.out.printf("Сумма чисел с 1 по %d: %d, аналогичное произведение: %d", num, sum, prod);
        //in.close();
    }
    private static void task2(){
        //Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Задача 2. Простые числа от 1 до 1000:\n2, ");
        for (Integer i = 1; i < 998; i += 2) {
            Integer count = 0;
            for (Double j = 3.0; j < Math.sqrt(i); j += 2) {
                if (i % j == 0) count++;
            }
            if (count == 0) System.out.print(i + ", ");
        }
        //in.close();
    }
    private static void task3(){
        System.out.println("\n");
        System.out.println("Задача 3. Простой калькулятор. Введите первое число:");
        Double num1 = Double.parseDouble(System.console().readLine());
        System.out.println("Введите второе число:");
        Double num2 = Double.parseDouble(System.console().readLine());
        
        System.out.println("Введите операцию(умножить, разделить, сложить, вычесть, остаток от деления):");
        String operation = System.console().readLine();
        //System.out.println(operation);
        Double result = 0.0;
        switch(operation) {
            case("умножить"):
            result = num1 * num2;
            break;
            case("разделить"):
            result = num1 / num2;
            break;
            case("сложить"):
            result = num1 + num2;
            break;
            case("вычесть"):
            result = num1 - num2;
            break;
            case("остаток от деления"):
            result = num1 % num2;
            break;
            default:
            break;
        }
        System.out.println(result);
    }
    private static void task4(){
        //String exp = "?32 + ?1 = 493";
        
        //System.out.println(Arrays.deepToString(elements));
        System.out.println();
        System.out.println("Введите равенство типа q + w = e (q, w, e >= 0), содержащее в каждом слогаемом по одному знаку '?'.\n" +
        "Например: ?32 + ?1 = 493");
        String exp = System.console().readLine();
        String[] elements = exp.split(" ");
        Integer pow_i = -1, pow_j = -1;
        if(elements[0].contains("?") && elements[2].contains("?")){
            pow_i += elements[0].length() - elements[0].indexOf("?");
            pow_j += elements[2].length() - elements[2].indexOf("?");
            String el_0 = elements[0].replace("?", "0");
            String el_2 = elements[2].replace("?", "0");
            Integer e = Integer.valueOf(elements[4]);
            Integer count = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    Integer q = i * (int)Math.pow(10, pow_i) + Integer.valueOf(el_0);
                    Integer w = j * (int)Math.pow(10, pow_j) + Integer.valueOf(el_2);
                    if (q + w == e) {
                        System.out.println("Полученное равенство: " + q + " + " + w + " = " + e);
                        count += 1;
                    }
                }
            }
            if (count == 0) System.out.println("Равенство не существует");
        }

    }
}