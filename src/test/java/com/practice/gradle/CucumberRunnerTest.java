package com.practice.gradle;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Login.feature",
        glue = "definitions", publish = true)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}
