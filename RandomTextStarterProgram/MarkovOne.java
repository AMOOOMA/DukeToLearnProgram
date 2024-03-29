import java.util.*;
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovOne {
     private String myText;
     private Random myRandom;
    
     public MarkovOne() {
        myRandom = new Random();
     }
    
     public void setRandom(int seed){
        myRandom = new Random(seed);
     }
    
     public void setTraining(String s){
        myText = s.trim();
     }
    
     public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index,index+1);
        sb.append(key);
        for(int k=0; k < numChars-1; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size()==0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }
        
        return sb.toString();
     }
    
     public ArrayList<String> getFollows(String key){
            ArrayList<String> answer = new ArrayList<String>();
            int index =0;
            for(int pos =0;pos<myText.length()-key.length();pos++){                
                index = myText.indexOf(key,pos);
                if(index == -1){
                    break;
                }
                if(index == myText.length()-key.length()){
                    break;
                }
                answer.add(myText.substring(index+ key.length(), index+key.length()+1));
                pos = index;
            }
            return answer;
        }
}
