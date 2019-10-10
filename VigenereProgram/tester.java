import edu.duke.*;
/**
 * Write a description of tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tester{
    public void test(){
        CaesarCracker cc = new CaesarCracker();
        FileResource fr = new FileResource();
        String s = fr.toString();
        String a = cc.decrypt(s);
        System.out.println(a);
    }
}
