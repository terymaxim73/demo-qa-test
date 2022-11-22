package com.demoqa;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class ExampleJunitTest {

    @BeforeAll
    static void configure() {
        System.out.println("this is the  @BeforeAll");
    }
    @AfterAll
    void tearDown() {
        System.out.println("this is the  @AfterAll);
    }

    @BeforeEach
    void beforeTest() {
        System.out.println("this is the  @BeforeEach");
    }

    @AfterEach
    void afterTest() {
        System.out.println("this is the  @AfterEach");
    }

    @Test
    void firstTest0() {
        System.out.println("this is the  @test 0");
    }

    @Test
    void firstTest1() {
        System.out.println("this is the  @test 1");
    }
}
