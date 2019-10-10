 
import java.io.File;
import edu.duke.*;
import java.util.*;
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordsInFiles {
    private HashMap<String, ArrayList<String>> myMap;
    public WordsInFiles(){
        myMap = new HashMap<String, ArrayList<String>>();
    }
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        ArrayList<String> name = new ArrayList<String>();
        for (String s : fr.words()){
            if (myMap.containsKey(s)){
                ArrayList<String> list = myMap.get(s);
                int index = list.indexOf(f.getName());
                if (index != -1){
                    int nothing = 0;
                }else{
                    list.add(f.getName());
                }
                myMap.put(s,list);
            }else{
                ArrayList<String> l = new ArrayList<String>();
                l.add(f.getName());
                myMap.put(s,l);
            }
        }
    }
    public void buildWordFileMap(){
        myMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File file: dr.selectedFiles()){
            addWordsFromFile(file);
        }
    }
    public int maxNumber(){
        int maxNum =0;
        for (String s : myMap.keySet()){
            ArrayList<String> num = myMap.get(s);
            if (num.size()>maxNum){
                maxNum = num.size();
            }
        }
        return maxNum;
    }
    public ArrayList<String> wordsInFiles(int number){
        ArrayList<String> words = new ArrayList<String>();
        for (String s : myMap.keySet()){
            ArrayList<String> n = myMap.get(s);
            if (n.size() == number){
                words.add(s);
            }
        }
        return words;
    }
    public void printFilesIn(String word){
        for( String name : myMap.get(word)){
            System.out.println(name);
        }
    }
    public void tester(){
        buildWordFileMap();
        int max = maxNumber();
        ArrayList<String> name = myMap.get("tree");
        for (int k=0;k<name.size();k++){
            System.out.println(name.get(k));
        }
        //ArrayList<String> w = wordsInFiles(4);
        //System.out.println(w.size());
    }
}
