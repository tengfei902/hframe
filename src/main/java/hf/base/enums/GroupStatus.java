package hf.base.enums;

public enum GroupStatus {
    NEW(0,"注册完成"),
    SUBMITED(1,"资料补充完成并提交"),
    AVAILABLE(10,"可用"),
    CANCEL(99,"停用");

    private int value;
    private String desc;

    GroupStatus(int value,String desc) {
        this.value = value;
        this.desc = desc;
    }
}
