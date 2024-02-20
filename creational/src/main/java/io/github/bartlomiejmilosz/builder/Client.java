package io.github.bartlomiejmilosz.builder;

import io.github.bartlomiejmilosz.builder.builders.BasicComputerBuilder;
import io.github.bartlomiejmilosz.builder.builders.ComputerBuilder;
import io.github.bartlomiejmilosz.builder.builders.GamingComputerBuilder;
import io.github.bartlomiejmilosz.builder.director.ComputerDirector;
import io.github.bartlomiejmilosz.builder.products.Computer;

public class Client {
    public static void main(String[] args) {
        ComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        ComputerBuilder basicComputerBuilder = new BasicComputerBuilder();

        ComputerDirector director = new ComputerDirector(gamingComputerBuilder);

        director.constructGamingComputer();
        Computer gamingComputer = director.getComputer();
        System.out.println(gamingComputer.toString());

        director = new ComputerDirector(basicComputerBuilder);
        director.constructBasicComputer();
        Computer standardComputer = director.getComputer();
        System.out.println(standardComputer.toString());
    }
}
