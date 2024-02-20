package io.github.bartlomiejmilosz.abstractfactory.app;

import io.github.bartlomiejmilosz.abstractfactory.factories.FurnitureFactory;
import io.github.bartlomiejmilosz.abstractfactory.factories.ModernFurnitureFactory;
import io.github.bartlomiejmilosz.abstractfactory.factories.VictorianFurnitureFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationConfiguratorTest {

    @Test
    void should_ReturnModern_WhenTrue() {
        boolean isModern = true;
        ApplicationConfigurator configurator = new ApplicationConfigurator();
        Application application = configurator.configureApplication(isModern);

        assertInstanceOf(ModernFurnitureFactory.class, application.getFurnitureFactory());
    }

    @Test
    void should_ReturnVictorian_WhenFalse() {
        boolean isModern = false;
        ApplicationConfigurator configurator = new ApplicationConfigurator();
        Application application = configurator.configureApplication(isModern);

        assertInstanceOf(VictorianFurnitureFactory.class, application.getFurnitureFactory());
    }
}