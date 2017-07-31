import music.CdStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        boolean programRunning = true;

        CdStore cd1 = new CdStore("Katy Perry", "Summer", 2005, 10);
        CdStore cd2 = new CdStore("Beattle", "Abby Road", 1960, 20);
        CdStore cd3 = new CdStore("Justin Bieber", "Me-Me and more Me", 2010, 5);
        CdStore cd4 = new CdStore("Madonna", "Virgin", 1987, 10);
        CdStore cd5 = new CdStore("Taylor Swift", "1989", 1960, 18);


        ArrayList<CdStore> allCds = new ArrayList<CdStore>();
        allCds.add(cd1);
        allCds.add(cd2);
        allCds.add(cd3);
        allCds.add(cd4);
        allCds.add(cd5);
        while (programRunning) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("What would you like to do: All Cds, year, price, artist name or Exit?");
            try {

                String userChoice = bufferedReader.readLine();

                if (userChoice.equals("All Cds")) {
                    for (CdStore eachCd : allCds) {
                        System.out.println("----------------------");
                        System.out.println(eachCd.artistName);
                        System.out.println(eachCd.albumName);
                        System.out.println(eachCd.releaseYr);
                        System.out.println(eachCd.price);

                    }
                } else if (userChoice.equals("year")) {
                    System.out.println("What year would you like to search?");
                    String year = bufferedReader.readLine();
                    int inputYr = Integer.parseInt(year);
                    for (CdStore eachCd : allCds) {
                        if (eachCd.releaseYear(inputYr)) {
                            System.out.println("----------------------");
                            System.out.println(eachCd.artistName);
                            System.out.println(eachCd.albumName);
                            System.out.println(eachCd.releaseYr);
                            System.out.println(eachCd.price);
                        }
                    }
                } else if (userChoice.equals("price")) {
                    System.out.println("What 's your cost maximum?");
                    String maximum = bufferedReader.readLine();
                    System.out.println("What's your cost minimum?");
                    String minimum = bufferedReader.readLine();
                    int inputMin = Integer.parseInt(minimum);
                    int inputMax = Integer.parseInt(maximum);
                    for (CdStore eachCd : allCds) {
                        if (eachCd.cost(inputMin, inputMax)) {
                            System.out.println("----------------------");
                            System.out.println(eachCd.artistName);
                            System.out.println(eachCd.albumName);
                            System.out.println(eachCd.releaseYr);
                            System.out.println(eachCd.price);
                        }
                    }
                } else if (userChoice.equals("artist name")) {
                    System.out.println("What is the name of your favorite artist?");
                    String inputArtistName = bufferedReader.readLine();
                    boolean answer = false;
                    for (CdStore eachCd : allCds) {
                        if (eachCd.artistSearch(inputArtistName)) {
                            System.out.println("----------------------");
                            System.out.println(eachCd.artistName);
                            System.out.println(eachCd.albumName);
                            System.out.println(eachCd.releaseYr);
                            System.out.println(eachCd.price);
                            answer = true;
                        }

                    } if(!answer){
                        System.out.println("We do not have that artist!");
                    }
                } else if (userChoice.equals("Exit")) {
                    System.out.println("Goodbye!");
                    programRunning = false;
                } else {
                    System.out.println("That's an invalid answer!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}