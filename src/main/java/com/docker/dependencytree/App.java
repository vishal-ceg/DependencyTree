/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docker.dependencytree;

import com.docker.dependencytree.finder.DependencyFinderFactory;
import com.docker.dependencytree.finder.DependencyTreeFinder;
import com.docker.dependencytree.finder.GradleDependencyFinder;
import com.docker.dependencytree.util.Util;
import java.io.File;
import org.apache.maven.shared.invoker.MavenInvocationException;

/**
 *
 * @author Vishal
 */
public class App {

    public static void main(String[] args) throws MavenInvocationException, Exception {
        if (args.length != 1) {
            System.out.println("Failed: Please provide project root path as argument.");
            System.exit(0);
        }

        DependencyTreeFinder finder = DependencyFinderFactory.getInstance(args[0]);
        if (finder != null) {
            finder.run();
        } else {
           System.out.println("Could not find project type");
        }
        System.out.println("Completed!!");
    }

}
