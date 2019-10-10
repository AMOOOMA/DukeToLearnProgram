import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of CasearCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
       private String alphabet;
       private String shiftedAlphabet;
       private int mainKey;
       public CaesarCipher(int key){
           alphabet  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
           shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
           mainKey = key;
        }
       public String encrypt(String input){
           StringBuilder en = new StringBuilder(input);
           for (int i = 0; i < en.length(); i++){
               char currChar = en.charAt(i);
               char Char = Character.toUpperCase(currChar);
               int idx = alphabet.indexOf(Char);
               if (idx != -1){
                   char newChar = shiftedAlphabet.charAt(idx);
                   en.setCharAt(i,newChar);
                }
            }
           return en.toString();
        }
       public void decrypt(String input){
           CaesarCipher cc = new CaesarCipher(26 - mainKey);
           cc.encrypt(input);
        }
       public void test(){
           CaesarCipher cc = new CaesarCipher(21);
           CaesarCipher cc2 = new CaesarCipher(8);
           String wtf = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
           String en = cc.encrypt(wtf);
           String en2 = cc2.encrypt(wtf);
           System.out.println(en + " ");
           System.out.println(en2);
        }
       public void countLength() {
           FileResource re = new FileResource();
           StringBuilder a = new StringBuilder(re.asString());
           int [] counts = new int[31];
           int c = 0;
           for (int i = 0; i< a.length(); i++){     
               char currChar = a.charAt(i);
               if (Character.isLetter(currChar) == true || currChar == '\'' || currChar == '-'){
                   c = c + 1;
                   
                }else{
                    counts[c] = counts[c] +1;
                    c = 0;
               }
            }
           for (int i = 1; i < counts.length; i++) {
               System.out.println("word" +" "+ i +" "+ counts[i]);
           }
        }
}

