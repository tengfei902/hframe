package hf.base.enums;

public enum TradeType {
    PAY(0,"付款"),
    REFUND(1,"退款"),
    CANCEL(2,"取消支付");

    private int value;
    private String desc;

    TradeType(int value,String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
