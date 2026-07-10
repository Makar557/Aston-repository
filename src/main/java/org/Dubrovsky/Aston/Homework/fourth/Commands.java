package org.Dubrovsky.Aston.Homework.fourth;

import java.util.Arrays;

public enum Commands {
    makeDL("makeDL"),
    makeLL("makeLL"),
    printOneAndTwo("printOneAndTwo");

    private final String value;

    Commands(String value) {
        this.value = value;
    }

    public static Commands getCommands(String value) {
        return Arrays.stream(Commands.values()).filter(command -> command.value.equals(value))
                .findFirst().orElseThrow(
                        () -> new IllegalArgumentException("Неизвестная команда")
                );
    }
}
