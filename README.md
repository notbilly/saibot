# saibot
Everything Works. Have fun! (Plz no hacks)
### Compile Saibot
```
  javac -classpath '/absolute/path/to/Saibot/lib/*:.' Saibot.java
  java -classpath '/absolute/path/to/Saibot/lib/*:.' Saibot
```
---
This class can be user-customized! Define your own transpositions, definitions, and random responses by setting the fields to your own data.

### Compile WolframParser
cd into Saibot Docs and run
```
  javac -classpath '/absolute/path/to/Saibot/lib/*:.' WolframParser.java
  java -classpath '/absolute/path/to/Saibot/lib/*:.' WolframParser 'term'
```
---
As a side note, you may have to add the following code to WolframParser.java in order to test it because the ```java``` command will only execute the ```main``` method
```java
  public static void main(String [] args){
      System.out.println(getWolframResp(args[0]));
  }
```
