import java.util.*;
/**
 * Write a description of MarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    
    public MarkovWord(int order) {
        myRandom = new Random();
        myOrder  = order;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder-1);  // random word to start with
        WordGram kGram = new WordGram(myText, index, index+myOrder);
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(kGram);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kGram.shiftAdd(next);
        }
        return sb.toString().trim();
    }
    
    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        for(int k=0; k<myText.length;k++){
            if(myText[k].equals(kGram.wordAt(0))){
                WordGram wg = new WordGram(myText, k, k+myOrder-1);
                if(wg.equals(kGram)){
                    follows.add(myText[k+kGram.length()]); 
                }
            }
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
