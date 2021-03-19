package com.viewhigh.example.easydp.dbstructure.proxy.staticproxy;

public class AdminServiceProxy implements AdminService {

    private AdminService service;

    public AdminServiceProxy() {
        this.service = new AdminServiceImp();
    }

    @Override
    public void update() {
        System.out.println("我是代理，我对update功能做了增强");
        System.out.println("---------日志记录-----------");
        System.out.println("---------检查更新条件-----------");
        System.out.println("---------检查更新条件完毕-----------");
        service.update();
    }
}
