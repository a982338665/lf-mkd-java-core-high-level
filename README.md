# CoreHighLevel
## 课程来源：https://www.icourse163.org/learn/ECNU-1206500807?tid=1206823217&from=study#/learn/content?type=detail&id=1212053983&cid=1215222125&replay=true
## 高级特性：
## 换算

    
    字节 （byte）：8个二进制位为一个字节(B)，最常用的单位。计算机存储单位一般用B，KB，MB，GB，TB，PB，EB，ZB，YB，BB来表示，它们之间的关系是：
    　　1B（Byte字节）=8bit
    　　1KB (Kilobyte 千字节)=1024B，
    　　1MB (Mega byte 兆字节 简称“兆”)=1024KB，
    　　1GB (Giga byte 吉字节 又称“千兆”)=1024MB，
    　　1TB (Tera byte 万亿字节 太字节)=1024GB，其中1024=2^10 ( 2 的10次方)

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
            ·var类型：
                -每个变量在定义时就确定了类型，类型固定了就不能更改：int x =11;
                -java10推出Var，局部变量推断：
                    ·避免信息冗余
                    ·对齐了变量名
                    ·更易阅读
                    ·本质还是强类型语言，编译器负责推断类型，并写入字节码
                -var的限制：
                    ·可以使用在局部变量上，非类成员变量
                    ·可以用在for/foreach循环中
                    ·申明时必须初始化
                    ·不能用在方法参数和返回类型
                    ·大面积滥用会使代码整体阅读性变差
                    ·var只在编译时起作用，没有在字节码中引入新的内容，也没有专门的jvm指令处理var
            ·switch-多分支选择语句
                -支持的类型：byte/Byte，short/Short，int/Integer，char/Character，String（java7及以后），Enum（java5及以后），不支持long、float、double
                -switch，多分支合并，采用->直接连接判定条件和动作【jdk12支持】
                -switch，直接在表达式赋值【jdk12支持】
    
**2.泛型：CoreHighLevel\src\main\java\pers\li\genericity**

    1.问题：
        ·存放多个不同类型的对象，在遍历时容易出现转型错误ClassCastException
        ·在编译前加泛型，限定内容类型
    2.泛型：jdk1.5推出的特性
        ·泛型类:ArrayList,HashSet,HashMap
        ·泛型方法：Collections.binarySearch,Arrays.sort
        ·泛型接口：List,Iterator等
    3.ArrayList源码：会用到泛型符号E
    4.自定义泛型类设计：$1
        ·ArrayList<E> E表示数据结构里的单个元素【element】
        ·HashMap<K,V> key和value
        ·自定义泛型变量常用T，T表示Template
        ·在类名后用<T>代表引入类型：
            -多个字母表示多个引入类型，如<T,U>
            -引入类型可以修饰成员变量，局部变量，参数，返回值
            -没有专门的template关键字
    5.泛型类型限定：$2 CoreHighLevel\src\main\java\pers\li\genericity\limits
        ·对泛型的类型有要求，例如T仅限于实现某接口的对象
        ·<T extends Comparable>约定T必须是Comparable的子类
        ·extends固定，后面可以是多个，以&拼接，如<T extends Comparable & Serializable>
        ·extends限定可以有多个接口，但只能有一个类，且类必须排在第一位，逗号隔开参数
            <T extends File & Cloneable,U extends Serializable>
        ·泛型类之间的继承：
            -Pair<S>和Pair<T>没有任何关系，无论S和T之间是什么关系
                Apple继承自Fruit
                Orange继承自Fruit
                //Pair<Apple> apples = new Pair<>(new Apple(3), new Apple(4));
                //Pair<Fruit> fruits = apples;//会报错，尽管Apple继承于Fruit，但是Pair<Apple>与Pair<Orange>是没有任何关系的
                //fruits.setFirst(new Orange(5));
            -泛型类可以拓展或实现其他类，如ArrayList<T>实现List<T>
                List<Orange> oranges = new ArrayList<Orange>();
        ·上界限定符：Pair<? extends S> 表示Pair能接受的参数是S自身或其子类，只能get
        ·下界限定符：Pair<? super S> 表示s的自身或超类 只能set
        ·泛型PECS原则：
            -Producer Extends：从泛型类读取T数据，不能写入，使用? extends上限通配符 
            -Customer Super：从泛型类写入T数据，不能读取，使用? super下限通配符
            -既要写入又要读取，则不加通配符
        ·无限定类型的泛型：
            ·Pair<T>
            ·Pair<?>    无限定通配符表示任意类型，?可以放入任意值，一般不使用
        ·泛型实现的本质：编译后进行类型擦除
        ·泛型的约束：
            -不能用基本数据类型实例化泛型 T只能是对象
            -运行时类型查询只适用于原始类型
            -不能创建参数化类型的数组
            -可变参数警告
            -不能构造泛型数组
            -泛型类的静态上下文中类型变量无效
            -不能抛出或捕获泛型类的异常实例
            -可以消除对受查异常的检查
            -类型擦除后引发的方法冲突
        ·总结：
           1.Pair<S>和Pair<T>没有关系
           2.Pair<T extends Comparable & Serializable> 限定T类型
           3.PESC：
               ·? extends T    只能get，不能set，只生产，不消费
               ·? super   T    只能set，不能get，只消费，不生产
           4.虚拟机中没有泛型，只有普通类和方法
           5.编译阶段，泛型参数被擦除为限定类型，并进行相关类型转换
           6.虚拟机也会合成桥方法来保持方法多态   
    6.java类型协变和逆变：CoreHighLevel\src\main\java\pers\li\genericity\$3variance
         ·面向对象语言，支持子类型 Subtyping
         ·类型变化关系：更复杂类型中的子类型关系，与子类型直接的关系相关联
         ·类型变化形式化定义：
            前提：A,B是类型，f(.)表示类型转换，<=表示继承关系 ，如A<=B 表示A继承于B
            -f(.)协变: A<=B 时 f(A)<=f(B)
            -f(.)逆变: A<=B 时 f(A)>=f(B)
            -f(.)不变: 上述两种不成立，即f(A)f(B)没有关系
            -f(.)双变: A<=B 时 f(A)<=f(B)和f(A)>=f(B)同时成立   
         ·java数组是协变的：String是Object子类，String[]是Object[]的子类
         ·方法情况：
            -jdk1.4     重写的方法参数和返回值要求一样
            -jdk1.5+    重写的方法参数一样，返回值可以是协变的
            
