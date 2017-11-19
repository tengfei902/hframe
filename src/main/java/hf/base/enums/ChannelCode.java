package hf.base.enums;

public enum ChannelCode {
    WX_OPEN("pay.weixin.jsp ay"),
    ALI("pay.alipay.jspa y"),
    QQ("pay.tenpay.nat ive"),
    WX("pay.weixin.raw. app");

    private String service;

    ChannelCode(String service) {
        this.service = service;
    }

    public String getService() {
        return this.service;
    }
}
