package com.rest.aurumrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Application;

public interface IApplicationDAO extends JpaRepository<Application, Integer> {

}