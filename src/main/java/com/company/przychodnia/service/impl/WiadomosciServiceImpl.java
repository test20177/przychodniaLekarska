package com.company.przychodnia.service.impl;

import com.company.przychodnia.domain.Wiadomosc;
import com.company.przychodnia.repository.WiadomosciRepository;
import com.company.przychodnia.service.WiadomosciService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;



@Service
public class WiadomosciServiceImpl implements WiadomosciService {

    private final WiadomosciRepository wiadomosciRepository;

    private final static Logger logger = LoggerFactory.getLogger(WiadomosciServiceImpl.class);

    @Autowired
    public WiadomosciServiceImpl(WiadomosciRepository wiadomosciRepository) {
        this.wiadomosciRepository = wiadomosciRepository;
    }

    @Override
    public List<Wiadomosc> pobierzWszytkieWiadomosci() {
        logger.debug("Wywołano com.company.przychodnia.service.impl.pobierzWszytkieWiadomosci()");
        List<Wiadomosc> wiadomosci = wiadomosciRepository.findAll();
        List<Wiadomosc> odwroconeWiadomosci = Lists.reverse(wiadomosci);
        return odwroconeWiadomosci;
    }

    @Override
    public List<Wiadomosc> pobierzOstatnieWiadomosci(int liczba) {
        logger.debug("Wywołano com.company.przychodnia.service.impl.pobierzOstatnieWiadomosci({})", liczba);
        List<Wiadomosc> wiadomosci = wiadomosciRepository.findAll();
        List<Wiadomosc> odwroconeWiadomosci = null;
        if (liczba <= wiadomosci.size()) {
            odwroconeWiadomosci = Lists.reverse(wiadomosci.subList(wiadomosci.size() - liczba, wiadomosci.size()));
        } else {
            odwroconeWiadomosci = Lists.reverse(wiadomosci);
        }
        return odwroconeWiadomosci;

    }

}
