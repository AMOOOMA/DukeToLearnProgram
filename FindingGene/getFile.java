
/**
 * Write a description of getFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class getFile {
    public void test(){
        int year = 1880;
        while (year < 2014){
            year = year + 1;
            String File ="yob" + year +".csv";
            System.out.println(File);
        }
    }
    
}
