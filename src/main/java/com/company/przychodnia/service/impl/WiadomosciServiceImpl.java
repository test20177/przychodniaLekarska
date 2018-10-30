package com.company.przychodnia.service.impl;

import com.company.przychodnia.domain.Wiadomosc;
import com.company.przychodnia.repository.WiadomosciRepository;
import com.company.przychodnia.service.WiadomosciService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;



@Service
public class WiadomosciServiceImpl implements WiadomosciService {

    private final WiadomosciRepository wiadomosciRepository;

    private static final Logger logger = LoggerFactory.getLogger(WiadomosciServiceImpl.class);

    @Autowired
    public WiadomosciServiceImpl(WiadomosciRepository wiadomosciRepository) {
        this.wiadomosciRepository = wiadomosciRepository;
    }

    @Override
    public List<Wiadomosc> pobierzWszytkieWiadomosci() {
        logger.debug("Wywołano com.company.przychodnia.service.impl.pobierzWszytkieWiadomosci()");
        return wiadomosciRepository.findAll();
    }

    @Override
    public List<Wiadomosc> pobierzOstatnieWiadomosci(int liczba) {
        logger.debug("Wywołano com.company.przychodnia.service.impl.pobierzOstatnieWiadomosci({})", liczba);
        List<Wiadomosc> wiadomosci = wiadomosciRepository.findAll();
        if (liczba <= wiadomosci.size()) {
            wiadomosci = wiadomosci.subList(wiadomosci.size() - liczba, wiadomosci.size());
        }
        return wiadomosci;
    }

    @Override
    public Wiadomosc pobierzWiadomosc(Long id) {
        logger.debug("Wywolano com.company.przychodnia.service.impl.pobierzWiadomosc({})", id);
        return wiadomosciRepository.getOne(id);
    }

    @Override
    public void dodajWiadomosc(Wiadomosc wiadomosc) {
        logger.debug("Wywolano com.company.przychodnia.service.impl.zapiszWiadomosc()");
        wiadomosc.setDataUtworzenia(LocalDateTime.now());
        logger.debug("Tresc wiadomosci do zapisania: {}", wiadomosc);
        wiadomosciRepository.save(wiadomosc);
        logger.info("Zapisano wiadomosc.");
    }

    @Override
    public void usunWiadomosc(Long id) {
        logger.debug("Wywolano com.company.przychodnia.service.impl.usunWiadomosc()");
        logger.debug("Wiadomosc do usuniecia: {}", wiadomosciRepository.findById(id));
        wiadomosciRepository.deleteById(id);
        logger.info("Usunięto wiadomość o id {}.", id);
    }

}
