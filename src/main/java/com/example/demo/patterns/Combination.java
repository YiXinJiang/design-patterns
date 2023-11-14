package com.example.demo.patterns;

import java.util.ArrayList;

/**
 * @ClassName: Combination
 * @Description: 组合模式
 * @Author: jyx
 * @Date: 2023-11-02 09:40
 * @Version: 1.0
 **/
public class Combination {
    public static void main(String[] args) {
        // 创建一个根节点
        Composite root = new Composite();
        root.doSomething();
        // 创建一个树枝构件
        Composite branch = new Composite();
        // 创建一个叶子节点
        Leaf leaf = new Leaf();
        // 建立整体
        root.add(branch);
        branch.add(leaf);
    }

    //通过递归遍历树
    public static void display(Composite root) {
        for (CombinationComponent c : root.getChildren()) {
            if (c instanceof Leaf) { // 叶子节点
                c.doSomething();
            } else { // 树枝节点
                display((Composite) c);
            }
        }
    }
}

// 抽象构件
abstract class CombinationComponent {
    // 个体和整体都具有的共享
    public void doSomething() {
        // 编写业务逻辑
    }
}

// 树枝构件
class Composite extends CombinationComponent {
    // 构件容器
    private ArrayList<CombinationComponent> componentArrayList = new ArrayList<>();

    // 增加一个叶子构件或树枝构件
    public void add(CombinationComponent component) {
        this.componentArrayList.add(component);
    }

    // 删除一个叶子构件或树枝构件
    public void remove(CombinationComponent component) {
        this.componentArrayList.remove(component);
    }

    // 获得分支下的所有叶子构件和树枝构件
    public ArrayList<CombinationComponent> getChildren() {
        return this.componentArrayList;
    }
}

// 树叶构件
class Leaf extends CombinationComponent {
    @Override
    public void doSomething() {
        // 可以覆写父类方法
    }

}



