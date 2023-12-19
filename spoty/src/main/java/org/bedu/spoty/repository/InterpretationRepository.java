package org.bedu.spoty.repository;

import org.bedu.spoty.model.Interpretation;
import org.bedu.spoty.model.InterpretationKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterpretationRepository extends JpaRepository<Interpretation, InterpretationKey> {
}
