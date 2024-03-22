package com.jyx.test.patterns;

/**
 * @ClassName: Decoration
 * @Description: 装饰模式
 * @Author: jyx
 * @Date: 2023-11-02 09:10
 * @Version: 1.0
 **/
public class Decoration {
    public static void main(String[] args) {
        // 要修饰的对象com
        Component com = new ConcreteComponent();
        // 进行第一次修饰
        com = new ConcreteDecorator1(com);
        // 进行第2次修饰
        com = new ConcreteDecorator2(com);
        com.operate();
        //com=new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
    }
}

// 抽象构件
abstract class Component {
    // 抽象方法
    public abstract void operate();
}

// 具体构件
class ConcreteComponent extends Component {
    // 具体实现
    public void operate() {
        System.out.println("这里是具体构件的操作方法执行了");
    }
}

// 抽象装饰者，一般为一个抽象类
abstract class Decorator extends Component {
    // 必须有一个private变量指向Component抽象构件
    private Component component;

    // 通过构造函数传递被修饰者
    public Decorator(Component component) {
        System.out.println("父抽象类Decortor构造方法...");
        this.component = component;
    }

    // 委托给被修饰者执行
    public void operate() {
        System.out.println("父抽象类Decortor的操作方法...");
        this.component.operate();
    }
}

// 具体的装饰类
class ConcreteDecorator1 extends Decorator {
    // 定义被装饰者
    public ConcreteDecorator1(Component component) {
        super(component);
        System.out.println("装饰类1的构造方法，装饰者1需要知道自己装饰谁");
    }

    // 定义自己的修饰方法
    private void method1() {
        System.out.println("装饰类1自己的装饰方法。。。");
    }

    // 重写父类的operate方法
    public void operate() {
        System.out.println("装饰类1自己的操作方法。。。");
        this.method1();
        super.operate();
    }
}

class ConcreteDecorator2 extends Decorator {
    /**
     * @param component
     * @author jyx
     * @date 2023/11/3 10:56
     */
    public ConcreteDecorator2(Component component) {
        super(component);
        System.out.println("装饰类2的构造方法，装饰者2需要知道自己装饰谁");
    }

    // 定义自己的修饰方法
    private void method2() {
        System.out.println("装饰类2自己的装饰方法。。。");
    }

    // 重写父类的operate方法
    public void operate() {
        System.out.println("装饰类2自己的操作方法。。。");
        super.operate();
        this.method2();
    }
}
