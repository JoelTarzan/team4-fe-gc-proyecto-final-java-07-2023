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
@Table(name = "candidatures")
public class Candidature {

	// Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "location")
    private String location;
    
    @Column(name="closing_date")
    private LocalDate closingDate;
    
    @Column(name="type_working_date")
    private String typeWorkingDate;
    
    @Column(name="applicants_num")
    private int applicantsNum;
    
    @Column(name="description")
    private String description;
    
    @Column(name="requirements")
    private String requirements;
    
    @Column(name="responsabilities")
    private String responsabilities;
    
    @Column(name = "state")
    private boolean state;
    
    @OneToMany(mappedBy = "candidature", fetch = FetchType.LAZY)
    private List<Application> applications;
    
    @ManyToOne
    @JoinColumn(name = "creator")
    private User creator;
    
    @OneToMany(mappedBy = "candidature", fetch = FetchType.LAZY)
    private List<OpenProcess> openProcesses;
    
    @OneToMany(mappedBy = "candidature", fetch = FetchType.LAZY)
    private List<SkillCandidature> skillCandidatures;

    // Constructores
    public Candidature() {
        
    }

    public Candidature(int id, String name, String location, LocalDate closingDate, String typeWorkingDate,
			int applicantsNum, String description, String requirements, String responsabilities, boolean state,
			User creator) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.closingDate = closingDate;
		this.typeWorkingDate = typeWorkingDate;
		this.applicantsNum = applicantsNum;
		this.description = description;
		this.requirements = requirements;
		this.responsabilities = responsabilities;
		this.state = state;
		this.creator = creator;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public String getTypeWorkingDate() {
		return typeWorkingDate;
	}

	public void setTypeWorkingDate(String typeWorkingDate) {
		this.typeWorkingDate = typeWorkingDate;
	}

	public int getApplicantsNum() {
		return applicantsNum;
	}

	public void setApplicantsNum(int applicantsNum) {
		this.applicantsNum = applicantsNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getResponsabilities() {
		return responsabilities;
	}

	public void setResponsabilities(String responsabilities) {
		this.responsabilities = responsabilities;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@JsonIgnore
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	@JsonIgnore
	public List<OpenProcess> getOpenProcesses() {
		return openProcesses;
	}

	public void setOpenProcesses(List<OpenProcess> openProcesses) {
		this.openProcesses = openProcesses;
	}

	@JsonIgnore
	public List<SkillCandidature> getSkillCandidatures() {
		return skillCandidatures;
	}

	public void setSkillCandidatures(List<SkillCandidature> skillCandidatures) {
		this.skillCandidatures = skillCandidatures;
	}

	@Override
	public String toString() {
		return "Candidature [id=" + id + ", name=" + name + ", location=" + location + ", closingDate=" + closingDate
				+ ", typeWorkingDate=" + typeWorkingDate + ", applicantsNum=" + applicantsNum + ", description="
				+ description + ", requirements=" + requirements + ", responsabilities=" + responsabilities + ", state="
				+ state + ", creator=" + creator + "]";
	}
}