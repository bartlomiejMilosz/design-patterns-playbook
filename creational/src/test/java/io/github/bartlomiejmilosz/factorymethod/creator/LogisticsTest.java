package io.github.bartlomiejmilosz.factorymethod.creator;

import io.github.bartlomiejmilosz.factorymethod.product.ShipTransport;
import io.github.bartlomiejmilosz.factorymethod.product.Transport;
import io.github.bartlomiejmilosz.factorymethod.product.TruckTransport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class LogisticsTest {
    private Transport mockTransport;

    static Stream<Object[]> logisticsProvider() {
        return Stream.of(
                new Object[]{new RoadLogistics(), TruckTransport.class},
                new Object[]{new SeaLogistics(), ShipTransport.class}
        );
    }

    @BeforeEach
    void setup() {
        this.mockTransport = mock(Transport.class);
    }

    @ParameterizedTest
    @MethodSource("logisticsProvider")
    void test_Logistics_CreatesCorrect_Transport(Logistics logistics, Class<? extends Transport> expectedTransportClass) {
        Transport actualTransport = logistics.createTransport();
        assertInstanceOf(expectedTransportClass, actualTransport);
    }

    @Test
    void should_Return_RoadLogisticDelivery_Once() {
        // Given
        Logistics spyRoadLogistics = spy(new RoadLogistics());
        when(spyRoadLogistics.createTransport()).thenReturn(mockTransport);

        // When
        spyRoadLogistics.planDelivery();

        // Then
        verify(mockTransport, times(1)).deliver();
    }

    @Test
    void should_Return_SeaLogisticsDelivery_Once() {
        // Given
        Logistics spySeaLogistics = spy(new SeaLogistics());
        when(spySeaLogistics.createTransport()).thenReturn(mockTransport);

        // When
        spySeaLogistics.planDelivery();

        // Then
        verify(mockTransport, times(1)).deliver();
    }
}