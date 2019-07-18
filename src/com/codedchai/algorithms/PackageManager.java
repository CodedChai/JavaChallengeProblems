package com.codedchai.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Package {
    String name;
    List<Package> dependencies;

    public Package(String name){
        this.name = name;
        dependencies = new ArrayList<>();
    }
}

/*
If you have a package manager make sure that it installs the dependencies before the package itself can be installed
 */

public class PackageManager {

    public static void main(String[] args){
        PackageManager packageManager = new PackageManager();

        HashSet<String> installedPackages = new HashSet<>();

        Package A = new Package("A");
        Package B = new Package("B");
        Package C = new Package("C");
        Package D = new Package("D");
        Package E = new Package("E");
        Package F = new Package("F");
        Package G = new Package("G");

        A.dependencies.add(B);
        A.dependencies.add(C);
        C.dependencies.add(F);
        B.dependencies.add(D);
        B.dependencies.add(E);
        F.dependencies.add(G);

        packageManager.install(installedPackages, A);
    }


    public void installPackage(HashSet<String> installedPackages, Package pkg){
        System.out.println("Installing package: " + pkg.name);
        installedPackages.add(pkg.name);
    }

    public boolean checkIfInstalled(HashSet<String> installedPackages, Package pkg){
        return installedPackages.contains(pkg.name);
    }

    public void install(HashSet<String> installedPackages, Package pkg){

        if(pkg.dependencies == null){
            installPackage(installedPackages, pkg);
        }

        for(Package dependency : pkg.dependencies){
            install(installedPackages, dependency);
        }

        if(pkg.dependencies.stream().allMatch(dependency -> checkIfInstalled(installedPackages, dependency))){
            installPackage(installedPackages, pkg);
        }
    }

}
