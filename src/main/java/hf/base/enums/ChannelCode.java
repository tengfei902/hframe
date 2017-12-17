package hf.base.enums;

public enum ChannelCode {
    WX_OPEN("pay.weixin.jspay"),
    ALI("pay.alipay.jspay"),
    QQ("pay.tenpay.native"),
    WX("pay.weixin.raw.app"),
    FXT_WX_OPEN_ID("01"),
    FXT_WX("02"),
    FXT_WX_FS("03"),
    FXT_WX_H5("04"),
    FXT_WX_APP("05"),
    FXT_ALI("06"),
    FXT_ALI_ZS("07"),
    FXT_ALI_FS("08");

    private String service;

    ChannelCode(String service) {
        this.service = service;
    }

    public String getService() {
        return this.service;
    }
}
