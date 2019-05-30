package com.company.przychodnia;

import com.company.przychodnia.domain.Wiadomosc;
import com.company.przychodnia.repository.WiadomosciRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private WiadomosciRepository wiadomosciRepository;

    @Autowired
    public DataLoader(WiadomosciRepository wiadomosciRepository) {
        this.wiadomosciRepository = wiadomosciRepository;
    }

    public void run(ApplicationArguments args) {
        Wiadomosc wiadomosc1 = new Wiadomosc("Powitanie", "Witaj na nowej platformie służącej obsłudze pacjentów przychodni lekarskiej.", LocalDateTime.of(2018, 9, 14, 14, 36));
        Wiadomosc wiadomosc2 = new Wiadomosc("Zmiana godzin przyjmownia pacjentów", "Informujemy, że w dniu 20 września przychodnia będzie czynna dłużej - do godziny 20.", LocalDateTime.of(2018, 9, 18, 10, 7));
        Wiadomosc wiadomosc3 = new Wiadomosc("Nowy specjalista", "Pragniemy poinformować, że od przyszłego miesiąca będzie można skorzystać z poradni nefrologicznej.", LocalDateTime.of(2018, 9, 21, 8, 11));
        Wiadomosc wiadomosc4 = new Wiadomosc("Zmiana godzin przyjmownia pacjentów", "Informujemy, że w dniu 27 września przychodnia będzie czynna dłużej - do godziny 20.", LocalDateTime.of(2018, 9, 24, 7, 52));
        Wiadomosc wiadomosc5 = new Wiadomosc("Nowe wyposażenie - analizator laboratoryjny", "Z przyjemnością informujemy, że nasza przychodnia wzbogaciła się o nowy analizator laboratoryjny. Sprzęt od dnia jutrzejszego będzie do Państwa dyspozycji.", LocalDateTime.of(2018, 9, 26, 13, 26));
        wiadomosciRepository.save(wiadomosc1);
        wiadomosciRepository.save(wiadomosc2);
        wiadomosciRepository.save(wiadomosc3);
        wiadomosciRepository.save(wiadomosc4);
        wiadomosciRepository.save(wiadomosc5);
        logger.debug("Dodano wiadomosc: {}", wiadomosc1);
        logger.debug("Dodano wiadomosc: {}", wiadomosc2);
        logger.debug("Dodano wiadomosc: {}", wiadomosc3);
        logger.debug("Dodano wiadomosc: {}", wiadomosc4);
        logger.debug("Dodano wiadomosc: {}", wiadomosc5);
        logger.info("Dodano wiadomosci do bazy danych");
    }

}
