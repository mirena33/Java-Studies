package VehicleCatalogue;

public class Vehicle {

    private String type;
    private String model;
    private String colour;
    private int horsepower;

    public Vehicle(String type, String model, String colour, int horsepower) {

        this.type = type;
        this.model = model;
        this.colour = colour;
        this.horsepower = horsepower;

    }

    public String getType(String type) {
        return this.type;
    }

    public String getModel(String model) {
        return this.model;
    }

    public String getColour(String colour) {
        return this.colour;
    }

    public int getHorsepower(int horsepower) {
        return this.horsepower;
    }

//    @Override
//    public String toString() {
//        return String.format("" +
//                "Type:%s\n" +
//                "Model:%s\n" +
//                "Color:%s\n" +
//                "Horsepower:%d",
//                this.getType()
//                this.getModel(),
//                this.getColour(),
//                this.getHorsepower());

    }

