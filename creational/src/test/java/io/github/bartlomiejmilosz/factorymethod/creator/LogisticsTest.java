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

    @Test
    void should_Return_RoadLogisticDelivery_Once() {
        Logistics spyRoadLogistics = spy(new RoadLogistics());
        when(spyRoadLogistics.createTransport()).thenReturn(mockTransport);

        spyRoadLogistics.planDelivery();

        verify(mockTransport, times(1)).deliver();
    }

    @Test
    void should_Return_SeaLogisticsDelivery_Once() {
        Logistics spySeaLogistics = spy(new SeaLogistics());
        when(spySeaLogistics.createTransport()).thenReturn(mockTransport);

        spySeaLogistics.planDelivery();

        verify(mockTransport, times(1)).deliver();
    }

    @ParameterizedTest
    @MethodSource("logisticsProvider")
    void test_Logistics_CreatesCorrect_Transport(Logistics logistics, Class<? extends Transport> expectedTransportClass) {
        Transport actualTransport = logistics.createTransport();
        assertInstanceOf(expectedTransportClass, actualTransport);
    }
}