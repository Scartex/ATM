import java.util.*;
import java.io.*;

public class main{
  public static void main(String[] args){

    Scanner tastatur = new Scanner(System.in);
    ATM bank = new ATM();
    int valg = 0;
    boolean run = true;

    System.out.println("Velkommen til ATM!");
    System.out.println("Vennligst velg et alternativ" + "\n");


    while(run){
    System.out.println("1. Registrer person");
    System.out.println("2. Sett inn penger");
    System.out.println("3. Ta ut penger");
    System.out.println("4. Se balanse");
    System.out.println("5. Skriv info om personer");
    System.out.println("6. Fjern person");
    System.out.println("7. Overfoer penger");
    System.out.println("8. Oversikt over utlaante penger");
    System.out.println("9. Avslutt");

    int alternativ = Integer.parseInt(tastatur.nextLine());
    valg = alternativ;

    switch(alternativ){
      case 1: bank.registrerPerson();
              break;
      case 2: bank.settInnPenger();
              break;
      case 3: bank.taUtPenger();
              break;
      case 4: bank.seBalanse();
              break;
      case 5: bank.skrivInfoMeny();
              break;
      case 6: bank.fjernPerson();
              break;
      case 7: bank.overfoerPenger();
              break;
      case 8: bank.printOverfoering();
              break;
      case 9: run = false;
              break;
    }

  }
}
}
