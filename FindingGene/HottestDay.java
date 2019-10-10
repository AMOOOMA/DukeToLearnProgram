import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * 
 * Write a description of HottedtDay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HottestDay {
 public CSVRecord FindMaxTemp(CSVParser parser){
     CSVRecord largestSoFar = null;
     for (CSVRecord currentRow : parser) {
         largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
     }
     return largestSoFar;
    }
 public CSVRecord hottestInManyDays(){
     CSVRecord largestSoFar = null;
     DirectoryResource dr = new DirectoryResource();
     for (File d : dr.selectedFiles()){
         FileResource fr = new FileResource(d);
         CSVRecord currentRow = FindMaxTemp(fr.getCSVParser());
         largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
     return largestSoFar;
    }
 public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
     if (largestSoFar == null){
             largestSoFar = currentRow;
            }
     else{
             double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
             double LargestTemp = Double.parseDouble(largestSoFar.get("Humidity"));
             if(currentTemp < LargestTemp){
                  largestSoFar = currentRow;
                }
            }
     return largestSoFar;
    }
 public void test(){
     CSVRecord largest = hottestInManyDays();
     System.out.println("hottest Temp was " + largest.get("Humidity") +" at " + largest.get ("DateUTC"));
    }


}
