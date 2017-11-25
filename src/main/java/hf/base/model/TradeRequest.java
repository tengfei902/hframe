package hf.base.model;

import hf.base.annotations.Field;

import java.util.Date;

public class TradeRequest {
    @Field
    private String mchId;
    @Field
    private String outTradeNo;
    @Field
    private Long channelId;
    @Field
    private Integer status;
    @Field
    private Integer type;
    @Field(required = true)
    private Long groupId;
    @Field(type = Field.Type.number,defaults = "1")
    private Integer currentPage;
    @Field(type= Field.Type.number,defaults = "100")
    private Integer pageSize;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
