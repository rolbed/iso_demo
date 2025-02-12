package de.testsolutions.isodemo;

import static org.junit.Assert.assertNotNull;
import de.testsolutions.isodemo.accessingdatajpa.SponsorRepository;
import de.testsolutions.isodemo.controller.SponsorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IsoDemoApplicationTests {

  @Autowired
  private SponsorRepository sponsorRepository;

  @Autowired
  private SponsorController sponsorController;

  @Test
  void contextLoads() throws Exception {
    assertNotNull("Autowired SponsorRepository is null", sponsorRepository);
    assertNotNull("Autowired SponsorController is null", sponsorController);
  }

}
