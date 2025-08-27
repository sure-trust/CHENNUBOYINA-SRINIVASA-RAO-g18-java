package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entiry.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
