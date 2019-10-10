import java.util.*;
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EfficientMarkovModel extends AbstractMarkovModel{
    private int n;
    private HashMap<String,ArrayList<String>> map;
    
     public EfficientMarkovModel(int num) {
        myRandom = new Random();
        n = num;
        map = new HashMap<String, ArrayList<String>>();
        
     }
    
     public void setTraining(String s){
        myText = s.trim();
     }
        
     public String getRandomText(int numChars){
        buildMap();
         if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-n);
        String key = myText.substring(index,index+n);
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
     
     public String toString(){
            String s = "The model is number " + n;
            return s;
        }
      
        
     public void buildMap(){
            for(int k =0;k<myText.length();k++){
                String s = "";
                if(k<myText.length()-n){
                    s = myText.substring(k, k+n);                    
                }else {
                    s = myText.substring(myText.length()-n, myText.length());
                }
                ArrayList<String> answer = new ArrayList<String>();
                int index =0;
                if(map.containsKey(s) == false){
                    for(int pos =0;pos<myText.length();pos++){                
                        index = myText.indexOf(s,pos);
                        if(index == -1){
                            break;
                         }
                        if(index == myText.length()-n){
                             break;
                        }
                            answer.add(myText.substring(index+ n, index+n+1));
                            pos = index;
                    }
                }   
                if(map.containsKey(s) == false&&answer != null){
                    map.put(s, answer);
                }
                
            }
            printHashMapInfo();
        }
        
     public ArrayList<String> getFollows(String key){
            ArrayList<String> answer = map.get(key);
            if( answer == null){
                ArrayList<String> sub = new ArrayList<String>();
                sub.add(" ");
                answer = sub;
            }
            return answer;
        }
        
     public void printHashMapInfo(){
         int max = 0;
         int index = 0;
         String biggest = null;
         
         for(String s: map.keySet()){
                //System.out.println( s + "//" + map.get(s)); 
                index++;
                ArrayList<String> answer = map.get(s);
                int size = answer.size();
                if(size > max){
                    max = size;
                    biggest = s;
                }
            }
            System.out.println("The size of map is " + index);
            System.out.println("The biggest key size is " + max);
            System.out.println("The key is " + biggest);
        }
}
