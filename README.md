# JavaSE

## 学前准备

### 计算机相关基础知识

#### 十进制与二进制的相互转换

##### 十进制->二进制
- (辗转相除法)(就是十进制数一直除2,最后商为0,将余数反转)

##### 二进制->十进制
- (8421,也就是利用每一位的位权计算)

##### 十进制小数如何转化为二进制数
- **十进制整数和小数与二进制的转换举例**

- >首先我们要搞清楚下面两个问题： 
	>
	>(1) 十进制整数如何转化为二进制数 
	>
	>算法很简单。举个例子，11表示成二进制数： 
	>
	>     11/2=5 余  1 
	>    
	>      5/2=2  余  1 
	>    
	>      2/2=1  余  0 
	>    
	>      1/2=0  余  1 
	>    
	>       0结束     11二进制表示为(从下往上):1011 
	>
	>这里提一点：只要遇到除以后的结果为0了就结束了，大家想一想，所有的整数除以2是不是一定能够最终得到0。换句话说，所有的整数转变为二进制数的算法会不会无限循环下去呢？绝对不会，整数永远可以用二进制精确表示 ，但小数就不一定了。 
	>
	>(2) 十进制小数如何转化为二进制数 
	>
	>算法是乘以2直到没有了小数为止。举个例子，0.9表示成二进制数 
	>
	>     0.9*2=1.8  取整数部分 1 
	>    
	>     0.8(1.8的小数部分)*2=1.6  取整数部分 1 
	>    
	>     0.6*2=1.2  取整数部分 1 
	>    
	>     0.2*2=0.4  取整数部分 0 
	>    
	>     0.4*2=0.8  取整数部分 0 
	>    
	>     0.8*2=1.6 取整数部分 1 
	>    
	>     0.6*2=1.2  取整数部分 0 
	>    
	>         .........   0.9二进制表示为(从上往下): 1100100100100...... 
	>
	>注意：上面的计算过程循环了，也就是说*2永远不可能消灭小数部分，这样算法将无限下去。很显然，小数的二进制表示有时是不可能精确的 。其实道理很简单，十进制系统中能不能准确表示出1/3呢？同样二进制系统也无法准确表示1/10。这也就解释了为什么浮点型减法出现了"减不尽"的精度丢失问题。

- 数据存储的最小单位Byte,字节,1Byte=8bit(网速单位Mbps->下载速度MB/s的换算)

- 1KB = 1024Byte

- 1MB = 1024KB

- 1GB = 1024MB

- 1TB = 1024GB

- 1PB = 1024TB

- 1EB = 1024PB

- 1ZB = 1024EB

### 计算机命令提示符

- cd C:(win下进入C盘根目录)
- dir 显示当前路径下文件列表
- cls 清空屏幕
- exit 退出cmd

## Java语言开发环境搭建

### JVM

- java的跨平台性是说编写的java程序是跨平台的,而jvm有Windows,linux,mac版本,jvm不是跨平台的,jvm起翻译作用

### JRE&JDK

- java runtime environment包含JVM和运行时所需要的的核心类库
- java development kit java程序开发包包含jre和开发人员工具
- jvm->jre->jdk(包含关系)
- **安装注意:windows的安装选项中,公共jre不需要安装,jdk中已经包含了jre**

## HelloWorld入门程序

- javac.exe 编译器
- java.exe 解释器
- **编写源代码->编译器编译为.class java字节码文件->JVM解释器边解释边运行**
- 编写.java代码文件后,通过命令行javac HelloWorld.java(完整文件名)编译
- 运行java HelloWorld(不加后缀,运行的实际上是编译后生成的.class文件)
- 此时比如修改了.java文件的输出内容,但是没有javac重新编译,那么运行java HelloWorld,输出并不会有什么改动
- **标识符**:程序中自己定义的内容叫做标识符,比如类名,方法名,变量名等(命名规范:大小驼峰式命名)
- **类名一般用大驼峰式命名,方法,变量名用小驼峰式命名**

## 一些基本概念理清

- **常量**:在程序运行期间,固定不变的量(字符串常量"123",整数常量123,浮点数常量0.1,字符常量'a',布尔常量true,空常量null)

- **java只有两种数据类型:基本数据类型和引用数据类型**,不是基本类型就是引用数据类型

- 基本数据类型:4类8种

- 4类:整数型(byte short int long),浮点型(float double),布尔型(boolean),字符型(char)

- byte叫字节型,char叫字符型

- int 4Byte long 8Byte short 2Byte byte 1Byte

- float 4Byte double 8Byte

- char 2Byte

- boolean 1Byte

- 引用数据类型包括比如:字符串,数组,类,接口,lambda

- 字符串不是基本类型,而是引用类型

- 数据范围不一定取决于字节数,比如float数据范围比long更大,但是float只有4字节,long是8字节

#### (重要)为什么float的4个字节比long类型的8个字节的范围大?

#### (重要)如何处理float,double的精度丢失问题?

- *首先要搞懂最上面的十进制整数与小数和二进制的转换问题*

- *然后要搞懂float型在内存中的存储结构*

- > 0-22位存储有效数位
	> 23-29位存储指数位
	> 30存储指数符号位
	> 31存储实数符号位

- *然后弄懂如何将一个float型转化为内存中的存储格式*

- >   （1）先将这个实数的绝对值化为二进制格式，注意实数的整数部分和小数部分的二进制方法在上面已经探讨过了。 
	>   （2）将这个二进制格式实数的小数点左移或右移n位，直到小数点移动到第一个有效数字的右边。 
	>   （3）从小数点右边第一位开始数出二十三位数字放入第22到第0位。 
	>   （4）如果实数是正的，则在第31位放入“0”，否则放入“1”。 
	>   （5）如果n是左移得到的，说明指数是正的，第30位放入“1”。如果n是右移得到的或n=0，则第30位放入“0”。 
	>   （6）如果n是左移得到的，则将n减去1后化为二进制，并在左边加“0”补足七位，放入第29到第23位。如果n是右移得到的或n=0，则将n化为二进制后在左边加“0”补足七位，再各位求反，再放入第29到第23位。

- *可以通过下面两个例子来理解转化过程*

- > 举例说明： 11.9的内存存储格式
	>
	> ​    (1) 将11.9化为二进制后大约是" 1011.1110011001100110011001100..."。
	>
	> ​    (2) 将小数点左移三位到第一个有效位右侧： "1. 011 11100110011001100110 "。 保证有效位数24位，右侧多余的截取（**误差在这里产生了** ）。
	>
	> ​    (3) 这已经有了二十四位有效数字，将最左边一位“1”去掉，得到“ 011 11100110011001100110 ”共23bit。将它放入float存储结构的第22到第0位。
	>
	> ​    (4) 因为11.9是正数，因此在第31位实数符号位放入“0”。
	>
	> ​    (5) 由于我们把小数点左移，因此在第30位指数符号位放入“1”。
	>
	> ​    (6) 因为我们是把小数点左移3位，因此将3减去1得2，化为二进制，并补足7位得到0000010，放入第29到第23位.
	>
	> 最后表示11.9为： 0 1 0000010 011 11100110011001100110
	>
	> 
	>
	> 再举一个例子：0.2356的内存存储格式
	> （1）将0.2356化为二进制后大约是0.00111100010100000100100000。 
	> （2）将小数点右移三位得到1.11100010100000100100000。 
	> （3）从小数点右边数出二十三位有效数字，即11100010100000100100000放
	> 入第22到第0位。 
	> （4）由于0.2356是正的，所以在第31位放入“0”。 
	> （5）由于我们把小数点右移了，所以在第30位放入“0”。 
	> （6）因为小数点被右移了3位，所以将3化为二进制，在左边补“0”补足七
	> 位，得到0000011，各位取反，得到1111100，放入第29到第23位。 
	>
	> 最后表示0.2356为：0 0 1111100 11100010100000100100000

