package heroRepository;

import org.junit.Assert;
import org.junit.Test;

public class HeroRepositoryTests {
    @Test
    public void getCountShouldIncreaseSize() {
        HeroRepository heroRepository = new HeroRepository();
        Assert.assertEquals(0, heroRepository.getHeroes().size());
    }

    @Test(expected = NullPointerException.class)
    public void createHeroShouldThrowExceptionIfHeroNull() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = null;
        heroRepository.create(hero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createHeroShouldThrowExceptionIfAlreadyExists() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 11);
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test
    public void createHeroShouldWorkCorrectly() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 11);
        heroRepository.create(hero);
        Assert.assertEquals(hero, heroRepository.getHero("Pesho"));
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExceptionIfNameNull() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove(null);
    }

    @Test
    public void removeShouldWorkCorrectly() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 11);
        heroRepository.create(hero);
        boolean actual = heroRepository.remove("Pesho");
        Assert.assertTrue(actual);
    }

    @Test
    public void getHeroWithHighestLevelShouldWorkCorrectly() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 11);
        Hero hero2 = new Hero("gosho", 100);
        heroRepository.create(hero);
        heroRepository.create(hero2);
        Hero actualHero = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(hero2, actualHero);
    }

    @Test
    public void getHeroWithHighestLevelShouldReturnNullIfNoHeroes() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = heroRepository.getHeroWithHighestLevel();
        Assert.assertNull(hero);
    }

    @Test
    public void getHeroShouldWorkCorrectly() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 11);
        heroRepository.create(hero);

        Hero actual = heroRepository.getHero("Pesho");
        Assert.assertEquals(hero, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getHeroesShouldThrowException(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 11);
        Hero hero2 = new Hero("gosho", 100);
        heroRepository.create(hero);
        heroRepository.create(hero2);

        heroRepository.getHeroes().clear();
    }
}
