package com.example.demo.basis.design.templatemethod;

/**
 * @author : sun
 * create at:  2020/4/28  22:10
 * @description: 模板方法——建筑房子
 *               这里我说下我对这个模式的理解：父类约束方法行为规范，子类细化每步方法的行为方式
 *               注意：父类的约束方法一定要是final，不可更改
 *               缺点：因为父类已经约束了行为规范，所有比较死板，不够灵活。
 *               优点：可扩展性强；便于维护
 */
public abstract class AbstractHouse {

    /**
     * 建造房子第一步；拿到设计图纸
     */
    public abstract void getDrawing();

    /**
     * 建筑房子第二步：打地基.开始建房子
     */
    public abstract void setGround();

    /**
     * 建房子第三步：装修
     */
    public abstract void decoration();

    /**
     * 建房子第四步：入住
     */
    public abstract void success();

    /**
     * 规定建造房子的流程
     */
    public final void buildHouse(){
        getDrawing();
        setGround();
        decoration();
        success();
    }
}
