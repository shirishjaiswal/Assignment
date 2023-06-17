import java.util.HashMap;


public class CoffeeMachine {

    static HashMap<Ingredient,Integer> totalIngredeint=new HashMap<>();
    public CoffeeMachine() {

    }
    public CoffeeMachine(String name) {
        totalIngredeint.put(Ingredient.Milk, 500);
        totalIngredeint.put(Ingredient.Water, 1000);
        totalIngredeint.put(Ingredient.Beans, 100);
    }
    public int getQuantity(Ingredient ingredientType) {
        return totalIngredeint.get(ingredientType);
    }

    public void reduceQuantity(Ingredient ingredientType, Integer quantity) {
        totalIngredeint.put(ingredientType, totalIngredeint.get(ingredientType) - quantity);
        // System.out.println(getQuantity(ingredientType));
    }



}
