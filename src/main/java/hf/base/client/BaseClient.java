package hf.base.client;

import hf.base.model.RemoteParams;
import org.springframework.web.client.RestTemplate;

public class BaseClient {
    private static final String APPLICATION_URL_ENCODED = "application/x-www-form-urlencoded";
    private RestTemplate restTemplate = new RestTemplate();

    protected <T> T get(RemoteParams params, Class<T> dataType) {
        return restTemplate.getForObject(params.getUrl()+params.getPath(),dataType,null == params.getParams()?params.getParamObj():params.getParams());
    }

    protected String get(RemoteParams params) {
        return restTemplate.getForObject(params.getUrl()+params.getPath(),String.class,null == params.getParams()?params.getParamObj():params.getParams());
    }

    protected String post(RemoteParams params) {
        return restTemplate.postForObject(params.getUrl()+params.getPath(),null == params.getParams()?params.getParamObj():params.getParams(),String.class);
    }
}
