package com.rxx.webservice.server;

import javax.jws.WebService;

/**
 * webservice 接口实现，所有接口展示页面：http://localhost:8081/somcweb/services/
 * @author zhang
 * @date 2017/9/14
 */
@WebService(endpointInterface= "com.rxx.webservice.server.IEventMonitorService")
public class EventMonitorServiceImpl implements IEventMonitorService {

    @Override
    public String queryItems(String type, String extendXml) {
        if("webpage".equals(type)){
            return "<?xml version='1.0' encoding='UTF-8'?>" +
                    "<root>" +
                    " <error_info>" +
                    "  <error_code>1000</error_code>" +
                    "  <error_desc>错误描述错误描述</error_desc>" +
                    " </error_info>" +
                    " <data_info>" +
                    "  <page>" +
                    "   <item>" +
                    "    <item_id>12345</item_id>" +
                    "    <item_name>校讯通</item_name>" +
                    "    <item_url>www.xiaoxuntong.com</item_url>" +
                    "    <approval_user_name>张三,李四</approval_user_name>" +
                    "    <approval_user_phone>13800000000, 13800000000</approval_user_phone>" +
                    "    <equips>" +
                    "     <so_ip>192.168.1.1</so_ip>" +
                    "     <script_content_normal>" +
                    "      <![CDATA[脚本内容脚本内容]]>" +
                    "     </script_content_normal>" +
                    "     <script_content_recover>" +
                    "      <![CDATA[脚本内容脚本内容]]>" +
                    "     </script_content_recover>" +
                    "     <script_content_bak>" +
                    "      <![CDATA[脚本内容脚本内容]]>" +
                    "     </script_content_bak>" +
                    "    </equips>" +
                    "   </item>" +
                    "   <item>" +
                    "    <item_id>1234</item_id>" +
                    "    <item_name>校讯</item_name>" +
                    "    <item_url>www.xiaoxuntong.com</item_url>" +
                    "    <approval_user_name>张三,李四</approval_user_name>" +
                    "    <approval_user_phone>13800000000, 13800000000</approval_user_phone>" +
                    "    <equips>" +
                    "     <so_ip>192.168.1.1</so_ip>" +
                    "     <script_content_normal>" +
                    "      <![CDATA[脚本内容脚本内容]]>" +
                    "     </script_content_normal>" +
                    "     <script_content_recover>" +
                    "      <![CDATA[脚本内容脚本内容]]>" +
                    "     </script_content_recover>" +
                    "     <script_content_bak>" +
                    "      <![CDATA[脚本内容脚本内容]]>" +
                    "     </script_content_bak>" +
                    "    </equips>" +
                    "   </item>" +
                    "  </page>" +
                    " </data_info>" +
                    "</root>";
        }else if("dns".equals(type)){
            return "<?xml version='1.0' encoding='UTF-8'?>" +
                    "<root>" +
                    " <error_info>" +
                    "  <error_code>1000</error_code>" +
                    "  <error_desc>错误描述错误描述</error_desc>" +
                    " </error_info>" +
                    " " +
                    " <data_info>" +
                    "  <dns>" +
                    "   <item>" +
                    "    <item_id>2</item_id>" +
                    "    <item_name>DNS强制解析</item_name>" +
                    "    <approval_user_name>张三,李四</approval_user_name>" +
                    "    <approval_user_phone>13800000000, 13800000000</approval_user_phone>" +
                    "   </item>" +
                    "   <item>" +
                    "    <item_id>3</item_id>" +
                    "    <item_name>删除强制解析</item_name>" +
                    "    <approval_user_name>张三,李四</approval_user_name>" +
                    "   <approval_user_phone>13800000000, 13800000000</approval_user_phone>" +
                    "   </item>" +
                    "   <item>" +
                    "    <item_id>4</item_id>" +
                    "    <item_name>DNS缓存清理</item_name>" +
                    "    <approval_user_name>张三,李四</approval_user_name>" +
                    "    <approval_user_phone>13800000000, 13800000000</approval_user_phone>" +
                    "   </item>" +
                    "  </dns>" +
                    " </data_info>" +
                    "</root>";
        }
        return "";
    }

    @Override
    public String handleItemByParams(String itemId, String type, String params, String extendXml) {
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                "  <error_info>" +
                "    <error_code>1000</error_code>" +
                "    <error_desc>错误描述错误描述</error_desc>" +
                "  </error_info>" +
                "  <data_info>" +
                "    <task_id>12345</task_id>" +
                "  </data_info>" +
                "</root>";
    }

    @Override
    public String queryTaskResult(String taskId, String extendXml){
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                "  <error_info>" +
                "    <error_code>1000</error_code>" +
                "    <error_desc>错误描述错误描述</error_desc>" +
                "  </error_info>" +
                "  <data_info>" +
                "    <task_id>12345</task_id>" +
                "    <task_status>5</task_status>" +
                "    <task_create_time>2017-01-01 12:00:00</task_create_time>" +
                "    <task_approval_time>2017-01-01 12:02:00</task_approval_time>" +
                "    <result_status>2</result_status>" +
                "    <result_create_time>2017-01-01 12:02:00</result_create_time>" +
                "    <script_content>" +
                "      <![CDATA[脚本内容脚本内容]]>" +
                "    </script_content>" +
                "    <result_content>" +
                "      <![CDATA[执行结果内容]]>" +
                "    </result_content>" +
                "  </data_info>" +
                "</root>";
    }
}
