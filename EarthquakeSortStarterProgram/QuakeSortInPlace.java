
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitudeWithBubbleSortWithCheck(list);
        //sortByMagnitudeWithCheck(list);
        //sortByLargestDepth(list);
        //for (QuakeEntry qe: list) { 
        //    System.out.println(qe);
        //} 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
    
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int k){
        int index = k;
        for(int i = k+1; i<quakeData.size();i++){
            if(quakeData.get(i).getDepth()>quakeData.get(index).getDepth()){
                index = i;
            }
        }
        return index;
    }
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
        int count =0;
        for(int k=0;k<in.size();k++){
            int index = getLargestDepth(in, k);
            QuakeEntry q = in.get(k);
            QuakeEntry qmax = in.get(index);
            in.set(k, qmax);
            in.set(index, q);
            count++;
            if(count == 70){
                break;
            }
        }
    }

    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted){
        for(int k=0;k<quakeData.size()-numSorted-1;k++){
            double mag1 = quakeData.get(k).getMagnitude();
            double mag2 = quakeData.get(k+1).getMagnitude();
            if(mag1>mag2){
                QuakeEntry q1 = quakeData.get(k);
                QuakeEntry q2 = quakeData.get(k+1);
                quakeData.set(k,q2);
                quakeData.set(k+1,q1);
            }
        }
    }
    
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        int size = in.size();
        for (int k=0; k<size;k++){
            onePassBubbleSort(in, k);
        }
    }
    
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakeData){
        for (int k=0; k<quakeData.size()-1;k++){
            double mag1 = quakeData.get(k).getMagnitude();
            double mag2 = quakeData.get(k+1).getMagnitude();
            if(mag1>mag2){
                return false;
            }
        }
        return true;
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
        for(int k=0; k<in.size()-1;k++){
            if(checkInSortedOrder(in) == true){
                break;
            }else{
                onePassBubbleSort(in,k);
                System.out.println("There has been " + k+" passes");
            }
        }
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
        while(checkInSortedOrder(in)==false){
            for(int k=0; k<in.size();k++){
                int minIdx = getSmallestMagnitude(in,k);
                QuakeEntry qi = in.get(k);
                QuakeEntry qmin = in.get(minIdx);
                in.set(k,qmin);
                in.set(minIdx,qi);
                System.out.println("There has been " + k + " passes");
            }
        }
    }
}
