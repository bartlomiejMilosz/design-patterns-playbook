package io.github.bartlomiejmilosz.factorymethod.creator;

import io.github.bartlomiejmilosz.factorymethod.product.Transport;

public abstract class Logistics {
    /**
     * In the context of design patterns and software architecture, the abstract method createTransport() and the Transport interface that this method returns are key elements of the factory method pattern. In this context, Transport is a dependency of the Logistics class, since Logistics depends on the Transport abstraction to perform its functionality (planDelivery() calls the deliver() method on the Transport object). Thus, the object returned by createTransport() (which implements Transport) is a Logistics dependency, and the createTransport() method itself is the mechanism that allows the polymorphic delivery of this dependency.
     * */
    // Factory method
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
