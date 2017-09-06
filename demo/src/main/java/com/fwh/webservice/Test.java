package com.fwh.webservice;
import org.apache.axis.client.Call;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import org.apache.axis.encoding.XMLType;
/**
 * webService 测试
 * @author Administrator
 *
 */
public class Test {
    /**
     * 通过genClient.bat文件生成的webservice客户端调用webservice服务的步骤如下：
     * 1.创建service对象 
     * 2.创建url对象 
     * 3.创建call对象，
     * 4.调用webservice的方法
*/
    public static void test1() {
        try {
            // 1.创建service对象，通过axis自带的类创建
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();
            // 2.创建url对象
            String wsdlUrl = "http://localhost:8180/hellowService/services/WebTestImpl?wsdl";//请求服务的URL
            URL url = new URL(wsdlUrl);//通过URL类的构造方法传入wsdlUrl地址创建URL对象
            // 2.创建服务方法的调用者对象call，设置call对象的属性
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);//给call对象设置请求的URL属性
            String serviceName = "webtest1";
            call.setOperationName(serviceName);//给call对象设置调用方法名属性
            call.addParameter("sdfs", XMLType.XSD_STRING, ParameterMode.IN);// 给call对象设置方法的参数名、参数类型、参数模式
            //call.addParameter("a", XMLType.XSD_INT, ParameterMode.IN);// 给call对象设置方法的参数名、参数类型、参数模式
            call.setReturnType(XMLType.SOAP_STRING);// 设置调用方法的返回值类型
            //4.通过invoke方法调用webservice
            String  groupNo = "fs";
            //int a = 10;
            String res = (String) call.invoke(new Object[] {groupNo});//调用服务方法
            System.out.println(res);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public static void test2() {
        try {
            // 1.创建service对象，通过axis自带的类创建
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();
            // 2.创建url对象
            String wsdlUrl = "http://localhost:8180/hellowService/services/WebTestImpl?wsdl";//请求服务的URL
            URL url = new URL(wsdlUrl);//通过URL类的构造方法传入wsdlUrl地址创建URL对象
            // 2.创建服务方法的调用者对象call，设置call对象的属性
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);//给call对象设置请求的URL属性
            String serviceName = "webtest2";
            call.setOperationName(serviceName);//给call对象设置调用方法名属性
            call.addParameter("sdfs", XMLType.XSD_STRING, ParameterMode.IN);// 给call对象设置方法的参数名、参数类型、参数模式
            call.addParameter("a", XMLType.XSD_INT, ParameterMode.IN);// 给call对象设置方法的参数名、参数类型、参数模式
            call.setReturnType(XMLType.SOAP_STRING);// 设置调用方法的返回值类型
            //4.通过invoke方法调用webservice
            String  groupNo = "fs";
            int a = 10;
            String res = (String) call.invoke(new Object[] {groupNo,a});//调用服务方法
            System.out.println(res);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    /**
     * jwx 方式发布 调用
     */
    public static void test3() {
        try {
            // 1.创建service对象，通过axis自带的类创建
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();
            // 2.创建url对象
            String wsdlUrl = "http://192.168.1.56:8180/webtest?wsdl";//请求服务的URL
            URL url = new URL(wsdlUrl);//通过URL类的构造方法传入wsdlUrl地址创建URL对象
            // 2.创建服务方法的调用者对象call，设置call对象的属性
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);//给call对象设置请求的URL属性
            String serviceName = "webtest3";
            //只通过上面的url是无法访问到指定方法的。需要加上wsdl中的方法的命名空间（namespace）
            call.setOperationName(new QName("http://impl.service.dieeman.com/",serviceName));//给call对象设置调用方法名属性
            //call.addParameter("sdfs", XMLType.XSD_STRING, ParameterMode.IN);// 给call对象设置方法的参数名、参数类型、参数模式
            //call.addParameter("a", XMLType.XSD_INT, ParameterMode.IN);// 给call对象设置方法的参数名、参数类型、参数模式
            //call.setReturnType(XMLType.SOAP_STRING);// 设置调用方法的返回值类型
            //4.通过invoke方法调用webservice
            //String  groupNo = "fs";
            ///int a = 10;
            //String res = (String) 
            call.invoke(new Object[] {});//调用服务方法
            //System.out.println(res);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //test1();
       // test2();
        //test3();
    	String a ="100",b="100";
    	System.out.println(a==b);
    }

}
