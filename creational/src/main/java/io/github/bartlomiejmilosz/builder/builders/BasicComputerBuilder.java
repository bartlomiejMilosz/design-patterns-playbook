package io.github.bartlomiejmilosz.builder.builders;

import io.github.bartlomiejmilosz.builder.products.Computer;

public class BasicComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public BasicComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU(String cpu) {
        computer.setCPU(cpu);
    }

    @Override
    public void buildGPU(String gpu) {
        computer.setGPU(gpu);
    }

    @Override
    public void buildRAM(String ram) {
        computer.setRAM(ram);
    }

    @Override
    public void buildStorage(String storage) {
        computer.setStorage(storage);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
