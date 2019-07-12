package footballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateStatus(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateStatus(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateStatus(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateStatus(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateStatus(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void validateStatus(int value, String type) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(type + " should be between 0 and 100.");
        }
    }

    public String getName() {
        return this.name;
    }

    public double overallSkillLevel() {
        return (this.endurance +
                        this.shooting +
                        this.dribble +
                        this.sprint +
                        this.passing) / 5.00;
    }
}
