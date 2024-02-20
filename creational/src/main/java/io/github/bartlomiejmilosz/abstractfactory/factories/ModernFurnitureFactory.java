package io.github.bartlomiejmilosz.abstractfactory.factories;

import io.github.bartlomiejmilosz.abstractfactory.products.chair.Chair;
import io.github.bartlomiejmilosz.abstractfactory.products.chair.ModernChair;
import io.github.bartlomiejmilosz.abstractfactory.products.coffeetable.CoffeeTable;
import io.github.bartlomiejmilosz.abstractfactory.products.coffeetable.ModernCoffeeTable;
import io.github.bartlomiejmilosz.abstractfactory.products.sofa.ModernSofa;
import io.github.bartlomiejmilosz.abstractfactory.products.sofa.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
