package spaceStationRecruitment;

import java.util.LinkedList;

public class SpaceStation {
    private LinkedList<Astronaut> data;
    private String name;
    private int capacity;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getCount(){
        return this.data.size();
    }

    public void add(Astronaut astronaut){
        if (this.data.size() < capacity){
            this.data.add(astronaut);
        }
    }

    public boolean remove(String name){
        boolean check = false;
        for (Astronaut astronaut : this.data) {
            if (astronaut.getName().equals(name)){
                this.data.remove(astronaut);
               check = true;
            }
        }
        return check;
    }

    public Astronaut getOldestAstronaut(){
        Astronaut astronaut = null;
        int oldest = Integer.MIN_VALUE;

        for (Astronaut a: this.data) {
            if (a.getAge() >= oldest){
                oldest = a.getAge();
                astronaut = a;
            }
        }
        return astronaut;
    }

    public Astronaut getAstronaut(String name){
        Astronaut a = null;
        for (Astronaut astronaut : this.data) {
            if (astronaut.getName().equals(name)){
               a = astronaut;
            }
        }

        return a;
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:", getName()))
                .append(System.lineSeparator());

        for (Astronaut astronaut : this.data) {
            sb.append(astronaut).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
