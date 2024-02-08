package io.github.bartlomiejmilosz.factorymethod;

import io.github.bartlomiejmilosz.factorymethod.creator.Logistics;
import io.github.bartlomiejmilosz.factorymethod.creator.RoadLogistics;
import io.github.bartlomiejmilosz.factorymethod.creator.SeaLogistics;

public class Client {
    private static Logistics logistics;

    public static void main(String[] args) {
        configure(args);
        runBusinessLogic();
    }

    private static void configure(String[] args) {
        if (isRoadLogistics(args)) {
            logistics = new RoadLogistics();
        } else {
            logistics = new SeaLogistics();
        }
    }

    private static void runBusinessLogic() {
        logistics.planDelivery();
    }


    // Default to SeaLogistics if no arguments provided or the first argument is not "road"
    private static boolean isRoadLogistics(String[] args) {
        return args.length > 0 && "road".equalsIgnoreCase(args[0]);
    }
}