- *然后弄懂如何将一个内存存储的float二进制格式转化为十进制的步骤*

- >   （1）将第22位到第0位的二进制数写出来，在最左边补一位“1”，得到二十四位有效数字。将小数点点在最左边那个“1”的右边。 
	>   （2）取出第29到第23位所表示的值n。当30位是“0”时将n各位求反。当30位是“1”时将n增1。 
	>   （3）将小数点左移n位（当30位是“0”时）或右移n位（当30位是“1”时），得到一个二进制表示的实数。 
	>   （4）将这个二进制实数化为十进制，并根据第31位是“0”还是“1”加上正号或负号即可。

- *然后大致看一下如何进行浮点型的减法运算*

- > 浮点加减运算过程比定点运算过程复杂。完成浮点加减运算的操作过程大体分为四步：  
	> (1) 0操作数的检查；
	>
	> ​      如果判断两个需要加减的浮点数有一个为0，即可得知运算结果而没有必要再进行有序的一些列操作。 
	>
	> 　(2) 比较阶码（指数位）大小并完成对阶；
	>
	> ​      两浮点数进行加减，首先要看两数的 **指数位** 是否相同，即小数点位置是否对齐。若两数 指数位 相同，表示小数点是对齐的，就可以进行尾数的加减运算。反之，若两数阶码不同，表示小数点位置没有对齐，此时必须使两数的阶码相同，这个过程叫做**对阶** 。
	>
	> ​      如何对阶(假设两浮点数的指数位为 E*x* 和 E*y* )：
	>
	> ​      通过尾数的移位以改变 E*x* 或 E*y* ，使之相等。 由 于浮点表示的数多是规格化的，尾数左移会引起最高有位的丢失，造成很大误差；而尾数右移虽引起最低有效位的丢失，但造成的误差较小，因此，对阶操作规定 使尾数右移，尾数右移后使阶码作相应增加，其数值保持不变。很显然，一个增加后的阶码与另一个相等，所增加的阶码一定是小阶。因此在对阶时，总是使**小阶向大阶看齐** ，即小阶的尾数向右移位 ( 相当于小数点左移 ) ，每右移一位，其阶码加 1 ，直到两数的阶码相等为止，右移的位数等于阶差 △ E 。 
	> 　(3) 尾数（有效数位）进行加或减运算；
	>
	> ​        对阶完毕后就可有效数位求和。 不论是加法运算还是减法运算，都按加法进行操作，其方法与定点加减运算完全一样。 
	> 　(4) 结果规格化并进行舍入处理。 

- 简单举例

- >  计算12.0f-11.9f
	>
	>  12.0f 的内存存储格式为：  0 1 0000010 10000000000000000000000   
	>  11.9f 的内存存储格式为:   0 1 0000010 011 11100110011001100110
	>  可见两数的指数位完全相同，只要对有效数位进行减法即可。
	>  12.0f-11.9f  结果：     0 1 0000010 00000011001100110011010
	>  将结果还原为十进制为： 0.000 11001100110011010= **0.10000038**

- 结论1,因此float浮点型和long的内存存储结构完全不同,long的最大值为2^63-1(==**解释:不要混淆最高位的阶数,第64位实际上是2^63次方,这是从0开始的2的阶数,同时2^63-1刚好是除符号位全为1的情况,这也就是正数的最大值就是2^63-1,因为如果符号位为0其他全为1此时加1,那么就是符号位变为1,其他位全为0,那么这个值刚好可以表示-2^63,也就是最小值,至于为什么这个值代表负数的最小值,因为符号位1,其他位为0,也只能当成-0,但哪有-0这个说法,同时取反加一也本来就是-2^63**==),最小值是-2^63(解释:见正数解释即可理解),而float因为设计原因,实际上大致在2^128-1

- 结论2,因为float会出现十进制小数化为二进制乘不完的情况,那么自然就会出现截断,那么精度丢失避免不了

- 避免丢失精度的两种方法:

- >解决方法1
	>
	>如果不介意自己记录十进制的小数点，而且数值不大，那么可以使用long ，int等基本类型，具体用int还是long要看涉及的数值范围大小，缺点是要自己处理十进制小数点，最明显的做法就是处理货币使用分来计算，而不用元（只涉及加减）。
	>
	>如：
	>
	>```java
	>int resultInt = 10- 9; 
	>double result = (double) resultInt / 100;//最终时候自己控制小数点 
	>```
	>
	>解决方法2
	>
	>使用BigDecmal，而且需要在构造参数使用String类型。
	>
	>在《Effective Java》这本书中就给出了一个解决方法。该书中也指出，float和double只能用来做科学计算或者是工程计算，在商业计算等精确计算中，我们要用java.math.BigDecimal。
	>
	>BigDecimal类一个有4个方法，我们只关心对我们解决浮点型数据进行精确计算有用的方法，即
	>
	>```java
	>BigDecimal(double value) // 将double型数据转换成BigDecimal型数据
	>```
	>
	>思路很简单，我们先通过BigDecimal(double value)方法，将double型数据转换成BigDecimal数据，然后就可以正常进行精确计算了。等计算完毕后，我们可以对结果做一些处理，比如 对除不尽的结果可以进行四舍五入。最后，再把结果由BigDecimal型数据转换回double型数据。
	>
	>这个思路很正确，但是如果你仔细看看API里关于BigDecimal的详细说明，你就会知道，如果需要精确计算，我们不能直接用double，而非要用 String来构造BigDecimal不可！所以，我们又开始关心BigDecimal类的另一个方法，即能够帮助我们正确完成精确计算的 BigDecimal(String value)方法。
	>
	>```java
	>BigDecimal(String value)能够将String型数据转换成BigDecimal型数据
	>```
	>
	>那么问题来了，想像一下吧，如果我们要做一个浮点型数据的加法运算，需要先将两个浮点数转为String型数据，然后用 BigDecimal(String value)构造成BigDecimal，之后要在其中一个上调用add方法，传入另一个作为参数，然后把运算的结果（BigDecimal）再转换为浮 点数。如果每次做浮点型数据的计算都要如此，你能够忍受这么烦琐的过程吗？至少我不能。所以最好的办法，就是写一个类，在类中完成这些繁琐的转换过程。这样，在我们需要进行浮点型数据计算的时候，只要调用这个类就可以了。网上已经有高手为我们提供了一个工具类Arith来完成这些转换操作。它提供静态方法，可以完成浮点型数据的加减乘除运算和对其结果进行四舍五入的操作

### 上面两个问题结束

- 浮点型只是一个近似值,并非精确值

- 浮点数当中默认类型是double,使用float类型数据,要在数据后加F/f,推荐使用大写字母后缀

