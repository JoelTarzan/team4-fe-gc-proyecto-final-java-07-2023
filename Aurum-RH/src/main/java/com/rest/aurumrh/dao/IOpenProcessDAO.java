package com.rest.aurumrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.OpenProcess;

public interface IOpenProcessDAO extends JpaRepository<OpenProcess, Integer> {

}