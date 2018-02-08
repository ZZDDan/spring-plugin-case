package com.rxx.webservice.server;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by zhang on 2017/9/14.
 * @author zhangdan
 * @create 2017/9/14
 */
@WebService
public interface IEventMonitorService {
    /**
     * 1、获取处置项列表
     * @param type webpage:网页防篡改，dns :DNS反劫持
     * @param extendXml 扩展字段，可为空
     * @return
     */
    String queryItems(String type, String extendXml);

    /**
     * 2、执行带参数的处置项
     * @param itemId 处置项id
     * @param type webpage:网页防篡改，dns :DNS反劫持
     * @param params 参数JSON串
     * @param extendXml 扩展字段，可为空
     * @return
     */
    String handleItemByParams(String itemId, String type, String params, String extendXml);

    /**
     * 3、查询任务结果
     * @param taskId 任务id
     * @param extendXml 扩展字段，可为空
     * @return
     */
    String queryTaskResult(String taskId, String extendXml);



//    String handleItemByParams(String itemId, String[] params, String extendXml);

}
