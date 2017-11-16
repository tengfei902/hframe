package hf.base.dispatcher;

import hf.base.contants.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class DefaultDispatcher implements Dispatcher {

    @Override
    public DispatchResult dispatch(HttpServletRequest request) {
        String page = String.valueOf(request.getAttribute("page"));
        Object userInfo = request.getSession().getAttribute(Constants.USER_LOGIN_INFO);
        DispatchResult result = new DispatchResult();
        result.setPage(page);
        result.setData((Map<String,Object>)userInfo);
        return result;
    }
}
