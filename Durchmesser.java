import java.util.ArrayList;

/**
 * Durchmesser
 */
public class Durchmesser {
     int infinity;


    public Durchmesser(ArrayList<ArrayList <Integer>> arr, int infinity) {
        this.infinity=infinity;
        
        //ArrayList<ArrayList <Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList <Integer>> d0 = new ArrayList<ArrayList<Integer>>(), dk = new ArrayList<ArrayList<Integer>>();

        //htmlhead();
        
        d0 = d0(arr);
        
        dk(d0,0);
    
    }

    private void out(String st) {
        System.out.print(st);
        
    }
    private void htmlhead() {
        
    }

    private void td(int in,String cl) {

        if (cl.length() == 0){
            if (in == infinity){
                out("<td>#</td>");
            }
            else{
                out("<td>" + in + "</td>");
            }

            
        }
        else{

            if (in == infinity){
                out("<td class=\" "+ cl +"\">#</td>");
            }
            else{
                out("<td class=\" "+ cl +"\">" + in + "</td>");
            }
        }
        
    }

    private void tdstr(String in) {

        out("<td>" + in + "</td>");
        
    }
    



    public void dk(ArrayList<ArrayList <Integer>> list, int num) {
        ArrayList<ArrayList <Integer>> dk = new ArrayList<ArrayList<Integer>>();
        //dk.addAll(list);
        int n = list.size();
        int sInstance, rInstance;
        int r = num; //Anzahl k verbindungen zwischen knoten.
        //Collections.copy(d0, arr);

        if (num < n){
            out("<br><table>");
            out("<tr>");
            tdstr("D(" + num + ")");
            out("<td>");
            out("<table>");
            for (int s = 0; s < n; s++) {
                sInstance = list.get(s).get(r);
                
                    if (s != r && sInstance != infinity){ //wenn (nicht) Zeilen Nr. die gewähltw n von d(n) spricht
                        out("<tr>");
                        for (int zr = 0; zr < n; zr++) {
                            rInstance = list.get(r).get(zr);
                            int value = list.get(s).get(zr);
                            
                            int sum = rInstance + sInstance;
                            if (r != zr && rInstance != infinity  && (sum < value || value == infinity)){ //wenn feld index (nicht) identisch mit gewählte n von d(n) ist.
                                
                                list.get(s).set(zr, sum);
                                value = sum;
                                td(value, "corange");
                            }
                            else if( r == zr){
                                td(value, "cgreen");
                            }

                            else {
                                td(value, "");
                            }
                        }
                        out("</tr>");
                    }
                    else if(s==r){
                        out("<tr class=\"highlight\">");
                        for (int i = 0; i < n; i++) {
                            int value = list.get(s).get(i);
                            td(value, "");
                        }
                        out("</tr>");

                    }
                    else { //wenn zeile mit eine Unendlich beginnt
                        out("<tr>");
                        for (int i = 0; i < n; i++) {
                            int value = list.get(s).get(i);
                            if (i == r){ //falls feld angefärbt sein muss.
                                td(value, "cgreen");
                            }
                            else{
                                td(value, "");
                            }
                        }
                        out("</tr>");
                    }
            }

            out("</table>");
            out("</td>");
            out("</tr>");
            out("</table>");

    
            //print(list);
    
            dk(list, ++num);

        }
        
        
    }


    public ArrayList<ArrayList <Integer>> d0 (ArrayList<ArrayList <Integer>> arr) {
        ArrayList<ArrayList <Integer>> d0 = new ArrayList<ArrayList<Integer>>();
        //print(arr);

        d0.addAll(arr);
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == j){
                    d0.get(i).set(j, 0);
                }

                else if (arr.get(i).get(j) > 0) {
                    d0.get(i).set(j, arr.get(i).get(j));
                }
                else {
                    d0.get(i).set(j, infinity);
                }
            }
        }
        printtable(d0);
        return d0;
    }

    public void print(ArrayList<ArrayList <Integer>> arr) {

        int n=arr.size();
        out("<br><table>");
        out("<tr>");
        tdstr("A(G)");
        out("<td>");

        out("<table>");
        for (int i = 0; i < n; i++) {
            out("<tr>");
            for (int k = 0; k < n; k++) {
                int value = arr.get(i).get(k);
                td(value, "");
            }
            out("</tr>");
            System.out.println("");
        }
        out("</table>");
        out("</td>");
        out("</tr>");
        out("</table>");

    }

    public void printtable(ArrayList<ArrayList <Integer>> arr) {

        int n=arr.size();
        out("<br><table>");
        out("<tr>");
        tdstr("D(0)");
        out("<td>");
        out("<table>");
        for (int i = 0; i < n; i++) {
            out("<tr>");
            for (int k = 0; k < n; k++) {
                int value = arr.get(i).get(k);
                
                if (value == infinity){
                    tdstr("#");
                }
                else{
                    td(value, "");
                }
            }
            out("</tr>");
            System.out.println("");
        }
        out("</table>");
        out("</td>");
        out("</tr>");
        out("</table>");
    }
}