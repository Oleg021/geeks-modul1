package com.vyrvykhvost.repository;

import com.vyrvykhvost.model.Souvenir;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RepositoryApp {

    public List<Souvenir> getInfoSouvenir(List<Souvenir> souvenirs, String manufacturer) {
        return souvenirs.stream()
                .filter(s -> s.getManufacturerName().equals(manufacturer))
                .collect(Collectors.toList());
    }

    public List<Souvenir> getInfSouvenirByCountry(List<Souvenir> souvenirs, String country) {
        return souvenirs.stream()
                .filter(s -> s.getManufacturerCountry().equals(country))
                .collect(Collectors.toList());
    }

    public List<Souvenir> getManufacturerByPrice(List<Souvenir> souvenirs, double price) {
        return souvenirs.stream()
                .filter(s -> s.getPrice() < price)
                .collect(Collectors.toList());
    }

    public List<Souvenir> getInfoManufacturer(List<Souvenir> souvenirs) {
        return souvenirs.stream()
                .sorted(Comparator.comparing(Souvenir::getManufacturerName))
                .collect(Collectors.toList());
    }

    public List<Souvenir> getSouvenirByYear(List<Souvenir> souvenirs, int year, String nameSouvenir) {
        return souvenirs.stream()
                .filter(s -> s.getYear() == year && s.getName().equals(nameSouvenir))
                .collect(Collectors.toList());
    }

    public List<Souvenir> sortByYear(List<Souvenir> souvenirs) {
        return souvenirs.stream()
                .sorted(Comparator.comparing(Souvenir::getYear))
                .collect(Collectors.toList());
    }

    public List<Souvenir> remove(List<Souvenir> souvenirs, String manufacturer) {
        return souvenirs.stream()
                .filter(s -> !Objects.equals(manufacturer,s.getManufacturerName()))
                .collect(Collectors.toList());
    }

}
