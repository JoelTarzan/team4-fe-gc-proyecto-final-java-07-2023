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
@Table(name = "skills_candidatures")
public class SkillCandidature {
	
	// Atributos
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_skill")
    private Skill skill;
    
    @ManyToOne
    @JoinColumn(name= " id_candidature")
    private Candidature candidature;

    // Constructores
    public SkillCandidature() {
        
    }

    public SkillCandidature(int id, Skill skill, Candidature candidature) {
		this.id = id;
		this.skill = skill;
		this.candidature = candidature;
	}

    // Métodos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Candidature getCandidature() {
		return candidature;
	}

	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}

	@Override
	public String toString() {
		return "SkillCandidature [id=" + id + ", skill=" + skill + ", candidature=" + candidature + "]";
	}
}