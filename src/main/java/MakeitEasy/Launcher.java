package MakeitEasy;

import com.natpryce.makeiteasy.Maker;

import static MakeitEasy.FruitMakers.leaves;
import static MakeitEasy.FruitMakers.size;
import static com.natpryce.makeiteasy.MakeItEasy.*;

public class Launcher {

    public static void main(String[] args) {
        Maker<Apple> appleMakerWithInitialState = an(new FruitMakers(), with(leaves, 2), with(size,10));
        Maker<Apple> appleMakerWithTwoLeaves = an(new FruitMakers()).but(with(leaves,2));

        make(appleMakerWithInitialState);
        make(a(new FruitMakers(),with(size, 100)));

    }
}
