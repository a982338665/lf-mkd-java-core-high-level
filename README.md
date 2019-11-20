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
              
