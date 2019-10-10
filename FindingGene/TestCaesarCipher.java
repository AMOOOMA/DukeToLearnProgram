 

import edu.duke.*;
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
    public void countLetters(String input){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0;k<input.length();k++){
            char ch = Character.toLowerCase(input.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] += 1;
            }
        }
    }
    public String breakCC(String input){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        return cc.encrypt(input, 26-dkey);
    }
    public void methodInCCTwo(){
        for (int i = 0;i < 26; i++){
            String an = CC(test,2,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,3,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,4,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,5,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,6,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,7,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,8,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,9,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,10,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,11,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,12,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,13,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,14,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,15,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,16,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,17,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,18,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,19,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,20,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,21,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,22,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,23,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,24,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,25,i);
            check[i] = an;
            if (check(an)>currIndex){
                answer = an;
                currIndex = check(an);
            } 
        }
        for (int i = 0;i < 26; i++){
            String an = CC(test,26,i);
            check[i] = an;
            if (check(an) > currIndex){
                answer = an;
                currIndex = check(an);
            } 
            
        }
    }
}
