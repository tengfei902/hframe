package hf.base.enums;

public enum PayRequestStatus {
    NEW(0,"未处理"),
    OPR_GENERATED(1,"处理中"),
    REMOTE_CALL_FINISHED(2,"成功,未返回"),
    PROCESSING(5,"银行已受理"),
    OPR_SUCCESS(10,"交易成功"),
    PAY_FAILED(98,"交易失败"),
    OPR_FINISHED(99,"交易失败");

    private int value;
    private String desc;

    PayRequestStatus(int value,String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static PayRequestStatus parse(int value) {
        for(PayRequestStatus status:PayRequestStatus.values()) {
            if(status.getValue() == value) {
                return status;
            }
        }
        return null;
    }
}
