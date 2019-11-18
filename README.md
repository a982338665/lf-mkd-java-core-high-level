# CoreHighLevel
## 课程来源：https://www.icourse163.org/learn/ECNU-1206500807?tid=1206823217&from=study#/learn/content?type=detail&id=1212053983&cid=1215222125&replay=true
## 高级特性：

**1.语法糖：CoreHighLevel\src\main\java\pers\li\syntacticsuger**
    
    1.语法糖使得程序员更容易编写程序，更清晰准确表达业务逻辑
    2.语法糖不仅是语法的转换，也包括一些小的改进
    3.JDk5,6,7,8,11长期稳定版
    4.语法糖:
        1.foreach和枚举
            1.for vs forEach:
                -for-each从jdk5开始引入
                -for-each语法更简洁
                -for-each避免越界错误
                -for可以删除元素，for-each不可以删除/替换元素
                -for-each遍历的时候，不知道当前元素的具体位置索引
                -for-each只能正向遍历，不能反向遍历
                -for-each不能同时遍历两个集合
                -for-each和for性能接近
            2.枚举：
                -枚举变量：变量的取值在一个有限的集合内：如性别，星期几，颜色等
                -java5推出的enum类型：
                    ·enum关键字申明枚举类，切都是Enum的子类，但是不需要写extends
                    ·enum内部有多少个值，就有多少实例对象
                    ·不能直接new枚举类对象
                -除了枚举的内容，还可以添加属性，构造函数，构造方法
                -构造函数只能是package-private(default)或者private，内部调用
                -枚举类型方法：所有的enum类型都是Enum的子类，也继承了他相应的方法
                    -ordianl()返回枚举值所在的索引位置，从零开始
                    -compareTo()比较两个枚举值索引位置大小
                    -toString()返回枚举值的字符串表示
                    -valueOf()将字符串初始化为枚举对象
                    -values()返回所有的枚举值
            3.总结：
                ·foreach，避免数组越界，提倡使用
                ·枚举，限定取值集合，减少实例对象，提倡使用
        2.不定项参数和静态导入:
            1.不定项参数：
                ·普通函数的形参列表是固定的个数、类型、shunx
                ·jdk5提供了不定项参数功能 
                    ·例如：public static void print(String... args){}
                    ·可变参数，本质上是个数组，只能在参数列表最后
                    ·一个方法不可以有多个可变参数
                    ·重载优先级：固定参数高于可变参数
            2.静态导入：
                ·import static导入一个类的静态方法和静态变量（jdk5引入）
            3.总结：
                ·建议少用不定项参数
                ·静态导入，有大量静态方法调用时使用，尽量不使用*号导入
        3.自动拆装箱，多异常并列，数值类型赋值优化
        4.接口方法
        5.try-with-resource和resource-bundle加载
        6.var类型和switch
        
    
