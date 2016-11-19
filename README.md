# saibot
Currently, only WolframParser.java works. Have fun! (Plz no hacks)
### Compile
cd into Saibot Docs
run
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
