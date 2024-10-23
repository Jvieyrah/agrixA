package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entity.Crop;

/**
 * Crop request dto.
 */
public record CropRequestDto(String name, double plantedArea) {
  public Crop toEntity() {
    return new Crop(name, plantedArea);
  }

}
