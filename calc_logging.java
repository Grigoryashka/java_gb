import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class calc_logging {
    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(
                    calc_logging.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        
        calc();
    }
    private static void calc(){
        Deque<String> queue = new LinkedList<>();
        Double result = 0.0;

        System.out.println("\nПростой калькулятор");

        System.out.println("Введите число:");
        Double num1 = Double.parseDouble(System.console().readLine());
        Logging.write_log("First number is taken");
        Double num_bet = null;
        String operation = " ";

        while (! operation.equals("null")){
            

            System.out.println("Введите число:");
            Double num2 = Double.parseDouble(System.console().readLine());
            Logging.write_log("Second number is taken");

            System.out.println("Введите операцию(умножить, разделить, сложить, вычесть, остаток от деления, " +
            "отмена(отмена последней операции)). Введите 'null', если хотите прервать программу:");
            operation = System.console().readLine();
            Logging.write_log("Operation is taken");
            if (! operation.equals("отмена")) {
                queue.add(operation);
                Logging.write_log("Operation has been added to queue");
            }

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
                case("отмена"):
                if (queue.size() >= 1){
                result = num_bet;
                queue.removeLast();
                break;
                }
                else {
                    System.out.println("Вы должны совершить хотя бы одну операцию");
                    break;
                }
                default:
                break;
            }
            num_bet = num1;
            num1 = result;
            System.out.println("Результат: " + result);
            Logging.write_log("Result is given");
            System.out.println(queue);
        }
    }   

}

class Logging{
    private static Logger log = Logger.getLogger(Logging.class.getName());
    public static void write_log(String s){
        log.info(s);
    }
}
