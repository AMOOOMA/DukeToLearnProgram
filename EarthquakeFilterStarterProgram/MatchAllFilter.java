import java.util.*;
/**
 * Write a description of MatchAllFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MatchAllFilter implements Filter{
    private ArrayList<Filter> filter;
    public MatchAllFilter(){
        filter = new ArrayList<Filter>();
    }
    public void addFilter(Filter f){
        filter.add(f);
    }
    public boolean satisfies(QuakeEntry quake){
        for (Filter f : filter){
            if(!f.satisfies(quake)){
                return false;
            }
        }
        return true;
    }
    public String getName(){
        String intial = "The filters applied are ";
        StringBuilder name = new StringBuilder(intial);
        for(int k=0; k<filter.size();k++){
            String s = filter.get(k).getName();
            name.append(s + ',' + ' ');
        }
        
        return name.toString();
    }
 }
