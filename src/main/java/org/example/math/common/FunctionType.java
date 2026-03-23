package org.example.math.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FunctionType {
    SIN("sin"),
    COS("cos"),
    TAN("tan"),
    COT("cot"),
    SEC("sec"),
    CSC("csc"),
    LN("ln"),
    LOG("log"),
    FACTORIAL("factorial"),
    SYSTEM("function system");

    @Getter
    private final String name;
}
