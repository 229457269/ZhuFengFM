package com.whl.zhufengfm.tasks;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 17:21
 */
/**
 * 异步任务回调接口
 * @see  TasklResult
 */
public interface TaskCallback {

    /**
     * 当异步任务  执行完成的时候   会回调这个方法，将数据结果传递给相应的实现类
     * @param result
     */
    void onTaskFinished(TasklResult result);

}
