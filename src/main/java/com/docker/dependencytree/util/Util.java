/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docker.dependencytree.util;

import java.io.File;

/**
 *
 * @author Vishal
 */
public class Util {

    public static String getCurrentWorkingDir() {
        return System.getProperty("user.dir");
    }

    public static File findBuildFile(String projectRootPath) {
        File directory = new File(projectRootPath);
        if (!(directory.exists() && directory.isDirectory())) {
            throw new RuntimeException("Invalid project path.");
        }
        File filesList[] = directory.listFiles();

        for (File f : filesList) {
            if (f.isFile() && f.getAbsolutePath().contains("pom.xml")) {
                return f;
            } else  if (f.isFile() && f.getAbsolutePath().contains("build.gradle")) {
               return f;
            }
        }
        return null;

    }

}
