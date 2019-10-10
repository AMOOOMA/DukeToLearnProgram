import java.util.*;
import edu.duke.*;
/**
 * Write a description of tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tester {
    public void testGetFollows(){
        MarkovOne m = new MarkovOne();
        m.setTraining("this is a test yes this is a test");
        ArrayList<String> s = m.getFollows("t");
        System.out.println(s.toString());
        
    }   
    public void testGetFollowsWithFiles(){
        MarkovOne m = new MarkovOne();
        FileResource fr = new FileResource();
        m.setTraining(fr.asString());
        ArrayList<String> s = m.getFollows("he");
        System.out.println(s.size());
    }
}
