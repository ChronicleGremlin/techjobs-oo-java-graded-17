package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.testng.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();

        assertNotEquals(testJob1.getId(), testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(true);
        assertEquals(testJob.getName(), "Product tester");
        assertNotNull(testJob.getEmployer());
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertNotNull(testJob.getLocation());
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertNotNull(testJob.getPositionType());
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertNotNull(testJob.getCoreCompetency());
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job testJobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertNotEquals(testJobB, testJobA);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(testJob.toString().charAt(0), '\n');
        assertEquals(testJob.toString().charAt(testJob.toString().length() -1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String answer = "\n" +
                "ID: " + testJob.getId() + '\n' +
                "Name: " + testJob.getName() + '\n' +
                "Employer: " + testJob.getEmployer() + '\n' +
                "Location: " + testJob.getLocation() + '\n' +
                "Position Type: " + testJob.getPositionType() + '\n' +
                "Core Competency: " + testJob.getCoreCompetency() + "\n";

        assertEquals(testJob.toString(), answer);

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job();

        testJob.setLocation(new Location("Desert"));
        testJob.setPositionType(new PositionType("Quality control"));
        testJob.setCoreCompetency(new CoreCompetency("Persistence"));

        String testString = "\n" +
                "ID: " + "1" + "\n" +
                "Name: " + null + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" + "\n";

        assertEquals(testJob.toString(), testString);
    }



    @Test
    public void testToStringHandlesJobDoesNotExist() {
        Job testJob = new Job();

        assertTrue(testJob.toString().contains("OOPS! This job does not seem to exist."));
    }
}
