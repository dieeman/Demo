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
 * webService ����
 * @author Administrator
 *
 */
public class Test {
    /**
     * ͨ��genClient.bat�ļ����ɵ�webservice�ͻ��˵���webservice����Ĳ������£�
     * 1.����service���� 
     * 2.����url���� 
     * 3.����call����
     * 4.����webservice�ķ���
*/
    public static void test1() {
        try {
            // 1.����service����ͨ��axis�Դ����ഴ��
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();
            // 2.����url����
            String wsdlUrl = "http://localhost:8180/hellowService/services/WebTestImpl?wsdl";//��������URL
            URL url = new URL(wsdlUrl);//ͨ��URL��Ĺ��췽������wsdlUrl��ַ����URL����
            // 2.�������񷽷��ĵ����߶���call������call���������
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);//��call�������������URL����
            String serviceName = "webtest1";
            call.setOperationName(serviceName);//��call�������õ��÷���������
            call.addParameter("sdfs", XMLType.XSD_STRING, ParameterMode.IN);// ��call�������÷����Ĳ��������������͡�����ģʽ
            //call.addParameter("a", XMLType.XSD_INT, ParameterMode.IN);// ��call�������÷����Ĳ��������������͡�����ģʽ
            call.setReturnType(XMLType.SOAP_STRING);// ���õ��÷����ķ���ֵ����
            //4.ͨ��invoke��������webservice
            String  groupNo = "fs";
            //int a = 10;
            String res = (String) call.invoke(new Object[] {groupNo});//���÷��񷽷�
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
            // 1.����service����ͨ��axis�Դ����ഴ��
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();
            // 2.����url����
            String wsdlUrl = "http://localhost:8180/hellowService/services/WebTestImpl?wsdl";//��������URL
            URL url = new URL(wsdlUrl);//ͨ��URL��Ĺ��췽������wsdlUrl��ַ����URL����
            // 2.�������񷽷��ĵ����߶���call������call���������
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);//��call�������������URL����
            String serviceName = "webtest2";
            call.setOperationName(serviceName);//��call�������õ��÷���������
            call.addParameter("sdfs", XMLType.XSD_STRING, ParameterMode.IN);// ��call�������÷����Ĳ��������������͡�����ģʽ
            call.addParameter("a", XMLType.XSD_INT, ParameterMode.IN);// ��call�������÷����Ĳ��������������͡�����ģʽ
            call.setReturnType(XMLType.SOAP_STRING);// ���õ��÷����ķ���ֵ����
            //4.ͨ��invoke��������webservice
            String  groupNo = "fs";
            int a = 10;
            String res = (String) call.invoke(new Object[] {groupNo,a});//���÷��񷽷�
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
     * jwx ��ʽ���� ����
     */
    public static void test3() {
        try {
            // 1.����service����ͨ��axis�Դ����ഴ��
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();
            // 2.����url����
            String wsdlUrl = "http://192.168.1.56:8180/webtest?wsdl";//��������URL
            URL url = new URL(wsdlUrl);//ͨ��URL��Ĺ��췽������wsdlUrl��ַ����URL����
            // 2.�������񷽷��ĵ����߶���call������call���������
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);//��call�������������URL����
            String serviceName = "webtest3";
            //ֻͨ�������url���޷����ʵ�ָ�������ġ���Ҫ����wsdl�еķ����������ռ䣨namespace��
            call.setOperationName(new QName("http://impl.service.dieeman.com/",serviceName));//��call�������õ��÷���������
            //call.addParameter("sdfs", XMLType.XSD_STRING, ParameterMode.IN);// ��call�������÷����Ĳ��������������͡�����ģʽ
            //call.addParameter("a", XMLType.XSD_INT, ParameterMode.IN);// ��call�������÷����Ĳ��������������͡�����ģʽ
            //call.setReturnType(XMLType.SOAP_STRING);// ���õ��÷����ķ���ֵ����
            //4.ͨ��invoke��������webservice
            //String  groupNo = "fs";
            ///int a = 10;
            //String res = (String) 
            call.invoke(new Object[] {});//���÷��񷽷�
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
