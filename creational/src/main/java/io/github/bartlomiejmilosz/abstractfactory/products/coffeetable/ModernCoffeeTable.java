package io.github.bartlomiejmilosz.abstractfactory.products.coffeetable;

public class ModernCoffeeTable implements CoffeeTable {
    @Override
    public void describe() {
        System.out.println("Modern Coffee Table");
    }
}
