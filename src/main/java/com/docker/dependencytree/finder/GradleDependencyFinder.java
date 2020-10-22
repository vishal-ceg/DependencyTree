/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docker.dependencytree.finder;

import java.io.File;
import org.gradle.tooling.BuildLauncher;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.gradle.tooling.model.GradleProject;
import org.gradle.tooling.model.GradleTask;

/**
 *
 * @author Vishal
 */
public class GradleDependencyFinder implements DependencyTreeFinder {

    private static final String GRADLE_INSTALLATION = "C:\\gradle\\gradle-6.7";
    private final String GRADLE_PROJECT_DIRECTORY;// = "C:\\Users\\Vishal\\workspace\\gradle-java-first";
    

    public GradleDependencyFinder(String projectPath) {
      this.GRADLE_PROJECT_DIRECTORY = projectPath;
    }

    @Override
    public void run() throws Exception {
        GradleConnector connector = GradleConnector.newConnector();
        connector.useInstallation(new File(GRADLE_INSTALLATION));
        connector.forProjectDirectory(new File(GRADLE_PROJECT_DIRECTORY));
        ProjectConnection connection = connector.connect();
        BuildLauncher build = connection.newBuild();
        build.forTasks("dependencyReport");
        build.run();
        connection.close();
    }

}
