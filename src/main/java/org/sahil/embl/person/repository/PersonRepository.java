package org.sahil.embl.person.repository;

import org.sahil.embl.person.model.PersonDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonDAO, Long> {
}
