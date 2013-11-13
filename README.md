#T.O.Y.

Theoretical Objective Yeild
***

A toy language(Haha), written by Alden Neely, in 2013 in preparation for the AP Computer Science Exam.
Regrettably, in Java as specificied by the AP Comp Sci Java subset. TOY attempts to mix the simplicity of design of LISP dialects with the readability and paradigms of C-Family languages.

**Paradigms**:Imperative, Procedural  
**Typing**:Strong, Human-Oriented  

Note: Human-Oriented Typing is unique feature in TOY, wherein types shall be described according to human standards, not machine standards, therefore, `int, float, BIGINT, int32, double` etc. become *Number* and `char*, char[], TEXT, string` become *String*
  
##Part I: Language Specification
***
Primarily, TOY is an entirely expressive language, that is, no statement shall be a declaration, that said, TOY shall not be functional in paradigm. 

Their shall be 3 types of expressions in TOY, and they are as follows 

*	Function application, dentoted as `f(arg1,arg2,...,argn)`
*	Literals
	*	Numbers: `23, 1.24, -3`
	*	Strings: `"Hello, World", 'I love T.O.Y.'`
	*	Lists: `['TOY','C++','Java'] , [0,-55.6,0.33, 54442345]`
		*	*Note: all elements of a List in TOY must be of the same type*
	*	Blocks:
	  
			{println("Hello, World");}  
		
			{
				set(x,add(3,5));
				println(x);
			}	  
		 
			(name){
				println(concat(["Hello,",name,"!"]));
			}
			
		*	*Note: In the final example for the blocks section, note the parenthesis enclosing name. All blocks in TOY are anonymous functions, and this is how to specify parameters.*
* 	Additionally, although not an expression type, C-style comments in single line `//Comment` or multi-line `/* This is a program */` are included in TOY
*	Infix Arithmetic Operators *see note* :

		5+6
		(x-y)/4*5
		5.5%6 + 78
		
	*	Note: This feature will not be implement in the first editions of TOY for speed of development, any code written in TOY with infix operators shall be reffered to as I-TOY code

Finally, in order to give a solid basis for the above-described syntax, here is a code sample in TOY
		
		/*
		A program to calculate the fibonnaci series, in the TOY language, rev. 0.0.1
		
		by: Alden Neely
		*/
		//First instantiate 3 numbers, setting the first two too 1
		set(new(first, Number),1); 
		set(new(second, Number), 1);
		new(temp, Number);
		
		//Pass an anonymous, 0-argument function to while iterator with condition true
		while(true, {
			println(first);
			
			set(temp, second)
			set(second,add(first,second));
			set(first,temp);
		});
##Part II. Runtime Specification
***
  
TOY has a fairly simple runtime enviroment, consisting of the following elements:

*	**Object Pool**: array of anonymous objects, indexable by integer
*	**Symbol Table**: binary search tree whose keys are hashes, which correspond to the string names of objects in TOY, and whos values are locations on the Object Table
*	**Run Stack**:	 Similar to any runtime stack, return values are pushed to it and then corresponding popped when needed

##Part III. Parser Specification
***

the fact that TOY is a language designed for the education of it's creator leads to two interesting facets

1.	The creator has no idea what he is doing
2.	The creator wishes to learn as much as possible by avoiding the treaded path

The parser for TOY shall be implemented in the Blackboard design pattern, that is, the raw source shall be put on a 'Blackboard' structure, where it will be examined by groups of 'Specialist' objects. The process is designed as follows:

1.	Source is put on Blackboard in raw form.
2.	Tokenization Commitee examines the blackboard, and leaves it in a tokenized state
3.	Parsing Commitee comes in, checks out the blackboard, and leaves the AST on it

##Part IV. Class Specification
***

*	Toy
	*	Parser
		*	Blackboard
		*	Specialists
			*	Tokenologists
			*	Parsologists
		*	Parse Unit
		*	Syntax Treeå
	*	Compiler (Maybe?)
	*	Runtime
		*	Object Pool
			*	Object
		*	Symbol Table
			*	Symbol
		*	Call Stack

