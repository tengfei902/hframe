package hf.base.dispatcher;

import java.util.Map;

public class DispatchResult {
    private String page;
    private Map<String,Object> data;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
