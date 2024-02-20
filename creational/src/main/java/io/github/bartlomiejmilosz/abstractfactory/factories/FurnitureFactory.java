package io.github.bartlomiejmilosz.abstractfactory.factories;

import io.github.bartlomiejmilosz.abstractfactory.products.chair.Chair;
import io.github.bartlomiejmilosz.abstractfactory.products.coffeetable.CoffeeTable;
import io.github.bartlomiejmilosz.abstractfactory.products.sofa.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    CoffeeTable createCoffeeTable();
    Sofa createSofa();
}
