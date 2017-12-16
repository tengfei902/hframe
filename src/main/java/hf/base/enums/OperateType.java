package hf.base.enums;

public enum OperateType {
    IN(0),OUT(1);

    private int value;

    OperateType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