**3.反射：CoreHighLevel\src\main\java\pers\li\reflection**
    
    1.问题：
        ·怎么知道一个类有多少个方法
    2.反射简介：reflection
        ·可以在运行时加载，探知和使用编译器间完全未知的类
        ·给java插上动态语言特性的翅膀，弥补强类型语言的不足【强类型语言：要求类型方法都是固定的】
            甚至可以在程序运行过程中生成一个新的类
        ·java.lang.reflect,java2产生，java5完善
    3.反射功能：
        -运行中分析类
        -运行中查看和操作对象
            ·基于反射自由创建对象
            ·反射构建出无法直接发访问的类：例如某些类的构造函数是私有的，则可以通过反射创建对象
            ·set或者get无法访问的成员变量：例如某类的私有属性，没有提供get，set方法，可通过反射修改读取该属性
            ·调用不可访问的方法：可以临时将方法前面的private修饰符变成public
        -实现通用数组操作代码：可以通过反射将数组长度5扩容至10，数组扩充器
        -类似函数指针的功能：通过反射可以将函数作为参数传递，供别人使用
    4.反射使用：
        1.创建对象的方式：
            ·new调用构造函数
            ·clone克隆：在内存中新开辟一个具有相同内容的对象，没有调用构造函数
                -对象要想被克隆必须实现Cloneable接口
                -优点：克隆的速度要比调用构造函数生成对象更高效，因为内存复制要比【构造函数赋值】更快
            ·序列化和反序列化：
                -需要实现序列化接口
                -将对象通过流的方式输出到文件
                -将文件读取，转换为对象
                -实际上，就是以文件为载体，将对象克隆了一份
                -注意：
                    ·oracle公司已发表申明：序列化创建对象由于要将数据写入到外部文件，有很大的安全漏洞，未来将被移出jdk，请谨慎使用
                    ·序列化也没有调用构造函数
            ·反射创建对象：newInstance 调用构造函数
        2.反射关键类：· Class：类型标识-jvm为每个对象都保留了其类型标识信息
        3.反射应用：
            ·数据库连接：jdbc连接，通过反射动态定义 数据库连接
            ·数组扩充：数组长度确定，不可更改，新建大数组，将旧的数组内容copy过去
            ·动态执行方法：给定类名，方法名，即可执行，加上定时器即可做定时任务执行
            ·json和java对象互转
            ·tomcat的servlet创建
        4.编译器api：
            ·反射：
                -可以查看对象类型标识
                -可以动态春感觉对象，访问其属性，调用其方法
                -前提：类（.class文件）必须存在
            ·编译器qpi：
                -对.java文件即时编译
                -对字符串即时编译：把.java文件读成字符流在编译
                -监听在编译过程中产生的警告和错误
                -在代码中运行编译器（非 命令行调用javac命令）
            ·JavaCompier：
                -自java1.6推出，位于javax.tools包中
                -可用在程序文件中国的java编译器接口（代替javac.exe）
                -在程序中编译java文件产生.class文件
                -run方法（继承自java.tools.Tools）：较简单。可以编译java源文件，生成class文件，但不能指定输出路径，
                    监控错误信息，调用后就在源码所在目录生成class文件
                -getTask方法：更强大的功能。可以编译java源文件，包括内存中的java文件（字符串），生成class文件
            ·java编译器api的作用：
                -javaee的jsp编译：jsp文件编译成java的servlet，然后使用java编译器api编译成class文件
                -在线编程环境：菜鸟教程，在线写代码
                -在线程序评判系统
                -自动化构建和测试工具
            ·基于JavaCompiler的集成工具：
                -Janino：推荐使用
                    http://janino-complier.github.io/janino
                -InMemoryJavaCompile
                    https://github.com/trung/inMemoryJavaCompiler
                -Java-Runtime-Compiler
                    http://github.com/OpenHFT/Java-Runtime-Compiler
                -Apache Commons JCI（java compiler interface）-> 适用于jdk1.5及以前的版本
                    http://commons.apache.org/proper/commons-jci/index.html

**4.java代理：CoreHighLevel\src\main\java\pers\li\proxy**
    
    1.代理：
        -代理服务器
        -代理经纪人
    2.代理模式：23个经典模式中的一种，又称委托模式
        -为目标对象提供了一个代理，这个代理可以控制对目标对象的访问
            ·外界不用直接访问目标对象，而是访问代理对象，由代理对象在调用目标对象
            ·代理对象中可以添加监控和审查处理
            ·计算机所有问题都可以添加中间层解决，但是会引起新的问题
    3.java代理：
        -1.代理模式和静态代理：
            1.java代理分类：
                -静态代理：
                    -代理对象持有目标对象的句柄
                    -所有调用目标对象的方法，都调用代理对象的方法
                    -对每个方法，需要静态编码-理解简单，但代码繁琐
                    -方法多的时候，针对没法方法都要进行前置处理，后置处理，显得麻烦，每增加一个方法都需要处理
                -动态代理
        -2.动态代理：对目标对象的方法每次被调用，进行动态拦截
            -持有目标对象的句柄
            -实现InvocationHandler接口
                ·实现invoke方法
                ·所有的代理对象方法调用，都会转发到invoke方法来
                ·invoke的形参method，就是指代理对象方法的调用
                ·在invoke内部，可以根据method，使用目标对象不同的方法来响应请求
            -代理对象：
                ·根据给定的接口，由Proxy类自动生成的对象
                ·类型com.sun.proxy.$Proxy0,继承自java.lang.reflect.Proxy
                ·通常和目标对象实现同样的接口（可另实现其他的接口）
                ·实现多个接口：
                    ·接口的排序很重要
                    ·当多个接口里面有方法同名，则默认一第一个接口的方法调用
            -总结：理解代理对象和代理处理器的区别，谨慎使用代理对象实现多个接口
        -3.AOP编程：面向切面编程 使用java的动态代理实现
            -分离代码的耦合（高内聚，低耦合）
            -业务逻辑变化，不需要修改源代码，不用重启
            -加快编程和测试速度
 
 **5.java注解：CoreHighLevel\src\main\java\pers\li\annotation**
    
    1.注解入门：$1
        -从jdk1.5引入
        -注解定义：拓展java.lang.annotation.Annotation注解接口
        -位于源码中（代码，注释，注解），使用其他工具进行处理的标签
        -注解用来饰程序的元素，但是不会对被修饰变量的对象有直接的影响
        -只有通过某种配套的工具才会对注解信息进行访问和处理
        -主要用途：
            ·提供信息给编译器，IDE工具
            ·可用于其他工具来产生额外的代码，配置文件等
            ·有一些注解可在程序运行时访问，增加程序的动态性，利用反射获取注解，作统一处理
        -jdk预定义的普通注解：
            ·@Override  表示继承或重写
            ·@Deprecated 表示废弃
            ·@SuppressWarnings 表示忽略警告
            ·@SafeVarargs 不会对不定项参数做危险操作
            ·@FunctionInterface 申明功能性接口
        -jdk预定义的元注解：用来修饰注解的注解
            ·@Target        设置目标范围
            ·@Retention     设置保持性
            ·@Documented    文档
            ·@Inherited     注解继承
            ·@Repeatable    此注解可以重复修饰
    2.java预定义的普通注解：$2
    3.自定义注解：$3
        -注解可以包含的类型：8种基本数据类型，String，Class，enum类型，注解类型，由以上类型组成的数组
            public @interface BugReport {
            	enum Status {UNCONFIRMED, CONFIRMED, FIXED, NOTABUG};
            	boolean showStopper() default true;
            	String assiganedTo() default "[none]";
            	Status status() default Status.UNCONFIRMED;
            	String[] reportedBy();
            }
        -注解使用：
             public @interface Test {}     @Test
             public @interface Test {
                int value() default 0;     @Test 或 @Test(5) 或 @Test(value=5) 
             }     
             public @interface Test {
                int a() default 0;         @Test 或 @Test(a=1) 或 @Test(a=5,b=5) ,不能写 @Test(1,2),无法识别
                int b() default 0;
             }     
        -注解使用的位置：注解上的注解 --模拟junit测试用例
            -@Target可以限定位置：指明该注解可以用在哪个位置，允许的位置如下
                -包
                -类
                -接口
                -方法
                -构造器
                -成员变量
                -局部变量，形参变量，类型参数   
    4.java预定义的元注解：修饰注解的注解：$4
        -@Retention（保留）：
            -示例：@Retention(RetentionPolicy.RUNTIME)
            -这个注解用来修饰其他注解存在的范围
            -RetentionPolicy.SOURCE 注解仅存在源码，不在class，一般是IDE工具用来进行代码分析，监控等
            -RetentionPolicy.CLASS  这是默认的注解保留策略，注解存在于class文件，但是不能被JVM加载
            -RetentionPolicy.RUNTIME这种策略下注解可以被JVM运行时访问到，通常情况下可以结合反射搞事情
        -@Target ：设置目标范围，注解作用于什么位置
            -@Target(ElementType.ANNOTATION_TYPE)   修饰别的注解
            -@Target(ElementType.CONSTRUCTOR)       修饰构造函数
            -@Target(ElementType.FIELD)             修饰变量
            -@Target(ElementType.LOCAL_VARIABLE)    修饰方法内的局部变量
            -@Target(ElementType.METHOD)            修饰方法
            -@Target(ElementType.PACKAGE)           修饰包
            -@Target(ElementType.PARAMETER)         修饰方法参数列表内的参数
            -@Target(ElementType.TYPE)              用于描述类、接口(包括注解类型) 或enum声明
        -@Inherited:继承
            -让一个类和他的子类都包含某个注解
            -普通的注解没有继承功能
        -@Repeatable
            -jdk1.8引入
            -表示被修饰的注解可以重复应用标注
            -需要定义注解和容器注解
        -Documented:
            -这个注解可以被javadoc工具解析，形成帮助文档     
            -idea生成javadoc的方式：
                顶行【Tools】-->【Generate javaDoc...】 -->
                【选择输出路径】+【在Other command line arguments中添加[-encoding utf-8 -charset utf-8]】   
    5.注解的解析：
        1.RetentionPolicy.RUNTIME这种策略下注解可以被JVM运行时访问到
            -Class.getAnnotations()     获取类有哪些注解修饰
            -Class.isAnnotation()       判断类是否有注解修饰它
            -Class.isAnnotationPresent(Class annotationClass) 判断是否有某注解
            -Method.getAnnotations()
            -Method.isAnnotationPresent(Class annotationClass)
            -Field.getAnnotations()
            -Field.isAnnotationPresent(Class annotationClass)
            -Constructor.getAnnotations()
            -Constructor.isAnnotationPresent(Class annotationClass)
        2.RetentionPolicy.CLASS:注解在class文件中，但是jvm没有加载，idea支持反编译可直接查看
            -只能采用字节码工具进行特殊处理：如ASM工具
        3.RetentionPolicy.SOURCE：注解在java文件中，不在class中，不会被jvm加载
            -只有源码级别进行注解处理
            -Java提供注解处理器来解析带注解的源码，产生新文件
                ·注解处理器继承AbstractProcessor，重写process方法
                ·javac -processor Processor1, Processor2,,...
                ·编译器定位源文件的注解，然后依次启动注解处理器执行处理。如果某个注解处理器
                    产生新的源文件，name将重复执行这个过程
                ·注解处理器只能产生新文件，不会修改已有的源文件
            -代码来源：java核心技术卷二，高级特性    
    6.RUNTIME注解的实现本质：$6 https://www.icourse163.org/learn/ECNU-1206500807?tid=1206823217&from=study#/learn/content?type=detail&id=1213070105&cid=1216555199
        1.调用路线：
            -注解采用接口中的方法来表示变量
            -java为注解产生一个代理类。这个代理类包括一个AnnotationInvocationHandler成员变量
            -AnnotationInvocationHandler有一个Map的成员变量，用来存储所有注解的属性赋值
            -在程序中，调用注解接口的方法，将会被代理类接管，然后根据方法名称，到Map拿到相应的value并返回
        2.设计思路：
            -注解需要随意赋值：
                -1.注解方法表示变量：一个方法名表示一个变量名
                -2.采用代理类拦截注解方法访问
                -3.所有注解的赋值，都放在Map中，访问速度快
        3.java自带的反编译工具：
            cmd命令行 --> javap -c 【类（不带后缀）】 javap -c Fruit
        4.注解的本质：
            1.编译注解：D:\go-20191030\CoreHighLevel\src\main\java\pers\li\annotation\$6>javac Fruit.java
            2.反编译注解：D:\go-20191030\CoreHighLevel\src\main\java\pers\li\annotation\$6>javap -c Fruit.class
                public interface pers.li.annotation.$6.Fruit extends java.lang.annotation.Annotation {
                  public abstract java.lang.String name();
                }
            3.反编译之后可以看见：字节码中没有@interface，只有一个接口
            
    7.注解应用：
        1.servlet3.0配置：
            -Servlet是javaee最重要的元素
            -传统是需要在web.xml里配置，3.0以后支持注解配置，更简便
            -需要容器的支持：tomcat7.0+支持注解servlet语法
        2.Junit
        3.lombok:
            @Data
            @AllArgsConstructr

