package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut implements Astronaut {

    public Biologist(String name) {
        super(name, 70.0);
    }

    @Override
    public void breath() {
        if (this.getOxygen() - 5 >= 0) {
            super.setOxygen(this.getOxygen() - 5);
        } else {
            super.setOxygen(0);
        }
    }

}

