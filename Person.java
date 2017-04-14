import java.util.*;

public class Person{

  private String navn;
  private int balanse;
  private int fodselsnummer;
  private int id = 0;
  private static int teller = -1;


  public Person(String navn, int fdsnmr, int balanse){
    this.navn = navn;
    this.fodselsnummer = fdsnmr;
    this.balanse = balanse;
    teller++;
    id = teller;
  }

  public String getNavn(){
    return navn;
  }
  public int getFdsnmr(){
    return fodselsnummer;
  }
  public int getBalanse(){
    return balanse;
  }
  public int getId(){
    return id;
  }
  public int oekBalanse(int oek){
    return balanse += oek;
  }
  public int taUt(int taUt){
    return balanse -= taUt;
  }
  @Override
  public String toString(){
    return "Navn: " + navn + "\n" + "fodselsnummer: " + fodselsnummer + "\n" + "Balanse: " + balanse + "\n";
  }
}
