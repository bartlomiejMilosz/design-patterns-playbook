package io.github.bartlomiejmilosz.abstractfactory.products.coffeetable;

public class VictorianCoffeeTable implements CoffeeTable {
    @Override
    public void describe() {
        System.out.println("Victorian Coffee Table");
    }
}
