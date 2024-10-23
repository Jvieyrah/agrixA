package com.betrybe.agrix.model.repository;

import com.betrybe.agrix.model.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Crop repository.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

}
