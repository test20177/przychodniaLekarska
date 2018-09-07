package com.company.przychodnia.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Wiadomosc {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String temat;
    private String tresc;
    private LocalDateTime dataUtworzenia;

    public Wiadomosc() {
    }

    public Wiadomosc(String temat, String tresc, LocalDateTime dataUtworzenia) {
        this.temat = temat;
        this.tresc = tresc;
        this.dataUtworzenia = dataUtworzenia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemat() {
        return temat;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public LocalDateTime getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(LocalDateTime dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wiadomosc wiadomosc = (Wiadomosc) o;
        return Objects.equals(id, wiadomosc.id) &&
                Objects.equals(temat, wiadomosc.temat) &&
                Objects.equals(tresc, wiadomosc.tresc) &&
                Objects.equals(dataUtworzenia, wiadomosc.dataUtworzenia);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, temat, tresc, dataUtworzenia);
    }

    @Override
    public String toString() {
        return "Wiadomosc{" +
                "id=" + id +
                ", temat='" + temat + '\'' +
                ", tresc='" + tresc + '\'' +
                ", dataUtworzenia=" + dataUtworzenia +
                '}';
    }

}


