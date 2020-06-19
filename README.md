# JInterpreter
A small interpreter for writing lisp-like interpreted languages only without all the parenthesis

This is a tiny interpreter that I created for my discord but but it could be used for creating custom lisp-like domain 
languages, shells, bots, and probably much more.

# Features

It will check words passed to it against the context inside a combinator. If there is already a command in the context
it will assume that it is being passed an argument.

If the aregument has a `]` prefix it will read it as a command and future aruments will be passed to that until the
command is satisified

It currently has support for being passed global variables also known as **system requirements** which are availible to all
commands.

Eventually I will add support for:
  * change function call symbols
  * local variables
  * functions
  * non-void functions
  * macros
  * variable number of arguments
  * and much, much more!
  
Any suggestions for this project would be appreciated you can message me on [![Gitter](https://img.shields.io/badge/gitter-blue?logo=gitter&style=flat-square)](https://gitter.im/PoetryInCode/JInterpreter/)

Or if you want to contribute yourself, just fork it and create a pull request!

Make sure to check out the [contributing guidelines](./CONTRIBUTING.md)!