- 整数默认是int,如果用long,要加L后缀

- float或者long类型,千万不要赋值时忘记写后缀

- 作用域:从定义变量的一行开始,一直到直接所属大括号结束,也就是说下面这种情况要注意,会报错

- ```java
	System.out.println(num);
	int num = 2;
	```

### 数据类型转换

- java包括自动类型转换和强制类型转换两种(隐式和显式)

- 从小到大自动转换规则`long l = 100;`发生int->long的自动转换

- `float f = 30L`也会发生自动转换哦!

- 范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据; 强制类型转换语法

- `int num = (int) 100L;`就不会报错了,但是超出范围后会出现**数据溢出**,随便编译不会出错,但是实际执行会发生数据截断,就不是我们需要的值了(注意:溢出也并不是int的最大值)

- `int num = (int) 3.99; //num实际是3`,发生了**精度丢失,不会发生四舍五入而是所有的小数都会损失掉**

- **byte/short/char三种类型都可以发生数学运算,都是先转换为int类型,然后在计算**

- 一旦char类型发生了数学运算,那么字符会按照编码表翻译为一个数字(指直接用计算表达式作为输出等情况 比如输出`char a + 1`)

- ```java
	byte b1 = 40;
	byte b2 = 50;
	byte result = b1 + b2;
	System.out.println(result); //会报错,int转换为byte会损失精度
	//因为会b1+b2就是byte发生了数学运算的情况,那么会被提升为两个int来计算,而计算的结果也是int类型,不通过强制转换,将int赋值给byte类型的result,自然发生了错误
	//解决办法可以要么 用int result接受结果
	//要么byte result = (byte) (b1+b2);
	```

- **Java中的boolean类型不能发生数据类型转换,不能当成1/0来对待,严格规定**

### 编码表

#### ASCII码表和Unicode码表,万国码

- 记住三个数字 ==**48代表'0' 57代表'9'  65代表'A' 90代表'Z'  97代表'a' 122代表'z'**==(**这里弄懂一直以来的模糊点,若97代表'a',那么97就是'a'了,相当于26个字母已经占去一个了,还剩下25个字母,所有推出'z'应该是97+25,也就是122**)

- 数字和字符的对照关系表(编码表)

- ```java
	char zifu = '中';
	System.out.println(zifu+0); //输出为20013 程序是正确的写法
	```

- Unicode 0-127和ASCII完全一样

#### ==面试题: Java中,char型变量中能不能存储一个中文汉字,为什么？==

- 因为Java的char类型是用来存储Unicode编码的字符的,Unicode编码字符集中是包含中国字的
- 也就是说,Java采用Unicode,2个字节来表示一个字符,所以char类型在java中也是2个字节存储空间
- char和Byte不要搞混

### 运算符

- 整数的除法不涉及四舍五入等概念,就是整数除整数等于整数,结果就只看商,不看余数,所以并不存在向上向下取整概念

- %取模运算,取余数,只对整数的除法有意义,小数不会报错,但没有意义

- 运算中一旦有不同的数据类型,那么结果就是数据范围较大的类型

- 任何数据类型和String进行'+'操作,结果都会变为String,比如`String s = "java"+20;//结果就是java20(字符串)`

- 只有变量才能用自增自减,常量不可发生改变,不可以用,同理常量不能位于赋值=左边

- ```java
	byte num = 30;
	num += 5;
	//实际发生了,byte + int -> int + int -> num = int -> (编译器自动) num = (byte) int
	```

- 比较运算符结果一定是boolean值

- 多次比较一定不能连着写

- "%%"和"||"具有**短路功能**,如果左边已经可以得到最终结果,那么右边代码将不会执行

- 三元运算符一定要保证两个表达式都符合左侧数据类型要求(要么本来就是同数据类型,要么手动强转,要么满足隐式转换)

- 三元运算必须被使用,要么被当做表达式作为参数,要么赋值给变量,单独写成一条语句 `a>b:a,b;`是会报错的

### 方法入门

- **方法必须在类中定义,并且是在这个类原本的方法外,就比如最基本的Demo类的main方法内就不能再定义方法了,因为main本来就是一个function了**
- **方法不能定义在另一个方法的里面**

### JShell(JAVA9新特性)

- 类似于各种shell界面,就是不需要编译等过程了,不需要定义类,main方法等,直接写代码语句即可,适合某些场景测试代码,及其简单的代码

### ==编译器为类型转换做的两点优化(编译器的常量优化,编译器对byte/char/short单次运算的默认强转)==

- 还是之前遇见过的问题

- ```java
	byte num = 30; //这是正确的写法
	byte num2 = 128; //这会报错int->byte精度损失错误
	```

- **右侧确实是将int类型,赋值给左侧byte类型,但是没有超出左侧的数据范围,但是int->byte并不是自动类型转换,这是为什么?**

- 这是因为对于byte/char/short三种类型来说,如果右侧赋值没有超过范围,那么javac编译器会自动隐式的为我们补上一个(byte)类似的强制类型转换,若超出范围则会报错

- **再分析一个问题**(==编译器对byte/char/short单次运算的默认强转==)

- ```java
	short s = 1;
	// s = s + 1;报错 int->short类型转换精度损失报错
	s+=1; //并不会报错
	```

- ==`s += 1` 逻辑上是看做 `s = s+1`,而s = s + 1;实际上是 short + int -> int + int(发生了小范围到大范围的转换) -> short = int(报错),不能将大数据范围类型赋值到小取值范围类型上去,但是 s = s + 1;实际上发生了两次运算,而+=是一个运算符,只运行一次,并且javac对这种运算有强制转换的自动完成,所以s+=1;实际应该等价于 s = (short)(s+1);并不会报错==

- **再分析一个问题**(==编译器的常量优化==)

- ```java
	byte b1 = 1;
	byte b2 = 2;
	byte b3 = 1 + 2; //不会报错
	byte b4 = b1 + b2; //报错 int->byte损失错误
	byte b5;
	b5 += b2; //并不会报错
	```

- ==分析:这是因为b3的赋值右侧是两个常量,是固定不变的数据,那么在编译的时候,编译器javac实际上已经确定了1+2的结果没有超过byte的取值范围,并且编译之后.class字节码直接就运算了byte b3 = 3;编译的时候就已经运算出了结果,不需要运行的时候再去运算消耗CPU性能,而b4右侧的赋值是两个变量,(即使是一个变量),编译器无法确定结果是什么,那么只能将发生了运算的byte + byte -> int + int ->int,编译器只能将结果以int类型处理,所以会报错,而最后一句 += 依然是编译器默认做了一个强制类型转换,所以依然不会报错(上个问题)==

### 执行流程(顺序,选择,循环结构)

- switch语句中,表达式的数据类型可以是byte short int char enum,JDK7版本后可以接收字符串

- ```java
	switch(表达式){
		case 常量值:
	        //语句体
	        break;
	    case 常量值:
	    	//语句体
	        break;
	    default:
	    	//语句体
	        break;
	}
	```

- **case的穿透性**,如果case中不写break,将出现穿透现象,也就是不会再判断下一个case的值,直接向后运行,直到遇见break,或者整体switch结束

- **for和while的小区别**  

