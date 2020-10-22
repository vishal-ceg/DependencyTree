/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docker.dependencytree.finder;

import java.io.File;

/**
 *
 * @author Vishal
 */
public class DependencyFinderFactory {

    public static DependencyTreeFinder getInstance(String projectPath) {
        File directory = new File(projectPath);
        if (!(directory.exists() && directory.isDirectory())) {
            throw new RuntimeException("Invalid project path.");
        }
        File filesList[] = directory.listFiles();

        for (File f : filesList) {
            if (f.isFile() && f.getAbsolutePath().contains("pom.xml")) {
                System.out.println("Maven project...........");
                return new MavenDependencyFinder(f);
            } else if (f.isFile() && f.getAbsolutePath().contains("build.gradle")) {
                 System.out.println("Gradle project...........");
                return new GradleDependencyFinder(projectPath);
            }
        }
        return null;
    }

}
