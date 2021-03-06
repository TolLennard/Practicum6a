package Practicum6a;
import java.time.LocalDate;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr) {
        naam = nm;
        releaseJaar = rJ;
        nieuwprijs = nwpr;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        double leeftijd = LocalDate.now().getYear() - releaseJaar;
        return nieuwprijs - ((nieuwprijs / 100 * 30) * leeftijd);
    }

    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false;

        if (andereObject instanceof Game) {
            Game andereGame = (Game) andereObject;

            if (this.naam.equals(andereGame.naam) &&
                    this.releaseJaar == andereGame.releaseJaar) {
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }

    public String toString() {
        return naam + ", uitegeven in " + releaseJaar + "; nieuwprijs: " + String.format("%.2f", nieuwprijs) + " nu voor: " + String.format("%.2f", huidigeWaarde()) + "\n";
    }


}
