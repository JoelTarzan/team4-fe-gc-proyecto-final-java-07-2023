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
@Table(name = "skills_users")
public class SkillUser {

	// Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "validated")
    private boolean validated;
    
    @ManyToOne
    @JoinColumn(name = "id_skill")
    private Skill skill;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    // Constructores
    public SkillUser() {
        
    }

    public SkillUser(int id, boolean validated, Skill skill, User user) {
		this.id = id;
		this.validated = validated;
		this.skill = skill;
		this.user = user;
	}

    // Métodos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SkillUser [id=" + id + ", validated=" + validated + ", skill=" + skill + ", user=" + user + "]";
	}
}