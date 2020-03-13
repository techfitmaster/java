#  Java
## 1. 语言基础(Language Basics)

### 1.1 变量(Variables)
1. **原始数据类型和默认值(Primitive Data Types)**

   | 数据类型 | 位数(bit) | 大小                       | 默认值   |
   | -------- | --------- | -------------------------- | -------- |
   | byte     | 8         | -128~127(inclusive)        | 0        |
   | short    | 16        | -32,768~32,767 (inclusive) | 0        |
   | int      | 32        | -2^31~2^31-1               | 0        |
   | long     | 64        | -2^63~2^63-1               | 0L       |
   | float    | 32        |                            | 0.0f     |
   | double   | 64        |                            | 0.0d     |
   | boolean  |           |                            | false    |
   | char     | 16        | 0~65,535(inclusive)        | '\u0000' |

2. **整型(Integer Literals)**

   > An integer literal is of type `long` if it ends with the letter `L` or `l`; otherwise it is of type `int`. It is recommended that you use the upper case letter `L` because the lower case letter `l` is hard to distinguish from the digit `1`.

   - 如果结尾是L或者是l，则是**long**类型，否则是**int**。

   - 推荐使用大写字母L，因为和1很难区分开来。

3. **(浮点类型)Floating-Point Literals**

   > A floating-point literal is of type `float` if it ends with the letter `F` or `f`; otherwise its type is `double` and it can optionally end with the letter `D` or `d`.

   - 如果结尾是F或者f，则是浮点类型，否则是double类型

4. **(字符和字符串)Character and String Literals**

   

### 1.2 运算符(Operators)

### 1.3 表达式、语句、块(Expressions, Statements, and Blocks)
### 1.4 流程控制语句(Control Flow Statements)


**问题**
- 为什么最大值是2位次方-1，而不是直接是2的次方，比如byte最大值是2的8次方-1

  因为Java最低位是符号位，0是正数，1是负数。

**参考资料**

- [官方介绍](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)








**参考资料**
- [官网文档](https://docs.oracle.com/javase/tutorial/java/index.html)

