import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rsverrisson on 29-01-2018.
 */
public class Hamburger {
    BreadType breadType;
    MeatDoness meat;
    Additions[] additions = {};
    int numberOfAdds = 4;
    int price;

    Hamburger(BreadType breadType, MeatDoness meat, int price) {
        this.breadType = breadType;
        this. meat = meat;
        this.price = price;
    }

    public void printBurger(){
        System.out.println("Bread: "+ this.breadType);
        System.out.println("Meat doness: "+ this.meat);
        System.out.println("Additions: "+ Arrays.toString(this.additions));
        System.out.println("Total price: "+ this.price);
    }

    public void addAdditions(Additions... adds) {
        System.out.println("OMG!!!");
        if (numberOfAdds >= additions.length + adds.length) {
            Additions[] allAdds = new Additions[adds.length + this.additions.length];
            Additions[][] arrs = {this.additions, adds};
            System.out.println("Okk");
            int counter  = 0;
            for (Additions[] arr : arrs){
                System.out.println(counter);
                for (Additions add : arr) {
                    System.out.println(add);
                    allAdds[counter++] = add;
                }
            }
            this.additions = allAdds;
        }
    }
   public enum BreadType {
       WHITE,
       BROWN_RYE,
       MAIZE;
   }
   public enum Additions {
       FRIES (5),
       SODA (10),
       TOMATO (2),
       CARROT (1),
       ONION (3),
       LETTUCE (4);

       private final int price;
       Additions(int price){
           this.price = price;
       }
   }
   public enum MeatDoness {
       NONE,
       RARE,
       MEDIUM,
       WELL_DONE;
   }
}
