package com.betrybe.agrix.service;

import com.betrybe.agrix.controller.dto.CropRequestDto;
import com.betrybe.agrix.controller.dto.FarmRequestDto;
import com.betrybe.agrix.exceptions.NotFoundException;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.model.repository.CropRepository;
import com.betrybe.agrix.model.repository.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {
  private FarmRepository farmRepository;
  private CropRepository cropRepository;

  /**
   * Instantiates a new Farm service.
   * the farm repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * Create farm.
   * the farm
   */
  public Farm createFarm(FarmRequestDto farmRequestDto) {
    Farm farm = new Farm(farmRequestDto);
    return farmRepository.save(farm);
  }

  /**
   * Update Farm.
   */
  public Farm updateFarm(Long farmId, FarmRequestDto farmRequestDto) throws NotFoundException {
    Optional<Farm> targetFarm = farmRepository.findById(farmId);
    targetFarm.orElseThrow(() -> new NotFoundException("Fazenda não encontrada!"));
    targetFarm.get().setName(farmRequestDto.name());
    targetFarm.get().setSize(farmRequestDto.size());
    return farmRepository.save(targetFarm.get());
  }

  /**
   * Find all list.
   */
  public List<Farm> getFarms() {
    return farmRepository.findAll();
  }

  /**
   * Find by id farm.
   * the farm id
   * the farm not found exception
    */
  public Farm getFarm(Long farmId) throws NotFoundException {
    return farmRepository.findById(farmId)
        .orElseThrow(() -> new NotFoundException("Fazenda não encontrada!"));
  }

  /**
   * Create crop.
   */
  public Crop createCrop(Long farmId, CropRequestDto crop) throws NotFoundException {
    Optional<Farm> targetFarm = farmRepository.findById(farmId);
    targetFarm.orElseThrow(() -> new NotFoundException("Fazenda não encontrada!"));
    Crop newCrop = new Crop(crop.name(), crop.plantedArea());
    newCrop.setFarm(targetFarm.get());
    return cropRepository.save(newCrop);
  }

  /**
   * List crops.
   */
  public List<Crop> listAllCrops() {
    return cropRepository.findAll();
  }

  /**
   * Find cro by id.
   */
  public Crop findCropById(Long id) throws NotFoundException {
    Optional<Crop> targetCrop = cropRepository.findById(id);
    targetCrop.orElseThrow(() -> new NotFoundException("Plantação não encontrada!"));
    return targetCrop.get();
  }
}

