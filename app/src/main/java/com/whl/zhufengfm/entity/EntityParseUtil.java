package com.whl.zhufengfm.entity;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 17:06
 */

import com.whl.zhufengfm.Constants;
import com.whl.zhufengfm.entity.DiscoverCategroy;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 实体类的解析工具类：
 */
public final class EntityParseUtil {

    public EntityParseUtil() {
    }

    public static List<DiscoverCategroy> parseDiscoveryCategory(JSONObject json){

        List<DiscoverCategroy> ret  = null;

        if (json != null) {
            try {
                int code = json.getInt("ret");

                if (code == Constants.TASK_RESULT_OK) {
                    ret = new LinkedList<>();

                    JSONArray array = json.getJSONArray("list");
                    int len = array.length();
                    if (len > 0) {
                        for (int i = 0; i < len; i++) {

                            JSONObject jsonObject = array.getJSONObject(i);

                            DiscoverCategroy category = new DiscoverCategroy();

                            category.parseJSON(jsonObject);

                            ret.add(category);
                        }
                    }
                }else{

                }
            } catch (Exception e) {

            }

        }
        return ret;
    }

}
