
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for (String s : fr.lines()){
             LogEntry l = WebLogParser.parseEntry(s);
             records.add(l);
         }
     }
        
     public void printAll(){
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
         ArrayList<String> ip = new ArrayList<String>();
         for (LogEntry le: records){
             String currIp= le.getIpAddress();
             if ( !ip.contains(currIp)){
                    ip.add(currIp);
                }
            }
         return ip.size();
     }
     
     public void printAllHigherThanNum(int num){
         for (LogEntry le : records){
             int statusCode = le.getStatusCode();
             if( statusCode > num){
                 System.out.println(le);               
             }
         }
     }
     
     public ArrayList<LogEntry> uniqueIPVisitsOnDay(String someday){
         ArrayList<LogEntry> l = new ArrayList<LogEntry>(); 
         ArrayList<String> ip = new ArrayList<String>();
         for (LogEntry le : records){
             Date date = le.getAccessTime();
             String d = date.toString(); 
             d = d.substring(4,10);
             if (d.equals(someday)){
                 String curr = le.getIpAddress(); 
                 if (!ip.contains(curr)){ 
                     l.add(le);
                     ip.add(curr);
                    }
                }
         }
         return l;
     }
     
     public int countUniqueIPsInRange(int low, int high){
         int ip = 0;
         ArrayList<String> i = new ArrayList<String>();
         for (LogEntry le : records){
             int statusCode = le.getStatusCode();
             if (low<statusCode && statusCode<high){
                 String curr = le.getIpAddress();
                 if (!i.contains(curr)){
                     ip = ip+1;
                     i.add(curr);
                    }
                }
         }
         return ip;
     }
     
     public HashMap<String,Integer> countVisitsPerIP(){
         HashMap<String,Integer> map = new HashMap<String, Integer>();
         for (LogEntry le: records){
             String ip = le.getIpAddress();
             if (map.containsKey(ip)){
                 map.put(ip, map.get(ip)+1);
                }
             else{
                 map.put(ip, 1);
                }
            }
         return map;
     }
        
     public int mostNumberVisitsByIP(HashMap<String,Integer> ip){
         int MaxNum = 0;
         for (String s: ip.keySet()){
             int currNum = ip.get(s);
             if (currNum>MaxNum){
                 MaxNum = currNum;
                }
            }
         return MaxNum;   
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> ip){
         ArrayList<String> mip = new ArrayList<String>();
         int MaxNum = mostNumberVisitsByIP(ip);
         for (String s: ip.keySet()){
             if (ip.get(s) == MaxNum){
                 mip.add(s);
                }
            }
         return mip;
     }
     
     public HashMap<String,ArrayList<String>> iPsForDays(){
         HashMap<String, ArrayList<String>> day = new HashMap<String, ArrayList<String>>();
         for (LogEntry le: records){
             String ip = le.getIpAddress();
             Date days = le.getAccessTime();
             String d = days.toString();
             d = d.substring(4,10);
             ArrayList<String> ips = new ArrayList<String>();
             if ( !day.containsKey(d) ){
                 ips.add(ip);
                 day.put(d,ips);
                }
             else{
                 ips = day.get(d);
                 ips.add(ip);
                 day.put(d,ips);
                }
            }
         
         return day;
     }
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> ips){
         String day = new String();
         int max = 0;
         for( String s : ips.keySet()){
             ArrayList<String> ip = ips.get(s);
             if(ip.size() == max){
                 day = day + " " + s;
                }
             if (ip.size() > max){
                 day = s;
                 max = ip.size();
                }
            }
         return day;
     }
     
     public ArrayList<String> iPsWithMostVisitsOnDay(String date){
         ArrayList<String> ip = new ArrayList<String>();
         HashMap<String, Integer> myMap = new HashMap<String, Integer>();
         int max = 0;
         for (LogEntry le: records){
             String IP = le.getIpAddress();
             Date days = le.getAccessTime();
             String d = days.toString();
             d = d.substring(4,10);
             if( d.equals(date)){
                 if ( myMap.containsKey(IP)){
                     myMap.put(IP, myMap.get(IP) +1);
                    }else{
                     myMap.put(IP, 1);
                    }
                }
            }
         for (String s: myMap.keySet()){
             int index = myMap.get(s);
             if (index == max){
                 ip.add(s);
                }
             else if (index>max){
                 ip.clear();
                 ip.add(s);
                 max = index;
                }
            }
         return ip;
        }
}
