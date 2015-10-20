package com.whl.zhufengfm.fragments.discover;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.whl.zhufengfm.Constants;
import com.whl.zhufengfm.R;
import com.whl.zhufengfm.entity.DiscoverCategroy;
import com.whl.zhufengfm.fragments.BaseFragment;
import com.whl.zhufengfm.tasks.DiscoverCategoryTAsk;
import com.whl.zhufengfm.tasks.TaskCallback;
import com.whl.zhufengfm.tasks.TasklResult;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 10:57
 */
public class DisCoverCategoryFragment extends BaseFragment implements TaskCallback{

    public DisCoverCategoryFragment() {
    }

    @Override
    public String getFragmentTitle() {
        return "分类";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        DiscoverCategoryTAsk task = new DiscoverCategoryTAsk(this);

        task.execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discover_category, container,false);
    }

    @Override
    public void onTaskFinished(TasklResult result) {

        if(result!=null){
            int action = result.action;
            if (action== Constants.TASK_ACTION_DISCOVER_CATEGRORY) {
                // TODO 结果从发现 - 分类 任务中返回的，获取的就是分类
                if(result.resultCode== Constants.TASK_RESULT_OK){
                    // TODO 加载成功
                    Log.d("info", "成功");
                }else {
                    // TODO 加载失败
                    Log.d("info","失败");
                }
            }else{
                Log.i("info","测试失败。。");
            }
        }
    }
}
