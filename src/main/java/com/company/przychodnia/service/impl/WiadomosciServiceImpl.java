package com.company.przychodnia.service.impl;

import com.company.przychodnia.domain.Wiadomosc;
import com.company.przychodnia.repository.WiadomosciRepository;
import com.company.przychodnia.service.WiadomosciService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return wiadomosciRepository.findAll();
    }

    @Override
    public List<Wiadomosc> pobierzOstatnieWiadomosci(int liczba) {
        List<Wiadomosc> wiadomosci = wiadomosciRepository.findAll();
        //return wiadomosci.subList(wiadomosci.size()-liczba, wiadomosci.size());
        logger.debug("Wywołano com.company.przychodnia.service.impl.pobierzOstatnieWiadomosci({})", liczba);
        return wiadomosciRepository.findAll();
   }
}
