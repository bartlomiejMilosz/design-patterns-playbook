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

    /**
     * Explains the testing process using mock and spy objects.
     * <ul>
     *     <li><b>Creating a Mock of Transport:</b> By using {@code mock(Transport.class)}, you create a mocked {@code Transport} object. This means none of its methods will have a real implementation until explicit behaviors for those methods are mocked. If the {@code deliver()} method's behavior is not configured in the test, calling it on the mock will not perform any operation nor cause an error or exception.</li>
     *     <li><b>Creating a Spy on RoadLogistics:</b> By using {@code spy(new RoadLogistics())}, you create a "spy" on an actual instance of {@code RoadLogistics}. This allows calling its real methods but also overriding some (like {@code createTransport()}) for testing purposes. The spy retains the real behavior of {@code RoadLogistics}, except where intervention is decided.</li>
     *     <li><b>Configuring the Spy to Return the Mock:</b> Through {@code when(spyRoadLogistics.createTransport()).thenReturn(mockTransport);}, the spy is configured so that the {@code createTransport()} method returns the previously created mock {@code Transport} instead of creating a new instance of {@code TruckTransport}. This isolates the tested logic from the specific implementation of {@code Transport}.</li>
     *     <li><b>Calling planDelivery:</b> By calling {@code planDelivery()} on the {@code spyRoadLogistics} spy, the delivery logic is triggered. It attempts to use the {@code Transport} object returned by {@code createTransport()} - in this case, the mocked {@code Transport} object.</li>
     *     <li><b>Verifying the Call to deliver():</b> Finally, through {@code verify(mockTransport, times(1)).deliver();}, it's verified whether the {@code deliver()} method was called exactly once on the mock {@code Transport}. This confirms that the logic within {@code planDelivery()} attempts to deliver the goods using the {@code Transport} object.</li>
     * </ul>
     * This approach allows for isolating and testing individual parts of the system in a controlled manner, without relying on external dependencies or specific implementations.
     */
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

    @ParameterizedTest
    @MethodSource("logisticsProvider")
    void test_Logistics_CreatesCorrect_Transport(Logistics logistics, Class<? extends Transport> expectedTransportClass) {
        Transport actualTransport = logistics.createTransport();
        assertInstanceOf(expectedTransportClass, actualTransport);
    }
}