
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer ana = new LogAnalyzer();
        ana.readFile("short-test_log");
        ana.printAll();
    }
    
    public void testCountUniqueIp(){
        LogAnalyzer l = new LogAnalyzer();
        l.readFile("weblog2_log");
        int size = l.countUniqueIPs();
        System.out.println("There are " + size + " unique IPs");
    }
    
    public void testPrintAllHigherNum(){
        LogAnalyzer l = new LogAnalyzer();
        l.readFile("short-test_log");
        l.printAllHigherThanNum(199);
    }
    
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer l = new LogAnalyzer();
        l.readFile("weblog2_log");
        ArrayList<LogEntry> log = l.uniqueIPVisitsOnDay("Sep 27");
        for (int k = 0; k<log.size();k++){
            System.out.println(log.get(k));
        }
        System.out.println(log.size());
    }
    
    public void testCountUniqueIPsInRange(){
        LogAnalyzer l = new LogAnalyzer();
        l.readFile("weblog2_log");
        int size = l.countUniqueIPsInRange(400,499);
        System.out.println("unique ips in range is " +size);
    }
    
    public void testMostNumberVisitsByIP(){
        LogAnalyzer l = new LogAnalyzer();
        l.readFile("weblog2_log");
        HashMap<String,Integer> ip = l.countVisitsPerIP();
        int MaxNum = l.mostNumberVisitsByIP(ip);
        System.out.println(MaxNum);
    }
    
    public void testIpsMostVisits(){
        LogAnalyzer l = new LogAnalyzer();
        l.readFile("weblog2_log");
        HashMap<String,Integer> ip = l.countVisitsPerIP();
        ArrayList<String> mip = l.iPsMostVisits(ip);
        for (int k = 0; k< mip.size();k++){
            System.out.println( mip.get(k));
        }
    }
    
    public void testIPsForDays(){
        LogAnalyzer l = new LogAnalyzer();
        l.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> map = l.iPsForDays();
        for (String s: map.keySet()){
            System.out.println(s + map.get(s));
        }
    }
    
    public void testDayWithMostIPVisits(){
        LogAnalyzer l = new LogAnalyzer();
        l.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> map = l.iPsForDays();
        String s = l.dayWithMostIPVisits(map);
        System.out.println(s);
    }
    
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer l = new LogAnalyzer();
        l.readFile("weblog2_log");
        ArrayList<String> ip = l.iPsWithMostVisitsOnDay("Sep 30");
        for (int k =0; k<ip.size(); k++){
            System.out.println(ip.get(k));
        }
    }
}
