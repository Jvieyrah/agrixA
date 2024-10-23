package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Farm;

/**
 * Crops.
 */
public record CropDto(Long id, String name, double plantedArea, Long farmId) {

  public static CropDto fromEntity(Crop crop) {
    Farm farm = crop.getFarm();
    return new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(), farm.getId());
  }
}