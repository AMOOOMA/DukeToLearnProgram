import java.util.*;
import edu.duke.*;
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersInPlay {
    private ArrayList<String> Names;
    private ArrayList<Integer> Freqs;
    public CharactersInPlay(){
        Names = new ArrayList<String>();
        Freqs = new ArrayList<Integer>();
    }
    public void update(String person){
        person = person.toLowerCase();
        int index = Names.indexOf(person);
        if ( index != -1){
            Freqs.set(index,Freqs.get(index) +1);
        }else{
            Names.add(person);
            Freqs.add(1);
        }
    }
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        Names.clear();
        Freqs.clear();
        for (String s : fr.lines()){
            s = s.toLowerCase();
            int index1 = s.indexOf(".");
            if (index1 != -1){
                String person = s.substring(0,index1);
                update(person);
            }
        }
    }
    public void test(){
        findAllCharacters();
        //for (int k=0; k< Names.size(); k++){
        //    System.out.println(Names.get(k) + " " + Freqs.get(k));
        //}
        charactersWithNumParts(9,16);
    }
    public void charactersWithNumParts(int num1, int num2){
        for (int k=0; k< Names.size(); k++){
            if (Freqs.get(k)> num1 && Freqs.get(k)<num2){
                System.out.println( Names.get(k) + " " +Freqs.get(k) );
            }
        }
    }
}
