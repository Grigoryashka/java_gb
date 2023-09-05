
import java.util.Scanner;

public class exeptios {
    public static void main(String[] args) throws Exception{
        //System.out.println(number());
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        }catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    
         
    }
    public static void printSum(Integer a, Integer b){
        System.out.println(a + b);
    }

    // TASKS 1 and 4
    public static Float number() throws Exception{
        Scanner in = new Scanner(System.in);
        Float num = null;
        String str = in.nextLine();
        if (str.equals("")){
            in.close();
            throw new Exception("String can not be empty!");
        }
        while(true){
            try {
                num = Float.parseFloat(str);
                in.close();
                break;
            }
            catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println(e);
                str = in.nextLine();
            }
        }
        return num;
    }
}
