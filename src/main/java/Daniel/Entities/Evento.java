package Daniel.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "titolo")
    private String titolo;


    @Column(name = "data_evento")
    private LocalDate data_evento;

    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private tipoEvento tipoEvento;

    @Column(name = "numero_massimo_partecipanti")
    private int participantiMassimi;

    public Evento() {

    }

    public Evento(String titolo, LocalDate data_evento, String descrizione, Daniel.Entities.tipoEvento tipoEvento, int participantiMassimi) {
        this.titolo = titolo;
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.participantiMassimi = participantiMassimi;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getParticipantiMassimi() {
        return participantiMassimi;
    }

    public void setParticipantiMassimi(int participantiMassimi) {
        this.participantiMassimi = participantiMassimi;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", tipo_evento=" + tipoEvento +
                ", participantiMassimi='" + participantiMassimi + '\'' +
                '}';
    }
}