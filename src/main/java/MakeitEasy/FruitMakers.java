package MakeitEasy;

import com.natpryce.makeiteasy.*;

import static com.natpryce.makeiteasy.Property.newProperty;

public class FruitMakers {
    public static final Property<Fruit, Double> ripeness = newProperty();
    public static final Property<Apple, Integer> leaves = newProperty();
    public static final Property<Banana, Double> curve = newProperty();

    public static final Instantiator<Apple> Apple = new Instantiator<Apple>() {
        public Apple instantiate(PropertyLookup<Apple> lookup) {
            Apple apple = new Apple(lookup.valueOf(leaves,2));
            apple.ripen(lookup.valueOf(ripeness,0.0));
            return apple;
        }
    };
}