package io.github.bartlomiejmilosz.builder.director;

import io.github.bartlomiejmilosz.builder.builders.ComputerBuilder;
import io.github.bartlomiejmilosz.builder.products.Computer;

public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.builder = computerBuilder;
    }

    public void constructGamingComputer() {
        builder.buildCPU("High-End CPU");
        builder.buildGPU("High-End GPU");
        builder.buildRAM("16GB RAM");
        builder.buildStorage("1TB SSD");
    }

    public void constructBasicComputer() {
        builder.buildCPU("Standard CPU");
        builder.buildGPU("Standard GPU");
        builder.buildRAM("8GB RAM");
        builder.buildStorage("512GB HDD");
    }

    public Computer getComputer() {
        return builder.getComputer();
    }
}
