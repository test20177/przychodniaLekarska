package com.company.przychodnia.service;

import com.company.przychodnia.domain.Wiadomosc;

import java.util.List;

public interface WiadomosciService {

    List<Wiadomosc> pobierzWszytkieWiadomosci();

    List<Wiadomosc> pobierzOstatnieWiadomosci(int liczba);

    Wiadomosc pobierzWiadomosc(Long id);

    void dodajWiadomosc(Wiadomosc wiadomosc);

    void usunWiadomosc(Long id);

}