- >控制条件语句所控制的那个变量，在for循环结束后，就不能再被访问到了，而while循环结束还可以继
	>续使用，如果你想继续使用，就用while，否则推荐使用for。原因是for循环结束，该变量就从内存中消
	>失，能够提高内存的使用效率。
	>在已知循环次数的时候使用推荐使用for，循环次数未知的时推荐使用while。 

- **break**:终止switch或者循环

- **continue**:结束本次循环,继续下次循环

### 方法进阶

- **方法只能定义在类当中,不能定义在方法中**
- **方法定义的前后顺序无要求**
- **一个方法中可以有多个return,但要确保只有一个return会被执行**
- return后面不要写代码,return意味方法结束,return后面的代码不会被执行
- 方法的调用主要有三种,直接调用,赋值调用,输出语句调用(**输出语句调用时,不能在输出语句中调用void类型方法,会报错**)

### (重要)方法重载

- **指在同一个类中，允许存在一个以上的同名方法，只要它们的参数列表不同即可，与修饰符和返回值类型无关。下面前四个语句都是正确的重载,只需要参数列表不同**

- ```java
	public static void open(int i){}
	public static void open(int i,int j){}
	static void open(){}
	public static int(int i,int j,int k){}
	
	public static int open(int i){} //错误,和返回类型无关
	static void open(int i){} //错误,和修饰符无关
	public void open(int a ,int b){} //错误,和参数名称无关
	```

- 参数列表：个数不同，数据类型不同，顺序不同。

- 重载方法调用：JVM通过方法的参数列表，调用不同的方法。 

### 数组

- **数组有定长特性,长度一旦指定,不可更改**

- 数组中的元素必须全是统一的类型

- 数组有两种初始化方法:动态初始化(指定长度)和静态初始化(不直接指定长度,而是直接指定内容,还有省略格式的静态初始化),静态初始化的长度就是指定内容的元素个数

- ```java
	int[] a = new int[100]; //动态初始化
	int[] b = new int[]{1,2,3}; //静态初始化 数组长度为3
	int[] c = {1,2,3}; //省略格式静态初始化 数组长度为3
	```

- 数组的长度属性： 每个数组都具有长度，而且是固定的，Java中赋予了数组的一个属性，可以获取到数组的
	长度，语句为： **数组名.length** ，属性length的执行结果是数组的长度，int类型结果。由次可以推断出，数
	组的最大索引值为 数组名.length-1。

- **静态,动态初始化都可以拆分为两个步骤,但是静态初始化的省略格式不能拆分了两个步骤,也就是java补充笔记中提到的数组字面量可以拆开写,但是数组初始化方式(也就是静态初始化的省略格式)不可以分开写**

- **直接打印数组名称,得到的是数组对应的内存地址的哈希值**

- **使用数组的动态初始化的时候,其中的元素会自动被赋予一个默认值**

- > 如果是整形,默认为0
	>
	> 如果是浮点型,默认为0.0
	>
	> 如果是字符类型,默认为'\u0000'其中\u代表Unicode,也就是Unicode中十六进制表示为0000的字符,'\u0000'是不可见字符
	>
	> 如果是布尔类型,默认为false
	>
	> 如果是引用类型,默认为null

- **静态初始化的时候其实也有默认值的赋予过程,只不过系统自动将默认值替换为大括号中的具体数值**

### (重要)Java内存划分

- Java的JVM要运行程序,那就就必须对内存进行空间的分配和管理

- Java内存划分为5个部分

- > 1.**栈(Stack):存放的是方法中的局部变量**
	>
	> 局部变量:方法的参数,方法内部的变量
	>
	> 作用域:一旦超出作用域了,立刻从栈内存空间中消失
	>
	> 2.**堆(Heap):凡是new出来的东西,都在堆内存当中**
	>
	> 堆内存里面的东西都有一个地址值:16进制
	>
	> 堆内存中的数据都是有默认值的,规则等同于数组
	>
	> 如果是整形,默认为0
	>
	> 如果是浮点型,默认为0.0
	>
	> 如果是字符类型,默认为'\u0000'其中\u代表Unicode,也就是Unicode中十六进制表示为0000的字符,'\u0000'是不可见字符
	>
	> 如果是布尔类型,默认为false
	>
	> 如果是引用类型,默认为null
	>
	> 3.**方法区(Method Area):存储.class相关信息,包含方法的信息**
	>
	> 只是包含了方法的信息,真正方法的运行是在栈内存中进行
	>
	> 4.**本地方法栈(Native Method Stack):与操作系统相关**
	>
	> 5.**寄存器(register):与CPU相关**

- ```java
	public class Demo{
		public static void main(String[] args){
			int[] arr = new int[3];
			System.out.println(arr);
		}
	}
	```

- ==程序执行在内存中的流程：==

- >  1.main方法进入方法栈执行(方法栈中存储public static void main(String[] args),记录方法信息,包括方法名字,返回值是什么,参数是什么等),同时为main方法在栈内存中开辟一块空间(main进入栈内存,进栈)
	>
	>  2.栈内存中创建数组(int[] arr)，然后JVM会在堆内存中开辟空间，存储数组(new int[3]就在堆内存中),**也就是说new出的数组在堆当中,但是声明的变量在栈当中**,**栈空间中变量存储的就是堆空间中数组在内存的首地址值(0x1abacvvv)**
	>  3.数组在内存中会有自己的内存地址，以十六进制数表示
	>  4.数组中有3个元素，默认值0
	>  5.JVM将数组的内存地址赋值给引用类型变量arr
	>  6.变量arr保存的是数组内存中的地址，而不是一个具体是数值,因此称为引用数据类型。

- 两种常见数组错误

- java.lang.ArrayIndexOutOfBoundsException数组索引越界异常

- 所有的引用类型变量都可以赋值一个null值,代表其中什么都没有,数组必须new才可以使用其中的元素,如果只是赋值null就想使用其中**元素**,那么就会发生空指针异常java.lang.NullPointerException

- ```java
	int[] a = null;
	System.out.println(a); //正确输出null
	System.out.println(a[0]); //报错 java.lang.NullPointerException
	```

- ==方法的参数为基本类型时,传递的是数据值. 方法的参数为引用类型时,传递的是地址值.==(也就是说java的方法参数为基本类型,值传递,为引用类型时,为地址值的传递)

- 所以说数组作为方法参数传入的是地址值,作为方法的返回值返回的也是数组的地址值

# Java进阶

## 面向对象

### 基础概念

- 这里的**对象**泛指现实中一切事物，每种事物都具备自己的**属性**和**行为**。面向对象思想就是在计算机程序设计过程中，参照现实中事物，将事物的属性特征、行为特征抽象出来，描述成计算机事件的设计思想。 它区别于面向过程思想，强调的是通过调用对象的行为来实现功能，而不是自己一步一步的去操作实现。  

- 面向过程:当实现一个功能时,每一个步骤亲力亲为,详细处理每一个细节,每一个工作步骤都要自己完成
- 面向对象:当实现一个功能时,不关心具体的步骤,而是找一个可以实现这个功能的对象帮我完成这个事情
- **面向对象的三大基本特征:封装,继承,多态**

### 类和对象

- 类：是一组相关属性和行为的集合。可以看成是一类事物的模板，使用事物的属性特征和行为特征来描述该类事物

