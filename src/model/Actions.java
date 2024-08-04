package model;

public enum Actions {
    LEFT(0),
    UP(1),
    RIGHT(2),
    DOWN(3);

    private final int value;

    Actions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
