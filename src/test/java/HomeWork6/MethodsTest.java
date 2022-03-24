package HomeWork6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MethodsTest {

    @Test
    public void foo1() {
        Methods methods = new Methods();
        int[] expected = {1, 7};
        int[] actual = methods.foo(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7});
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void foo2() {
        Methods methods = new Methods();
        int[] expected = {3, 2, 1};
        int[] actual = methods.foo(new int[]{4, 3, 2, 1});
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void fooWithException() {
        Methods methods = new Methods();
        Exception exception = assertThrows(RuntimeException.class, () -> {methods.foo(new int[]{3, 2, 1});});
        assertEquals("no 4 found!", exception.getMessage());
    }

    @Test
    public void fPositiveCase() {
        Methods methods = new Methods();
        assertTrue(methods.f(new int[] {1, 4}));
    }

    @Test
    public void fWithout4() {
        Methods methods = new Methods();
        assertFalse(methods.f(new int[] {1, 1, 2, 3, 5, 6}));
    }

    @Test
    public void fWithout1() {
        Methods methods = new Methods();
        assertFalse(methods.f(new int[] {2, 3, 4, 5, 6}));
    }

    @Test
    public void fNegativeCase() {
        Methods methods = new Methods();
        assertFalse(methods.f(new int[] {2, 3, 5, 6}));
    }
}