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
        Job testJobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertNotEquals(testJobB, testJobA);
    }
}
