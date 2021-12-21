package project2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class NumsTest {

        int[] testArrayDuplicationAndSorting = { 1, 10, 4, 10 };
        int[] testArraySameDistances = { 1, 3, 5 };
        int[] testArrayManyNumbers = { 13, 125, 42, 7, 84, 31, 45, 75, 62, 24, 111, 18, 173 };

        Nums classUnderTest = new Nums();

        @Test
        @DisplayName("numbersInRange equal numbers")
        public void testNumbersInRangeSameNumbers() {
                assertEquals(0, classUnderTest.numbersInRange(4, 4),
                                "Distance calculation between same numbers should return 0");
        }

        @Test
        @DisplayName("numbersInRange ascending")
        public void testNumbersInRangeBetweenAscending() {
                assertEquals(2, classUnderTest.numbersInRange(1, 4),
                                "Distance calculation between numbers 1, 4 should return 2");
        }

        @Test
        @DisplayName("numbersInRange descending")
        public void testNumbersInRangeDescending() {
                assertEquals(2, classUnderTest.numbersInRange(4, 1),
                                "Distance calculation between numbers 4, 1 should return 2");
        }

        @Test
        @DisplayName("listNumbersInRange ArrayList items match")
        public void testlistNumbersInRange() {
                ArrayList<Integer> expected = new ArrayList<Integer>();
                expected.add(2);
                expected.add(3);
                assertTrue(classUnderTest.listNumbersInRange(1, 4).equals(expected),
                                "List should match test list");
        }

        @Test
        @DisplayName("getMinDistance Duplication and sorting")
        public void testSmallestDistanceDuplicationAndSorting() {
                assertEquals(2, classUnderTest.getMinDistance(testArrayDuplicationAndSorting),
                                "Smallest distance calculation between numbers in array "
                                                + java.util.Arrays.toString(testArrayDuplicationAndSorting)
                                                + " should return 2 (1<>4)");
        }

        @Test
        @DisplayName("getMinDistance Equal distances")
        public void testSmallestDistanceEqualDistances() {
                assertEquals(1, classUnderTest.getMinDistance(testArraySameDistances),
                                "Smallest distance calculation between numbers in array "
                                                + java.util.Arrays.toString(testArraySameDistances)
                                                + " should return 1 (1<>3)");
        }

        @Test
        @DisplayName("getMinDistance more numbers array")
        public void testSmallestDistanceLongArray() {
                assertEquals(2, classUnderTest.getMinDistance(testArrayManyNumbers),
                                "Smallest distance calculation between numbers in array "
                                                + java.util.Arrays.toString(testArrayManyNumbers)
                                                + " should return 2 (42<>45)");
        }
}
