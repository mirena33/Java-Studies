package heroRepository;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add(Hero entity) {
        this.data.add(entity);
    }

    public void remove(String name) {

        Hero currentHero = null;
        for (int i = 0; i < this.data.size(); i++) {
            currentHero = this.data.get(i);

            if (currentHero.getName().equals(name)) {
                this.data.remove(i);
                break;
            }
        }

        //ANOTHER SOLUTION:
        //this.data.removeIf(h -> h.getName().equals(name));
    }

    public Hero getHeroWithHighestStrength() {
        Hero hero = this.data
                .stream()
                .max((h1, h2) -> h1.getItem().getStrength() - h2.getItem().getStrength())
                .get();

        return hero;
    }

    public Hero getHeroWithHighestAgility() {

        Hero hero = null;
        int highestAgility = Integer.MIN_VALUE;

        for (Hero currentHero : this.data) {
            if (currentHero.getItem().getAgility() > highestAgility) {
                highestAgility = currentHero.getItem().getAgility();
                hero = currentHero;
            }
        }
        return hero;
    }

    public Hero getHeroWithHighestIntelligence() {
        Hero hero = this.data.stream().max((h1, h2) -> h1.getItem().getIntelligence() -
                h2.getItem().getIntelligence())
                .get();
        return hero;
    }

    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Hero hero : this.data) {
            sb.append(hero)
            .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
