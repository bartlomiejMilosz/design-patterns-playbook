package io.github.bartlomiejmilosz.factorymethod.product;

public class TruckTransport implements Transport {

    @Override
    public void deliver() {
        System.out.println("Delivery by Truck");
    }
}
