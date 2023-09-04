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
@Table(name = "subscriptions")
public class Subscription {

	// Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_open_process")
    private OpenProcess openProcess;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    // Constructores
    public Subscription() {
        
    }

    public Subscription(int id, OpenProcess openProcess, User user) {
		this.id = id;
		this.openProcess = openProcess;
		this.user = user;
	}

    // Métodos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OpenProcess getOpenProcess() {
		return openProcess;
	}

	public void setOpenProcess(OpenProcess openProcess) {
		this.openProcess = openProcess;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", openProcess=" + openProcess + ", user=" + user + "]";
	}
}