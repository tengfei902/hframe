package hf.base.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hf.base.exceptions.BizFailException;
import hf.base.model.*;
import hf.base.utils.MapUtils;
import hf.base.utils.Pagenation;
import hf.base.utils.ResponseResult;

import java.math.BigDecimal;
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
    private static final String GET_USER_BANK_CARD_DETAIL = "/user/get_user_bank_card_detail";
    private static final String GET_SUB_USER_GROUP = "/user/get_sub_user_group";
    private static final String GET_CHANNEL_BY_ID = "/user/get_channel_by_id";
    private static final String GET_TRADE_REQUEST_LIST = "/user/get_trade_request_list";
    private static final String GET_ACCOUNT_LIST = "/user/get_account_list";
    private static final String GET_ADMIN_ACCOUNT_LIST = "/user/get_admin_account_list";
    private static final String GET_ACCOUNT_OPR_LOG_LIST = "/user/get_account_opr_log_list";
    private static final String GET_ACCOUNT_BY_GROUP_ID = "/user/get_account_by_group_id";
    private static final String GET_WITHDRAW_FEE_RATE = "/user/get_withdraw_fee_rate";

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

    public UserBankCard getUserBankCardDetail(String bankCardId) {
        RemoteParams params = new RemoteParams(url).withPath(GET_USER_BANK_CARD_DETAIL).withParam("id",bankCardId);
        String result = super.post(params);
        ResponseResult<UserBankCard> response = new Gson().fromJson(result,new TypeToken<ResponseResult<UserBankCard>>(){}.getType());
        return response.getData();
    }

    public List<Map<String,Object>> getSubGroups(String groupId) {
        RemoteParams params = new RemoteParams(url).withPath(GET_SUB_USER_GROUP).withParam("groupId",groupId);
        String result = super.post(params);
        ResponseResult<List<Map<String,Object>>> response = new Gson().fromJson(result,new TypeToken<ResponseResult<List<Map<String,Object>>>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public Channel getChannelById(String id) {
        RemoteParams remoteParams = new RemoteParams(url).withPath(GET_CHANNEL_BY_ID).withParam("id",id);
        String result = super.post(remoteParams);
        ResponseResult<Channel> response = new Gson().fromJson(result,new TypeToken<ResponseResult<Channel>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public Pagenation<TradeRequestDto> getTradeList(TradeRequest tradeRequest) {
        RemoteParams remoteParams = new RemoteParams(url).withPath(GET_TRADE_REQUEST_LIST).withParams(MapUtils.beanToMap(tradeRequest));
        String result = super.post(remoteParams);
        ResponseResult<Pagenation<TradeRequestDto>> response = new Gson().fromJson(result,new TypeToken<ResponseResult<Pagenation<TradeRequestDto>>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public Pagenation<AccountPageInfo> getAccountList(AccountRequest accountRequest) {
        RemoteParams remoteParams = new RemoteParams(url).withPath(GET_ACCOUNT_LIST).withParams(MapUtils.beanToMap(accountRequest));
        String result = super.post(remoteParams);
        ResponseResult<Pagenation<AccountPageInfo>> response = new Gson().fromJson(result,new TypeToken<ResponseResult<Pagenation<AccountPageInfo>>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public Pagenation<AdminAccountPageInfo> getAdminAccountList(AccountRequest accountRequest) {
        RemoteParams remoteParams = new RemoteParams(url).withPath(GET_ADMIN_ACCOUNT_LIST).withParams(MapUtils.beanToMap(accountRequest));
        String result = super.post(remoteParams);
        ResponseResult<Pagenation<AdminAccountPageInfo>> response = new Gson().fromJson(result,new TypeToken<ResponseResult<Pagenation<AdminAccountPageInfo>>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public Pagenation<AccountOprInfo> getAccountOprLogList(AccountOprRequest request) {
        RemoteParams remoteParams = new RemoteParams(url).withPath(GET_ACCOUNT_OPR_LOG_LIST).withParams(MapUtils.beanToMap(request));
        String result = super.post(remoteParams);
        ResponseResult<Pagenation<AccountOprInfo>> response = new Gson().fromJson(result,new TypeToken<ResponseResult<Pagenation<AccountOprInfo>>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public Account getAccountByGroupId(Long groupId) {
        RemoteParams remoteParams = new RemoteParams(url).withPath(GET_ACCOUNT_BY_GROUP_ID).withParam("groupId",groupId);
        String result = super.post(remoteParams);
        ResponseResult<Account> response = new Gson().fromJson(result,new TypeToken<ResponseResult<Account>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }

    public BigDecimal getWithDrawRate() {
        RemoteParams remoteParams = new RemoteParams(url).withPath(GET_WITHDRAW_FEE_RATE);
        String result = super.post(remoteParams);
        ResponseResult<BigDecimal> response = new Gson().fromJson(result,new TypeToken<ResponseResult<BigDecimal>>(){}.getType());
        if(response.isSuccess()) {
            return response.getData();
        }
        throw new BizFailException(response.getCode(),response.getMsg());
    }
}
