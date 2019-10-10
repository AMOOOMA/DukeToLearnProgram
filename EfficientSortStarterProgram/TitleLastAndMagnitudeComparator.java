import java.util.*;
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2){
        String t1 = q1.getInfo();
        String t2 = q2.getInfo();
        int index = t1.indexOf(",");
        int index2 = t2.indexOf(",");
        String t1L = t1.substring(index+1,t1.length());
        String t2L = t2.substring(index2+1,t2.length());
        int answer = t1L.compareTo(t2L);
        if(answer < 0){
            return -1;
        }
        if(answer > 0){
            return 1;
        }
        return Double.compare(q1.getMagnitude(), q2.getMagnitude());
    }
}
