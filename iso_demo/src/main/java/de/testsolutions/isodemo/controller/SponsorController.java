package de.testsolutions.isodemo.controller;

import de.testsolutions.isodemo.accessingdatajpa.Sponsor;
import de.testsolutions.isodemo.accessingdatajpa.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sponsor")
public class SponsorController {

  @Autowired
  private SponsorRepository sponsorRepository;

  @GetMapping("/")
  public ResponseEntity<List<Sponsor>> getAllSponsors() {
    final List<Sponsor> sponsors = new ArrayList<>();

    sponsorRepository.findAll().forEach(sponsors::add);

    if (sponsors.isEmpty()) {
      return new ResponseEntity<>(sponsors, HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(sponsors, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Sponsor> getSponsorById(@PathVariable("id") final long id) {
    final Optional<Sponsor> sponsorData = sponsorRepository.findById(id);

    if (sponsorData.isPresent()) {
      return new ResponseEntity<>(sponsorData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/")
  public ResponseEntity<Sponsor> createSponsor(@RequestBody final Sponsor sponsor) {
    final Sponsor persistedSponsor = sponsorRepository.save(new Sponsor(sponsor.getName()));
    return new ResponseEntity<>(persistedSponsor, HttpStatus.CREATED);
  }
}
