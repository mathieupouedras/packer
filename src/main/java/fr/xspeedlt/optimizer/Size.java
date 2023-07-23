package fr.xspeedlt.optimizer;

import static java.util.Arrays.stream;

public enum Size {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private final int value;


    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Size of(int value) {
       return stream(Size.values())
               .filter(size -> size.getValue() == value)
               .findFirst()
               .orElseThrow();
    }
}
