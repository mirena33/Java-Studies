package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private int exploredPlanets;

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        Astronaut astronaut = null;

        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                return ASTRONAUT_INVALID_TYPE;
        }
        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        for (String item : items) {
            planet.getItems().add(item);
        }
        this.planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        if (this.astronautRepository.findByName(astronautName) == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        this.astronautRepository.remove(this.astronautRepository.findByName(astronautName));

        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Mission mission = new MissionImpl();
        Planet planet = this.planetRepository.findByName(planetName);

        List<Astronaut> suitableAstronauts = this.astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());


        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        mission.explore(planet, suitableAstronauts);

        List<Astronaut> deadAstronauts = suitableAstronauts.stream().filter(a -> !a.canBreath()).collect(Collectors.toList());

        exploredPlanets++;
        return String.format(PLANET_EXPLORED, planetName, deadAstronauts.size());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanets))
                .append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());

        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            sb.append(astronaut.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
