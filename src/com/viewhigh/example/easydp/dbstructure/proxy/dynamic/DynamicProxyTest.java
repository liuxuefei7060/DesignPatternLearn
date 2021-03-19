package com.viewhigh.example.easydp.dbstructure.proxy.dynamic;

import com.viewhigh.example.easydp.dbstructure.proxy.staticproxy.AdminService;
import com.viewhigh.example.easydp.dbstructure.proxy.staticproxy.AdminServiceImp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {

        AdminService adminService = new AdminServiceImp();
        ProxyHandler proxyHandler = new ProxyHandler();
        AdminService proxy = (AdminService) proxyHandler.newProxyInstance(adminService);


        proxy.update();

    }
}
