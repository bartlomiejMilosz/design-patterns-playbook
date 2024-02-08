package io.github.bartlomiejmilosz.factorymethod.product;

public class ShipTransport implements Transport {

    @Override
    public void deliver() {
        System.out.println("Delivery by Ship");
    }
}