**6.嵌套类：pers.li.nestedclass**

    1.嵌套类入门:
        1.定义：一个类定义在别的类内部
            嵌套类：同一个文件中A在B内
                    public class B {
                        class A{}
                    }
            非嵌套类：同一个文件中，A,B并列
                    class A{}
                    public class B{}
        2.介绍分类：Nested classes （嵌套类）https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
            -静态嵌套类：类中静态类
                public class A {
                    String name;
                    static class inner1{
                        String name;
                    }
                }
            -非静态嵌套类，也称内部类
                ·普通内部类（成员内部类）类中普通类
                    public class A {
                        String name;
                        public class inner1{
                            String name;
                        }
                    }
                ·局部内部类:类中方法中的类
                    public class A {
                        String name;
                        public void f1(){
                            public class inner1{
                                String name;
                            }
                        }
                    }
                ·匿名内部类:类中方法中的无名类:new 的接口，后面加大括号实现，所以下面的new Runnable(){}是匿名内部类
                    public class A {
                        String name;
                        public void inner1(){
                            new Thread(new Runnable(){
                                public void run(){}
                            }).start();
                        }
                    }
        3.为什么需要嵌套类：
            -不同的访问权限要求，更细粒度的访问控制
            -简洁，避免过多的类定义
            -缺点：语言设计过于复杂，胶南学习使用
    2.匿名内部类和局部内部类
        1.匿名内部类：Anonymous classes
            -没有类名的内部类，必须继承一个父类或实现一个接口，编译器会产生内部名字：类名+$+数字编号
            -在实例化后，迅速转型为父类或父接口
            -这种类型的对象，只能new一个对象，之后以对象的名字操作
            -可在普通语句和成员变量赋值是使用内部类
            -匿名内部类不能定义静态变量，除非是常量
            -匿名内部类不能定义静态方法
            -没有类名，没有构造函数，能用父类或父接口的构造函数 - 可带参数
            -可以继承，改写，补充父接口/父类的方法
            -可以访问外部保卫类的成员变量和方法（包括private）
            -如果定义在静态方法中，也只能访问外部包围类的静态成员
            -没有类名，外部包围类和其他类无法访问到匿名内部类
        2.局部内部类：Local classes
            -也是定义在代码块中的非静态的类，如方法，for循环，if语句等
            -定义后即可new对象使用
            -只能作用于当前代码块，结束后，外界无法使用该类
            -编译后名称：外部类名+$+序号+内部类名
            -可以继承其他类，或者实现其他接口
            -非静态的类，不能包含静态成员（变量和方法），常量除外
            -可以访问外部包围类的成员
            -如果定义静态方法中，只能访问外围类的静态成员
            -局部内部类不能是一个接口，即接口不能定义在代码块中
        3.总结：
            -两者都是定义在方法中，几乎相似
            -局部内部类因为有类名，所以可以重用，匿名内部类不能
            -匿名内部类更简洁
            
    3.普通内部类和静态内部类
        1.普通内部类：
            -定义在类中，非static的类，定义在某个类的成员变量的位置
            -定义后在类中均可使用
            -编译后名称：外部类型+$ +内部类名
            -可以继承其他类，或者实现其他接口
            -可以用private/package private(不写)/protectes/public控制外界访问，当是private时，外部类无法访问内部类，也不能创建对象
            -非静态类，不能包含静态变量，方法，除了常量
            -和外部包围类的实例相关，一个普通内部类实例肯定是在一个外部包围类的实例中，且可以访问外部包围类的所有成员
            -在第三方类中，需要先创建外部包围类实例，才能创建普通内部类的实例，不允许单独的普通内部类对象存在
        2.静态嵌套类：
            -层级和包围类的成员变量，方法一样
            -第三方需要通过外部包围类，才可以访问到静态嵌套类
            -类前加static
            -可以定义静态成员和非静态成员
            -不能直接访问包围类的非静态成员，可直接访问包围类的静态成员，可通过new包围类的对象进行访问非静态成员
            -外界可以通过静态嵌套类名访问其静态成员，通过对象访问其非静态成员
            -外界需要通过包围类才可以访问到静态嵌套类，并创建其对象，不需要外部包围类的实例
            -官方解释：静态嵌套类和顶层类无很大区别，主要是为了打包方便
    4.嵌套类对比
    5.嵌套类应用
    
