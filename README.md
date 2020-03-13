[TOC]
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

   	> Literals of types `char` and `String` may contain any Unicode (UTF-16) characters. If your editor and file system allow it, you can use such characters directly in your code. If not, you can use a "Unicode escape" such as `'\u0108'` (capital C with circumflex), or `"S\u00ED Se\u00F1or"` (Sí Señor in Spanish). Always use 'single quotes' for `char` literals and "double quotes" for `String` literals. Unicode escape sequences may be used elsewhere in a program (such as in field names, for example), not just in `char` or `String` literals.
   	>
   	> The Java programming language also supports a few special escape sequences for `char` and `String` literals: `\b` (backspace), `\t` (tab), `\n` (line feed), `\f` (form feed), `\r` (carriage return), `\"` (double quote), `\'` (single quote), and `\\` (backslash).
   	>
   	> There's also a special `null` literal that can be used as a value for any reference type. `null` may be assigned to any variable, except variables of primitive types. There's little you can do with a `null` value beyond testing for its presence. Therefore, `null` is often used in programs as a marker to indicate that some object is unavailable.
   	>
   	> Finally, there's also a special kind of literal called a *class literal*, formed by taking a type name and appending "`.class"`; for example, `String.class`. This refers to the object (of type `Class`) that represents the type itself.

   - 单引号用char，双引号用String
   - 字符转义，转义序列：\ b（退格），\ t（制表符），\ n（换行），\ f（换页），\ r（回车）， \“（双引号），\'（单引号）和\\（反斜杠）。

### 1.2 运算符(Operators)

### 1.3 表达式、语句、块(Expressions, Statements, and Blocks)
### 1.4 流程控制语句(Control Flow Statements)


**问题**
- 为什么最大值是2位次方-1，而不是直接是2的次方，比如byte最大值是2的8次方-1

  因为Java最低位是符号位，0是正数，1是负数。



**参考资料**

- [官网文档首页](https://docs.oracle.com/javase/tutorial/java/index.html)
- [官方文档-语言基础](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)



