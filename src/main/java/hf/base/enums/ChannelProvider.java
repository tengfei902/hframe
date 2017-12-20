package hf.base.enums;

public enum  ChannelProvider {
    YS("ys","友收宝"),
    FXT("fxt","富信通");

    private String code;
    private String name;

    ChannelProvider(String code,String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
