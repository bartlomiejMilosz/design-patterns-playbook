package io.github.bartlomiejmilosz.abstractfactory.app;

import io.github.bartlomiejmilosz.abstractfactory.factories.FurnitureFactory;
import io.github.bartlomiejmilosz.abstractfactory.products.chair.Chair;
import io.github.bartlomiejmilosz.abstractfactory.products.coffeetable.CoffeeTable;
import io.github.bartlomiejmilosz.abstractfactory.products.sofa.Sofa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileFilter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicationTest {
    private Chair mockChair;
    private CoffeeTable mockCoffeeTable;
    private Sofa mockSofa;
    private FurnitureFactory mockFurnitureFactory;

    @BeforeEach
    void setup() {
        mockChair = mock(Chair.class);
        mockCoffeeTable = mock(CoffeeTable.class);
        mockSofa = mock(Sofa.class);
        mockFurnitureFactory = mock(FurnitureFactory.class);
    }

    @Test
    void should_Print_DescriptionOnce_ForEachProduct() {
        when(mockFurnitureFactory.createChair()).thenReturn(mockChair);
        when(mockFurnitureFactory.createCoffeeTable()).thenReturn(mockCoffeeTable);
        when(mockFurnitureFactory.createSofa()).thenReturn(mockSofa);

        Application app = new Application(mockFurnitureFactory);
        app.showDescriptions();

        verify(mockChair, times(1)).describe();
        verify(mockCoffeeTable, times(1)).describe();
        verify(mockSofa, times(1)).describe();
    }
}