import java.util.ArrayList;
import java.util.Collections;


public class lists {
    public static void main(String[] args) {
        ArrayList<Integer> nums_list = new ArrayList<Integer>();
        Integer min_limit = -50, max_limit = 51;
        Integer min, max, sum = 0;
        Double average;
        for (int i = 0; i < 50; i++) {
            nums_list.add((int) (Math.random() * (max_limit - min_limit) + min_limit));
        }
        //System.out.println(nums_list);
        for (int i = 0; i < nums_list.size(); i++) {
            if (nums_list.get(i) % 2 == 0){
                nums_list.remove(i);
                i--;
            }
            else
                sum += nums_list.get(i);
        }
        min = Collections.min(nums_list); max = Collections.max(nums_list);
        average = (double) sum / nums_list.size();
        System.out.println("Полученный список: " + nums_list +
        "\nМин. элемент: " + min + "\nМакс. элемент: " + max + "\nСреднее арифм.: " + average);
    }
}
