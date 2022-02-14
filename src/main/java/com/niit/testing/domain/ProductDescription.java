package com.niit.testing.domain;

import java.time.LocalDateTime;

public class ProductDescription {
    private LocalDateTime manufacturingDate;
    private String manfacturingPlace;

    public ProductDescription() {
    }

    public ProductDescription(LocalDateTime manufacturingDate, String manfacturingPlace) {
        this.manufacturingDate = manufacturingDate;
        this.manfacturingPlace = manfacturingPlace;
    }

    public LocalDateTime getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDateTime manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getManfacturingPlace() {
        return manfacturingPlace;
    }

    public void setManfacturingPlace(String manfacturingPlace) {
        this.manfacturingPlace = manfacturingPlace;
    }

    @Override
    public String toString() {
        return "ProductDescription{" +
                "manufacturingDate=" + manufacturingDate +
                ", manfacturingPlace='" + manfacturingPlace + '\'' +
                '}';
    }
}
