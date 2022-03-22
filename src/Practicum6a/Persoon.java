package Practicum6a;
import java.util.ArrayList;
public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    public Persoon(String nm, double bud) {
        naam = nm;
        budget = bud;
        mijnGames = new ArrayList<>();
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {

        if (budget - g.huidigeWaarde() >= 0 && !mijnGames.contains(g)) {
            mijnGames.add(g);
            budget = budget - g.huidigeWaarde();

            return true;
        }
        return false;
    }
    public boolean verkoop(Game g, Persoon koper) {
        if (mijnGames.contains(g) && !koper.mijnGames.contains(g) && koper.budget - g.huidigeWaarde() >= 0) {
            koper.mijnGames.add(g);
            koper.budget -= g.huidigeWaarde();
            budget += g.huidigeWaarde();
            mijnGames.remove(g);

            return true;
        }
        return false;
    }

        public String toString() {
        String output = naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:\n";
        for (Game g : mijnGames) {
        output += g.toString();
        }
        return output;
    }

}

