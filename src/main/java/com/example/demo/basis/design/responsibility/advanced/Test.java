package com.example.demo.basis.design.responsibility.advanced;

/**
 * @author: sunzhinan
 * @create: 2020-07-31 23:43
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        Request request = new Request();
        request.setRequestStr("请求来了 : ");
        Response response = new Response();
        response.setResponseStr("返回来了 : ");

        ChainRole chainRole = new ChainRole();
        chainRole.add(new GroupLeader());
        chainRole.add(new Manager());
        chainRole.add(new Finance());

        chainRole.excute(request,response);

        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
