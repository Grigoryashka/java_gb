import java.util.Scanner;

public class exeptios {
    public static void main(String[] args) throws Exception{
        System.out.println(number());
    }
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
