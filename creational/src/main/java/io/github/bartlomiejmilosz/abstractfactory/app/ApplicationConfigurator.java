package io.github.bartlomiejmilosz.abstractfactory.app;

import io.github.bartlomiejmilosz.abstractfactory.factories.FurnitureFactory;
import io.github.bartlomiejmilosz.abstractfactory.factories.ModernFurnitureFactory;
import io.github.bartlomiejmilosz.abstractfactory.factories.VictorianFurnitureFactory;

public class ApplicationConfigurator implements Configurator {
    @Override
    public Application configureApplication(Boolean isModern) {
        Application application;
        FurnitureFactory furnitureFactory;

        if (isModern) {
            furnitureFactory = new ModernFurnitureFactory();
        } else {
            furnitureFactory = new VictorianFurnitureFactory();
        }

        application = new Application(furnitureFactory);
        return application;
    }
}