**7.Lambda表达式：pers.li.lambdas**
    
    1.入门：pers.li.lambdas.$1.StringOrderTest
        -1.面向过程程序语言：参数传递是基本类型的变量
        -2.面向对象语言：
            -传递基本类型变量
            -传递对象变量
        -3.传递方法、代码块（函数式程序语言设计）
            -刚开始，java为了简单性，一致性，拒绝此功能
            -为了市场需求和技术实现，java8开始，支持此功能，提出java的Lambda表达式实现，可以将方法作为参数传递
                例如：Arrays.sort(planets, (first, second) -> (-1) * (first.length() - second.length()));
        -4.lambda表达式：
            1.可以当做参数，传递给其他高阶函数    
            2.类似于匿名方法，一个没有名字的方法
            3.参数，箭头，表达式语句
            4.可以忽略写参数类型
            5.坚决不申明返回值类型
            6.没有public,protected,private,static,final等修饰符
            7.单句表达式，将直接返回值，不使用大括号
            8.带return语句，算多句，必须使用大括号
    2.函数式接口：
        1.只包含一个抽象方法的接口
        2.可以包括其他的default方法，static方法，private方法
        3.由于只有一盒未实现的方法，所以Lambda表达式可以自动填充上这个未实现的方法
        4.采用Lambda表达式，可以自动创建出一个（伪）嵌套类的对象（没有实际的嵌套类class文件产生），然后使用
            比真正的嵌套类更加轻量，更加简洁高效
        5.自定义函数式接口：
            1.@FunctionalInterface //系统自带的函数式接口注解，用于编译器检查：检查是否只有一个未实现接口，推荐使用
        6.函数式接口：
            -只带有一个未实现的方法，内容简单
            -大量重复性的函数式接，使得源码膨胀
        7.系统自带的函数式接口：
            -涵盖大部分常用的功能，可以重复使用
            -位于java.util.function包中
            -常见：--重点关注
                -Predicate<T>  接收一个参数返回一个boolean
                -Consumer<T>   接收一个参数无返回 
                -Function<T,R> 接收一个参数返回一个值
                -Supplier<T>   数据工厂:没有参数，但是返回一个值
    3.方法引用：
        1.类::静态方法，如Math.abs方法
            -等价于提供方法参数的Lambda表达式
            -Math::abs 等价于 x -> Math.abs(x)
        2.类::实例方法，如String::compareToIgnoreCase方法
            -第一个参数将变成方法的执行体
            -String::compareToIgnoreCase等价于(x,y)->x.compareToIgnoreCase(y)
        3....
    
    4.表达式应用：
        1.
    
**8.java stream流：pers.li.streams**
    
    1.概述：
        1.一个流对外提供一个接口，可以访问到一串特定的数据。流不存储元素，但是可以根据需要进行计算转化
        2.数据来源：数据结构，数组，文件等
        3.聚合操作：刘支持想sql操作或其他函数式语言操作：如filter,map,reduce,find,match,sorted
        4.很多流操作也是返回一个流
        5.流操作进行迭代，用户感知不到循环遍历
        6.流的工作流程：
            1.流的创建
            2.流的转换，将流转换为其他流的中间操作，可包括多个步骤【惰性操作】
            3.流的计算结果，这个操作会强制执行之前的惰性操作，这个步骤以后流就再也不用了
    2.流的创建：
        1.// Collection子类产生stream
          //还有其他子类，如LinkedList,LinkedSet,TreeSet等
          Stream<String> a1 = new ArrayList<String>().stream();
          Stream<String> a2 = new HashSet<String>().stream();
          // 使用Arrays.stream 转化数组为stream，第三个到第五个
          Stream<String> b1 = Arrays.stream("a,b,c,d,e".split(","), 3, 5);
          // 数组产生stream
          Stream<Integer> c1 = Stream.of(new Integer[5]);
          Stream<String> c2 = Stream.of("a,b,c".split(","));
          Stream<String> c3 = Stream.of("a", "b", "c");
          //空流
          Stream<String> d1 = Stream.empty();
          //无限流,使用generate方法，根据Lambda表达式产生
          Stream<String> e1 = Stream.generate(()->"hello");
          Stream<Double> e2 = Stream.generate(Math::random);
          //无限流，使用iterate方法，第一个参数是种子
          //第二个是Lambda表达式
          //首位为0，步长为1，每次加1
          Stream<BigInteger> e3 = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
          //Files的lines方法读取一个文件，产生每一行内容的Stream
          Stream<String> contents = Files.lines(Paths.get("C:/abc.txt")); 
          //Pattern的splitAsStream方法，根据一个正则表达式，将内容分为一个字符串的Stream
          Stream<String> words = Pattern.compile(",").splitAsStream("a,b,c");
          //words.forEach(System.out::println);
        2.基本类型流：只有三种 CoreHighLevel\src\main\java\pers\li\streams\$2\BasicTypeStream.java
            -IntStream,
            -LongStream
            -DoubleStream
        3.并行流：
            -使得所有的中间转换操作都将被序列化
            -Collections.parallelStream()将任何集合转换为并行流
            -Stream.parallel()方法，产生一个并行流
            -注意：要保证传给并行流的操作不存在竞争
    3.流的转换：
        1.Stream的转换，从一种流到另一种流的转换
            ·过滤，去重
            ·排序
            ·转化计算
            ·抽取，跳过，连接
            ·其他
    4.流：Optional<T>
        ·一个包装器对象
        ·要么包装了类型T的对象，要么没有包装对象（还是null）
        ·如果T有值直接返回T
        ·如果没有T，返回一个替代物
        ·创建：
            of
            empty
            ofNullable
        ·使用：
            get：获取值，不安全，为null时会报错
            orElse：获取值，为null，使用替代物的值 常用
            orElseGet：获取值，为null，使用lambda表达式值返回 常用
            orElseThrow：获取值，为null，抛出异常
            ifPresent：判断是否为null，不为null返回true
            isPresent(Consumer)：判断是否为空，不为空则进行后续Consumer操作，若为空则不进行任何操作
            map(Function):将值传递给Function进行计算，若为空，不计算
    5.流的计算结果
        ·流的计算：
            ·简单约简（聚合函数）：count/max/min...
                1-count 计数
                2-max(Comparator) 最大值需要比较器
                3-min(Comparator) 最小值需要比较器
                4-findFirst 取第一个元素
                5-findAny   取任意一个元素
                6-anyMatch(Predicate) 若有任意一个元素满足Predicate返回true
                7-allMatch(Predicate) 所有满足返回true
                8-noneMatch(Predicate) 没有任何一个满足返回true
            ·自定义约简：reduce
            ·查看遍历元素：iterator/foreach
            ·存放到数据结构中
    6.流的应用
        -类似于sql操作，简化了串行和并行的大批量操作
        1.Stream和循环迭代的区别：
            Stream广泛使用Lambda表达式，只能读取外围的final或者effectively final变量，循环迭代代码可以读取、修改任意的局部变量
            在循环迭代代码块中，可以随意break，continue，return，或者抛出异常，而lambda表达式无法完成此事
            stream流不是淘汰循环迭代代码，而是两者相互搭配使用
        2.注意：
            1.一个流只能用一次，用完就没了，不能重复使用
            2.避免创建无限流：
                IntStream.iterate(0,i->i+1).foreach(System.out::print)      //无限流
                IntStream.iterate(0,i->i+1).limit(10).foreach(System.out::print) //对流元素进行限制
            3.注意流的操作顺序:先排序后limit，和先limit后排序的区别
            4.谨慎使用并行流：
                ·底层使用Fork-Join Pool，处理计算密集型任务【java核心技术进阶第五章】
                ·数据量过小不使用
                ·数据结构不易分解的不用，如LinkedList
                ·频繁拆箱装箱不用
                ·设计findFirst和limit的时候不用
            5.Stream和collection可以相互转换
    
