
/**
 * Write a description of FindingMutiGene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindingMutiGene {
public String mystery() {
  String dna = "TTAGTHSYDIFTHSDFHIEYTHDT";
    int pos = dna.indexOf("T");
  int count = 0;
  int startPos = 0;
  String newDna = "";
  if (pos == -1) {
    return dna;
  }
  while (count < 3) {
    count += 1;
    newDna = newDna + dna.substring(startPos,pos);
    startPos = pos+1;
    pos = dna.indexOf("T", startPos);
    if (pos == -1) {
      break;
    }
  }
  newDna = newDna + dna.substring(startPos);
  return newDna;
}
}
