
/**
 * Write a description of CCTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CCTwo {
    public String CC(String input, int key1, int key2){
        String alphabet  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        StringBuilder en = new StringBuilder(input);
           for (int i = 0; i < en.length(); i = i + 2){
               char currChar = en.charAt(i);
               char Char = Character.toUpperCase(currChar);
               int idx = alphabet.indexOf(Char);
               if (idx != -1){
                   char newChar = shiftedAlphabet1.charAt(idx);
                   en.setCharAt(i,newChar);
                }
            }
           for (int i = 1; i < en.length(); i = i + 2){
               char currChar = en.charAt(i);
               char Char = Character.toUpperCase(currChar);
               int idx = alphabet.indexOf(Char);
               if (idx != -1){
                   char newChar = shiftedAlphabet2.charAt(idx);
                   en.setCharAt(i,newChar);
                }
            }
           return en.toString();
    }
    public int check(String an){
        int count = 0;
        int currIndex = an.indexOf("E");
        for (int i =0; i < an.length(); i++){
            if (currIndex != -1){
                count =count +1;
                currIndex = an.indexOf("E",currIndex + 1);
                
            }
        }
        return count;
    }
    public void teston(){
        String test = "Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin";
        int currIndex = check(test);
        System.out.println(currIndex);
    }
    public void test(){
        String test = "Duke Computer Science Department Overview";
        String [] check = new String[26];
        String [] group = new String[10];
        String answer = "error";
        int count = 0;
        //for (int i = 0;i < 26; i++){
            String an = CC(test,17,4);
            System.out.println(an);
        //}
    }
}
