package io.github.bartlomiejmilosz.abstractfactory.app;

import io.github.bartlomiejmilosz.abstractfactory.factories.FurnitureFactory;
import io.github.bartlomiejmilosz.abstractfactory.products.chair.Chair;
import io.github.bartlomiejmilosz.abstractfactory.products.coffeetable.CoffeeTable;
import io.github.bartlomiejmilosz.abstractfactory.products.sofa.Sofa;

public class Application {
    private Chair chair;
    private CoffeeTable coffeeTable;
    private Sofa sofa;
    private FurnitureFactory furnitureFactory;

    public Application(FurnitureFactory furnitureFactory) {
        this.chair = furnitureFactory.createChair();
        this.coffeeTable = furnitureFactory.createCoffeeTable();
        this.sofa = furnitureFactory.createSofa();
        this.furnitureFactory = furnitureFactory;
    }

    public void showDescriptions() {
        chair.describe();
        coffeeTable.describe();
        sofa.describe();
    }

    public FurnitureFactory getFurnitureFactory() {
        return furnitureFactory;
    }
}
