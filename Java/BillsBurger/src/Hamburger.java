import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by rsverrisson on 29-01-2018.
 */
public class Hamburger {
    private BreadType breadType;
    private MeatDoness meat;
    private HashSet<Additions> additions = new HashSet<>();
    protected int numberOfAdds = 4;
    protected int price;

    Hamburger(BreadType breadType, MeatDoness meat) {
        this.breadType = breadType;
        this. meat = meat;
        this.price = 25;
    }

    public void printBurger(){
        System.out.println("Bread: "+ this.breadType);
        System.out.println("Meat doness: "+ this.meat);
        System.out.println("Base price: " + this.price);
        System.out.println("Additions: ");
        for (Additions add : this.additions) {
            System.out.println(add + " price " + add.getPrice());
        }
        System.out.println("Total price: "+ this.burgerPrice());
    }

    public void addAdditions(Additions... adds) {
        if (numberOfAdds >= additions.size() + adds.length) {
            additions.addAll(Arrays.asList(adds));
        }
        else {
            throw new RuntimeException("Can't add all of this stuff to the burger!");
        }
    }

    public int burgerPrice() {
        int totalPrice = this.price;
        for (Additions add : this.additions) {
            totalPrice += add.getPrice();
        }
        return totalPrice;
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
       public int getPrice() {
           return this.price;
       }
   }
   public enum MeatDoness {
       NONE,
       RARE,
       MEDIUM,
       WELL_DONE;
   }
}

class HealthyBurger extends Hamburger{
   HealthyBurger(MeatDoness meat) {
       super(BreadType.BROWN_RYE, meat);
       this.numberOfAdds = 6;
   }
}

class DeluxeBurger extends Hamburger {
    DeluxeBurger(BreadType breadType, MeatDoness meatDoness) {
        super(breadType, meatDoness);
        numberOfAdds = 2;
        addAdditions(Additions.FRIES, Additions.SODA);
    }
}
