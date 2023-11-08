package com.github.ageresgit.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {
    final TaskScheduler ts = new TaskScheduler();
    @Test
    void test01(){
        char[] tasks = {'A','A','A','B','B','B'};
        assertEquals(6, ts.leastInterval(tasks, 2));
    }
    @Test
    void test03(){
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        assertEquals(16, ts.leastInterval(tasks, 2));
    }
}