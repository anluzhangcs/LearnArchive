package org.zhang.lifetime;

/**
 * @author: zhanghao
 * @date: 2021/11/23-20:04
 */

/**
 * @Description 用于测试IOC容器bean的生命周期
 */
public class Order {

    public Order() {
        System.out.println("第一步,创建bean的实例");
    }

    private String oName;

    public void setoName(String oName) {
        System.out.println("第二步,通过set方法注入属性值");
        this.oName = oName;
    }

    //初始化方法
    public void init() {
        System.out.println("第五步,调用bean标签中配置的init-method方法");
    }

    //IOC容器关闭时,销毁方法
    public void destory() {
        System.out.println("第七步,调用bean标签中配置的destory-method方法");
    }
}
