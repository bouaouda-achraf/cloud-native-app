package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Cat;

@RepositoryRestResource
public interface CatRepository extends JpaRepository<Cat, Long> {

}
