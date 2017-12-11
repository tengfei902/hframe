package hf.base.utils;

import hf.base.exceptions.BizFailException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by tengfei on 2017/10/28.
 */
public class Utils {

    public static Map<String,Object> bean2Map(Object obj) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor:propertyDescriptors) {
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(obj, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, "");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnMap;
    }

    public static boolean checkSign(Object obj,String field) {
        Map<String,Object> map = bean2Map(obj);
        Map<String,Object> treeMap = new TreeMap<>((o1, o2) -> o1.compareTo(o2));

        for(String key:map.keySet()) {
            if(StringUtils.equals(key,field)) {
                continue;
            }

            if(StringUtils.isEmpty(String.valueOf(map.get(key)))) {
                continue;
            }

            treeMap.put(key,map.get(key));
        }

        StringBuilder sb = new StringBuilder("");
        for(String key:treeMap.keySet()) {
            sb.append("&").append(key).append("=").append(treeMap.get(key));
        }

        return StringUtils.equals(String.valueOf(map.get(field)),sb.toString());
    }

    public static <K,V> Map<K,V> buildMap(Object... objs) {
        Map<K,V> map = new HashMap<>();
        append(map,objs);
        return map;
    }

    public static <K,V> void append(Map<K,V> map,Object... objs) {

        int z = objs.length;
        for(int i = 0; i < z - 1; i += 2) {
            map.put((K)objs[i], (V)objs[i + 1]);
        }
    }

    public static String convertPassword(String str) {
        return DigestUtils.md5Hex(str);
    }

    public static String getUrlParam(Object obj,Class dataType) {
        try {
            Field[] fields = Object.class.getFields();
            List<String> objFieldList = new ArrayList<>();
            for(Field field:fields) {
                objFieldList.add(field.getName());
            }

            BeanInfo beanInfo = Introspector.getBeanInfo(dataType);
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            StringBuilder params = new StringBuilder("");

            for(PropertyDescriptor descriptor : descriptors) {
                if(objFieldList.contains(descriptor.getDisplayName())) {
                    continue;
                }
                Object o = descriptor.getReadMethod().invoke(obj);
                if(Objects.isNull(o)) {
                    continue;
                }
                params.append(String.format("%s=%s&",descriptor.getDisplayName(),String.valueOf(o)));
            }

            return params.substring(0,params.length()-1);
        } catch (Exception e) {
            throw new BizFailException(e.getMessage());
        }

    }
}
