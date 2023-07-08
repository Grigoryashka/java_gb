import java.io.IOException;
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
        System.out.println("\n");
        System.out.println("Задача 3. Простой калькулятор. Введите первое число:");
        Double num1 = Double.parseDouble(System.console().readLine());
        Logging.write_log("First number is taken");
        System.out.println("Введите второе число:");
        Double num2 = Double.parseDouble(System.console().readLine());
        Logging.write_log("Second number is taken");
        
        System.out.println("Введите операцию(умножить, разделить, сложить, вычесть, остаток от деления):");
        String operation = System.console().readLine();
        Logging.write_log("Operation is taken");
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
        Logging.write_log("Result is given");
    }
}

class Logging{
    private static Logger log = Logger.getLogger(Logging.class.getName());
    public static void write_log(String s){
        log.info(s);
    }
}
