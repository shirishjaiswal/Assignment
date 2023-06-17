import java.util.HashMap;

import java.util.Map.Entry;

public class MakeLatte {

    HashMap<Ingredient,Integer> latteCoffee=new HashMap<>();
    CoffeeMachine coffeeMachine=new CoffeeMachine();

    public MakeLatte() {
        latteCoffee.put(Ingredient.Milk,75);
        latteCoffee.put(Ingredient.Water,350);
        latteCoffee.put(Ingredient.Beans,20);
    }

    public void createCoffee() {
        if(isIngredient()) {
            makeCoffee();
            System.out.println("Latte Dispatched ");
        } else {
            throw new RuntimeException("Ingredients for Latte is not sufficient");
        }
    }

    private boolean isIngredient() {
        for(Entry<Ingredient, Integer> mapEntry : latteCoffee.entrySet()) {
            if(coffeeMachine.getQuantity(mapEntry.getKey()) < mapEntry.getValue())
                return false;
        }
        return true;
    }
    private void makeCoffee() {
        for(Entry<Ingredient, Integer> mapEntry : latteCoffee.entrySet()) {
            coffeeMachine.reduceQuantity(mapEntry.getKey(), mapEntry.getValue());
        }
    }

}