import java.util.*;
import edu.duke.*;
import java.io.*;
/**
 * Write a description of GladLibs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFreqs {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    private HashMap<String, Integer> myMap;
    public WordFreqs(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
        myMap = new HashMap<String, Integer>();
    }
    public int findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource re = new FileResource();
        int NumUni = 0;
        for ( String s : re.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if ( index != -1 ){
                myWords.add(s);
                myFreqs.add(1);
            }else{
                NumUni = NumUni +1;
            }
            if (myMap.containsKey(s)==true){
                myMap.put(s, myMap.get(s)+1);
            }else{
                myMap.put(s,1);
            }
        }
        return NumUni;
    }
    public void mostCommon(){
        int biggestnum =0;
        String mostOften = "error";
        for (String s : myMap.keySet()){
            if (myMap.get(s)>biggestnum){
                mostOften = s;
                biggestnum = myMap.get(s);
            }
        }
        System.out.println(mostOften + " " + biggestnum);
    }
    public void test(){
        int index = findUnique();
        System.out.println( "There are " + index + " unique words" );
        for ( int k =0; k< myWords.size(); k++){
            System.out.println( myFreqs.get(k) + " " + myWords.get(k) );
        }
        mostCommon();
    }
}
