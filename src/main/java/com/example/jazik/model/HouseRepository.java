package com.example.jazik.model;
import com.example.jazik.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {
    boolean existsBySourceId(String sourceId);

    Optional<House> findByName(String name);
}
