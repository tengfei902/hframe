package hf.base.biz.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import hf.base.biz.CacheService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DefaultCacheService implements CacheService {
    private LoadingCache<String,String> userCache = CacheBuilder.newBuilder()
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .maximumSize(5000)
            .refreshAfterWrite(10,TimeUnit.MINUTES)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return null;
                }
            });

    @Override
    public boolean checkLogin(String userId, String sessionId) {
        try {
            String sessionIdTemp = userCache.get(userId);
            String userIdTemp = userCache.get(sessionId);

            if(StringUtils.equals(sessionIdTemp,sessionId) && StringUtils.equals(userIdTemp,String.valueOf(userId))) {
                userCache.put(userId,sessionId);
                userCache.put(sessionId,String.valueOf(userId));
                return true;
            }

            return false;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean login(String userId, String sessionId) {
        userCache.put(userId,sessionId);
        userCache.put(sessionId,userId);
        return true;
    }
}
