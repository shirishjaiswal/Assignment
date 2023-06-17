import java.util.HashMap;
import java.util.Map.Entry;

public class MakeCappuccino {
    HashMap<Ingredient,Integer> CappuccinoCoffee=new HashMap<>();
    CoffeeMachine coffeeMachine=new CoffeeMachine();

    public  MakeCappuccino() {
        CappuccinoCoffee.put(Ingredient.Milk,100);
        CappuccinoCoffee.put(Ingredient.Water,200);
        CappuccinoCoffee.put(Ingredient.Beans,12);
    }

    public void createCoffee() {
        if(isIngredient()) {
            makeCoffee();
            System.out.println("Cappuccino Dispatched");
        } else {
            throw new RuntimeException("Ingredients for Cappuccino is not sufficient");
        }
    }

    private boolean isIngredient() {
        for(Entry<Ingredient, Integer> mapEntry : CappuccinoCoffee.entrySet()) {
            if(coffeeMachine.getQuantity(mapEntry.getKey()) < mapEntry.getValue())
                return false;
        }
        return true;
    }
    private void makeCoffee() {
        for(Entry<Ingredient, Integer> mapEntry : CappuccinoCoffee.entrySet()) {
            coffeeMachine.reduceQuantity(mapEntry.getKey(), mapEntry.getValue());
        }
    }
}