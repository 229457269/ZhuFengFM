package com.whl.zhufengfm.tasks;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 16:30
 */

import android.os.AsyncTask;
import com.whl.zhufengfm.Constants;
import com.whl.zhufengfm.client.ClientApi;
import com.whl.zhufengfm.utils.EntityParseUtil;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 发现部分   分类的数据加载异步任务。
 */
public class DiscoverCategoryTAsk extends AsyncTask<String,Void,TasklResult>{

    private TaskCallback callback;

    public DiscoverCategoryTAsk(TaskCallback callback) {
        this.callback = callback;
    }

    @Override
    protected TasklResult doInBackground(String... params) {
        TasklResult ret = new TasklResult();

        //标识唯一：
        ret.action = Constants.TASK_ACTION_DISCOVER_CATEGRORY;//代表发现当中的分类接口：

        JSONObject jsonObject = ClientApi.getDiscoverCategories();

        if (jsonObject != null) {
            try {
                //代表数据  服务器返回结果
                ret.resultCode = jsonObject.getInt("ret");

                //代表获取的结果
                ret.data =
                        EntityParseUtil.parseDiscoveryCategory(jsonObject);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return ret;
    }

    @Override
    protected void onPostExecute(TasklResult result) {
        if (callback != null) {
            callback.onTaskFinished(taskResult);
        }
    }
}
