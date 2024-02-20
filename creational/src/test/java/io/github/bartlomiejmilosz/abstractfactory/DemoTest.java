package io.github.bartlomiejmilosz.abstractfactory;

import io.github.bartlomiejmilosz.abstractfactory.app.Application;
import io.github.bartlomiejmilosz.abstractfactory.app.Configurator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DemoTest {
    private Configurator mockConfigurator;
    private Application mockApplication;

    @BeforeEach
    void setUp() {
        // Mock the Configurator and Application
        mockConfigurator = mock(Configurator.class);
        mockApplication = mock(Application.class);
    }

    @Test
    void runApplication_ShouldInvokeConfigureApplicationAndShowDescriptions() {
        // Given
        boolean isModern = false; // You can test with both true and false
        Demo demo = new Demo(mockConfigurator);

        // When configuring the application, return the mock application
        when(mockConfigurator.configureApplication(isModern)).thenReturn(mockApplication);

        // Execute
        demo.runApplication(isModern);

        // Then
        // Verify that configureApplication was called with the correct parameter
        verify(mockConfigurator, times(1)).configureApplication(isModern);

        // Verify that showDescriptions was called on the returned Application
        verify(mockApplication, times(1)).showDescriptions();
    }
}