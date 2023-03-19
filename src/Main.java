import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int stn,kln;
        Scanner input=new Scanner(System.in);
        System.out.println("Mayın Tarlası oyununa hoş geldiniz.");
        System.out.print("Oyunun sütun sayısını giriniz : ");
        stn=input.nextInt();
        System.out.print("Oyunun kolon sayısını giriniz : ");
        kln=input.nextInt();

        MineSweeper mine=new MineSweeper(stn,kln);
        mine.mineToSTring();
        mine.game();
    }
}