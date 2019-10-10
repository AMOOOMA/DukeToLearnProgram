import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of BabyName here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyName {
    public void printName(){
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)){
            int currentRow = 0;
            int numBorn = Integer.parseInt(rec.get(2));
            if ( numBorn > currentRow ){
            System.out.println("Name" + rec.get(0) + "Gender" + rec.get(1) + "Num Born" + rec.get(2));
        }
        }
    }
    
    public void totoalBirths (FileResource fr){
        int totalBirths = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
        }
        System.out.println(totalBirths);
    }
    public int getRank(int year, String Name, String Gender){
        String File = "us_babynames/us_babynames_by_year" + "/yob" + year +".csv";
        FileResource fr = new FileResource(File);
        int numBorn = 0;
        int count = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            String row = rec.get(0);
            String gender = rec.get(1);
            if ( row.contains(Name)&& gender.contains(Gender)){
                numBorn = Integer.parseInt(rec.get(2));
            }
        }
        for (CSVRecord rec : fr.getCSVParser(false)){
            int currentRow = Integer.parseInt(rec.get(2));
            String gender = rec.get(1);
            if ( currentRow > numBorn && gender.contains(Gender)) {
                count = count +1;
            }
        }
        count = count + 1;
        return count; 
    }
    public String getName(int year, int rank, String Gender){
        String File = "us_babynames/us_babynames_by_year" + "/yob" + year +".csv";
        FileResource fr = new FileResource(File);
        String name = "No name";
        int count = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            
            String gender = rec.get(1);
            if(gender.contains(Gender)) {
                count = count +1;
                if (gender.contains(Gender) && count==rank) {
                    name = rec.get(0);
               }
            }
        }
        return name;
    }
    public String whatIsNameInYear(String Name, int year, String Gender,int newYear){
        int rank = getRank(year, Name, Gender);
        String name = getName(newYear, rank, Gender);
        return name;
    }
    public String yearOfHighestRank(String Name, String Gender){
      
        String largest = "";
        int numBorn = 0;
        int count = 1;
        int preC = 10000;
        
      File dir = new File("us_babynames/us_babynames_by_year");
      File[] directoryListing = dir.listFiles();
    
      for (File child : directoryListing) {
            FileResource fr = new FileResource(child);
            for (CSVRecord rec : fr.getCSVParser(false)){
                String row = rec.get(0);
                String gender = rec.get(1);
                if ( row.contains(Name)&& gender.contains(Gender)){
                    numBorn = Integer.parseInt(rec.get(2));
                }
            }
            for (CSVRecord rec : fr.getCSVParser(false)){
                int currentRow = Integer.parseInt(rec.get(2));
                String gender = rec.get(1);
                if ( currentRow > numBorn && gender.contains(Gender)) {
                    count = count +1;
                }
            }
            if ( count < preC ){
                largest = child.getName();
                preC = count;
            }
            count = 1;
        }
        return largest;
    }
    public float getAverageRank( String Name, String Gender,int gap){
        DirectoryResource dr = new DirectoryResource();
        float Ave = 0;
        int curr = 0;
        int total = 0;
      File dir = new File("us_babynames/us_babynames_by_year");
      File[] directoryListing = dir.listFiles();
    
      for (File child : directoryListing) {
            FileResource fr = new FileResource(child);
            int count = 1;
            int numBorn = 0;
            for (CSVRecord rec : fr.getCSVParser(false)){
                String row = rec.get(0);
                String gender = rec.get(1);
                if ( row.contains(Name)&& gender.contains(Gender)){
                    break;
               }
               count = count +1;
               
            }
            total = count + total;
       }
       Ave = (float)total/gap; 
       return Ave;
    }
    
   
    public void test(){
        float rank = getAverageRank( "Robert","M",135);
        System.out.println(rank);
    }
}
