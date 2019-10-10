import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of CSV here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSV {
    public void listExporters(CSVParser parser, String item1, String item2){
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(item1)&&export.contains(item2)){
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    public void whoExportCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int count = 0;
        for (CSVRecord record : parser) {
            String money = record.get("Value (dollars)"); 
            if (money.length() > 12){
                String country = record.get("Country");
                System.out.println(country);
            }
            
        }
        //System.out.println(count);
    }
}
