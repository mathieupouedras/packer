package fr.xspeedlt.optimizer;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class Packer {
    public List<Package> pack(List<Item> items) {

        var packages = new ArrayList<Package>();
        var currentPackage = new Package(10);
        packages.add(currentPackage);

        for (Item item : items) {
            if (!currentPackage.add(item)) {
                packages.add(currentPackage);
                currentPackage = new Package(10);
                currentPackage.add(item);
            }
        }

        return packages;
    }

    // First Fit Decreasing algorithm
    public List<Package> packBetter(List<Item> items) {
        items.sort(Comparator.comparing(Item::size).reversed());
        return items.stream()
                .reduce(new ArrayList<>(),
                        (packages, item) -> {
                             boolean addedToExistingPackage = packages.stream().anyMatch(aPackage -> aPackage.add(item));

                            if (!addedToExistingPackage) {
                                Package newPackage = new Package(10);
                                newPackage.add(item);
                                packages.add(newPackage);
                            }
                            return packages;
                        },
                        (packages1, packages2) -> {
                            packages1.addAll(packages2);
                            return packages1;
                        });
    }
}