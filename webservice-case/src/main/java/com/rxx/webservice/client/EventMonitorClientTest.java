package com.rxx.webservice.client;

import com.alibaba.fastjson.JSONObject;
import com.rxx.utils.dom.AttackXmlResult;
import com.rxx.webservice.server.IEventMonitorService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

/**
 *
 * @author zd
 * @date 2017/9/18
 *
 * 基于 soap 的客户端调用
 */
public class EventMonitorClientTest {

    /**
     * 通过代理API调用，依赖于服务端的接口
     */
    @Test
    public void testClientByProxy(){
        // 调用WebService
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(IEventMonitorService.class);
        factory.setAddress("http://localhost:8081/somcweb/services/queryItems");
        IEventMonitorService service = (IEventMonitorService) factory.create();
        String items = service.queryItems("webpage", null);
        System.out.println(items);
    }

    /**
     * 不依赖服务端的接口
     * @throws Exception
     */
    @Test
    public void testClient() throws Exception{
        //不依赖服务器端接口来完成调用的，也就是不仅仅能调用Java的接口
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
//        Client client = clientFactory.createClient("http://localhost:8081/somcweb/services/handleItemByParams?wsdl");
        Client client = clientFactory.createClient("http://192.168.12.124/somcweb/services/handleService?wsdl");
        Object[] items = client.invoke("handleItemByParams", "12345", "webpage", "{\"executeType\":\"bak\"}", null);
        System.out.println(AttackXmlResult.parseDealResult(String.valueOf(items[0])));
    }

    /**
     * 使用 axis 打开的 webservice 连接，具体没有测通，需要再调试
     */
    @Test
    public void testClientByAxis(){
        // webservice地址
//        String endpoint = "http://localhost:8081/somcweb/services/handleItemByParams?wsdl";
        String endpoint = "http://192.168.12.124/somcweb/services/handleService?wsdl";
        String operationName = "handleItemByParams";

        // 直接引用远程的wsdl文件
        Service service = new Service();
        Call call;
        try {
            call = (Call)service.createCall();
            call.setTargetEndpointAddress(new URL(endpoint));
            // 你需要远程调用的方法
            call.setOperationName(new QName(operationName));
            call.removeAllParameters();
            // 创建连接
            JSONObject object = new JSONObject();
            object.put("domain", "");
            String result = (String) call.invoke(new String[]{"1", "dns", object.toJSONString(), ""});

            System.out.println("result is " + result);
            // 方法参数，如果没有参数请无视
//            call.addParameter("1001", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
//            call.addParameter("dns", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
//            call.addParameter("{}", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
//            call.addParameter("", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
        } catch (ServiceException | MalformedURLException | RemoteException e) {
            System.out.println("创建 Call 失败！");
            e.printStackTrace();
            return;
        }

    }
}
