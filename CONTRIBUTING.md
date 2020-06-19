# Thank you for contributing!

## General Guidelines

Here are a couple guidelines of contributing:
 * Make descriptive commits. 
 
 I'm going to review code that you write but it makes life
 easier to just look at the commit and find out what it adds. You don't have to be
 descriptive to the point of line numbers just don't make the content of the commit ambiguous.
 
 * Follow the formatting.
 
 I know you think your style of formatting is better and more understandable than mine, but I
 don't. If you really want to program with your format, write a script to format it the 'correct'
 way before committing.
 
 * Write readable code
 
 Don't be afraid to use long variable/function names. Long names don't affect the performance
 of the program they just make it more readable. As programmers that's something we need more of.
 If you **really** don't want to make long names that's alright just abbreviate words down to 
 a couple letters: `FunctionRequirement` -> `FunReq`.
 
 * Test your code
 
 Make sure your code actually works before it gets merged into the project. I don't want to have
 to go back and revert the changes it made, or delete the chunk(s) that made it break.
 
## Formatting Guidelines

###Brackets/Parenthesis:

When writing functions put the `{` on the same line that the function was declared. Like this:
```java
public class App {
    public static void Main(String[] args) {
        System.out.println("Like this");
    }
}
```
Not this:
```java
public class App
{
    public static void Main(String[] args)
    {
        System.out.println("Not like this");
    }
}
```

The fewer lines of code there are the easier it is to read. I know its only a bracket but it
makes things more confusing in my opinion.

You might be thinking what if there are a **crap ton** of arguments going into a function or
array. Simple follow the same guidelines as above just replace the curly braces with parenthesis.

```java
public class Color {
    Color(
        int red,
        int green,
        int blue,
        int alpha
    ) {
        System.out.println("Pretty arguments");    
    }
}
```

It may look a little weird that the first argument isn't passed on the same lines as `Color` is
defined but its consistent with function declarations. We don't put the first command on the
same line that defined the Main function. It's just consistent.

## Function/Variable Names

Try to use camel casing. Using underscores is perfectly fine but it's just easier to type a
capital letter rather than an underscore. If the file you are working in uses camel casing, use
camel casing. If it uses underscores, use underscores.

### Methods

For methods use camel casing. 

That's all that really needs to be said about that.

### Classes

The first letter of every word in a class name must be upper case. Camel cased, and underscores
just look strange in class names.

### Duplicate methods

If you wrote a method that already exist in a library but you don't want to use that library to
keep code from getting bloated. Put an underscore at the beginning of the method(s). This applies
more to C/C++ projects but it may happen in other projects.
```C
int _strlen(char *str) {
    int length=0;
    while(*str++) {
        length++;
    }
    return length;
}
```

### Types

If you have an object where the type actually matters name it as such. If you have a float called
`value` name it `value_f`. This is one of the times I would encourage the use of underscores
rather than camel casing. It looks weird to have written it like this: `valueF`. It just doesn't
really make sense. Though you wouldn't need to do things like this for `double` or `int` because
they don't really have extraordinary properties. If you make your names descriptive you won't
have to worry about this. We can all probably agree that a variable called `name` will never 
be an `int`, or really anything other than a `string`.

### Constants

This goes for pre-processor directives for C/C++, and for interface/final variable names.

If we define something that ***shouldn't*** change throughout the program make the name in all
caps. As such use underscores because we obviously cant use camel casing.
```C++
#define YES 1
#define NO 0
```
or
```Java
public static final int YES = 1;
public static final int NO = 0;
```

## C/C++ Only

### Headers

Always guard your headers or definitions!
```C++
#ifndef FUNCTION
#define FUNCTION

bool guardHeaders() {
    return true;
}

#endif
```

This will prevent many headaches when you have headers that contain dependencies a few
layers deep.

## Java Only

Organize your imports! This isn't necessary but it makes things look nice.
```Java
import com.weird.imports.Wow;
import com.weird.imports.Organized;
import com.weird.imports.orderBySize;

import com.weird.otherImports.Separated;

import org.domain.*;
```
Group the imports together by package. Then inside those packages organize the imports by
length of them names.