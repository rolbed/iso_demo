package de.testsolutions.isodemo.accessingdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SponsorRepository extends JpaRepository<Sponsor, Long> {

  Optional<Sponsor> findById(long id);
}
