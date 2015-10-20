package com.whl.zhufengfm.tasks;

import android.os.AsyncTask;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 17:47
 */
public abstract class BaseTask extends AsyncTask<String,Void,TasklResult>{

    private TaskCallback taskCallback;

    public BaseTask(TaskCallback taskCallback) {
        this.taskCallback = taskCallback;
    }

    @Override
    protected void onPostExecute(TasklResult result) {
        if (taskCallback != null){
            taskCallback.onTaskFinished(result);
        }

    }
}
