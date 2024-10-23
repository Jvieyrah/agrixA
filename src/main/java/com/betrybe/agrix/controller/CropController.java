package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.exceptions.NotFoundException;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {
  private final FarmService farmService;

  /**
   * The type Crop constructor.
   */
  @Autowired
  public CropController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * get all Crops.
   */
  @GetMapping
  public ResponseEntity<List<CropDto>> listAllCrops() {
    List<Crop> crops = farmService.listAllCrops();
    List<CropDto> editedCrops = crops.stream().map(CropDto::fromEntity)
        .toList();
    return ResponseEntity.ok().body(editedCrops);
  }

  /**
   * get Crop by id.
   */
  @GetMapping("/{cropId}")
  public ResponseEntity<CropDto> findCropById(@PathVariable Long cropId) throws NotFoundException {
    CropDto crop = CropDto.fromEntity(farmService.findCropById(cropId));
    return ResponseEntity.ok().body(crop);
  }
}
