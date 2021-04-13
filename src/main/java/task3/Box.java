package task3;

import task3.fruit.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box <T> {

    private T fruit;
    private float weight;
    List<T> list = new ArrayList<>();

    public Box() {
    }

    public Box(T fruit, int amount, float weight) {
        this.fruit = fruit;
        this.weight = weight;
        for (int i = 0; i < amount; i++) {
            list.add(fruit);
        }
    }

    public void addFruit(T fruit){
        list.add(fruit);
    }

    public void addFruits(T fruit, int amount){
        for (int i = 0; i < amount; i++) {
            list.add(fruit);
        }
    }

    public List<T> getList() {
        return list;
    }

    public float getWeight(){
        return list.size() * weight;
    }

    public boolean compare(Box<? extends Fruit> secondBox) {
        return Math.abs(getWeight() - secondBox.getWeight()) < 0.00001;
    }

    public void merge(Box<T> secondBox){

        if(this.equals(secondBox)) return;
        secondBox.getList().addAll(list);
        list.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return Float.compare(box.weight, weight) == 0 && Objects.equals(fruit, box.fruit) && Objects.equals(list, box.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit, weight, list);
    }
}
