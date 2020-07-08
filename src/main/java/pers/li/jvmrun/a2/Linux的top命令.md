
**1.top命令介绍：**
    
    显示进程信息，实时进程动态
    
**2.常用命令：**

    显示进程信息
        # top
    显示完整命令
        # top -c
    以批处理模式显示程序信息
        # top -b
    以累积模式显示程序信息
        # top -S
    设置信息更新次数
        #top -n 2
        //表示更新两次后终止更新显示
    设置信息更新时间
        # top -d 3
        //表示更新周期为3秒
    显示指定的进程信息
        # top -p 139
        //显示进程号为139的进程信息，CPU、内存占用率等
    显示更新十次后退出
        #top -n 10
    使用者将不能利用交谈式指令来对行程下命令
        #top -s    
        
**3.linux中top的各项含义：**
    
    [root@VM_0_9_centos ~]# cat top.txt 
    top - 09:46:38 up 5 days, 23:26,  1 user,  load average: 0.07, 0.07, 0.05       
    Tasks:  99 total,   1 running,  98 sleeping,   0 stopped,   0 zombie
    %Cpu(s):  0.7 us,  0.3 sy,  0.0 ni, 98.7 id,  0.3 wa,  0.0 hi,  0.0 si,  0.0 st
    KiB Mem :  3880316 total,   125260 free,  1521296 used,  2233760 buff/cache
    KiB Swap:        0 total,        0 free,        0 used.  2070916 avail Mem 
    
      PID USER      PR  NI    VIRT    RES    SHR S  %CPU %MEM     TIME+ COMMAND                                                                                                   
     8768 root      20   0  158268   9076   1788 S   0.3  0.2   6:17.56 barad_agent                                                                                               
     8769 root      20   0  609236  11236   2000 S   0.3  0.3  36:05.90 barad_agent                                                                                               
     9238 polkitd   20   0 1595132 112372   4592 S   0.3  2.9  31:58.13 mongod                                                                                                    
    14818 root      20   0  163252  33992   3540 S   0.3  0.9  29:38.90 YDService                                                                                                 
        1 root      20   0   43496   3396   2096 S   0.0  0.1   0:40.40 systemd              
        
    ·前五行 - 【信息统计区】
        -第一行：
            top - 09:46:38 up 5 days, 23:26,  1 user,  load average: 0.07, 0.07, 0.05  
            09:46:38, #当前系统的时间
            up 5 days,23:26, #系统已经运行的时长 5天23小时26分
            1 user,  #当前开启的终端数量
            load average: 0.07, 0.07, 0.05  #系统负载（分别为1分钟，5分钟，15分钟的负载值）
                -返回cpu信息：cat /proc/cpuinfo
                -返回cpu核数：grep -c 'model name' /proc/cpuinfo
                -仅返回此行命令：uptime
                -三个load先看哪个，从15分钟的看起或者从1分钟看起：
                    1）1分钟Load>5，5分钟Load<1，15分钟Load<1：短期内繁忙，中长期空闲，初步判断是一个“抖动”，或者是“拥塞前兆”
                    2）1分钟Load>5，5分钟Load>1，15分钟Load<1：短期内繁忙，中期内紧张，很可能是一个“拥塞的开始”
                    3）1分钟Load>5，5分钟Load>5，15分钟Load>5：短中长期都繁忙，系统“正在拥塞”
                    4）1分钟Load<1，5分钟Load>1，15分钟Load>5：短期内空闲，中长期繁忙，不用紧张，系统“拥塞正在好转”
                ·什么样的Load值得警惕（单核）？
                     Load < 0.7时：系统很闲，马路上没什么车，要考虑多部署一些服务
                     0.7 < Load < 1时：系统状态不错，马路可以轻松应对
                     Load == 1时：系统马上要处理不多来了，赶紧找一下原因
                     Load > 5时：马路已经非常繁忙了，进入马路的每辆汽车都要无法很快的运行
        -第二行：
            Tasks:  99 total,   1 running,  98 sleeping,   0 stopped,   0 zombie
            当前系统共有454个进程，其中有1个进程正在为用户提供服务，有453个进程在休眠状态（等待为用户提供服务），0个被停止，0个僵尸进程
        -第三行：
            %Cpu(s):  0.7 us,  0.3 sy,  0.0 ni, 98.7 id,  0.3 wa,  0.0 hi,  0.0 si,  0.0 st
            0.7 us, #用户空间占用CPU百分比
            0.3 sy, #内核空间占用CPU百分比
            0.0 ni, #用户进程空间内改变过优先级的进程占用CPU百分比
            98.7 id,#空闲CPU百分比
            0.3 wa, #等待输入输出的CPU时间百分比
            0.0 hi,
            0.0 si,
            0.0 st
        -第四行：可使用free -h 命令查看
            KiB Mem :  3880316 total,   125260 free,  1521296 used,  2233760 buff/cache
            3880316 total,   #物理内存总量
            125260 free,     #空闲内存总量
            1521296 used,    #使用内存总量
            2233760 buff/cache #用作内核缓存的内存量
        -第五行：可使用free -h 命令查看
            KiB Swap:        0 total,        0 free,        0 used.  2070916 avail Mem 
            0 total,   #交换区总量
            0 free,    #可用交换区    
            0 used.    #已使用
            2070916 avail Mem 
    ·后五行 - 【进程信息区】
        PID 进程id
        PPID 父进程id
        RUSER Real user name
        UID 进程所有者的用户id
        USER 进程所有者的用户名
        GROUP 进程所有者的组名
        TTY 启动进程的终端名。不是从终端启动的进程则显示为 ?
        PR 优先级
        NI nice值。负值表示高优先级，正值表示低优先级
        P 最后使用的CPU，仅在多CPU环境下有意义
        %CPU 上次更新到现在的CPU时间占用百分比
        TIME 进程使用的CPU时间总计，单位秒
        TIME+ 进程使用的CPU时间总计，单位1/100秒
        %MEM 进程使用的物理内存百分比
        VIRT 进程使用的虚拟内存总量，单位kb。VIRT=SWAP+RES
        SWAP 进程使用的虚拟内存中，被换出的大小，单位kb。
        RES 进程使用的、未被换出的物理内存大小，单位kb。RES=CODE+DATA
        CODE 可执行代码占用的物理内存大小，单位kb
        DATA 可执行代码以外的部分(数据段+栈)占用的物理内存大小，单位kb
        SHR 共享内存大小，单位kb
        nFLT 页面错误次数
        nDRT 最后一次写入到现在，被修改过的页面数。
        S 进程状态。
        D=不可中断的睡眠状态
        R=运行
        S=睡眠
        T=跟踪/停止
        Z=僵尸进程
        x COMMAND 命令名/命令行
        y WCHAN 若该进程在睡眠，则显示睡眠中的系统函数名
        z Flags 任务标志，参考 sched.h
        
        默认情况下仅显示比较重要的 PID、USER、PR、NI、VIRT、RES、SHR、S、%CPU、%MEM、TIME+、COMMAND 列。可以通过下面的快捷键来更改显示内容。
