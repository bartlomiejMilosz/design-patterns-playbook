package io.github.bartlomiejmilosz.abstractfactory.factories;

import io.github.bartlomiejmilosz.abstractfactory.products.chair.Chair;
import io.github.bartlomiejmilosz.abstractfactory.products.chair.VictorianChair;
import io.github.bartlomiejmilosz.abstractfactory.products.coffeetable.CoffeeTable;
import io.github.bartlomiejmilosz.abstractfactory.products.coffeetable.VictorianCoffeeTable;
import io.github.bartlomiejmilosz.abstractfactory.products.sofa.Sofa;
import io.github.bartlomiejmilosz.abstractfactory.products.sofa.VictorianSofa;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