- >属性：就是该事物的状态信息。
	>行为：就是该事物能够做什么。  
	>
	>举例：小猫。
	>属性：名字、体重、年龄、颜色。 行为：走、跑、叫。  

- 对象：是一类事物的具体体现。对象是类的一个实例，必然具备该类事物的属性和行为  

- >现实中，一类事物的一个实例：一只小猫。
	>举例：一只小猫。
	>属性：tom、5kg、2 years、yellow。 行为：溜墙根走、蹦跶的跑、喵喵叫。  

- **类是对一类事物的描述，是抽象的。对象是一类事物的实例，是具体的。类是对象的模板，对象是类的实体。**  

- 成员变量是定义在类当中的,在方法的外面(不同于方法中的局部变量)

- 一般情况下,一个类不能直接使用,需要根据类创建一个对象(类方法不用),才能使用,这样需要三个步骤:

- **导包(就是导入类所在的位置,package的建立就是这样的意义,导包就是导入package)**->创建对象->使用

- 如果成员变量没有进行赋值,那么将会有一个默认值,(基本数据类型+String)规则等同于数组章节的默认值

### 类-对象内存图

#### ==单个对象的调用方法内存流程==

- ```java
	//Phone.java文件
	public class Phone{
		String brand;
		int price;
		String color;
		
		public void sendMessage(String who){
			System.out.println("给"  + who + "发送短信");
	    }
	}
	//另一个Demo文件的代码
	public class Demo{
	    public static void main(String[] args){
	        Phone p = new Phone();
	        p.brand = "锤子";
	        p.price = 2999;
	        p.color = "棕色";
	        p.sendMessage("jackson");
		}
	}
	```

- 运行main方法之前,方法区(Method Area)中最先有数据,方法区先保存.class相关数据

- 此时一共两个.class,一个是Phone.class{里面包含成员变量和成员方法信息} Demo.class{里面包换main方法信息},此时两个.class都在方法区中,有main方法的先开始

- main方法想运行就要进栈(又称压栈)

- 而实际上对象Phone p就**好比是**一个main方法的变量类型为Phone和名称为p的局部变量,用来保存内容

- 而保存的内容就是右侧的new产生的东西,new出的东西都在堆当中,此时堆中就new出了一个对象Phone,并不知道Phone中到底有什么内容,而Phone的内容实际就在方法区当中,Phone.class会告诉有三个成员变量还有两个成员方法,并且附上一些默认值

- **成员变量就会被参考着对应放在堆new的Phone对象中,然后会为成员变量附上默认值(==在堆中完成,也就是为String brand赋默认值null,这个null就在堆当中,但堆当中的成员方法是一个地址值,指向方法区内对应方法==)**

- **成员方法也被参考着对应放在堆new的Phone对象中,但成员方法不同的是,对于堆中创建一个对象来说,成员方法保存的实际上是一个地址值,当在创建对象时,实际上是方法区当中的成员方法的地址值保存在堆当中,(也就是说堆当中的new Phone()的成员方法保存的是一个地址值,指向方法区中的call和message方法,而方法区当中存放的是成员方法的信息)**

- 此时堆中new Phone()对象成员变量有个,成员方法也有了,并且在堆中有地址,所以栈中存储的就是这个堆中创建的对象的地址

- 然后p.brand = "锤子";就会根据p找到Phone p的地址是多少,然后就会进入堆中找到brand,然后就会修改默认值null为"锤子"

- ==而p.sendMessage(String who);就是根据p找到Phone p的地址是多少,然后进入堆中找对应的成员方法的地址,然后在通过这个地址进入方法区中找对应的sendMessage(String who)方法==,然后sendMessage方法想运行也是要进栈的,压入栈中(在main之前),而此时调用的参数为jackson,所以就会输出给jackson发短信,然后sendMessage方法调用结束,就会弹出栈,从栈内存中消失

- 然后达到main方法最后一行,然后程序运行结束

#### ==两个对象调用同一个方法内存图==

- 通过上面流程，我们可以理解，在栈内存中运行的方法，遵循"先进后出，后进先出"的原则。变量p指向堆内存中的空间，寻找方法信息，去执行该方法。

- 但是，这里依然有问题存在。创建多个对象时，如果每个对象内部都保存一份方法信息(意思是方法区内多个重复的方法信息,不同的地址)，这就非常浪费内存了，因为所有对象的方法信息都是一样的。那么如何解决这个问题呢？

- ```java
	//同一个类中创建多个对象,并分别调用sendMessage方法
	Phone p1 = new Phone();
	Phone p2 = new Phone();
	```

- 此时,还是方法区载入两个.class,然后有main方法的先入栈,main方法入栈,执行上面两个对象的new(相当于两个局部变量),然后在堆中创建两个对象,其中最重要的就是堆内存中两个对象是两个不同的地址,但是堆中两个new Phone对象的成员方法都存的是方法区中对应方法的地址,是相同的,所以并不需要方法区内多个重复的方法信息

- 对象调用方法时，根据对象中方法标记（地址值），去类中寻找方法信息。这样哪怕是多个对象，方法信息只保存一份,节约内存空间

#### 一个引用,作为参数传递到方法中内存图

- 引用类型作为参数，传递的是地址值 ,所以就是比如有一个show(Phone p)方法,参数是一个引用类型,那么p传入的就是栈内存中Phone p存储的指向堆空间中的地址值

### ==成员变量和局部变量的不同==

- >**在类中的位置不同** 重点
	>成员变量：类中，方法外
	>局部变量：方法中或者方法声明上(形式参数),也就是**方法的参数也是局部变量**
	>**作用范围不一样** 重点
	>成员变量：类中
	>局部变量：方法中
	>**初始化值的不同** 重点
	>成员变量：有默认值
	>局部变量：没有默认值。必须先定义，赋值，最后使用
	>**在内存中的位置不同** 了解
	>成员变量：堆内存
	>局部变量：栈内存
	>**生命周期不同** 了解
	>成员变量：随着对象的创建而存在，随着对象的消失而消失
	>局部变量：随着方法的调用而存在，随着方法的调用完毕而消失  

- ```java
	public class Demo{
		String name;
		public void method1(int param){
			int age;
			System.out.println(name); //正确,因为name成员变量是有默认值的
			System.out.println(age); //错误,局部变量age在栈内存中,不进行初始化肯定不会在堆中有对应值,那么肯定会报错
	        System.out.println(param); //正确,方法参数虽然也是局部变量,但参数在方法调用的时候,必然会被赋值的,因为如果没赋值那么就又变成上一个错误,调用这个方法的方法传入的局部变量没有赋值
		}
	}
	```

### 封装性

- 方法就是一种封装

- 关键字private也是一种封装

- >面向对象编程语言是对客观世界的模拟，客观世界里成员变量都是隐藏在对象内部的，外界无法直接操作和修改。封装可以被认为是一个保护屏障，防止该类的代码和数据被其他类随意访问。要访问该类的数据，必须通过指定的方式。适当的封装可以让代码更容易理解与维护，也加强了代码的安全性。  

- 封装原则:将**属性隐藏**起来，若需要访问某个属性，**提供公共方法**对其访问。 

- 封装步骤:

- > 1. ==使用 private 关键字来修饰成员变量。(保护性详见下面例程)==
	> 2. 对需要访问的成员变量，提供对应的一对 getXxx 方法 、 setXxx 方法。  

