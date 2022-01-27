package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob4;

    @Before
    public void createJobObject() {
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob4 = new Job("Product tester", new Employer(), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test //each Job object should contain a unique ID number and these should also be sequential integers
    public void testSettingJobId() {
        assertNotEquals(testJob1.getId(), testJob2.getId());
        assertEquals(testJob1.getId() + 1, testJob2.getId());
    }

    @Test //each job object made with full constructor should contain all 6 fields with correct data types
    public void testJobConstructorSetsAllFields () {
        // test values
        assertEquals(3, testJob3.getId());
        assertEquals("Product tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().getValue());
        assertEquals("Desert", testJob3.getLocation().getValue());
        assertEquals("Quality control", testJob3.getPositionType().getValue());
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());

        // test classes
        assertTrue(testJob3.getName() instanceof String);
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobDotToString() {
        //The string should contain a label for each field, followed by the data stored in that field.
        // Each field should be on its own line. EX:
        //ID:  _______
        //Name: _______
        //Employer: _______
        //Location: _______
        //Position Type: _______
        //Core Competency: _______
        assertEquals("\n" +
                "ID: 3" + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: ACME" + "\n" +
                "Location: Desert"  + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence", testJob3.toString());
        // If a field is empty, the method should add, “Data not available” after the label
        assertEquals("\n" +
                "ID: 4" + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: Desert"  + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence", testJob4.toString());
        // If a Job object ONLY contains data for the id field, the method should return,
        // “OOPS! This job does not seem to exist.”
        //assertEquals("OOPS! This job does not seem to exist.", testJob1.toString());
    }

}
