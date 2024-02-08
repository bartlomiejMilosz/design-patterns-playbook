package io.github.bartlomiejmilosz.factorymethod.creator;

import io.github.bartlomiejmilosz.factorymethod.product.ShipTransport;
import io.github.bartlomiejmilosz.factorymethod.product.Transport;

public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new ShipTransport();
    }
}
