import java.util.*;
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter{
    private String where;
    private String phrase;
    public PhraseFilter(String w, String p){
        where = w;
        phrase = p;
    }
    public boolean satisfies(QuakeEntry quake){
        String info = quake.getInfo();
        if(where == "start"){
            int index= info.indexOf("-");
            String title = info.substring(0,index);
            if(title == phrase){
                return true;
            }
        }
        if(where == "any"){
            int index = info.indexOf(phrase);
            if(index != -1){
                return true;
            }
        }
        if(where == "end"){
            int index = info.indexOf(",");
            int s = info.length();
            String title = info.substring(index+2,s);
            int test = title.indexOf(phrase);
            if(test != -1){
                return true;
            }
        }
        return false;
    }
    public String getName(){
        String answer = "PhraseFilter";
        return answer;
    }
}
