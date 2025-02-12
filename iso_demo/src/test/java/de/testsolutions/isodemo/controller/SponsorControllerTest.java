package de.testsolutions.isodemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import de.testsolutions.isodemo.accessingdatajpa.Sponsor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class SponsorControllerTest {

  @Autowired
  private SponsorController sponsorController;

  @Test
  void testPersistance() {
    assertTrue("GET on all Sponsors is not successful (2xx)",
        sponsorController.getAllSponsors().getStatusCode().is2xxSuccessful());

    sponsorController.createSponsor(new Sponsor("TestSponsor1"));
    List<Sponsor> sponsors = sponsorController.getAllSponsors().getBody();

    assertEquals("Not exactly 1 Sponsor found", 1, sponsors.size());
    assertEquals("Name of Sponsor 1 is wrong", "TestSponsor1", sponsors.get(0).getName());

    sponsorController.createSponsor(new Sponsor("TestSponsor2"));
    sponsors = sponsorController.getAllSponsors().getBody();

    assertEquals("Not exactly 2 Sponsors found", 2, sponsors.size());
    assertEquals("Name of Sponsor 2 is wrong", "TestSponsor2",
        sponsorController.getSponsorById(2).getBody().getName());
    assertEquals("Name of Sponsor 1 is wrong after adding Sponsor 2", "TestSponsor1",
        sponsorController.getSponsorById(1).getBody().getName());
    assertTrue("GET on all Sponsor 3 returns no error status code (4xx)",
        sponsorController.getSponsorById(3).getStatusCode().is4xxClientError());
  }

}
