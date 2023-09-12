package com.rest.aurumrh.dto;

import java.sql.Blob;
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
@Table(name = "users")
public class User {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "description")
	private String description;

	@Column(name = "rating")
	private int rating;

	@Column(name = "title")
	private String title;

	@Column(name = "phone")
	private String phone;

	@Column(name = "web")
	private String web;

	@Column(name = "linkedin")
	private String linkedin;

	@Column(name = "git")
	private String git;

	@Column(name = "avatar")
	private Blob avatar;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Application> applications;

	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Candidature> candidatures;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<OpenProcess> openProcesses;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<SkillUser> skillsUsers;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Subscription> subscriptions;

	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;

	// Constructores
	public User() {

	}

	public User(int id, String name, String lastname, String email, String password, String description, int rating, String title,
			String phone, String web, String linkedin, String git, Blob avatar, Role role) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.description = description;
		this.rating = rating;
		this.title = title;
		this.phone = phone;
		this.web = web;
		this.linkedin = linkedin;
		this.git = git;
		this.avatar = avatar;
		this.role = role;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getGit() {
		return git;
	}

	public void setGit(String git) {
		this.git = git;
	}

	public Blob getAvatar() {
		return avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}

	@JsonIgnore
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@JsonIgnore
	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	@JsonIgnore
	public List<OpenProcess> getOpenProcesses() {
		return openProcesses;
	}

	public void setOpenProcesses(List<OpenProcess> openProcesses) {
		this.openProcesses = openProcesses;
	}

	@JsonIgnore
	public List<SkillUser> getSkillsUsers() {
		return skillsUsers;
	}

	public void setSkillsUsers(List<SkillUser> skillsUsers) {
		this.skillsUsers = skillsUsers;
	}

	@JsonIgnore
	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + ", description=" + description + ", rating=" + rating + ", title=" + title + ", phone="
				+ phone + ", web=" + web + ", linkedin=" + linkedin + ", git=" + git + ", avatar=" + avatar + ", role="
				+ role + "]";
	}
}