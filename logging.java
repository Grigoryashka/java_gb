import java.io.IOException;
import java.util.logging.*;
import java.util.Arrays;



public class logging {
    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(
                    logging.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        Integer numbers[] = new Integer[] {1, 9, 3, 6, 92, 8, 6};
        Integer g;
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[i+1]){
                g = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = g;
            }
            SomeClass.someMethod(i + " iteration: " + Arrays.deepToString(numbers));
            if (numbers.length - i == 2) break;
        }
        }
        
            
        
    }
}


class SomeClass {
	    
	    private static Logger log = Logger.getLogger(SomeClass.class.getName());
	    
	    public static void someMethod(String s)
	    { 
	        log.info(s);
	    }   
}