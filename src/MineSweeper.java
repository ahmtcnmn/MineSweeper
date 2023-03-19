import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int a, b;
    int stn;
    int kln;
    int stnkln;
    int maySayisi;
    int[] randmMayin;
    int[] numbers;
    String[] numberTostring;
    String[][] gameMay;
    int start = 0;
    boolean isGo = true;
    int puan = 0;

    MineSweeper(int stn, int kln) {
        this.stn = stn;
        this.kln = kln;
        this.stnkln = stn * kln;
        this.maySayisi = (stn * kln) / 4;
        this.randmMayin = new int[maySayisi];
        this.numbers = new int[stnkln];
        this.numberTostring = new String[stnkln];
        this.gameMay = new String[stn][kln];
        mayinTarla();
    }

    void mayinTarla() {

        for (int i = 0; i < randmMayin.length; i++) {
            randmMayin[i] = randomSay();   // randmMayin dizisine rasgele sayı ekliyor.
        }


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 0;
            for (int k = 0; k < randmMayin.length; k++) {
                if (randmMayin[k] == i) {                   //rasgele sayıları tek boyutluya yerlerine yerleştiriyor.
                    numbers[i] = randmMayin[k];
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numberTostring[i] = "-";
            } else {
                numberTostring[i] = "*";
            }
        }

        for (int i = 0; i < gameMay.length; i++) {
            for (int k = 0; k < gameMay[i].length; k++) {
                gameMay[i][k] = numberTostring[start];
                start++;
            }
        }

    }

    void game() {
        int ordinalNumber = 0;
        System.out.println("Oyundaki mayın sayısı 0 ile " + maySayisi + " arasında olacaktır. Kaç tane olacağı şansınıza artık :)");
        Scanner input = new Scanner(System.in);
        for (int i=1;i<=stnkln-maySayisi;i++) {
            System.out.printf("Sütun sayısını giriniz : ");
            while (true) {
                this.a = input.nextInt();
                if (this.a <= stn) {
                    break;
                } else {
                    System.out.printf("Girdiğiniz sayı oyundaki sütun sayısında büyüktür.Tekrar deneyiniz : ");
                }
            }
            System.out.printf("Kolon sayısını giriniz : ");
            while (true) {
                this.b = input.nextInt();
                if (this.b <= kln) {
                    break;
                } else {
                    System.out.printf("Girdiğiniz sayı oyundaki kolon sayısında büyüktür.Tekrar deneyiniz");
                }
            }
            System.out.println("===============================================================================");
            if (gameMay[a][b].equals("-")) {
                puan+=10;
            }if (gameMay[a][b].equals("*")) {
                isGo=false;
                System.out.printf("puanınız"+puan);
                break;
            }
            if (i==(stnkln-maySayisi)-1){
                System.out.println("Son deneme hakkını başarılı olursanız geçtiniz yoksa kaybettiniz :)");
            }
        }
        System.out.print("Oyun Sonu. Puanınız : "+puan);


    }



    int randomSay() {
        Random random = new Random();
        return random.nextInt(this.stnkln);
    }

    void mineToSTring() {
        /**
         for (int i=0;i<numbers.length;i++){
         System.out.print(numbers[i]+" ");
         }
         **/

        for (int i = 0; i < gameMay.length; i++) {
            for (int k = 0; k < gameMay[i].length; k++) {
                System.out.print(gameMay[i][k] + " ");
            }
            System.out.println();
        }

    }

}
