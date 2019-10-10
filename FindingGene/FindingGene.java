import edu.duke.*;
import java.io.File;

public class FindingGene {
    public String findGene(String g){
        int startIndex = g.indexOf("ATG");
        int currIndex = g.indexOf("TAA",startIndex + 3);
        while (currIndex != -1){
            
       if ((currIndex-startIndex)%3 == 0){
           String Gene = g.substring(startIndex,currIndex + 3);
           return Gene;
        
     }else{
         currIndex = g.indexOf("TAA",currIndex + 1);
        }
    }
    return"";
    }
    
        
        
        
        
        public void testFindgeneSimple(){
        String g = "ATTTGATGTAGGAATAAATGGTA";
        System.out.println("Gene is" + findGene(g));
    }
}