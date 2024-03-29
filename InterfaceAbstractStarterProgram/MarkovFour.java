import edu.duke.*;
import java.util.*;
/**
 * Write a description of MarkovFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovFour extends AbstractMarkovModel {
    
     public MarkovFour() {
        myRandom = new Random();
     }
    
     public void setTraining(String s){
        myText = s.trim();
     }
    
     public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index,index+4);
        sb.append(key);
        for(int k=0; k < numChars-1; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size()==0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1,key.length()) + next;
        }
        
        return sb.toString();
     }
}
