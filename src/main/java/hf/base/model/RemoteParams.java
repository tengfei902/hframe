package hf.base.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RemoteParams {
    private String path;
    private Map<String,Object> params;
    private Object paramObj;

    public String getPath() {
        return path;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public Object getParamObj() {
        return paramObj;
    }

    public RemoteParams withPath(String path) {
        this.path = path;
        return this;
    }

    public RemoteParams withParam(String param,Object value) {
        if(Objects.isNull(params)) {
            params = new HashMap<>();
        }
        params.put(param,value);
        return this;
    }

    public RemoteParams withObject(Object obj) {
        this.paramObj = obj;
        return this;
    }
}
