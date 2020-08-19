package com.example.demo.basis.design.responsibility.advanced;

/**
 * @author: sunzhinan
 * @create: 2020-07-31 23:39
 * @description:
 */
public class GroupLeader implements Role{
    @Override
    public boolean approve(Request request, Response response, ChainRole chainRole) {
        //处理请求结果
        request.setRequestStr(request.getRequestStr() + "GroupLeader Request ; ");
        //调用chainRole的excute方法，根据方法内的index，逐层升入
        chainRole.excute(request,response);
        response.setResponseStr(response.getResponseStr() + "GroupLeader Response ; ");
        return true;
    }
}
