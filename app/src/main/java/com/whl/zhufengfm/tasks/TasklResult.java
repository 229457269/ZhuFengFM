package com.whl.zhufengfm.tasks;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 16:33
 */

/**
 * 异步任务回调接口定义的数据，其中包含的action用于代表处理请求的task
 * 让回调接口处理类  能够检测到这个数据从哪里来。
 */
public class TasklResult {

    /**
     * 异步任务唯一标识，每一个异步任务标识都不同。
     */
    public int action;

    /**
     * 服务器返回的结果   ret值  0代表成功。
     */
    public int resultCode = -1;//默认失败


    /**
     * 任意数据类型，只要接口实现类支持即可。任务的结果
     */
    public Object data;

}
