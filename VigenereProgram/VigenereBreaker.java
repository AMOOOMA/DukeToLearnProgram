import java.util.*;
import edu.duke.*;
import java.io.File;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice , int totalSlices){
        StringBuilder s = new StringBuilder();
        StringBuilder o = new StringBuilder(message);
        for (int k= whichSlice ;k< message.length(); k += totalSlices){
            s.append(o.charAt(k));
        }
        String slice = s.toString();
        return slice;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for(int k=0; k<klength;k++){
            String s = sliceString(encrypted, k, klength);
            key[k] = cc.getKey(s);
        }
        return key;
    }

    public void breakVigenere () {
        FileResource e = new FileResource();
        String encrypted = e.asString();
        HashMap<String, HashSet> myMap = new HashMap<String, HashSet>();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            HashSet set = readDictionary(fr);
            myMap.put(f.getName(), set);
            System.out.println( f.getName() + " has been read into HashSet");
        }
        breakForAllLangs(encrypted, myMap);
    }
    
    public HashSet readDictionary(FileResource fr){
        HashSet set = new HashSet();
        for (String s : fr.lines()){
            s = s.toLowerCase();
            set.add(s);
        }
        return set;
    }
        
    public int countWords(String message, HashSet dictionary){
        int count = 0;
        String[] words = message.split("\\W+");
        for (int k = 0;k< words.length;k++){
            String word = words[k];
            word = word.toLowerCase();
            if (dictionary.contains(word)){
                count++;
            }
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet dictionary){
        String decryption = "";
        int countMax = 0;
        char mostCommon = mostCommonCharIn(dictionary);
        for (int k=1; k<100; k++){
            int[] key = tryKeyLength(encrypted, k,mostCommon);
            VigenereCipher vc = new VigenereCipher(key);
            String s = vc.decrypt(encrypted);
            int count = countWords(s, dictionary);
            if (count > countMax){
                countMax = count;
                decryption = s;
            }
        }
        return decryption;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        int[] count = new int[26];
        int MaxIndex =0;
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int i =0;
        for (String s : dictionary){
            for(int k=0; k < s.length(); k++){
            int dex = alph.indexOf(Character.toLowerCase(s.charAt(k)));
            if (dex != -1){
                count[dex] += 1;
            }
           }
        }
        for (int k=0;k<26;k++){
            int currIndex = count[k];
            if (currIndex>MaxIndex){
                MaxIndex = currIndex;
                i = k;
            }
        }
        char a = alph.charAt(i);
        return a;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet> languages){
        int Max = 0;
        String lan = "";
        String decryption = "";
        for ( String s : languages.keySet()){
            String decry = breakForLanguage(encrypted, languages.get(s));
            int currIndex = countWords(decry, languages.get(s));
            if ( currIndex > Max ){
                Max = currIndex;
                lan = s ;
                decryption = decry;
            }
        }
        System.out.println( "Language is " + lan + "\n"  + decryption );
    }
}
