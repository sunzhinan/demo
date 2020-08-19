package com.example.demo.basis.design.responsibility.advanced;

/**
 * 接口，定义一个方法
 */
public interface Role {
    /**
     * 方法说明
     * @param request 处理的请求
     * @param response  处理的结果
     * @param chainRole 这个参数很重要，它是责任链执行的发起者，在整个流程中，他控制流程
     * @return
     */
    public boolean approve(Request request,Response response,ChainRole chainRole);
}
