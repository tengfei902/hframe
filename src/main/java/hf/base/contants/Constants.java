package hf.base.contants;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String USER_LOGIN_INFO = "user_login_info";

    public static final String CURRENT_USER_ID = "current_user_id";

    public static final String SUCCESS = "0000000";

    public static final String USER_VARIFIED_FAILED = "9000001";

    public static final String PAGE_DATE_IS_GET = "pageDataIsGet";

    //1:普通商户;2:代理商;3:分公司;10:总部
    public static final int GROUP_TYPE = 3;

    public static final int GROUP_TYPE_COMPANY = 3;

    public static final int GROUP_TYPE_AGENT = 2;

    public static final int GROUP_TYPE_CUSTOMER = 1;

    public static final List<String> bankNames = Arrays.asList("北京银行","东亚银行","中国工商银行","中国光大银行","广发银行","华夏银行","中国建设银行","交通银行","中国民生银行","南京银行","宁波银行","中国农业银行","平安银行","上海银行","上海浦东发展银行","深圳发展银行","兴业银行","中国邮政储蓄银行","招商银行","浙商银行","中国银行","中信银行");
}
