package JediGalaxy;

public class Player {
    private long stars;

    public Player(){
        this.stars = 0;
    }

    public void addStars(int starsToAdd) {
        this.stars += starsToAdd;
    }

    public long getStars(){
        return this.stars;
    }
}
