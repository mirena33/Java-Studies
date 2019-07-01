package CatLady;

public class Cymric extends Cat {

    public Cymric(String name, double skillValue){
        super(name, skillValue);
    }

    @Override
    public String toString(){
        return "Cymric " + super.toString();
    }
}
