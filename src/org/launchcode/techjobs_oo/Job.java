package org.launchcode.techjobs_oo;

import java.util.Objects;
import java.util.stream.Stream;

public class Job {

    private final int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    //  Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job () {
        this.id = nextId;
        nextId++;
    }

    public Job (String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // add toString()

    @Override
    public String toString() {
        return Stream.of(name, employer, location, positionType, coreCompetency).allMatch(Objects::isNull) ?
            "OOPS! This job does not seem to exist." :
                "\n" + "ID: " + id +
                "\n" + "Name: " + (name == null ? "Data not available" : name) +
                "\n" + "Employer: " + (employer.getValue() == null ? "Data not available" : employer.getValue()) +
                "\n" + "Location: " + (location.getValue() == null ? "Data not available" : location.getValue()) +
                "\n" + "Position Type: " + (positionType.getValue() == null ? "Data not available" : positionType.getValue()) +
                "\n" + "Core Competency: " + (coreCompetency.getValue() == null ? "Data not available" : coreCompetency.getValue());
    }

    //  Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //  Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
