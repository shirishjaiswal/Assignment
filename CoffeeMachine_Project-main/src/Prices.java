import java.util.HashMap;

public class Prices {

    HashMap<CoffeeType, Integer> pricesHashMap=new HashMap<CoffeeType, Integer>();

    public Prices() {
        pricesHashMap.put(CoffeeType.Latte, 12);
        pricesHashMap.put(CoffeeType.Espresso, 15);
        pricesHashMap.put(CoffeeType.Cappuccino, 10);
    }

    public Integer getPricesHashMap(CoffeeType coffeeType) {
        return pricesHashMap.get(coffeeType);
    }

    public void setPricesHashMap(HashMap<CoffeeType, Integer> pricesHashMap) {
        this.pricesHashMap = pricesHashMap;
    }


}
