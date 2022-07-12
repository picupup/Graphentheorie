import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

import javax.security.auth.kerberos.KerberosCredMessage;


public class run{

    public static void main(String[] args) {
        int feldWert, zeilenNr=0, spaltenNr, zeilenNr_Aktuell = 0;

        ArrayList<Integer> rowx = new ArrayList<Integer>();
        ArrayList<ArrayList <Integer>> arr = new ArrayList<ArrayList<Integer>>();
        arr.clear();
        boolean condition = true;

        int size;
        //run run = new run();
        int infinity=0;
        Pattern p = Pattern.compile("([a-zA-Z])([0-9]*)([a-zA-Z])([0-9]*)(=)([0-9]*)");
        for (int i = 0; i < args.length; i++) {
           	//System.out.println(args[i]);
            String sr = args[i];
            Matcher m = p.matcher(sr);
            
            spaltenNr = 0;
            feldWert = 0;
            if (m.find()){
                zeilenNr = Integer.parseInt(m.group(2));
                spaltenNr = Integer.parseInt(m.group(4));
                feldWert = Integer.parseInt(m.group(6));
                infinity += feldWert;

                if ( zeilenNr != zeilenNr_Aktuell){
                    arr.add(rowx);
                    if (condition){
                        size = rowx.size();
                        condition = false;
                    }

                    rowx = new ArrayList<Integer>();
                    zeilenNr_Aktuell = zeilenNr;
                    
                }
                //System.out.println("ZeilenNr: " + zeilenNr + "feldWert: " + feldWert);
                rowx.add(feldWert);
                //System.out.println(Integer.toString(feldWert));
            }
        }

        arr.add(rowx);
       if (infinity < 100){
         infinity = 99
       }
       new Durchmesser(arr, infinity + 1);
    }

    public void print(String te) {
        System.out.println(te);
        
    }
}