- ```java
	public class Person{
		int age; //这么写也对,但是这样定义的Person无法阻止不合理的数值被设置进来,比如在外通过Person p = new Person();p.age = 10000;这样就对Person这个类没有保护性
		String name;
	}
	```

- 一旦使用private进行修饰,那么本类当中可以访问,超出本类范围就无法直接访问了(直接访问就是p.age这样访问)

- ==成员内部类里面为什么不能有静态成员和方法?==

- > **非静态内部类不能有静态成员**
	>
	> **成员内部类必须先实例化外部类对象然后再实例化成员内部类**
	>
	> 
	>
	> **非static的内部类，在外部类加载的时候，并不会加载它，所以它里面不能有静态变量或者静态方法**。
	>
	> 1. static类型的属性和方法，在类加载的时候就会存在于内存中。
	> 2. 要使用某个类的static属性或者方法，那么这个类必须要加载到jvm中。
	> 3. 基于以上两点，可以看出，如果一个非static的内部类如果具有static的属性或者方法，那么就会出现一种情况：内部类未加载，但是却试图在内存中创建static的属性和方法，这当然是错误的。原因：类还不存在，但却希望操作它的属性和方法。
	>
	>  
	>
	> **java很多想这类不能共同存在的 一般都与他们的生命周期有关**
	> 比如 静态成员和静态方法是随着类的加载而存在的，也就是说内部类的静态属性是随着类的加载的，但是内部类的实例 是创建后才存在的，也就是说其静态属性优先存在于他的类实例的存在 这显然是矛盾的，所以要把内部类设为静态的 这样他们的生命周期就是相同了
	>
	>  
	>
	> 如果内部类没有static的话，就需要实例化内部类才能调用，说明非static的内部类不是自动跟随主类加载的，而是被实例化的时候才会加载。
	> 而static的语义，就是主类能直接通过内部类名来访问内部类中的static方法，而非static的内部类又是不会自动加载的，所以这时候内部类也要static，否则会前后冲突。

- ==为什么静态成员、静态方法（static）中不能用this和super关键字==

- ```java
	public class CodeNovice {
	    private String name;
	    private int age;
	    public static void main(String[] args) {
	        int param;
	        CodeNovice c = new CodeNovice();
	        method3();
	
	    }
	    public void method2(int param){
	        System.out.println(param);
	    }
	    public static void method3(){
	        this.name = "";//报错,'java.com.chenxin.base.CodeNovice.this' cannot be referenced from a static context
	    }
	}
	```

- 

- >因为this代表的是调用这个函数的对象的引用,而静态方法是属于类的,不属于对象,静态方法成功加载后,对象还不一定存在
	>
	>首先要明白对象和类的区别.**this和super是属于对象范畴的东西，而静态方法是属于类范畴的东西**,所有的成员方法,都有一个默认的的参数this(即使是无参的方法),只要是成员方法,编译器就会给你加上this这个参数如:
	>Class A中 void method1(){}实际上是这样的--------> void method1(A this)
	>void method2(int x){}实际上是这样的--------> void method2(A this, int x)
	>而静态方法与对象无关,根本不能把对象的引用传到方法中,所以不能用this

- ==**为什么java的静态方法中不能有静态变量?**==

- **==为什么静态方法内不能调用类的成员变量和方法==**

- ```java
	public class CodeNovice {
	    private String name;
	    private int age;
	    public static void main(String[] args) {
	        int param;
	        CodeNovice c = new CodeNovice();
	        method3();
	
	    }
	    public void method2(int param){
	        System.out.println(param);
	    }
	    public static void method3(){
	        static int a = 1; //报错,静态成员方法内不能声明静态变量
	    }
	}
	```

- 静态变量是类级别的，不能成方法中定义

- 静态变量只能定义在类的内部，不可以定义在静态块或方法中

- 可以在类内部定义静态变量，在静态块中进行初始化操作，因为类的内部是不允许有操作语句存在的

- 在方法内部定义的叫“局部变量”，而不是静态变量，局部变量不能加static，包括protected, private, public这些也不能加。静态变量是定义在类中，方法体外面的。

- **如果清楚JVM，应该知道局部变量是保存在栈中的，而静态变量保存于方法区，局部变量出了方法就被栈回收了，而静态变量不会，所以在局部变量前不能加static关键字**

- >static 静态方法里 定义的就是静态的变量，只不过作用域只在方法内
	>
	>
	>
	>**静态成员（属性和方法）都是类特有的，是为了各个对象共享数据的**。比如静态变量，不属于任何一个具体的类的实例，而是属于类的。所以在使用的时候，就不需要先进行实例化，而后再去使用该变量（因为那样的变量只属于某个实例），直接Class.Property就可属以使用它
	>
	>
	>
	>==而如果加入可以在静态方法中使用成员变量,不就相当于我不依赖于实例化对象,即使没有对象,我依然可以访问name,age,那这不是根本就不合理么,没有实例化就没有new,没有new就不会再堆中创建对象,没有创建对象,怎么又可能访问name,age?==

- ==所以并不是成员方法不能声明为static静态的,而是声明为静态的方法应该称之为类方法,类方法不应该依存于类中动态的成员变量和成员方法==

- ```java
	public class CodeNovice {
	    private String name;
	    private int age;
	    public static void main(String[] args) {
	        method3();//直接在静态方法中调用为了公用的类方法(静态方法)
	        int param;
	        CodeNovice c = new CodeNovice();
	    }
	    public void method2(int param){
	        method3(); //直接在动态的成员方法中调用为了公用的类方法(静态方法)
	        System.out.println(param);
	    }
	    public static void method3(){
	        System.out.println("欢迎使用本程序");
	    }
	}
	```

- 就像上面的程序一样,静态方法method3()就是设计的一个不依存成员变量的类方法

#### this关键字(解决重名)

- 当方法的局部变量和类的成员变量重名的时候,根据就近原则,优先使用局部变量
- 所以通过this.成员变量名
- **解决局部和成员变量的重名问题**
- 通过哪一个对象调用的this,那么谁就是this

#### 构造方法

- 构造方法是专门用于创建对象的方法,当通过关键字new来创建对象时,其实就是在调用构造方法

- `Person person = new Person();`不就是相当于调用了构造方法 

- ```java
	public class Student{
		public Student(){ //public 类名称(参数类型 参数名称){ 方法体 } 
			//方法体
		}
	}
	```

- 构造方法的名称必须和类名称一模一样

- 构造方法不需要返回值类型

- 构造方法不能return一个具体的返回值

- 构造方法不通过.方法名称()来调用

- 构造方法的用途就是用于创建对象的

- **构造方法就是通过new 构造方法名称();来调用的,new 对象就是在调用构造方法**

- **如果没有编写任何构造方法,编译器会默认生成一个无参构造方法,方法体内什么事情都不做**

- **一旦编写了至少一个构造方法,那么编译器将不会生成默认的无参构造方法了**

- 构造方法可以重载

#### 标准类(JavaBean)

- JavaBean 是 Java语言编写类的一种标准规范。
- **符合 JavaBean 的类，要求类必须是具体的和公共的,并且具有无参数的构造方法，提供用来操作成员变量的 set 和 get 方法。** 
- **成员变量全部为private**
- **编写一个全参数的构造方法**

