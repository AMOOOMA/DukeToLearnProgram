import java.util.*;
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter{
    private Location loca;
    private double maxDist;
    public DistanceFilter(Location l, double max){
        loca = l;
        maxDist = max;
    }
    public boolean satisfies(QuakeEntry quake){
        double dist = quake.getLocation().distanceTo(loca)/1000.00;
        if(dist<maxDist){
                return true;
        }
        return false;   
    }
    public String getName(){
        String answer = "DistanceFilter";
        return answer;
    }
}
