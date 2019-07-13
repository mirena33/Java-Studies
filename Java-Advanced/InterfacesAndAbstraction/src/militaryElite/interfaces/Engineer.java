package militaryElite.interfaces;

import militaryElite.helperClasses.RepairImpl;
import militaryElite.helperClasses.interfaces.Repair;

import java.util.Collection;

public interface Engineer {
    void addRepair(RepairImpl repair);

    Collection<Repair> getRepairs();
}
