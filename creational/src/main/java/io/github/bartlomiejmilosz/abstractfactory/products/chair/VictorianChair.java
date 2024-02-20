package io.github.bartlomiejmilosz.abstractfactory.products.chair;

public class VictorianChair implements Chair {
    @Override
    public void describe() {
        System.out.println("Victorian Chair");
    }
}
