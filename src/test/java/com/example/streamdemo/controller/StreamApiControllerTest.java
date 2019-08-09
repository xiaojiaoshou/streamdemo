package com.example.streamdemo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamApiControllerTest {
    @Autowired
    private  StreamApiController  streamApiController;

    @Test
    public void getSorted() {
        streamApiController.getSorted();
    }

    @Test
    public void getStudent() {
        streamApiController.getStudent();
    }
}