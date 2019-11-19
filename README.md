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
        3.自动拆装箱，多异常并列，数值类型赋值优化：
            1.自动拆装箱：auto-boxing/auto-unboxing
                ·jdk5开始引入，简化了基本类型和对象转换的方法
                ·基本类型：boolean、byte、char、int、short、long、float、double
                ·对象：    Boolean、Byte、Character、Integer、Short、Long、Float、Double
                ·注意事项：
                    -装箱和拆箱是编译器的工作，在class中已经被转换，也就是说虚拟机没有自动拆箱和装箱的功能
                    -==：基本类型是内容相同，对象是指针是否相同（内存同一个区域）
                    -基本类型没有null，对象有null
                    -当一个基础数据类型与封装类进行==，+，-，*，/运算时，会将封装类拆箱，对基础数据进行运算
                    -谨慎使用多个非同类的数值类对象进行运算
            2.多异常并列：
                ·jdk7引入，简化写法，并列写在一个catch中，使用管道符号【|】，与或不同
                ·多个异常之间不能有直接或间接的继承关系，如果有会报错
                ·如果针对不同异常有不同的处理方式，那最好不要使用此种方式
            3.数值类型赋值优化：
                ·java7新语法：整数类型用二进制数赋值，避免二进制计算【byte、short、int、long】
                ·java7新语法：添加下划线，增加代码可读性和纠错功能，编译器在编译时会自动去掉下划线，下划线只能出现在数字中继，前后必须有数字
            4.总结：
                ·多异常并列不建议使用
                ·数值类型赋值优化建议使用
        4.接口方法：
            1.java最初设计：接口方法没有实现的，公开的【java1-7，编译器不允许接口里有实现方法】
            2.java8推出接口的默认方法、静态方法都带实现的，为Lambda表达式提供支持
            3.接口的默认方法：
                -以default关键字标注，其他的定义和普通函数一样
                -规则1：默认方法不能重写Object中的方法
                -规则2：实现类可以继承，重写父接口的默认方法
                -规则3：接口可以继承，重写父接口的默认方法
                -规则4：当父类和父接口都有同名同参数的默认方法，子类继承父类的默认方法，这样可以兼容jdk7以前的代码
                -规则5：子类实现两个接口，均有同名同参数的默认方法，n那么编译失败，必须在子类在重写这个default方法
            4.接口的静态方法：
                -该静态方法属于本接口的，不属于子类，子接口
                -子类，子接口没有继承该静态方法，只能通过所在的接口名来调用
            5.接口的私有方法：带实现的，java9才有的
                -解决多个默认方法，静态方法内容重复问题
                -私有方法属于本接口，仅限本接口内使用，不属于子类，子接口
                -子类无法继承，无法调用
                -静态私有方法可以被静态、默认方法电源，非静态私有方法被默认方法调用
            6.接口和抽象类的区别：截止java12,
                -相同点：
                    -都是抽象的，不能被实例化，即不能被new
                    -都可以有实现方法
                    -都可以不需要子类实现所有方法
                -不同点：
                    -抽象类最多只能继承一个，接口可以实现多个
                    -接口默认申明变量：public static final ,即常量，且必须有初值，子类不能修改
                    -抽象类默认是default，子类可以继承修改
                    -接口没有构造函数，抽象类有构造函数
                        抽象类可以声明并定义构造函数。因为你不可以创建抽象类的实例，所以构造函数只能通过构造函数链调用
                        （Java中构造函数链指的是从其他构造函数调用一个构造函数），例如，当你创建具体的实现类。现在一些面试官问，
                        如果你不能对抽象类实例化那么构造函数的作用是什么？好吧，他可以用来初始化抽象类内部声明的通用变量，并被各种实现使用。
                        另外，即使你没有提供任何构造函数，编译器将为抽象类添加默认的无参数的构造函数，没有的话你的子类将无法编译，
                        因为在任何构造函数中的第一条语句隐式调用super（），Java中默认超类的构造函数。
                    -接口没有main函数，抽象类可有
                    -接口有public，default，private方法，此处default要显式申明
                    -抽象类有public，private，protected及不写关键字的default方法
            7.总结：建议少用，对以往接口概念有很大冲击，如果有Lambda表达式需求，可以使用
        5.try-with-resource和resource-bundle加载
            ·程序如果打开外部资源，那么在使用后需要正确关闭
            ·考虑异常处理，java使用try-catch-finally保证
            ·jdk7提供try-with-resource，比try-catch-finally更简便
                -jdk7：资源要求定义在try中，若已经在外面定义，则需要一个本地变量，例如：
                    FileinputStream fis = ...;
                    try(FileinputStream fis2 = fis){
                    }catch(Exception e){
                    }
                -jdk9：则可以直接引用外部资源变量 例如：
                    FileinputStream fis = ...;
                    try(fis){
                    }catch(Exception e){
                    }
            ·tr-catch-resource原理：
                -资源对象必须实现AutoCloseable接口，即实现close方法
                -在经过编译器后，此种方式最后仍旧会变成try-catch-finally形式
            ·ResourceBundle文件加载：
                -java8以前，ResourceBundle默认以ISO-8859-1方式加载Properties文件
                    -需要利用native2ascii工具（jdk自带）对文件进行转义
                -jdk9及以后，已经删除了native2ascii工具，新的Properties文件可以直接以UTf-8形式保存
                    -已经利用native2ascii工具转换后的文件，不受影响，即ResourceBundle，若解析文件不是有效的UTF-8，则以ISO-8859-1方式加载
            ·总结：
                ·try-with-resource：jdk7及以后，资源自动关闭
                ·ResourceBundle文件加载优化，java9以后默认以utf-8加载，之前以iso-8859-1加载
        6.var类型和switch
        
    
