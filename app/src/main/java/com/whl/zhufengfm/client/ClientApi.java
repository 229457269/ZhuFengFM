package com.whl.zhufengfm.client;

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

    private ClientApi(){}

    //-----------------------
    //接口 12 ：获取发现的分类，

    /**
     *  地址：
     * 	/mobile/discovery/v1/categories
     * 	        ?device=android&picVersion=10&scale=2
     * @return
     */
    public static JSONObject getDiscoverCategories(){
        JSONObject ret = null;

        byte[] data = HttpTools.doGet(API_POINT+"/mobile/discovery/v1/categories" +
                "?device=android&picVersion=10&scale=2");

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
    //-----------------------

}
