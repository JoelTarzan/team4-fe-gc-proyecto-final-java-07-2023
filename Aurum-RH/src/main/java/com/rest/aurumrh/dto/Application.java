package com.rest.aurumrh.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {

	// Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "id_candidature")
    private Candidature candidature;
    
    @ManyToOne
    @JoinColumn(name = "phase")
    private OpenProcess phase;

    // Constructores
    public Application() {
        
    }

    public Application(int id, User user, Candidature candidature, OpenProcess phase) {
		this.id = id;
		this.user = user;
		this.candidature = candidature;
		this.phase = phase;
	}

    // Métodos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Candidature getCandidature() {
		return candidature;
	}

	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}

	public OpenProcess getPhase() {
		return phase;
	}

	public void setPhase(OpenProcess phase) {
		this.phase = phase;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", user=" + user + ", candidature=" + candidature + ", phase=" + phase + "]";
	}
}