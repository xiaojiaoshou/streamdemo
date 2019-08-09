package com.example.streamdemo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamCollectControllerTest {


    @Autowired
    private StreamCollectController streamCollectController;
    @Test
    public void getCollectToList() {

        streamCollectController.getCollectToList();

    }

    @Test
    public void getCollectToSet() {
        streamCollectController.getCollectToSet();
    }

    @Test
    public void getCollectToMap() {
        streamCollectController.getCollectToMap();
    }

    @Test
    public void getPartitioningBy() {
        streamCollectController.getPartitioningBy();
    }

    @Test
    public void getGroupByGrade() {
        streamCollectController.getGroupByGrade();
    }

    @Test
    public void getGroupMapping() {
        streamCollectController.getGroupMapping();
    }

    @Test
    public void getGroupBykey() {
        streamCollectController.getGroupBykey();
    }

    @Test
    public void getGroupCount() {
        streamCollectController.getGroupCount();
    }
}