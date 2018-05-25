# Study Report
***
## Vim Editor
<br />   
### Basic conception
<br />***Command mode***: control the movement of the screen cursor, delete the character, word or line, move the copied segment and enter the Insert mode, or to the last line mode.
<br />***Insert mode***: only under the Insert mode, can make text input, press the ESC key to return to the command line mode.
<br />***Bottom line mode***: generally we simplify the vim into two modes when we use it, that is to add the last line mode to the command mode.

### Basic operation
<br /><br />**entrance**
<br />After the system prompt symbol input vi and file name, enter vi full screen editing screen: $vi myfile
<br /><br />**switch to Insert mode**
<br />Click the "I" in the "command mode" to enter the Insert mode, and then you can start typing.
<br /><br />**switch to Command mode**
<br />You are currently in the "Insert mode" (Insert mode), you can enter text all the time. If you want to use the cursor keys to delete the wrong word, you need first click on the "ESC" key to "command line mode to delete the text.
<br /><br />**exit vi and save the file**
<br />Under "command mode", press the ":" colon key to enter "Last line mode".

### Common command
<br /><br />**list the line**
<br />"Set nu" : after entering "set nu", the line number is listed in front of each line in the file.
<br /><br />**jump to a certain row of file**
<br />"#" : "#" means a number, type a number after the colon, and then press the enter key to jump to the line, such as losing.
<br /><br />**lookup character**
<br />"/ keyword" : press the "/" button first, and then enter the character you are looking for, if the first keyword is not what you want. You can always press "n" to find the keyword you want. 
<br />"? Key words" : first click "?" Key, enter the character you are looking for, if the first keyword is not what you want. You can always press "n" to find the keyword you want.
<br /><br />**save files**
<br />W: you can save the file by entering the letter "w" in the colon.
<br /><br />**quit**
<br />"q" : press "q" to exit. If you can't leave vi, you can have "q" followed by "!" Force out vi.
<br />"qw" : it is generally recommended to use "w" when leaving, so that files can be saved when exiting.


<br />  
## Ant 
### Basic Conception
<br / >Ant is the ant build tool, image, you need to bring the code from somewhere, compiled, and then copy it somewhere, and so on, of course not only with this, but is mainly used to do this. Many of the things ant does, most of which were once made by a name called make, but the objects are different, make more apply to c/c++,ant is more applied to Java.
<br />to use ant to build an ant environment first, write some program and then compile them, such as "HelloWorld". To run ant, you need a build.xml file.

###About build.xml file:
<br /><br />Ant of all content must be included in the < project >, the name is the name you give it, basedir so the name implies is the root directory of the work. On behalf of the current directory. Default represents the default thing to do.
<br /><br />Write every thing you want to do a target, it has a name, a target is depends upon which it depends, in carrying out this target, such as the compile here before ant will first check whether the init has been carried out, if carried out, directly executed the compile, if there is no will execute it first depend on the target of the init here, for example, and then carry out the target.
<br /><br />Creat a new SRC folder, and then put the HelloWorld.java directory according to the package in, ready to build the XML file, type ant under the command line, you will find that the tasks are completed. Once you have changed the code, just type ant again. This simple ant task is done.
***

## JUnit
### Basic Conception
<br />JUnit is a unit testing framework for a Java language. JUnit has its own JUnit extension ecosystem. Most Java development environments have integrated JUnit as a unit test tool. In general, for example, I wrote a class that I want to use for other people, and I want to test whether there are bugs in this class before they use it. The test is unit testing.
### Extreme Programming
<br /> Write tests before you write code, this will force you think before you write the code code (method) of function and logic, otherwise the code is not very stable, so you need to maintain the test code and real code at the same time, the workload will increase greatly. Therefore in extreme programming, the basic process is as follows: conception - > writing test code - > code - > test, and write a test and write code are incremental, write a little test, after writing code if it is found that problems can be quickly traced to the cause of the problem, reduce the return error correction.
### Refactoring
<br />Its benefits are similar to that of extreme programming, since refactoring is also required to change a little bit to reduce the time consumption caused by regression errors.
<br /><br />1.Creates a subclass of TestCase and writes a test method to assert the desired result.
<br />2.Write a suite () method, it is to create a dynamically using reflection contains all the testXxxx method of test suite, write a main () method in the form of text runner convenient run through tests.
<br />3.Writing test code will reduce your stress level, because by writing test code, you have a definite understanding of the behavior of the class. You can write efficient code faster.
<br /><br />
###Thanks!
