package com.betrybe.agrix.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The type Crop.
 */
@Entity
@Table(name = "crops")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  private double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farmId")
  private Farm farm;

  /**
   * Instantiates a new Crop.
   */
  public Crop() {
  }

  /**
   * Instantiates a new Crop.
   */
  public Crop(String name, double plantedArea) {
    this.name = name;
    this.plantedArea = plantedArea;
  }

  /**
   * Gets id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets Name.
   */
  public String getName() {
    return name;
  }

  /**
   * sets name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets plantedArea.
   */
  public double getPlantedArea() {
    return plantedArea;
  }

  /**
   * sets plantedArea.
   */
  public void setPlantedArea(double plantedArea) {
    this.plantedArea = plantedArea;
  }

  /**
   * Gets farm.
   */
  public Farm getFarm() {
    return farm;
  }

  /**
   * Gets farm.
   */
  public void setFarm(Farm farm) {
    this.farm = farm;
  }
}
