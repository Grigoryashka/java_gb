
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class exeptios {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        LFM(in.nextLine());
        in.close();
    }

    public static String LFM(String str) throws AmountException{
        ArrayList<String> lfm = new ArrayList<>();
        String[] arr = str.split(" ");
        char gen = 0;
        String str_date = null;
        Long phone = null;

        for (String object : arr) {
            if (object.length() == 1 && (object.equals("m") || object.equals("f"))){
                gen = object.charAt(0);
                System.out.println(gen);
            }
            else{
                try {
                    phone = Long.parseLong(object);
                    System.out.println(phone);
                } catch (NumberFormatException e) {
                    // TODO: handle exception
                    try{
                    new SimpleDateFormat("dd.MM.yyyy").parse(object);
                    str_date = object;
                    System.out.println(str_date);
                    } catch(ParseException ex){
                        // TODO: handle exception
                        lfm.add(object);
                    }
                }
            }
            
        }
        if (arr.length != 6 || lfm.size() != 3 || gen == 0 || str_date == null || phone == null)
            throw new AmountException("The amount of values is incorrect", arr.length);
        else {
            String result;
            try {
                String person = lfm.get(0) + ".txt";
                Integer count = 0;
                Integer countLines = 0;
                File lastName = new File(person);
                lastName.createNewFile();
                FileWriter writer = new FileWriter(person, true);
                RandomAccessFile raf = new RandomAccessFile(person, "r");
                person = "<" + lfm.get(0) + "> <" + lfm.get(1) + "> <" + lfm.get(2) + "> <" + str_date + "> <" + phone + "> <" + gen + ">\n";                
                result = raf.readLine() + "\n";
                while(result != null){
                System.out.println(count + " " + countLines + (result + "\n").equals(person));
                    countLines += 1;
                    if((result + "\n").equals(person) || result.equals(person))
                        break;
                    else
                        count += 1;
                    result = raf.readLine();
                    System.out.println(result);
                }
                if(count == countLines) writer.write(person);

                raf.close();
                writer.close();
            } catch (IOException e) {
                // TODO: handle exception
                System.out.println(e);
            }
        }
        System.out.println(lfm);
        return " ";
    }
}
class AmountException extends Exception{
 
    private int number;
    public int getNumber(){return number;}
    public AmountException(String message, int num){
        super(message);
        number=num;
    }
}
