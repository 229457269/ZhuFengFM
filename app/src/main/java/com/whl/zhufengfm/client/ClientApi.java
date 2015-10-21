package com.whl.zhufengfm.client;

import android.util.Log;

import com.whl.zhufengfm.utils.HttpTools;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 15:58
 */
public final class ClientApi {

    /**
     * 单独提取服务器地址的部分，避免以后更换服务器地址。
     */
    private static final String API_POINT = "http://mobile.ximalaya.com";

    private ClientApi() {
    }

    //-----------------------
    //接口 12 ：获取发现的分类，

    /**
     * 地址：
     * http://mobile.ximalaya.com/mobile/discovery/v1/categories?device=android&picVersion=10&scale=2
     *
     * @return JSONOBJECT
     */
    public static JSONObject getDiscoverCategories() {
        JSONObject ret = null;

        byte[] data = HttpTools.doGet(API_POINT + "/mobile/discovery/v1/categories?device=android&picVersion=10&scale=2");

        if (data != null) {
            try {

                String str = new String(data, "utf-8");

                Log.d("debug11","str="+str);


                ret = new JSONObject(str);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    //-----------------------
    /**
     * 接口11：用于  获取发现部分  推荐列表的内容
     * /mobile/discovery/v1/recommends?channel=and-f6&device=android&
     * includeActivity=true&includeSpecial=true&scale=2&version=4.1.7.1
     * @param channel  软件发布渠道
     * @param includeActivity   是否包含活动
     * @param includeSpecial   是否包含活动清单
     * @return
     */
    public static JSONObject getDiscoverRecommed(
            String channel, boolean includeActivity, boolean includeSpecial) {

        JSONObject ret = null;

        if(channel == null){
            channel = "and-f6";
        }

        String url = API_POINT +
                "/mobile/discovery/v1/recommends"+
                "?channel="+channel
                +"&device=android"
                +"&includeActivity=" +includeActivity
                +"&includeSpecial=" + includeSpecial
                +"&scale=2"
                +"&version=4.1.7.1";

        byte[] data = HttpTools.doGet(url);
        if (data != null) {
            try {
                String str = new String(data,"UTF-8");

                ret = new JSONObject(str);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    //-----------------------
    //-----------------------
    //-----------------------
    //-----------------------


}