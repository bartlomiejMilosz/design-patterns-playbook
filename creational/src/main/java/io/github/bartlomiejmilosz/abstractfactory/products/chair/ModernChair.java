package io.github.bartlomiejmilosz.abstractfactory.products.chair;

public class ModernChair implements Chair {

    @Override
    public void describe() {
        System.out.println("Modern Chair");
    }
}