**9.java模块化：** 

    1.java模块化概述：
        1.jdk8及以前的开发模式
            将所有程序的jar包，类库的jar包都放在classpath上，来运行
        2.java Hell：
            ·不同的jar包中，可能会有相同的类名（包名+类名）
            ·java运行时，无法判断classpath路径上的jar有多少个不同版本的文件，java加载第一个符合名字的类
            ·所有的jar包在classpath都会依次排开，当程序用到某个类的时候，从classpath一次去找
                例如：Main.class需要p1.Foo类，而classpath上有foo-1.0.jar和foo-1.1.jar，当main运行时，将按照classpath顺序，加载第一个
                        jar-1.1.0.jar的内容，而忽略后面的jar-1.1.jar的文件内容
            ·java在运行时，加载类是依次一个一个加载，无法预判classpath路径上是否缺失了关键类
        3.模块化必须遵循的三个原则：
            ·强封装性：一个模块必须对其他模块隐藏其部分代码
            ·定义良好的接口：模块必须向其他模块公开定义良好且稳定的接口
            ·显示依赖：明确一个模块需要那些模块的支持才能完成工作
        4.java9开始引入新的模块化系统：Jigsaw拼图
            ·以模块为中心 
            ·对jdk本身进行模块化
            ·提供一个应用程序可以使用的模块系统
            ·优点：
                ·可靠地配置
                ·强封装性
                ·可拓展开发
                ·安全性
                ·性能优化
        5.以java11.0.1为例
            ·一共有71个模块
            ·最底层的是java.base
            ·每个模块都有明确的依赖模块，不存在循环依赖
            ·使用java --list-module可以查看jdk的模块列表（需要jdk9及以上）
            ·每个类都自动引用java.base模块
            ·使用java --describe-module查看平台模块申明
    2.java模块化创建和运行：D:\go-20191030\CoreHighLevel\src\main\java\pers\li\module
        改版太多，暂时不用
        
**10.java字节码：D:\go-20191030\CoreHighLevel\src\main\java\pers\li\bytecode**        
    
    1.java字节码概述：
        1.java开发过程：
            ·编写 文本编写       .java文件
            ·编译 javac.exe 编译 .class文件
            ·运行 java.exe加载   .class文件运行
        2.class文件：-字节码（bytecode）文件
            ·class文件是java 一次编译到处运行的基础
            ·class文件具备平台无关性，由jvm执行
            ·每个class文件包含一个类或接口或模块的定义
            ·class文件是一个二进制文件由jvm定义class的文件的规范
            ·任何满足这种规范的class文件都会被jvm加载运行
            ·class文件可以有其他语言编译生成，甚至不用程序语言直接生成
            ·jdk版本不同，编译出来的.class文件不同，低版本编译出的class可在高版本运行，反之不可
        3.class文件包含的内容：D:\go-20191030\CoreHighLevel\src\main\java\pers\li\bytecode\class文件内容.jpg
        4.class文件的学习：
            -字节码文件结构：了解各个模块组成
            -字节码生成：javac编译器api
            -字节码操作：利用工具对字节码进行查看和编辑
            -字节码增强：
                使用Instrument对字节码进行转换
                对字节码反编译和混淆（重点：防止源码泄露）
    2.java字节码文件构成：
        混淆器：反编译-ProGuard，实为更换方法名称，逻辑等，使可读性变差
       
