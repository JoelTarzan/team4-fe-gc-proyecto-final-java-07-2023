package com.rest.aurumrh.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private List<SkillCandidature> skillsCandidatures;
    
    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private List<SkillUser> skillsUsers;

    // Constructores
    public Skill() {
        
    }

    public Skill(int id, String name) {
		this.id = id;
		this.name = name;
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

	@JsonIgnore
	public List<SkillCandidature> getSkillsCandidatures() {
		return skillsCandidatures;
	}

	public void setSkillsCandidatures(List<SkillCandidature> skillsCandidatures) {
		this.skillsCandidatures = skillsCandidatures;
	}

	@JsonIgnore
	public List<SkillUser> getSkillsUsers() {
		return skillsUsers;
	}

	public void setSkillsUsers(List<SkillUser> skillsUsers) {
		this.skillsUsers = skillsUsers;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
}