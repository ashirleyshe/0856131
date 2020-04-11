package lab4.travis_ci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class PriorityQueueTest {

    private int[] expected;   // expected result
    private int[] testcase;   // test case

    @Parameterized.Parameters
    public static Collection priority_queue() {
        List<int[][]> para = new ArrayList<int[][]>();
        int[][] case1 = new int[][]{{ 0, 1, 2, 3, 5 }, { 3, 2, 0, 1, 4 },};
        int[][] case2 = new int[][]{{ 0, 1, 2, 3, 4 }, { 3, 0, 2, 4, 1 },};
        int[][] case3 = new int[][]{{ 5, 6, 7, 8, 9 }, { 9, 8, 7, 6, 5 },};
        int[][] case4 = new int[][]{{ 10, 11, 12, 13, 14 }, { 11, 13, 10, 14, 12 },};
        int[][] case5 = new int[][]{{ 15, 16, 17, 18, 19 }, { 17, 18, 15, 19, 16 },};
        para.add(case1);
        para.add(case2);
        para.add(case3);
        para.add(case4);
        para.add(case5);
        return para;
    }

    // constructor
    public PriorityQueueTest(int[] expected, int[] testcase) {
        this.expected = expected;
        this.testcase = testcase;
    }

    @Test
    public void testParameterization() {
        PriorityQueue queue1 = new PriorityQueue();
        for(int i = 0; i < 5; i ++)
            queue1.offer(testcase[i]);
        for(int i = 0; i < 5; i ++)
            assertEquals(expected[i], queue1.poll());
    }

    @Test(expected = NullPointerException.class)
    public void testOfferNullPointerException() {
        PriorityQueue queue2 = new PriorityQueue();
        queue2.offer(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllNullPointerException() {
        PriorityQueue queue3 = new PriorityQueue();
        queue3.addAll(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllIllegalArgumentException() {
        PriorityQueue queue4 = new PriorityQueue();
        queue4.addAll(queue4);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullPointerException() {
        PriorityQueue queue5 = new PriorityQueue();
        queue5.add(null);
    }
}

