package Daniel.Entities;

import Daniel.Entities.Evento;
import Daniel.Entities.Persona;

import javax.persistence.*;

public class Partecipazione
{   @Id
@GeneratedValue
private long id;

    @OneToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToMany
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private String stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento, String stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public long getId() {
        return id;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "PartecipazioneDAO{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato='" + stato + '\'' +
                '}';
    }
}
