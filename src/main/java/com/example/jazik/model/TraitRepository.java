package com.example.jazik.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraitRepository extends JpaRepository<Trait, Integer> {
}
