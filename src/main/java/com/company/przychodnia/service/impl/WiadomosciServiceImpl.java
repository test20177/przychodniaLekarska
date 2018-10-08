package com.company.przychodnia.service.impl;

import com.company.przychodnia.domain.Wiadomosc;
import com.company.przychodnia.repository.WiadomosciRepository;
import com.company.przychodnia.service.WiadomosciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WiadomosciServiceImpl implements WiadomosciService {

    private final WiadomosciRepository wiadomosciRepository;

   @Autowired
    public WiadomosciServiceImpl(WiadomosciRepository wiadomosciRepository) {
        this.wiadomosciRepository = wiadomosciRepository;
    }

    @Override
    public List<Wiadomosc> pobierzWszytkieWiadomosci() {
        return wiadomosciRepository.findAll();
    }

    @Override
    public List<Wiadomosc> pobierzOstatnieWiadomosci(int liczba) {
        List<Wiadomosc> wiadomosci = wiadomosciRepository.findAll();
        //return wiadomosci.subList(wiadomosci.size()-liczba, wiadomosci.size());
        return wiadomosciRepository.findAll();
   }
}
