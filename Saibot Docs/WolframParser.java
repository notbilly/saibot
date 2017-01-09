import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

/**
* WolframParser queries and parses data and definitions from Wolfram Alpha
* @author Billy Zhong, Gaurav Phanse, Sai Kapuluru
* @version 1.0
*/
public class WolframParser{
  private static String appid = "2JHXWJ-WQ7PVWR6TW";

  /**
  * Retrieves a definition or information about term from Wolfram Alpha
  * @param term Term to define
  * @return String Wolfram Alpha Definition of Term Response
  */
  public static String getWolframResp(String term){
    return parseWolframXml(getWolframXml(term), term);
  }

  /**
  * Queries Wolfram Alpha and retrieves xml response
  * @param term Term to query
  * @return String xml response from Wolfram Alpha Query
  */
  private static String getWolframXml(String term){
    WAEngine engine = new WAEngine();
    engine.setAppID(appid);
    engine.addFormat("plaintext");
    WAQuery query = engine.createQuery();
    query.setInput("define " + term);
    try {
        WAQueryResult queryResult = engine.performQuery(query);
        String res = "";
        if (queryResult.isError() || !queryResult.isSuccess()) {
          return "";
        } else {
            for (WAPod pod : queryResult.getPods()) {
                if (!pod.isError() && pod.getTitle().equals("Result")) {
                    for (WASubpod subpod : pod.getSubpods()) {
                        for (Object element : subpod.getContents()) {
                            if (element instanceof WAPlainText) {
                                res+=((WAPlainText) element).getText()+"\n";
                            }
                        }
                    }
                }
            }
        }
        return res;
    } catch (WAException e) {
        e.printStackTrace();
        return "";
    }
  }

  /**
  * Parses definition or information from Wolfram Alpha xml page
  * @param xml xml page to parse
  * @param term the term being defined
  * @return String Wolfram Alpha Definition of Term Response
  */
  private static String parseWolframXml(String xml, String term){
    String [] arr = xml.split("\n");
    return term.substring(0,1).toUpperCase() + term.substring(1) + " is" + arr[0].substring(arr[0].lastIndexOf("|")+1);
  }
}