**11.java类加载器：D:\go-20191030\CoreHighLevel\src\main\java\pers\li\classloader**
    
    1.java类加载机制：
        1.类加载过程：
            0. 执行时，增加一个VM参数 -verbose:class,会输出，整个程序运行时的类加载顺序
            1.程序是依靠多个java类共同协作完成的
            2.jvm依据classpath执行的类库的顺序来查找类
            3.潜在的问题：
                ·如何找到正确的类：如classpath路径的前后
                ·如何避免恶意的类，如一个假的String类
                ·加载的顺序，如先加载父类还是子类
        2.类加载器ClassLoader
            1.负责查找，加载，校验字节码的应用程序
            2.java.lang.CLassLoader：
            3.java四级类加载器：java8之前的，java8之后拓展类加载器被重命名为Platform加载器（和java模块化有关）
                ·启动类加载器：Bootstrap，加载系统类rt.jar
                ·拓展类加载器：Extension，加载jre/lib/ext等文件下的java文件
                ·应用类加载器：App,加载应用中classpath路径下的java文件
                ·用户自定义加载器：Plugin，程序自定义
            4.加载机制：双亲委托模型
                -首先判断是否已经加载
                -若无，父加载器加载
                -若无，当前加载器加载
                注意：可查看源码jdk8
                    String类是在rt.jar下，由于双亲委托模型加载顺序，每次在加载类的时候，都会先找父级加载，所以在加载String类的时候，他是无法被冒充的
                    加载的查找顺序为：Bootstrap - Extension - App
                    此种方式有效的保证了JDK里面一些核心类的关键代码
                类加载器是JVM生态系统的基础构成之一
    2.java类双亲委托加载拓展：
        1.java严格执行双亲委托机制;
            `类先由最顶层的加载器来加载，若没有才由下级加载器加载
            `委托是单向的，确保上层核心类的正确性
            `但是上级类加载器所加载的类，无法访问下级类加载器所加载的类
                ·例如：java.lang.String无法访问一个自定义的Test类
                ·java是一个遵循契约设计的程序语言，核心类库提供接口，应用层提供实现
                ·核心类库是由BootstrapClassLoader加载
                ·应用层是由AppClassLoader加载
                ·典型例子是JDBC和XML Parser等
            ·执行java，添加虚拟机参数（VM）：-Xbootclasspath/a:path,将类路径配置为Bootstrap等级
            ·使用ServiceLoader.load方法来加载（底层加载器所加载的类，以jdbc为例）
            ·每个jdbc的驱动jar，里面都有一个services目录，里面有一个java.sql.Driver文件：
                ·jar包解压后目录：mysql-connector-java-5.1.8\META-INF\services\java.sql.Driver
                ·java.sql.Driver内容：
                    com.mysql.jdbc.Driver 
                ·即java.sql.Driver为接口名，其内容为实现类
            ·ServiceLoader：
                ·JDK1.6引入的一种新特性，用于加载服务的一种工具
                ·服务有接口定义和具体的实现类（服务提供者）
                ·SPI机制：Service Provider Interface
                ·源码分析：
                    1.加载实现类：Class.forName("com.mysql.jdbc.Driver");
                        public class Driver extends NonRegisteringDriver implements java.sql.Driver {
                            public Driver() throws SQLException {
                            }
                        
                            static {
                                try {
                                    //向驱动管理注册mysql实现类
                                    DriverManager.registerDriver(new Driver());
                                } catch (SQLException var1) {
                                    throw new RuntimeException("Can't register driver!");
                                }
                            }
                        }
                    2.获取连接：Connection conn = DriverManager.getConnection(url, "root", "123456");
                        //遍历驱动管理里注册的实现类，获取连接
                        Iterator var5 = registeredDrivers.iterator();
                                    while(true) {
                                        while(var5.hasNext()) {
                                            DriverInfo aDriver = (DriverInfo)var5.next();
                                            if (isDriverAllowed(aDriver.driver, callerCL)) {
                                                try {
                                                    println("    trying " + aDriver.driver.getClass().getName());
                                                    Connection con = aDriver.driver.connect(url, info);
                                                    if (con != null) {
                                                        println("getConnection returning " + aDriver.driver.getClass().getName());
                                                        return con;
                                                    }
                                                } catch (SQLException var8) {
                                                    if (reason == null) {
                                                        reason = var8;
                                                    }
                                                }
                                            } else {
                                                println("    skipping: " + aDriver.getClass().getName());
                                            }
                                        }
                        
                                        if (reason != null) {
                                            println("getConnection failed: " + reason);
                                            throw reason;
                                        }
                        
                                        println("getConnection: no suitable driver found for " + url);
                                        throw new SQLException("No suitable driver found for " + url, "08001");
                                    }
                ·实现：
                    调用方 -> ServiceLoader.loader -> 接口 -> 本地服务发现+加载 -> 服务提供方【实体类A+实体类B】
        2.自定义类加载路径：
            1.自定义加载路径:
                ·弥补类搜索路径静态的不足（前面的三种类加载器在程序运行之前都是确定好的，在程序运行的时候没办法在修改，程序动态性就比较差）
                ·URClassLoader-从多个URL，jar或者目录中加载类
                    ·继承自CLassLoader
                    ·程序运行时，增加新的类加载路径
                    ·可从多个来源中加载类：目录，jar，网络
                    ·addURL添加路径
                    ·close方法关闭
            2.自定义类加载器：
                ·继承ClassLoader类
                ·重写findClass(String className)方法
        3.总结：
            ·程序动态增加类加载路径，客服静态路径的缺点
            ·不同程序，线程可以有不同的加载路径，互相隔离
            ·重复加载某一个路径，实现程序热部署
    4.自定义类加载器：
        1.自定义类加载器：
            ·继承ClassLoader类
            ·重写findClass(String clasName)方法
            ·使用时，默认先调用loadClass(ClassName)来查看是否已经加载过，然后委托双亲加载，如果都没有，然后在通过findClass加载返回
                -在findClass中，首先读取字节码文件，然后调用defineClass（className,bytes,off,len）将类注册到虚拟机中
                -可以重写loadClass来打破双亲加载
            ·两个不同的类加载器在加载同一个类的时候，编译可通过，但是运行会报错，jvm中会把他认为是不同的两个类
        2.总结：
            ·jvm四级类加载器严格遵守从上到下的加载机制
            ·自定义类加载器继承ClassLoader类，可重写loadClass和findClass方法
            ·不同层次的类加载器加载同名的类，在jvm里面也算是不同的类
    5.java类加载器总结：
        1.java四级类加载器：java8之前的，java8之后拓展类加载器被重命名为Platform加载器（和java模块化有关）
            ·启动类加载器：Bootstrap，加载系统类rt.jar
            ·拓展类加载器：Extension，加载jre/lib/ext等文件下的java文件
            ·应用类加载器：App,加载应用中classpath路径下的java文件
            ·用户自定义加载器：Plugin，程序自定义
        2.优点：
            ·层次分明，逐级加载，确保核心类可用
            ·兼顾静态和动态加载
        3.java四级类加载器的动态性：
            ·使用虚拟机参数 -Xbootclasspath，将jar或目录提高到Bootstrap等级
            ·使用ServiceLoader和SPI机制，实现上层加载器的类，访问下层加载器的类（JDBC）
            ·使用URLClassLoader，可以在运行时增加新的classpath路径
            ·使用自定义的classloader，可以通过重写loadClass和findClass方法动态加载字节码，还可以在加载字节码的过程中进行修改校验等操作
        4.jvm类装载过程：
            ·加载-loading
            ·链接-linking
                验证：字节码是否满足规范要求
                准备：分配内存，常量池初始化
                解析：解析类，接口，字段，方法的符号引用
            ·初始化：执行类的初始化方法
        5.其他：
            ·java类加载器：类加载和隔离
            ·基于类加载器诞生OSGI（open service gataway initiative）,在OSGi容器里运行bundle，通过类加载器控制类的可见性
            ·类加载器和模块直接的关系-java9之后
        6.推荐：
            ·网站：
                jvm规范
                oracle java文档
            ·书籍：
                深入理解java虚拟机 - 周志明
                实战java虚拟机     - 葛一鸣
                揭秘Java虚拟机     - 封亚飞
                java Performance   - Oreilly
            
**12.jvm内存管理：**
    
    1.JVM概述：
        1.虚拟机：vm,Virtual Machine
            -逻辑上，一台虚拟的计算机
            -实际上，一个软件，能够执行一系列虚拟的计算指令，介于软件和硬件之间
            -系统虚拟机：-桌面程序和服务器级别的
                ·对物理计算机的仿真
                ·如VMware,Oracle VirtualBox等
            -软件虚拟机：
                ·专门为单个计算程序而设计
                ·如JVM等
        2.java官方虚拟机发展历程：sun
            -当今：2014年jdk1.8发布，Hotsport融合了JRockit
        3.java常用虚拟机：
            ·Sun/Oracle，Classic Vm/Hotsport VM/JRockit VM
            ·IBM/Eclipse:J9 VM,https://www.eclipse.org/openj9/
            ·OpenJDK:开源的虚拟机，https://openjdk.java.net:由此衍生出很多大公司的特定的虚拟机，如Alibaba JVM等
                在jdk1.6的时候由Sun公司同步建立的开源项目，虚拟机开源，可拿到源码
            ·Apache Harmony，已消亡，被OpenJdk冲击
            ·Google Android Dalvik Vm，已消亡，被ART虚拟机顶替
        4.Sun/Oracle和OpenJDK
            ·Sun/Oracle:
                -从jdk9分成LTS和non-LTS版本，LTS-long term support长期稳定版
                -jdk11是LTS，长期稳定版，目前最新的
                -OTN协议，个人免费使用，生产环境商用收费+长期更新
            ·Open-JDK：
                -GPL V2协议
                -可以免费使用，含个人和商用
        5.官方提供的Hotsport虚拟机构成：
            一个java类，经过ClassLoader加载以后进入JVM里面，
            JVM内存：所有的字节码文件，被加载进jvm内存
            那么，有相应的执行机，有相应的执行机读取字节码文件内容，进行执行
            最后转化为本地的方法指令进行工作
            所有的java字节码可以跨平台使用，但是都要经过jvm解释执行
            本次重点学习【JVM内存】，执行机及本地方法是由C语言写的，暂不关注
    2.JVM内存分类：
        1.java自动内存管理：
            ·传统程序语言：由程序员手动内存管理
                -C/C++，malloc申请内存和free手动释放内存
                -由于程序员疏忽或程序异常，导致内存泄漏
            ·现在程序语言：自动内存管理
                -java/C#,采用内存自动管理
                -程序员只需要申请使用，系统会检查无用的对象并回收内存
                -系统统一管理内存，内存使用相对高效，但也会出现异常
        2.jvm调优：主要就是针对jvm内存管理进行的调优
            ·一般程序员只会使用java的标准虚拟机，很少会自己去定制新的虚拟机，在某方面添加新功能
            ·大部分程序员都是在官方的jvm下如何使得程序更加高效
        3.jvm内存：
            ·线程私有内存：java程序运行中的每个线程都含有的内容
                -程序计数器 Program Counter Register（PC）
                    -一块小内存，每个线程都有
                    -PC只要用来存储当前方法：线程正在执行的方法称为该线程的当前方法
                    -当前方法为本地（native）方法时，pc值未定义[当前方法为C语言方法时，未定义]
                    -当前方法为非本地方法时，pc包含了当前正在执行指令的地址[当前语言为java方法时]
                    -当前唯一一块不会引发OutOfMemaryError异常[小内存存储指令地址不会爆发异常]
                -java虚拟机栈 jvm stack - java栈
                    - 每个线程有自己独立的java虚拟机栈，线程私有
                    - -Xss设置每个线程堆栈大小
                    - java方法的执行基于栈
                        -每个方法从调用到完成对应一个栈帧在栈中入栈，出栈的过程
                            ·栈帧存储局部变量表，操作数栈等
                            ·局部变量表存放方法中存在"栈"里面的东西
                        -引发的异常 - 代码展示
                            -栈的深度超过虚拟机规定深度，StackOverflowError异常
                            -程序中使用过多变量，无法拓展内存，OutOfMemoryError等
                -本地方法栈 Native Method Stack
                    -存储本地（native）方法执行信息，线程私有
                        ·java调用c程序的时候，c的函数就叫做native方法，会存储在本地方法栈里
                    -vm规范没有对本地方法栈做明显规定,靠每个虚拟机厂商自己实现
                    -引发的异常：
                        -栈的深度超过虚拟机规定深度，StackOverflowError异常
                        -程序中使用过多变量，无法拓展内存，OutOfMemoryError等
            ·多线程共享内存：
                -堆 Heap
                    -虚拟机启动时创建，所有线程共享，占地最大
                    -对象实例和数组都是在堆上分配内存，int，byte等基本类型数据都是在jvm栈上来定义
                    -垃圾回收的主要区域
                    -设置大小：程序能否高效运行的重要因素 - 代码展示两个参数对程序的影响
                        · -Xms 初始堆值
                        · -Xmx 最大堆值 
                    -引发的异常：
                        · 无法满足内存分配要求，OutOfMemoryError等【内存泄漏/内存不足】
                        · JVM参数配置 -XX:-OmitStackTraceInFastThrow 会显示所有的堆栈异常信息
                        · 所以当一些异常抛出的足够多的时候，JIT编译器会优化掉异常堆栈的信息。加入** -XX:-OmitStackTraceInFastThrow**参数才会显示所有的信息。
                -方法区 Method Area
                    ·运行时常量池 Run-Time Constant Pool
                        -Class文件中常量池的运行时表示
                            ·每个class文件中都有一个Constant Pool,在运行的时候，这个类被加载进来，class里面的constant pool就会被映射到内存区域上
                        -属于方法区的一部分，没法单独进行大小调整，只能调整方法区的大小
                        -动态性
                            ·java语言并不要求常量一定只有在编译期产生
                            ·比如使用String.intern方法，也可以将运行时的数据放入常量池
                        -引发的异常：
                            · 无法满足内存分配要求，OutOfMemoryError等【内存泄漏/内存不足】
                    -存储jvm已经加载类的结构，线程共享：运行时常量池，类信息，常量，静态变量等
                        -一个jvm能够加载多少个类，这个将会被方法区的大小限制
                    -jvm启动时创建，逻辑上属于堆的一部分
                    -很少做垃圾回收
                    -引发的异常【javaee编写时，jsp会被编译成servlet，此时他的类有可能会超过最大限制，导致内存溢出】
                        · 无法满足内存分配要求，OutOfMemoryError等【内存泄漏/内存不足】
        4.总结表
            |名称|线程私有/共享|功能|大小|异常|
            |---|---|---|---|---|
            程序计数器|私有|保存当前线程执行方法|通常固定大小|不会
            jvm栈|私有|方法的栈帧|-Xss|OutOfMemoryError & StackOverflowError
            本地方法栈|私有|存储native方法信息|通常固定大小|OutOfMemoryError & StackOverflowError
            堆|共享|存储对象和数组|-Xms -Xmx|OutOfMemoryError
            方法区|共享|存储类结构，常量，静态变量|-XX参数设置[方法区大小随着jdk不同的版本设置的参数还不一样-代码展示]|OutOfMemoryError
            运行时常量池|共享|常量池运行时表示|从属于方法区|OutOfMemoryError
        5.总结：
            ·jvm内存分类
            ·对照class文件，理清jvm各部分内存的作用
    3.JVM内存参数：通过调整内存参数，使程序运行高效
        1.JVM默认的运行参数：
            -支持jvm运行的重要配置，根据操作系统，物理硬件不同而不同，特别是内存，机器的物理内存越多，可能有些参数就越大
                ·两台机器安装同版本的jdk，然后运行出来的程序，他的jvm默认参数可能有所不同
            -使用-XX:+PrintFlagsFinal 显示VM参数
                ·完整命令：1M = 1024KB = 1024*1024B 查看堆内存大小
                    D:\go-20191030\CoreHighLevel\src\main\java\pers\li\annotation\$6>java -XX:+PrintFlagsFinal -version | findstr HeapSize
                        uintx ErgoHeapSizeLimit                         = 0                                   {product}
                        uintx HeapSizePerGCThread                       = 87241520                            {product}
                        uintx InitialHeapSize                          := 201326592                           {product} [换算：201326592b/1024/1024 = 192M ] 初始堆内存
                        uintx LargePageHeapSizeThreshold                = 134217728                           {product} [128M] 
                        uintx MaxHeapSize                              := 3191865344                          {product} [3044M = 2G 996M] 最大堆内存
                    java version "1.8.0_231"
                    Java(TM) SE Runtime Environment (build 1.8.0_231-b11)
                    Java HotSpot(TM) 64-Bit Server VM (build 25.231-b11, mixed mode)
                ·命令解析：
                    1.使用管道查找堆内存大小：| findstr HeapSize
                        findstr 对关键字的查找
        2.程序启动的两类参数：- param.jpg
            -程序参数：程序需要，存储在main函数的形参数组中
            -虚拟机参数：更改默认配置，用以指导进程运行
                · -X参数，不标准，不在所有的VM中通用 non-standard
                · -XX参数，不稳定，容易变更  non-stable ，可能下个版本参数就被废弃了
        3.本示例使用 JDK1.8
            -jvm堆内存：设置最大值为20M:-Xmx20M 【HeapOOM】
                -循环创建对象 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            -jvm栈内存：【JvmStackSOF】 StackOverFlowError -Xss1M
                -循环调用方法 - 递归无限调用
                -循环方法中局部变量 - 【JvmStackSOF】
                -多线程 - 【JvmStackOOM】
            -方法区：-XX参数命令，可能会变更，不稳定
                -存储类信息，常量池，静态变量等
                -1.7及以前，永久区（Perm），-XX:PermSize,-XX:MaxPermSize
                    查看命令：java -XX:+PrintFlagsFinal -version | findstr Perm
                -1.8及以后，元数据区，-XX:MetaspaceSize,-XX:MaxMetaspaceSize,
                    查看命令：java -XX:+PrintFlagsFinal -version | findstr Meta
                    D:\go-20191030\CoreHighLevel\src\main\java\pers\li\annotation\$6>java -XX:+PrintFlagsFinal -version | findstr Meta
                        uintx InitialBootClassLoaderMetaspaceSize       = 4194304                             {product}
                        uintx MaxMetaspaceExpansion                     = 5451776                             {product}
                        uintx MaxMetaspaceFreeRatio                     = 70                                  {product}
                        uintx MaxMetaspaceSize                          = 4294901760                          {product}    默认的方法区最大值：约等于4G
                        uintx MetaspaceSize                             = 21807104                            {pd product} 默认的方法区初始大小：20.79M
                        uintx MinMetaspaceExpansion                     = 339968                              {product}
                        uintx MinMetaspaceFreeRatio                     = 40                                  {product}
                         bool TraceMetadataHumongousAllocation          = false                               {product}
                         bool UseLargePagesInMetaspace                  = false                               {product}
                    java version "1.8.0_231"
                    Java(TM) SE Runtime Environment (build 1.8.0_231-b11)
                    Java HotSpot(TM) 64-Bit Server VM (build 25.231-b11, mixed mode)
                -存储类信息，若一个项目有很多类，那么默认的方法区是否能够容纳下这么多类，所以在程序运行前，限定最大方法区大小为9M：
                    -XX:MaxMetaspaceSize=9M 【JavaCompilerTask】在线编译类函数
                    循环注册类，直到内存溢出 OutOfMemoryError 
                    注意：因此在写程序时，尽量不使用import * ,因为加载的类越多，方法区所承受的压力就越大，若整个系统要依赖的jar包有几百个，每个jar有几百类，那么方法区消耗就会很快
        4.总结：
            ·jvm运行参数
            ·各个区域的调优及参数配置
    4.java对象引用：--> 判断无用对象
        1.垃圾收集器：
            ·jvm有内置垃圾收集器
                -GC，Garbage Collector
                -自动清除无用的对象，回收内存
            ·垃圾收集器的工作职责（John Mccarthy提出，Lisp语言发明者，人工智能奠基者之一，图灵奖获得者，提出任务分时，和垃圾回收）
                -什么内存需要收集 - 判定无用对象
                -什么时候回收 - 何时启动，不影响程序正常运行
                -如何回收 - 回收过程要求速度快，时间短，影响小
        2.java对象的生命周期：
            1.对象通过构造函数创建，但是没有析构函数回收内存
                构造函数和析构函数：
                    构造函数：创建对象过程
                    析构函数：清除对象过程 -> java中没有析构函数，因为自动垃圾回收机制
                        变量创建站内存，引用消失，回收内存
                        GC垃圾回收器：回收算法关系性能好坏，是jvm重点
            2.对象存在在离他最近的一对大括号中:执行完，可回收，不是立刻回收
            3.虽然java程序中没有析构函数，但是提供了其他内存回收的api
                -Object的finalize方法，垃圾回收器在回收对象时调用，有且仅被调用一次
                -System的gc方法，运行垃圾收集器
                -以上两种方法均不靠谱，因为虚拟机会自己决定什么时候来运行垃圾收集器，所以即使写上，虚拟机也不一定会运行垃圾收集器，所以目的转变为怎么使垃圾收集器快速定位到 可回收对象
            4.基于对象引用判定无用对象
                -零引用和互引用等
            5.对象引用链：
                -通过一系列的称为"GC Roots"的对象作为起始点，从这些节点开始向下搜索，搜索所走过的路径称为引用链，当一个对象到GC roots没有任何引用链相连
                    （用图论话来说，从GC Roots到这个对象不可达）时，则证明此对象是不可用的
                -GC Roots对象包括：--> 当前活着的对象可当做出发点来用
                    -虚拟机栈中的引用对象
                    -方法区中类静态属性引用的对象
                    -方法区中常量引用的对象
                    -本地方法栈中引用的对象
            6.为了加快垃圾收集器判定无用对象的速度，java提供了几种不同的引用方法：
                Java执行GC判断对象是否存活有两种方式其中一种是引用计数。
                    引用计数：Java堆中每一个对象都有一个引用计数属性，引用每新增1次计数加1，引用每释放1次计数减1。
                    在JDK 1.2以前的版本中，若一个对象不被任何变量引用，那么程序就无法再使用这个对象。也就是说，只有对象处于(reachable)可达状态，程序才能使用它。
                    从JDK 1.2版本开始，对象的引用被划分为4种级别，从而使程序能更加灵活地控制对象的生命周期。这4种级别由高到低依次为：强引用、软引用、弱引用和虚引用
                -强引用：所有对象的赋值，均叫做强引用
                    ·例如：Object obj1 = new Object(); Object obj2 = obj1; 当obj1置为null，其实例仍赋值给obj2，所以该实例仍然不会被回收
                    ·只要强引用存在，对象就不会被回收，哪怕发生OOM异常 - OutOfMemoryError
                    ·场景：
                        在一个方法的内部有一个强引用，这个引用保存在Java栈中，而真正的引用内容(Object)保存在Java堆中。
                        当这个方法运行完成后，就会退出方法栈，则引用对象的引用数为0，这个对象会被回收。
                        但是如果这个strongReference是全局变量时，就需要在不用这个对象时赋值为null，因为强引用不会被垃圾回收。
                        ArrayList的Clear方法:方法内存数组中存放的引用类型进行内存释放特别适用，这样就可以及时释放内存。
                -软引用：
                    ·描述有用，但非必须的对象
                    ·在系统将要发生内存溢出异常之前，会把这些对象列为可回收
                    ·JDK提供了SoftReference类来实现软引用
                    ·场景：页面缓存问题，若未被回收，取出来，已回收，重新获取，常用于缓存数据
                -弱引用：
                    ·描述非必须对象，比软引用更弱一些
                    ·被软引用关联的对象，只能生存到下一次垃圾收集器发生之前
                    ·jdk提供了WeakReference类来实现弱引用
                -虚引用：用来跟踪对象的回收过程
                    ·最弱的引用关系，jdk提供PhantomReference实现虚引用
                    ·为一个对象设置虚引用关联的唯一目的就是能在这个对象被收集器回收时收到一个系统通知，用于对象回收跟踪
                    ·场景：
                        虚引用必须和引用队列(ReferenceQueue)联合使用。当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，
                        把这个虚引用加入到与之关联的引用队列中。
                        程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要进行垃圾回收。如果程序发现某个虚引用已经被加入到引用队列，
                        那么就可以在所引用的对象的内存被回收之前采取必要的行动。
            7.总结：
                强引用：正常赋值        不回收
                软引用：SoftReference   内存紧张时回收
                弱引用：WeakReference   只要gc就回收
                虚引用：PhantomReference随时被回收
                软引用和弱引用适合保存可有可无的缓存数据
                在日常程序编写中，我们对一些不重要的数据，例如缓存数据等，可以采用软引用，弱引用可以加快对象所占用的内存的回收速度
    5.垃圾收集算法：--> 什么时候回收不影响程序运行，如何回收好
        1.引用计数法：4种引用
            1.介绍：
                -一种古老的算法，每个对象都有一个引用计数器
                -有引用，计数器加一，失效减一
                -计数器为0的时候，回收
            2.优点：
                -简单高效
            3.缺点：
                -无法识别对象直接相互循环使用 ，例如 a引用b，b引用a，但是其他外部没有引用a和b,那么a和b作为整体是可以被回收的，但是用词方法无法回收
        2.标记-清除：可以根据引用计数法标记出来
            1.介绍：
                -标记阶段：标记出所有需要回收的对象
                -回收阶段：统一回收所有被标记的对象
            2.优点：简单
            3.缺点：
                -效率不高
                -内存碎片：内存不连续
        3.复制算法：
            -将可用内存容量划分为大小相等的两块，每次只使用其中的一块
            -当这一块用完了，就将还存活的对象复制到另一块上面去
            -然后在把已使用过的内存空间一次清理掉
            -优点：简单高效
            -缺点：
                ·可用内存减少：本来是一整块，后面可用的只有一半
                ·对象存活率高时，复制操作较多
        4.标记-整理：
            -标记阶段：与“标记-清除”算法一样
            -整理阶段：让所有存活的对象都向一端移动，然后直接清理掉端边界以外的内存
            -优点：
                -避免碎片产生
                -无需两块相同内存
            -缺点：
                -计算代价大，标记清除+碎片整理
                -更新引用地址
        5.分代收集：-> 标准JVM普遍采用的垃圾收集算法
            -java对象根据生命周期不同，有长有短
            -根据对象存活周期，将内存划分为新生代和老年代
            -新生代：-会频繁gc
                ·主要存放短暂生命周期的对象
                ·新创建的对象都先放入新生代，大部分新建对象在第一次gc时被回收
            -老年代：-不会频繁gc
                ·一个对象经过几次gc仍存活，则放入老年代
                ·这些对象可以存活很长时间，或者伴随程序一生，需要常驻内存的，可以减少回收次数
            -针对不同代进行不同算法：
                -新生代：复制算法，包含两部分
                    -Eden区：占比80%
                    -Survivor区：占比20%
                        ·From Space 50%
                        ·To Space   50%
                    -解释：
                        1.对象创建优先放在 Eden和From Space区
                        2.在第一次GC的时候会将里面还活着的内容复制到 To Space区
                        3.因为新生代对象，大部分在第一次gc的时候都会死掉，都会被回收，只有少部分会被放到To Space里面
                        4.那么 Eden和From Space就会被清空
                        5.新的对象 被放在 Eden 和 To Space里面
                        6.下次gc ，将eden 和 To space里面活着的对象放到 From Space
                        7.那么 Eden 和To Space就会被清空
                        8.所以新生代里会采用复制的算法，进行活的对象的拷贝
                -老年代：标记清除或标记整理
                    -由于老年代的存活率非常高，所以采用标记-清除，或标记-整理的方式
                -注意：永久代-jdk6和jdk7，jdk8的时候重命名为元数据区，里面存放的都是类结构等
        6.总结：
            理解各种垃圾收集方法的基本原理
            理解分代收集和java堆内结构
    6.JVM堆内存参数设置和GC跟踪：
        1.堆内存参数：
            ·-Xms 初始堆大小
            ·-Xmx 最大堆大小
            ·-Xmn 新生代大小：包含eden,from,to
            ·-XX:SurvivorRatio设置eden区/from(to)的比例
            ·-XX:NewRatio 设置老年代/新生代比例
            ·-XX:+PrintGC/-XX:+PrintGCDetails打印GC的过程信息：可以看出垃圾收集器在垃圾收集过程中内存变化情况
        2.Hotspot现有垃圾收集器：
            ·串行收集器  Serial Collector 
            ·并行收集器  Parallel Collector   大内存可用
            ·CMS收集器 Concurrent Mark Sweep Collector java高版本
            ·GI收集器  Garbage-First Collector  java高版本 
            ·Z收集器   Z Garbage Collector java高版本
    7.jvm内存管理总结和展望     
        ·自己编译一个jvm
        ·jvm的多种垃圾收集器的使用和区别
        ·理解每一种内存分类的职责，熟悉相关参数设置
        ·根据GC报告和VM监控。调整正确的内存分配策略，例如新生代/老生代之比
        
**13.java运行管理：**














        
