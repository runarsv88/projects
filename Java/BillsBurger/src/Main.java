/**
 * Created by rsverrisson on 29-01-2018.
 */
public class Main {
    public static void main(String[] argv) {
        System.out.println("Let's make some burgeeeeeeeers!");
        Hamburger burger = new Hamburger(
                Hamburger.BreadType.BROWN_RYE,
                Hamburger.MeatDoness.MEDIUM,
                10
        );
        burger.addAdditions(Hamburger.Additions.CARROT, Hamburger.Additions.FRIES);
        burger.addAdditions(Hamburger.Additions.LETTUCE);
        burger.printBurger();
    }
}