### Scanner

- 一个可以使用正则表达式来解析基本类型和字符串的简单文本扫描器

- 导包(除了java.lang包其他均需要导入)import

- ```java
	Scanner sc = new Scanner(System.in); //System.in就是代表从键盘进行输入
	//其实就相当于在不断的扫描从控制台键盘输入的内容
	int num = s.nextInt(); 
	System.out.println(num);
	String str = s.next(); //其实next()方法就是将输入的内容作为字符串,而nextInt()只不过就是将字符串转化为int
	System.out.println(str);
	```

### 匿名对象

- 匿名对象就是只有右边的对象,没有左边的名字和赋值运算符

- ```java
	Person per = new Person();//创建对象的标准格式
	new Person(); //匿名对象
	new Person().name; //可以调用成员变量
	new Person().showName(); //可以调用成员方法
	//注意:上面一共四个new,也就是在堆中创建了四个对象,每次new都是一个新的对象
	```

- **匿名对象只能使用唯一的一次,下次再次使用不得不再创建一个对象**

- 使用建议就是一个对象确定只使用一次

- ```java
	int num = new Scanner(System.in).nextInt();
	```

- 就比如上面的程序只想输入一次

- 匿名对象可作为方法传入参数,也可作为方法的返回值

### Random

- ```java
	int num = r.nextInt(); //从整个int取值范围获取一个随机数,有正有负
	int num2 = r.nextInt(3); //从一个左闭右开的[0,3)获取一个随机数
	```

### 对象数组

- 数组中存的是每一个对象的地址值
- 但还是有数组的缺点,一旦创建,长度不可以更改

### ArrayList

- **泛型只能是引用类型,不能是基本类型**

- ```java
	add();
	get(int index);
	remove(int index);
	size();
	```

- **基本类型的存储必须使用基本类型的包装类,同时由于基本类型的包装类都位于java.lang下,所以并不需要导包**

- ==基本类型在创建的时候位于什么空间?==

- 同原理问题(==java中的 == 号判断，为什么基本数据类型就是比较内容，而对象则是比较地址？==)

- >首先第一个问题:基本类型的变量到底位于什么空间取决于int a这条语句到底位于程序的什么地方
	>
	>1. 如果是在方法内部中被执行到，也就是说是局部变量，来就会在栈内存中分配内存，由于是int型，所以就是4字节，也就是32bit，long类型的会是64bit。
	>
	>2. 创建的对象以及对象中的方法和数据是存储在堆内存中的。JVM会在栈内存中建立对象的引用，然后当执行到new语句时，在堆内存中创建对象，这时就将这个对象的类型以及这块区域的内存地址值赋给引用，然后进行对象中数据的初始化。也就是说，对象的引用存储在栈内存中，存放的是类型以及hash值，如Integer@0xff67。而对象里的内容实际上是存储在堆内存中的。
	>3. 基本类型的变量如果是临时变量(方法内的局部变量)，只要定义了，就会分配内存空间，不管是否被赋值；如果是作为对象的属性出现，只要该对象不实例化，就不会分配内存空间。
	>4. 无论是普通类型的变量还是引用类型的变量(俗称实例)，都可以作为局部变量，他们都可以出现在栈中。只不过普通类型的变量在栈中直接保存它所对应的值，而引用类型的变量保存的是一个指向堆区的指针，通过这个指针，就可以找到这个实例在堆区对应的对象。因此，普通类型变量只在栈区占用一块内存，而引用类型变量要在栈区和堆区各占一块内存
	>
	>其次第二个问题:
	>
	>1. 基本类型的变量在只是局部变量时,是只存在栈空间当中的,所以当int a = 3;int b =3;的时候,jvm实际上因为要避免大量拥有相同内容对象的内存开销,是会在栈空间中找时候已经有一个数据为3了,如果不是的话新建一个地址，是的话，就把b指向这个地址，所以对于基本类型来说，当值相同的时候，地址也是相同的，所以当你对基本类型`==`的时候，内容相同的肯定返回的是true。。因为实质上，他们的地址也是相同的
	>	但是对于其他类型，都是存在堆里面的动态分配内存，所以每一次新建一个数据都会动态分配一个内存地址，所以`==`的时候，当然内存地址是不一样的。
	>	要记住，`==`永远是用来比较内存中的地址的，基本类型感觉上是在比较内容，实际上还是在比较地址！

- ==看下面这个程序的例子,解释为什么会出现两个对象但是却相等的这种情况?==

- 1. 这个问题可以参考享元模式，这个设计是为了避免大量拥有相同内容对象的内存开销。

	```java
	Integer i1 = 20;
	Integer i2 = 20 ;
	System.out.println(i1 == i2);  // true
	Integer i3 = 200;
	Integer i4 = 200 ;
	System.out.println(i3 == i4);  // false
	```

	2. Integer i1 = 20; 其实是一个自动装箱的过程，编译器会自动展开成Integer i = Integer.valueOf(20);详情可以看Integer.valueOf的源代码，可以看到参数的值在IntegerCache.low（默认-128） 到 IntegerCache.high（默认127）范围内时（比如20），会从IntegerCache.cache中直接取(此处参考Integer的内部类IntegerCache的源代码，如果不配置的话，默认是cache存储-128到127的Integer)，所以取到的都是同一个Integer的对象，因此相同。而200不在-128到127范围内，所以会new 一个新的Integer，故不相同

- 从JDK1.5版本开始,支持了自动拆箱和自动装箱

- **自动装箱**:基本类型->包装类型

- **自动拆箱**:包装类型->基本类型

### String

#### 特点

- API表示,java程序中的所有字符串字面值("abc")都作为此类的实例实现,也就是说程序中所有的双引号字符串都是String类的对象,即便没有new 
- 特点:字符串的内容是常量,永不可变,也正因为是常量,所以字符串是可以共享使用的
- 字符串效果相当于是char[]数组,但是底层原理是用byte[]字节数组存储的

#### 掌握3+1创建字符串方式

- ```java
	//下面是三种new创建方式
	//直接new一个空字符串对象
	String str1 = new String();
	System.out.println(str1); //此时的输入是什么都没有,并不是null,也不是地址值,而就是一个空字符串
	String str2 = new String(charArray);
	String str3 = new String(byteArray);
	//直接创建方法
	String str = "Hello"; //String可以这样直接创建,直接创建字符串字面量
	```

#### 字符串比较

- ```java
	String str1 = "abc";
	String str2 = "abc";
	char[] charArray = {'a','b','c'};
	String str3 = new String(charArray);
	System.out.println(str1 == str2);  //true
	System.out.println(str1 == str3);  //false
	```

- ==解释==,**对基本类型来说,==是进行数值的比较,对于引用类型来说是进行地址值的比较,所以这两个比较都是进行了地址值的比较,但是由于程序当中直接用双引号创建的字符串,都作为字符串常量放入了字符串常量池当中,字符串常量池位于堆空间当中(从JDK1.7开始),所以str1和str2在栈空间的存放的地址值都指向的是同一个字符串常量池的字符串对象,而字符串常量池中的字符串对象存储的是一个指向byte类型字节数组(字符串的底层存储)的地址值,所以相当于占空间的str1和str2存储的都是这个byte字节型数组的地址值**,**而charArray在栈空间中存放的是指向堆空间char型创建的char型数组,而堆空间中的char型数组会转换为byte[]类型的字节数组,然后new了一个String str3,new出来String都不在字符串常量池当中,所以栈空间中str3的地址值也不同于str1**

