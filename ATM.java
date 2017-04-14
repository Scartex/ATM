import java.util.*;
import java.io.*;

public class ATM{

  private Scanner tastatur = new Scanner(System.in);
  private String navn; private int fdsnmr; private int balanse;
  private int t = 0;

  ArrayList<Person> personer = new ArrayList<Person>();
  ArrayList<Person> utlaant = new ArrayList<Person>();
  ArrayList<Person> laaner = new ArrayList<Person>();

  public void registrerPerson(){
    try{
      System.out.println("Navn:");
      navn = tastatur.nextLine();
      System.out.println("fodselsnummer:");
      fdsnmr = Integer.parseInt(tastatur.nextLine());
      System.out.println("Balanse:");
      balanse = Integer.parseInt(tastatur.nextLine());
    } catch(NumberFormatException e){
        System.out.println("Vennligst skriv inn et tall");
      }

    Person nyperson = new Person(navn, fdsnmr, balanse);
    personer.add(nyperson);
    System.out.println(navn + " har blitt registrert!");
  }



  public void seBalanse(){
    if(personer.isEmpty()){
      System.out.println("Ingen personer registrert!" + "\n");
      return;
    }
    int t = 0;
    System.out.println("Hvem oensker du aa se balanse for?");

    printPersoner();
    int b = Integer.parseInt(tastatur.nextLine());
    System.out.println("Balanse for " + personer.get(b).getNavn() + ": " + personer.get(b).getBalanse() + " kr");
  }

  public void printPersoner(){
    for(Person p : personer){
      System.out.println("[" + p.getId() + "]" + p.getNavn());
    }
  }



  public void settInnPenger(){
    if(personer.isEmpty()){
      System.out.println("Ingen personer registrer, vennligst registrer deg" + "\n");
      return;
    }
    int penger = 0;
    System.out.println("Hvem oensker du aa sette inn penger for?");

    printPersoner();

    int valg = Integer.parseInt(tastatur.nextLine());

    System.out.println("Hvor mye oensker du aa sette inn?");
    penger = Integer.parseInt(tastatur.nextLine());

    try{
      personer.get(valg).oekBalanse(penger);
    } catch(NumberFormatException e){
      System.out.println("Vennligst skriv inn et tall!");
    }
    System.out.println("Ny sum: " + personer.get(valg).getBalanse() + " kr");
  }



  public void taUtPenger(){
    if(personer.isEmpty()){
      System.out.println("Ingen personer registrert" + "\n");
      return;
    }
    int penger = 0;
    System.out.println("Hvem oensker du aa ta ut penger for?");

    printPersoner();
    int valg = Integer.parseInt(tastatur.nextLine());

    System.out.println("Hvor mye oensker du aa ta ut?");
    penger = Integer.parseInt(tastatur.nextLine());

    personer.get(valg).taUt(penger);
    System.out.println("Ny sum: " + personer.get(valg).getBalanse() + " kr");
  }

  public void skrivUtInfo(){
    if(personer.isEmpty()){
      System.out.println("Ingen personer registrert" + "\n");
      return;
    }
    System.out.println("Hvem oensker du aa se info for?");
    printPersoner();

    int valg = Integer.parseInt(tastatur.nextLine());
    System.out.println(personer.get(valg).toString());
  }

  public void skrivUtAlle(){
    if(personer.isEmpty()){
      System.out.println("Ingen personer registrert!" + "\n");
      return;
    }
    for(Person p : personer){
      System.out.println(p.toString());
    }
  }

  public void skrivInfoMeny(){
    System.out.println("1. Velg person");
    System.out.println("2. skriv ut alle");

    int valg = Integer.parseInt(tastatur.nextLine());

    switch(valg){
      case 1: skrivUtInfo();
              break;
      case 2: skrivUtAlle();
              break;
    }
  }

  public void fjernPerson(){
    if(personer.isEmpty()){
      System.out.println("Ingen personer registrert!" + "\n");
      return;
    }
    System.out.println("Hvem oensker du aa fjerne?");
    printPersoner();
    int valg = Integer.parseInt(tastatur.nextLine());

    personer.remove(valg);
  }

  public void overfoerPenger(){
    if(personer.size() < 2){
      System.out.println("Det maa vaere registrert mer enn 1 person!");
      return;
    }
    System.out.println("Hvem skal overfoere?");
    printPersoner();
    int overfoerer = Integer.parseInt(tastatur.nextLine());
    printPersoner();
    System.out.println("Hvem skal overfoeres til?");
    int mottaker = Integer.parseInt(tastatur.nextLine());
    printPersoner();
    System.out.println("Hvor mye skal overfoeres?");
    int penger = Integer.parseInt(tastatur.nextLine());

    personer.get(overfoerer).taUt(penger);
    personer.get(mottaker).oekBalanse(penger);
    System.out.println(personer.get(overfoerer).getNavn() + " overfoerte " + penger + " til " + personer.get(mottaker).getNavn());
    utlaant.add(personer.get(overfoerer));
    laaner.add(personer.get(mottaker));
  }

  public void printOverfoering(){
    if(personer.isEmpty()){
      System.out.println("Ingen personer registrert!");
      return;
    }
    System.out.println("Hvem som har overfoert til hvem:" + "\n");
    for(Person p : utlaant){
      for(Person b : laaner){
        System.out.println(p.getNavn() + " har overfoert til " + b.getNavn());
      }
    }
  }
}
