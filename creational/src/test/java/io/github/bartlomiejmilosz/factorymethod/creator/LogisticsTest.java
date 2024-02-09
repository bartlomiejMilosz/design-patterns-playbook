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
     * 1. **Creating a Mock of Transport:** By using `mock(Transport.class)`, you create a mocked `Transport` object, meaning none of its methods will have a real implementation until explicit behaviors for those methods are defined (mocked). In the case of the `deliver()` method, if you do not configure its behavior in the test, calling this method on the mock will not perform any operation (nor will it cause an error or exception).
     *
     * 2. **Creating a Spy on RoadLogistics:** By using `spy(new RoadLogistics())`, you create a "spy" on an actual instance of `RoadLogistics`. This means you can call its real methods, but you also have the option to override some of them (like `createTransport()`) for testing purposes. In this case, `spy` allows you to retain the real behavior of `RoadLogistics`, except where you decide to intervene.
     *
     * 3. **Configuring the Spy to Return the Mock:** Through `when(spyRoadLogistics.createTransport()).thenReturn(mockTransport);`, you configure the spy so that the `createTransport()` method returns the previously created mock `Transport`, instead of creating a new instance of `TruckTransport`. This separates the logic being tested (`planDelivery()`) from the specific implementation of `Transport`, allowing for testing in isolation.
     *
     * 4. **Calling planDelivery:** Next, by calling `planDelivery()` on the `spyRoadLogistics` spy, you trigger the delivery logic, which underneath tries to use the `Transport` object returned by `createTransport()` - in this case, it's the mocked `Transport` object.
     *
     * 5. **Verifying the Call to deliver():** Finally, through `verify(mockTransport, times(1)).deliver();`, you check whether the `deliver()` method was called exactly once on the mock `Transport`. This confirms that the logic contained in `planDelivery()` indeed attempts to deliver the goods using the `Transport` object.
     *
     * This is an elegant approach to testing as it allows for isolating and testing individual parts of the system in a controlled manner, without the need to rely on external dependencies or specific implementations.
     * */
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