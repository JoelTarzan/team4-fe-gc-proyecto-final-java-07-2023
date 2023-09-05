package com.rest.aurumrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Candidature;

public interface ICandidatureDAO extends JpaRepository<Candidature, Integer> {

}