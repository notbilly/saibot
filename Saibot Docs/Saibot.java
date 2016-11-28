import java.util.HashMap;
import java.lang.Math;
/**
* The Saibot Class is a physics tutor chatbot that will fulfill
* all of your deepest, darkest, physics-related desires
* @author Billy Zhong, Gaurav Phanse, Sai Kapuluru
* @version 1.0
*/
public class Saibot{
    /**
    * Contains all random responses from response database
    */
    private static final String[] randomResponses;
    /**
    * A Map of all definition and responses from response database
    */
    private static final HashMap termResponses;
    /**
    * Contains all Transposition Targets
    */
    private static final String[] transposeFrom;
    /**
    * Contains all Transposition Transformations
    */
    private static final String[] transposeTo;

    /**
    * Say hi to Sai!
    */
    public static void greet(){
      System.out.println("Hi, I'm Saibot. I'm a physics tutor. Ask me anything!");
    }

    /**
    * Generates a response based off of user input
    * @param input Text given to Saibot
    */
    public static void chat(String input){
      if(isQuestion(input)){
        if(isWhatIsQ(input)){
          String term = parseTerm(input);
          if(inDefDB(term)){
            System.out.println(getDefResp(term));
          }
          else{
            System.out.println(getWolframResp(term));
          }
        }
        else{
          System.out.println(getTransposedResp(input));
        }
      }
      else{
        System.out.println(getRandomResp());
      }
    }

    /**
    * Determines whether or not the input phrase is a question
    * @param input Text to be analyzed
    * @return boolean True if input is a question, False if not
    */
    private static boolean isQuestion(String input){
      return input.replaceAll(" ", "").valueOf(input.replaceAll(" ","").length()-1).equals("?");
    }

    /**
    * Determines whether or not the input phrase is of the syntactical
    * form similar to "What is ...?"
    * @param input Text to be analyzed
    * @return boolean True if input follows the syntax, False if not
    */
    private static boolean isWhatIsQ(String input){
      return input.replaceAll(" ","").toLowerCase().indexOf("whatis")==0||input.replaceAll(" ","").toLowerCase().indexOf("whatare")==0||input.replaceAll(" ","").toLowerCase().indexOf("define")==0;
    }

    /**
    * Determines whether or not the term is in {@link Saibot#termResponses}
    * @param term Term to be analyzed
    * @return boolean True if term is in {@link Saibot#termResponses}, False if not
    */
    private static boolean inDefDB(String term){
      return termResponses.containsKey(term);
    }

    /**
    * Parses the input string for the term that needs to be defined
    * @param input Text to be analyzed
    * @return String term that needs to be defined
    */
    private static String parseTerm(String input){
      return input.toLowerCase().replace("what","").replace("are","").replace("is","").replace("define","").trim();
    }

    /**
    * Transposes a question into another question
    * @param input Text to be transposed
    * @return String Transposed Question String
    */
    private static String getTransposedResp(String input){
      String temp = input.toLowerCase();
      for(int i = 0; i < transposeFrom.length; i++){
        temp = temp.replaceAll(transposeFrom[i].toLowerCase(),transposeTo[i].toLowerCase());
      }
      return temp.valueOf(0).toUpperCase() + temp.substring(1);
    }

    /**
    * Retrieves a random response from {@link Saibot#randomResponses}
    * @return String Random String Response from {@link Saibot#randomResponses}
    */
    private static String getRandomResp(){
      return randomResponses[(int)(Math.random()*randomResponses.length)];
    }

    /**
    * Retrieves the response corresponding to the term
    * from {@link Saibot#termResponses}
    * @param term Term to define
    * @return String Definition of Term Response from {@link Saibot#termResponses}
    */
    private static String getDefResp(String term){
      return termResponses.get(term).toString();
    }

    /**
    * Retrieves a definition of unknown term from Wolfram Alpha
    * @param term Term to define
    * @return String Wolfram Alpha Definition of Term Response
    */
    private static String getWolframResp(String term){
      return WolframParser.getWolframResp(term);
    }
}
