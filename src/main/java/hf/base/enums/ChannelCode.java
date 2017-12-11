package hf.base.enums;

public enum ChannelCode {
    WX_OPEN("pay.weixin.jspay"),
    ALI("pay.alipay.jspay"),
    QQ("pay.tenpay.native"),
    WX("pay.weixin.raw.app");

    private String service;

    ChannelCode(String service) {
        this.service = service;
    }

    public String getService() {
        return this.service;
    }
}
