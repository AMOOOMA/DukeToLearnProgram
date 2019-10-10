import edu.duke.*;
import java.util.*;
/**
 * Write a description of Asignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asignment {
    private HashMap<String, Integer> myMap;
    public Asignment(){
        myMap = new HashMap<String, Integer>();
    }
    public void buildCondonMap(int start, String dna){
        myMap.clear();
        String s = dna.substring(start, dna.length());
        int index = s.length();
        int extra = (index)%3;
        String dna2 = s.substring(0, index-extra);
        int count = (dna2.length())/3;
        for (int k =0; k<count;k++){
            int first =k+k+k ;
            int second =k+k+k+3;
            String dnaFrac = dna2.substring(first,second);
            if (myMap.containsKey(dnaFrac) == true){
                myMap.put(dnaFrac, myMap.get(dnaFrac)+1);
            }else if (dnaFrac.length() == 3){
                myMap.put(dnaFrac,1);
            }
        }
    }
    public void  test(){
        String dna = "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC";
        buildCondonMap(0,dna);
        int count = 0;
        for (String s: myMap.keySet()){
            System.out.println(s + " " + myMap.get(s));
            count = count +1;
        }
        String dnaS = getMostCommonCodon();
        System.out.println("The most often dna is "+dnaS + " " + myMap.get(dnaS)+ " and the total dna is "+ count);
    }
    public String getMostCommonCodon(){
        String MostCommon = "";
        int index =0;
        int a = 0;
        for (String s : myMap.keySet()){
            index = myMap.get(s);
            if (index > a){
                MostCommon = s;
                a = index;
            }
        }
        return MostCommon;
    }
}
