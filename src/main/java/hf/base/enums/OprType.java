package hf.base.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tengfei on 2017/11/5.
 */
public enum OprType {
    PAY(0,"付款"),
    TAX(1,"税费"),
    REFUND(2,"退款"),
    REVERSE(3,"撤销交易"),
    WITHDRAW(4,"结算"),
    BONUS(5,"提成");

    private int value;
    private String desc;

    OprType(int value,String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static OprType parse(int value) {
        for(OprType oprType:OprType.values()) {
            if(oprType.value == value) {
                return oprType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getValue() {
        return this.value;
    }

    public static List<Integer> getAddList() {
        return Arrays.asList(PAY.value,BONUS.value);
    }
}
