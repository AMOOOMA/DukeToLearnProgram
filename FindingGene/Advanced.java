
import edu.duke.*;
import java.io.File;
public class Advanced { 
    public int findStopCondon(String dnaStr, int startIndex, String stopCondon){
        int currIndex = dnaStr.indexOf(stopCondon,startIndex+3);
        while(currIndex != -1){
            int diff = currIndex - startIndex;
            if( diff % 3 == 0){
                return currIndex;
            }
            else{
                currIndex = dnaStr.indexOf(stopCondon, currIndex + 1);
            }
            
        }
        return dnaStr.length();
    }
    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG",where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCondon(dna,startIndex,"TAA");
        int tagIndex = findStopCondon(dna,startIndex,"TAG");
        int tgaIndex = findStopCondon(dna,startIndex,"TGA");
        int endIndex = 0;
        if (taaIndex==-1||tagIndex==-1||tgaIndex==-1){
            return"";
        }
        else{
            endIndex = Math.min(taaIndex,Math.min(tagIndex,tgaIndex));
        }
        if (endIndex == dna.length()){
            return"";
        }
        return dna.substring(startIndex,endIndex + 3);
    }
    public StorageResource getAllGene(String dna){
        StorageResource genelist = new StorageResource();
        int startIndex = 0; 
        while (true) {
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            genelist.add(currGene);
            startIndex = dna.indexOf(currGene, startIndex)+ currGene.length();
        }
        return genelist;
    }
    public float getCG (String dna){
        int countC = 0;
        int countG = 0;
        float total = 0;
        int currIndex = 0; 
        int currIndex2 = 0;
        while(true){
        if ( dna.indexOf("C",currIndex) != -1 ){
            countC = countC + 1;
            currIndex = dna.indexOf("C",currIndex) + 1; 
        }
        else{
            break;
        }
    }
        while(true){   
        if (dna.indexOf("G",currIndex2) != -1) {
            countG = countG + 1;
            currIndex2 = dna.indexOf("G",currIndex2) + 1;
        }
        else{
            break;
        }
    }
        total= (float)countC + (float)countG;
        int dnal = dna.length();
        float CGratio = total/dnal;
        return CGratio;
    }
    public void countCTG(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        int count = 0;
        int currIndex = 0;
        while (true){
            if ( dna.indexOf("CTG",currIndex) != -1){
                count = count + 1;
                currIndex = dna.indexOf("CTG",currIndex) +3;
            }
            else{
                break;
            }
            }
        System.out.println(count);
    }
    
    public void test(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        int count = 0;
        int Longest = 0;
        StorageResource genes = getAllGene(dna);
        for (String g : genes.data()){
           if (g.length()>60){
               count = count +1;
            }
        }
        System.out.println(count);
        }
        
        }
  
    
    //public void test() {
       // FileResource fr = new FileResource();
        //String dna = fr.asString();
        //StorageResource genes = getAllGene(dna);
        //for (String g : genes.data()){
           // System.out.println(g);
       // }
   // }
   
//}
