package CatLady;

public class StreetExtraordinaire extends Cat{

    public StreetExtraordinaire(String name, double skillValue){
       super(name, skillValue);
    }

    @Override
    public String toString(){
        return "StreetExtraordinaire " + super.toString();
    }
}
