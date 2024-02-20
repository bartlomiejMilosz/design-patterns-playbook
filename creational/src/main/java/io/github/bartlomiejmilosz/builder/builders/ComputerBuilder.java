package io.github.bartlomiejmilosz.builder.builders;

import io.github.bartlomiejmilosz.builder.products.Computer;

public interface ComputerBuilder {
    void buildCPU(String CPU);
    void buildGPU(String GPU);
    void buildRAM(String RAM);
    void buildStorage(String storage);
    Computer getComputer();
}
