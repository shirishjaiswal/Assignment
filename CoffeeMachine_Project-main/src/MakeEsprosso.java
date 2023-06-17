import java.util.HashMap;
import java.util.Map.Entry;

public class MakeEsprosso {
    HashMap<Ingredient,Integer> EsprossoCoffee =new HashMap<>();
    CoffeeMachine coffeeMachine=new CoffeeMachine();

    public  MakeEsprosso() {
        EsprossoCoffee.put(Ingredient.Milk,0);
        EsprossoCoffee.put(Ingredient.Water,250);
        EsprossoCoffee.put(Ingredient.Beans,16);
    }

    public void createCoffee() {
        if(isIngredient()) {
            makeCoffee();
            System.out.println("Espresso Dispatched");
        } else {
            throw new RuntimeException("Ingredients for Espresso is not sufficient");
        }
    }

    private boolean isIngredient() {
        for(Entry<Ingredient, Integer> mapEntry : EsprossoCoffee.entrySet()) {
            if(coffeeMachine.getQuantity(mapEntry.getKey()) < mapEntry.getValue())
                return false;
        }
        return true;
    }
    private void makeCoffee() {
        for(Entry<Ingredient, Integer> mapEntry : EsprossoCoffee.entrySet()) {
            coffeeMachine.reduceQuantity(mapEntry.getKey(), mapEntry.getValue());
        }
    }
}