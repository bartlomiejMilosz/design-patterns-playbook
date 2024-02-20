package io.github.bartlomiejmilosz.abstractfactory;

import io.github.bartlomiejmilosz.abstractfactory.app.Application;
import io.github.bartlomiejmilosz.abstractfactory.app.ApplicationConfigurator;
import io.github.bartlomiejmilosz.abstractfactory.app.Configurator;

public class Demo {
    private Configurator configurator;

    public Demo(Configurator configurator) {
        this.configurator = configurator;
    }

    public static void main(String[] args) {
        boolean isModern = false;
        Demo demo = new Demo(new ApplicationConfigurator());
        demo.runApplication(isModern);
    }

    public void runApplication(boolean isModern) {
        Application app = configurator.configureApplication(isModern);
        app.showDescriptions();
    }
}
