package basics.Scan;

import java.util.Scanner;

public class ScanTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()){
            String str=s.next();
            System.out.println(str);
        }
        while (s.hasNextLine()){
            String str=s.nextLine();
            System.out.println(str);
        }
        s.close();
    }
}
