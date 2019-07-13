package militaryElite.interfaces;

import militaryElite.helperClasses.interfaces.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}
