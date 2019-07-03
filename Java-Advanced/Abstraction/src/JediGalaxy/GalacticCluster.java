package JediGalaxy;

public class GalacticCluster {
    private Galactic galactic;

    public GalacticCluster(Galactic galactic){
        this.galactic = galactic;
    }


    public void moveEvilForce(int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < galactic.getRow() && evilCol < galactic.getCol()) {
                galactic.setStarValue(evilRow, evilCol, 0);
            }
            evilRow--;
            evilCol--;
        }
    }

    public int collectPlayerStars(int playerRow, int playerCol) {

        int  sum = 0;
        while (playerRow >= 0 && playerCol < galactic.getCol()) {
            if (playerRow < galactic.getRow() && playerCol >= 0 && playerCol < galactic.getCol()) {
                sum += galactic.getStarValue(playerRow, playerCol);
            }

            playerCol++;
            playerRow--;
        }

        return sum;
    }
}
