package hf.base.model;

import java.math.BigDecimal;

public class Channel {
    private Long id;

    private String channelCode;

    private String codeDescl

    private String channelName;

    private BigDecimal feeRate;

    private String url;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCodeDescl() {
        return codeDescl;
    }

    public void setCodeDescl(String codeDescl) {
        this.codeDescl = codeDescl;
    }
}