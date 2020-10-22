/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docker.dependencytree.finder;

import com.docker.dependencytree.util.Util;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;

/**
 *
 * @author Vishal
 */
public class MavenDependencyFinder implements DependencyTreeFinder {

    public static List<String> GOALS = Arrays.asList("dependency:tree -DoutputFile=" + Util.getCurrentWorkingDir() + File.separator + "maven-dep.txt -DoutputType=text");
    private File pomFile;

    public MavenDependencyFinder(File file) {
        this.pomFile = file;
    }

    @Override
    public void run() throws Exception {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(pomFile);
        request.setGoals(GOALS);
        Invoker invoker = new DefaultInvoker();
        InvocationResult r= invoker.execute(request);
    }

}
