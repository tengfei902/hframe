package hf.base.client;

import hf.base.model.RemoteParams;
import hf.base.utils.Utils;
import org.springframework.web.client.RestTemplate;

public class BaseClient {
    private static final String APPLICATION_URL_ENCODED = "application/x-www-form-urlencoded";
    private RestTemplate restTemplate = new RestTemplate();

    protected <T> T get(RemoteParams params, Class<T> dataType) {
        return restTemplate.getForObject(getUrl(params),dataType,null == params.getParams()?params.getParamObj():params.getParams());
    }

    protected String get(RemoteParams params) {
        return restTemplate.getForObject(getUrl(params),String.class,null == params.getParams()?params.getParamObj():params.getParams());
    }

    protected String post(RemoteParams params) {
        return restTemplate.postForObject(getUrl(params),null == params.getParams()?params.getParamObj():params.getParams(),String.class);
    }

    private String getUrl(RemoteParams params) {
        String url = params.getUrl();
        if(!Utils.isEmpty(params.getPath())) {
            url = params.getUrl()+params.getPath();
        }
        return url;
    }
}
