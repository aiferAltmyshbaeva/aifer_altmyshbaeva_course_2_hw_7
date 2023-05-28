package com.example.calculator;

import java.util.function.Supplier;

class KeyPressedStrategy {
    Supplier<String> supplier;

    public KeyPressedStrategy(String value) {
        this.supplier = () -> value;
    }

    public KeyPressedStrategy(Supplier<String> supplier) {
        this.supplier = supplier;
    }

    public String getValue() {
        return supplier.get();
    }
}