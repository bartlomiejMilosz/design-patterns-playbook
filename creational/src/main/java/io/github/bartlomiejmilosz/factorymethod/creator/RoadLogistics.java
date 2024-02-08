package io.github.bartlomiejmilosz.factorymethod.creator;

import io.github.bartlomiejmilosz.factorymethod.product.Transport;
import io.github.bartlomiejmilosz.factorymethod.product.TruckTransport;

public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new TruckTransport();
    }
}
