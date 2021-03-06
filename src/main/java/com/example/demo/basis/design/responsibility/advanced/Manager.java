package com.example.demo.basis.design.responsibility.advanced;

/**
 * @author: sunzhinan
 * @create: 2020-07-31 23:39
 * @description:
 */
public class Manager implements Role{
    @Override
    public boolean approve(Request request, Response response, ChainRole chainRole) {
        request.setRequestStr(request.getRequestStr() + "Manager Request ; ");
        chainRole.excute(request,response);
        response.setResponseStr(response.getResponseStr() + "Manager Response ; ");
        return true;
    }
}
