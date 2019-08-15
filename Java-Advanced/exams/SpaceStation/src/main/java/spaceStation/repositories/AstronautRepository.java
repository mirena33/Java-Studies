package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository implements Repository<Astronaut> {
    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts.values());
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.put(model.getName(), model);
    }

    @Override
    public boolean remove(Astronaut model) {
        Astronaut removedObject = this.astronauts.remove(model.getName());
        boolean isRemoved = true;

        if (removedObject == null) {
            isRemoved = false;
        }

        return isRemoved;
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.get(name);
        //maybe null
    }
}
