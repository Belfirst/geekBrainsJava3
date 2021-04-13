import task3.Box;
import task3.fruit.Apple;
import task3.fruit.Orange;

public class Main {
    public static void main(String[] args) {

        Orange orange = new Orange();
        Apple apple = new Apple();
        Box<Orange> boxOrange = new Box<>(orange,10,1.5f);
        Box<Apple> boxApple = new Box<>(apple, 10,1.0f);
        Box<Apple> box2Apple = new Box<>(apple, 5,1.0f);

        box2Apple.addFruits(apple,5);

        System.out.println(boxApple.compare(boxOrange));
        boxApple.merge(box2Apple);

    }
}



