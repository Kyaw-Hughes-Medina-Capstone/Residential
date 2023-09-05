package com.codeup.rentlister.services;

import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.repositories.PropertyRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
    public List<Property> filterProperties(String type, String city, Integer zip, Integer minBedrooms, Integer minBathrooms, Integer maxPrice, Integer minPrice) {
        List<Property> allProperties = propertyRepository.findAll();

        List<Property> filteredProperties = allProperties.stream()
                .filter(property ->
                        (type == null || type.equals(property.getType())) &&
                                (city == null || city.equals(property.getCity())) &&
                                (zip == null || zip.equals(property.getZip())) &&
                                (minBedrooms == null || property.getBeds() >= minBedrooms) &&
                                (minBathrooms == null || property.getBath() >= minBathrooms) &&
                                (maxPrice == null || property.getRent() <= maxPrice) &&
                                (minPrice == null || property.getRent() >= minPrice)
                )
                .collect(Collectors.toList());

        System.out.println("Filtered Properties: " + filteredProperties); // Debugging line

        return filteredProperties;
    }
}
