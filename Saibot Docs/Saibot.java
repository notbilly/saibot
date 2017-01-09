import java.util.HashMap;
import java.lang.Math;
/**
* The Saibot Class is a physics tutor chatbot that will fulfill
* all of your deepest, darkest, physics-related desires
* @author Billy Zhong, Gaurav Phanse, Sai Kapuluru
* @version 1.0
*/
public class Saibot
{
    //Requirement 2b and 4-i satisfied by line 14
    /**
    * Contains all random responses from response database
    */
    private static final String[] randomResponses = {"I do not understand.", "What?", "Repita por favor.", "Come again?", "Could you please say something that makes sense?", "Sorry, can you say that in a different way?", "That is an inappropriate question, sir/ma’am.", "No comprendo", "You might need to dumb that down for me.", "I don’t dig that bro."};

    //Requirement 2a and 4-ii satisfied by line 19
    /**
    * A Map of all definition and responses from response database
    */
    private static HashMap termResponses = new HashMap<String, String>();;
    static {
      termResponses.put("normal force", "Normal force is the force that acts perpendicular to the surface that an object is on.");
      termResponses.put("work", "W = Change in Kinetic Energy = Force x distance");
      termResponses.put("power", "Power is work per unit time");
      termResponses.put("vector", "A Vector is a quantity that includes both magnitude and direction.");
      termResponses.put("newton's first law", "Newton's First Law is the Law of Inertia. An object in motion (or at rest) will remain in motion at constant velocity (or at rest) unless acted upon by an unbalanced force.");
      termResponses.put("newton's second law", "Newton's Second Law states that force is equal to mass times acceleration.");
      termResponses.put("newton's third law", "Newton's Third Law states that for every action force, there is an equal and opposite reaction force.");
      termResponses.put("torque", "Torque is a force's ability to cause an object to rotate, measured in m-N.");
    }

    //Requirement 4-iii satisfied by lines 27-32 and 108-114
    /**
    * Contains all Transposition Targets
    */
    private static final String[] transposeFrom = {"are","am","were","was","you","i","your","my","i've","you've","i'm","you're","you","me"};

    /**
    * Contains all Transposition Transformations
    */
    private static final String[] transposeTo = {"am","are","was","were","i","you","my","your","you've","i've","you're","i'm","me","you"};

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

    //Requirement 3 satisfied by lines 70-100
    /**
    * Determines whether or not the input phrase is a question
    * @param input Text to be analyzed
    * @return boolean True if input is a question, False if not
    */
    private static boolean isQuestion(String input){
      return input.replaceAll(" ", "").substring(input.replaceAll(" ","").length()-1).equals("?");
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
      return input.toLowerCase().replace("what","").replace("are","").replace("is","").replace("define","").replace("?","").trim();
    }

    /**
    * Transposes a question into another question
    * @param input Text to be transposed
    * @return String Transposed Question String
    */
    private static String getTransposedResp(String input){
      String temp = input.toLowerCase();
      for(int i = 0; i < transposeFrom.length; i++){
        temp = temp.replaceAll(" " + transposeFrom[i].toLowerCase() + " ", " " + transposeTo[i].toLowerCase() + " ");
      }
      return temp.substring(0,1).toUpperCase() + temp.substring(1);
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

    //Requirement 4-iv satisfied by lines 139-141 and WolframParser.java
    /**
    * Retrieves a definition of unknown term from Wolfram Alpha
    * @param term Term to define
    * @return String Wolfram Alpha Definition of Term Response
    */
    private static String getWolframResp(String term){
      return WolframParser.getWolframResp(term);
    }

    public static void main(String [] args){
      greet();
      System.out.println("> Can I do physics?");
      chat("Can I do physics?");                          //Transpose
      System.out.println("> What is torque?");
      chat("What is torque?");                            //Definition Response
      System.out.println("> What is kinetic energy?");
      chat("What is kinetic energy?");                    //Unique Response (Wolfram Alpha)
      System.out.println("> blah blah blah");
      chat("blah blah blah");                             //Random Response
    }
}
