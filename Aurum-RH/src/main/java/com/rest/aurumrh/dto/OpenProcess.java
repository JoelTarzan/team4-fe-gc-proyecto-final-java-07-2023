package com.rest.aurumrh.dto;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "open_processes")
public class OpenProcess {

	// Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "date")
    private LocalDate date;
    
    @Column(name="is_open")
    private boolean isOpen;
    
    @OneToMany(mappedBy = "phase", fetch = FetchType.LAZY)
    private List<Application> applications;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "id_candidature")
    private Candidature candidature;
    
    @OneToMany(mappedBy = "openProcess", fetch = FetchType.LAZY)
    private List<Subscription> subscriptions;

    // Constructores
    public OpenProcess() {
        
    }

    public OpenProcess(int id, String name, LocalDate date, boolean isOpen, User user, Candidature candidature) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.isOpen = isOpen;
		this.user = user;
		this.candidature = candidature;
	}

    // Métodos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	@JsonIgnore
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
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

	@JsonIgnore
	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	@Override
	public String toString() {
		return "OpenProcess [id=" + id + ", name=" + name + ", date=" + date + ", isOpen=" + isOpen + ", user=" + user
				+ ", candidature=" + candidature + "]";
	}
}