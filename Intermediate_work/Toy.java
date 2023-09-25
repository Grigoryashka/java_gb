package Intermediate_work;

public class Toy {
    private Integer id;
    private String name;
    private Integer count;
    private Float frequency;

    public Toy(Integer id, String name, Integer count){
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public void set_frequency(Float freq){
        this.frequency = freq;
    }

    public String toy_toString(){
        String str_toy = "id: " + this.id + ", name: " + this.name + ", count: " + this.count + ", freq: " + this.frequency + "\n";
        return str_toy;
    }

    public boolean count_less(){
        if (this.count > 0){
            this.count--;
            return true;
        }
        return false;
    }

    public Integer get_id(){
        return this.id;
    }

    public Integer get_count(){
        return this.count;
    }

}