- 真正相比较字符串内容就使用equals方法

- equals比较如果要用到字符串常量,把字符串常量放前面,比如"abc".equals(str1);

- equalsIgnoreCase忽略大小写比较

#### 常用方法

- length() 长度
- concat(String str) 拼接(返回的一定是新的字符串,字符串常量永不可变)
- charAt(int index) 从0开始获取指定索引位置字符
- indexOf(String str) 查找参数字符串在本字符串中首次出现的索引位置,没有则返回-1
- substring(int index),截取从参数开始一直到字符串数组末尾
- substring(begin,end) 从begin开始到end结束,左闭右开
- toCharArray() 将当前字符串拆分为字符数组作为返回值
- getbytes() 获取当前字符串底层的字节数组
- replace(CharSequence oldString,CharSequence newString) 将所有出现的老字符串替换成为新的字符串,返回替换之后的结果新字符串,CharSequence 是一个接口,可以接收String类型
- split(String regex)按照参数规则,将字符串拆分为若干部分

### static静态

- 只在类当中保存一份,那么所有本类的对象共享同一份,一旦使用了static关键字修饰,那么这样的内容不再输入对象自己,而是属于类的

- 可以通过实例化的对象进行赋值,也可以通过类进行赋值

- ```java
	//这样就可以实现每new一个学生对象,就可以让学生学号自动增加
	private static int id = 0; //学号计数器
	public student(){ //如果还有有参构造方法也要写上
		id++;
	}
	```

- 不加static叫成员方法,加了static就是静态方法,静态方法不属于对象和是属于类的

## 函数式编程(P419-P450)

#### 函数式接口

##### 概念
- 函数式接口指的是:**有且仅有一个抽象方法的接口**
- 函数式接口，即适用于函数式编程场景的接口。而Java中的函数式编程体现就是**Lambda**，所以函数式接口就是可以适用于Lambda使用的接口。只有确保接口中有且仅有一个抽象方法，Java中的Lambda才能顺利地进行推导。
	- 备注：“**语法糖**”是指使用更加方便，但是原理不变的代码语法。例如在遍历集合时使用的for-each语法，其实底层的实现原理仍然是迭代器，这便是“语法糖”。从应用层面来讲，Java中的Lambda可以被当做是匿名内部类的“语法糖”，但是二者在原理上是不同的。

##### 定义
- 只要确保接口中有且仅有一个抽象方法即可：
```java
修饰符 interface 接口名称 {
public abstract 返回值类型 方法名称(可选参数信息);
// 其他非抽象方法内容
}
```



## JVM
#### Java类加载机制
- Rico书呆子总结博文
- https://www.yuque.com/codenovice/xuymgk/3c38e3a9-dd41-4779-9e2a-310e19e5d282
- https://www.yuque.com/codenovice/xuymgk/b4840832-cc75-4d90-86d2-348578b7c0cf
- https://www.yuque.com/codenovice/xuymgk/c5d21972-0290-47c9-af51-326d9a58cdd4

## Java多线程

- 一定要搞懂interrupted()和isInterrupted()的区别,一定要注意interrupted是静态方法,`实例对象.interrupted()`和`Thread.interrupted()`是一样的作用,所以很容易考察比如在main方法内,`thread1.interrupt()`,然后问`thread1.interrupted()`的结果,肯定是false,因为`thread1.interrupted()`实际上也是在看main主线程是否被中断,很显然没有

### synchronized和volatile

### 锁

### CAS(compare and swap)

### 问题
##### (个人问题)线程A调用线程B的join()方法是什么意思?
- 可以看下面这个例子
- ```java
	public class JoinTest {
		public static void main(String [] args) throws InterruptedException {
			ThreadJoinTest t1 = new ThreadJoinTest("小明");
			ThreadJoinTest t2 = new ThreadJoinTest("小东");
			t1.start();
			/**join的意思是使得放弃当前线程的执行，并返回对应的线程，例如下面代码的意思就是：
			程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
			所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会
			*/
			t1.join();
			t2.start();
		}

	}
	class ThreadJoinTest extends Thread{
		public ThreadJoinTest(String name){
			super(name);
		}
		@Override
		public void run(){
			for(int i=0;i<1000;i++){
				System.out.println(this.getName() + ":" + i);
			}
		}
	}
  ```
- 实际上这个程序中的`t1.start();` `t1.join();`就可以翻译为在主线程(Main线程)中调用了t1线程的`start()`方法和`join()`方法

##### 为什么线程A调用线程B的join()方法,阻塞的是线程A自己呢?
- 理解上一题之后,我们开始理解这个问题
- 线程A调用线程B的join()方法,可以通过下面两个场景来理解
  - 1. 主线程中调用t1线程的join()方法,那实际上不就是主线程需要wait等待线程t1执行完才能执行下面的语句,也就是阻塞的是主线程
  - 2. 比如下面的代码
  - ```java
		private static volatile Object object1 = new Object();
    	private static volatile Object object2 = new Object();
	    private static class ThreadTest1 implements Runnable {
        @Override
        public void run() {
            System.out.println("线程1尝试获取A资源");
            try {
                Thread.sleep(1000);
                synchronized(object1){
                    System.out.println("线程1获取A资源成功");
                    System.out.println("线程1尝试获取B资源");
                    synchronized(object2){
                        System.out.println("线程1获取B资源成功");
                        System.out.println("线程1释放A资源");
                        object1.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		ThreadTest1 threadTest1 = new ThreadTest1();
		threadTest1.start();
	```
  
  -  其实我们把object1理解为一个线程,那么线程ThreadTest1创建线程之后`threadTest1.start();`,实际上线程threadTest1就拥有了object1线程的锁,当在线程threadTest1中执行`object1.wait()`或者`object1.join()`之后就相当于线程threadTest1放弃object1的锁然后把自己挂起来,等待`object1.join()`完成,也就是阻塞的是线程threadTest1自己

- 下面看一看join()方法的源码:
- ```java
	public final synchronized void join(long millis)
		throws InterruptedException {
			long base = System.currentTimeMillis();
			long now = 0;

			if (millis < 0) {
				throw new IllegalArgumentException("timeout value is negative");
			}

			if (millis == 0) {
				while (isAlive()) {
					wait(0);
				}
			} else {
				while (isAlive()) {
					long delay = millis - now;
					if (delay <= 0) {
						break;
					}
					wait(delay);
					now = System.currentTimeMillis() - base;
				}
			}
		}
	```
- 可以看出当没有传入参数时,其实就是在执行被调用线程的wait()方法,然后不断判断被调用的线程是否存活
- join方法的原理就是调用相应线程的wait方法进行等待操作的，例如A线程中调用了B线程的join方法，则相当于在A线程中调用了B线程的wait方法，当B线程执行完（或者到达等待时间），B线程会自动调用自身的notifyAll方法唤醒A线程，从而达到同步的目的。
- 有一道经典的面试题是让线程T1，T2，T3按顺序执行。也就是main等待T3，T3等待T2，T2等待T1.那么应该在main方法中调t3.join() 在T3线程的run方法的开始调用t2.join
