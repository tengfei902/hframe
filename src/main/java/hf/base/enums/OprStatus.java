package hf.base.enums;

import java.util.Arrays;
import java.util.List;

public enum OprStatus {
    NEW(0),
    PAY_SUCCESS(1),
    PAY_FAILED(99),
    FINISHED(10),
    REFUND(98);

    private int value;

    OprStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OprStatus parse(int value) {
        for(OprStatus oprStatus:OprStatus.values()) {
            if(oprStatus.getValue()== value) {
                return oprStatus;
            }
        }
        return null;
    }
}
