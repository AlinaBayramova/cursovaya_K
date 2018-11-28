import java.util.Scanner;

class Mnozh {
    Mnozh(Scanner sc, byte n) {
        String tmp = sc.next();
        if (tmp.equals("First") || tmp.equals("Second")){

            //цел , ..цел
        } else {
            System.out.println("Ожидалось слово First or Second");
            System.exit(n++);
        }
        tmp = sc.next();
        if(tmp.equals("Add") || tmp.equals("Multy")){
            if(sc.hasNextDouble()){
                System.out.println("Встретилось"+ sc.nextDouble());
            } else{
                System.out.println("Ожидалось вещественное число!");
                n++;
                System.exit(n);
            }
        } else {
            System.out.println("Ожидалось слово Add or Multy");
            n++;
            System.exit(n);
        }

    }
}



public class Main {

    public static void main(String[] args) {
        System.out.println("Введите строку!");
        byte n = 0;
        Scanner scan = new Scanner(System.in);
        try {
           if (scan.hasNextLine()) {
               String begin = scan.next().toUpperCase();
               if (begin.equals("BEGIN")) {
                   Mnozh mn_vo = new Mnozh(scan, n);
               } else {
                   System.out.println("Язык должен начинаться со слова Begin");
                   n++;
                   System.exit(n);
               }
           } else {
               System.out.println("End-of-Line");
               n++;
               System.exit(n);
           }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
