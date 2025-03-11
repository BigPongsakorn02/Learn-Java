package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import MyUtil.Stack;
import MyUtil.StackFullException;
import MyUtil.StackEmptyException;

class StackTest {
    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(3); // Limit size to 3
    }

    @Test
    void testPushAndPop() throws StackFullException, StackEmptyException {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
    }

    @Test
    void testStackFullException() {
        assertThrows(StackFullException.class, () -> {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4); // Should throw exception
        });
    }

    @Test
    void testStackEmptyException() {
        assertThrows(StackEmptyException.class, () -> {
            stack.pop(); // Empty pop should fail
        });
    }
}
