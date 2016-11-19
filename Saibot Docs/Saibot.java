import java.util.HashMap;
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
    * Say hi to Sai!
    */
    public static void greet(){}

    /**
    * Generates a response based off of user input
    * @param input Text given to Saibot
    */
    public static void chat(String input){}

    /**
    * Determines whether or not the input phrase is a question
    * @param input Text to be analyzed
    * @return boolean True if input is a question, False if not
    */
    private static boolean isQuestion(String input){}

    /**
    * Determines whether or not the input phrase is of the syntactical
    * form similar to "What is ...?"
    * @param input Text to be analyzed
    * @return boolean True if input follows the syntax, False if not
    */
    private static boolean isWhatIsQ(String input){}

    /**
    * Determines whether or not the term is in {@link Saibot#termResponses}
    * @param term Term to be analyzed
    * @return boolean True if term is in {@link Saibot#termResponses}, False if not
    */
    private static boolean inDefDB(String term){}

    /**
    * Transposes a question into another question
    * @param input Text to be transposed
    * @return String Transposed Question String
    */
    private static String getTransposedResp(String input){}

    /**
    * Retrieves a random response from {@link Saibot#randomResponses}
    * @return String Random String Response from {@link Saibot#randomResponses}
    */
    private static String getRandomResp(){}

    /**
    * Retrieves the response corresponding to the term
    * from {@link Saibot#termResponses}
    * @param term Term to define
    * @return String Definition of Term Response from {@link Saibot#termResponses}
    */
    private static String getDefResp(String term){}

    /**
    * Retrieves a definition of unknown term from Wolfram Alpha
    * @param term Term to define
    * @return String Wolfram Alpha Definition of Term Response
    */
    private static String getWolframResp(String term){}
}
