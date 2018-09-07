package com.company.przychodnia.repository;

import com.company.przychodnia.domain.Wiadomosc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WiadomosciRepository extends JpaRepository<Wiadomosc, Long> {
}
