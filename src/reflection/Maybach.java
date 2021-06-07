package reflection;

/**
 * @author bertking
 * @Package reflection
 * @Description: AndroidBucket
 * @date 2021/6/7-11:54 下午
 * @problem
 * @level
 */
public class Maybach {

    private double price;

    private String owner;

    public static final String branch = "MAYBACH";

    private Maybach(double price) {
        this.price = price;
    }

    public Maybach(String owner) {
        this.owner = owner;
    }

    public Maybach() {
    }

    public void getState(){
        System.out.println("迈巴赫在那里停着等我...");
    }



    private void drive(String driver){
        System.out.println(driver+"开着Maybach");
    }
}
