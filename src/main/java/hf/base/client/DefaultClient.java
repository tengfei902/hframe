package hf.base.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hf.base.exceptions.BizFailException;
import hf.base.model.RemoteParams;
import hf.base.model.UserBankCard;
import hf.base.model.UserGroup;
import hf.base.model.UserInfo;
import hf.base.utils.ResponseResult;

import java.util.List;
import java.util.Map;

public class DefaultClient extends BaseClient {

    private String url;

    public DefaultClient(String url) {
        this.url = url;
    }

    private static final String GET_USER_INFO = "/user/get_user_info";
    private static final String CUSTOMER_REGISTER = "/user/customer_register";
    private static final String GET_USER_INFO_BY_ID = "/user/get_user_info_by_id";
    private static final String GET_USER_GROUP_BY_ID = "/user/get_user_group_by_id";
    private static final String GET_USER_BANK_CARD = "/user/get_user_bank_card";
    private static final String GET_USER_INFO_BY_GROUP_ID = "/user/get_user_list_by_groupId";

    public UserInfo getUserInfo(String loginId, String password, int userType) {
        RemoteParams params = new RemoteParams(url).withPath(GET_USER_INFO).withParam("loginId",loginId).withParam("password",password).withParam("userType",userType);

        String result = super.post(params);
        ResponseResult<UserInfo> response = new Gson().fromJson(result,new TypeToken<ResponseResult<UserInfo>>(){}.getType());
        UserInfo userInfo = response.getData();
        if(userInfo == null || userInfo.getId() == null) {
            return null;
        }

        return userInfo;
    }

    public UserInfo getUserInfoById(Long id) {
        RemoteParams params = new RemoteParams(url).withPath(GET_USER_INFO_BY_ID).withParam("id",id);
        String result = super.post(params);

        ResponseResult<UserInfo> response = new Gson().fromJson(result,new TypeToken<ResponseResult<UserInfo>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }

        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public String register(Map<String,Object> request) {
        RemoteParams params = new RemoteParams(url).withPath(CUSTOMER_REGISTER).withParams(request);
        String result = super.post(params);
        ResponseResult<String> response = new Gson().fromJson(result,new TypeToken<ResponseResult<String>>(){}.getType());
        return response.getCode();
    }

    public UserGroup getUserGroupById(Long id) {
        RemoteParams params = new RemoteParams(url).withPath(GET_USER_GROUP_BY_ID).withParam("id",id);
        String result = super.post(params);
        ResponseResult<UserGroup> response = new Gson().fromJson(result,new TypeToken<ResponseResult<UserGroup>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public List<UserBankCard> getUserBankCard(Long groupId) {
        RemoteParams params = new RemoteParams(url).withPath(GET_USER_BANK_CARD).withParam("groupId",groupId);
        String result = super.post(params);
        ResponseResult<List<UserBankCard>> response = new Gson().fromJson(result,new TypeToken<ResponseResult<List<UserBankCard>>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public List<UserInfo> getUserInfoByGroupId(String groupId) {
        RemoteParams params = new RemoteParams(url).withPath(GET_USER_INFO_BY_GROUP_ID).withParam("groupId",groupId);
        String result = super.post(params);
        ResponseResult<List<UserInfo>> response = new Gson().fromJson(result,new TypeToken<ResponseResult<List<UserInfo>>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }
}
