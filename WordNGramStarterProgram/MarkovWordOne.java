
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }
        
        return sb.toString().trim();
    }
    
    private ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        for(int k =0;k<myText.length;k++){
            int index = indexOf(myText, key,k);
            if(index == -1){
                break;
            }
            follows.add(myText[index+1]);
            k = index;
        }
        return follows;
    }
    
    private int indexOf(String[]words, String target, int start){
        int answer = -1;
        for(int k =start;k<words.length;k++){
            if(target.equals(words[k])){
                answer = k;
                break;
            }  
        }
        return answer;
    }
    
    public void testIndexOf(){
        String s = "this is just a test yes this is a simple test";
        String[] sample = s.split("\\s+");
        int index = indexOf(sample, "this", 3);
        System.out.println(sample[index]);
    }
}
