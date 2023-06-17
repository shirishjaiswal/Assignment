import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Print {
    int coffeeCount=0;
    int money=0;
    CoffeeMachine coffeeMachine=new CoffeeMachine("Pratam");

    Prices prices=new Prices();
    Scanner scanner=new Scanner(System.in);
    String type="";

    public void display() {
        System.out.println("----Welcome to CoffeeMachine----");
        System.out.println(CoffeeType.Cappuccino +" "+"10$");
        System.out.println(CoffeeType.Latte+" "+"12$");
        System.out.println(CoffeeType.Espresso+" "+"15$");
        System.out.println("Analysis :");
        System.out.println("Please Eneter your Coffee: ");
        type=scanner.nextLine();
        createCoffee(type);
    }

    private void createCoffee(String type2) {
        if(type2.equals("Cappuccino")) {
            MakeCappuccino makeCappuccino=new MakeCappuccino();
            makeCappuccino.createCoffee();
            printbill(CoffeeType.Cappuccino);
        }
        else if(type2.equals("Latte")) {
            MakeLatte makeLatte=new MakeLatte();
            makeLatte.createCoffee();
            printbill(CoffeeType.Latte);
        }
        else if(type2.equals("Espresso")) {
            MakeEsprosso makeExprosso=new MakeEsprosso();
            makeExprosso.createCoffee();
            printbill(CoffeeType.Espresso);
        }
        else if(type2.equals("Analysis")) {
            analysis();
        }
        else {
            System.out.println("Please Enter Proper Details");
        }

    }

    public void printbill(CoffeeType coffeeType){
        System.out.println("Coffee Bill :" );
        System.out.println("Coffee :" +coffeeType);
        System.out.println("Bill :" +prices.getPricesHashMap(coffeeType));
        System.out.println("Thanks for visiting.");
        coffeeCount++;
        money=money+prices.getPricesHashMap(coffeeType);
        System.out.println("---------------------------");
        display();

    }

    public void analysis() {
        System.out.println("Coffee Sale : " +coffeeCount);
        System.out.println("Money Earned :" +money);
        System.out.println("Milk Remainning :" + coffeeMachine.getQuantity(Ingredient.Milk));
        System.out.println("Water Remainning :" + coffeeMachine.getQuantity(Ingredient.Water));
        System.out.println("Benas Remainning :" + coffeeMachine.getQuantity(Ingredient.Beans));
        display();
    }




}
