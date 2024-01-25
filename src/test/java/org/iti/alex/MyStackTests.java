package org.iti.alex;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTests {

    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
    }

    @Test
    @DisplayName("Check push functionality")
    void testPushingSingleItem() {
        myStack.push("ITI-Alex-Mobile");
        assertEquals("ITI-Alex-Mobile", myStack.getStackPeek());
        assertEquals(1, myStack.getSize());
        myStack.push("ITI-Smart-Mobile");
        assertEquals("ITI-Smart-Mobile", myStack.getStackPeek());
        assertEquals(2, myStack.getSize());
        assertEquals(List.of("ITI-Alex-Mobile", "ITI-Smart-Mobile"), myStack.getCurrentStack());
    }

    @Test
    @DisplayName("Check pop functionality")
    void testPoppingItems() {
        assertTrue(myStack.getCurrentStack().isEmpty());
        var exception = assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> myStack.pop());
        assertEquals("Out of Bound Exception", exception.getMessage());

        myStack.push("ITI-Alex-Mobile1");
        myStack.push("ITI-Alex-Mobile2");
        myStack.push("ITI-Alex-Mobile3");
        myStack.push("ITI-Alex-Mobile4");
        myStack.push("ITI-Alex-Mobile5");
        assertFalse(myStack.getCurrentStack().isEmpty());
        int prevSize = myStack.getSize();
        String item = myStack.pop();
        assertEquals("ITI-Alex-Mobile5", item);
        assertEquals(prevSize - 1, myStack.getSize());
        assertEquals(List.of("ITI-Alex-Mobile1","ITI-Alex-Mobile2","ITI-Alex-Mobile3","ITI-Alex-Mobile4"),myStack.getCurrentStack());
    }

    @Test
    @DisplayName("Check Stack State functionality")
    @Tag("Feb")
    void testGetCurrentStack(){
        assertTrue(myStack.getCurrentStack().isEmpty());
        myStack.push("ITI-Alex-Mobile1");
        assertEquals(List.of("ITI-Alex-Mobile1"),myStack.getCurrentStack());
        myStack.push("ITI-Alex-Mobile2");
        myStack.push("ITI-Alex-Mobile3");
        myStack.push("ITI-Alex-Mobile4");
        assertEquals(List.of("ITI-Alex-Mobile1","ITI-Alex-Mobile2","ITI-Alex-Mobile3","ITI-Alex-Mobile4"),myStack.getCurrentStack());
    }

    @Test
    @DisplayName("Check Getting Last Item functionality")
    @EnabledOnOs(OS.WINDOWS)
    void testGetStackPeek() {
        assertTrue(myStack.getCurrentStack().isEmpty());
        assertNull(myStack.getStackPeek());
        myStack.push("ITI-Alex-Mobile1");
        myStack.push("ITI-Alex-Mobile2");
        myStack.push("ITI-Alex-Mobile3");
        myStack.push("ITI-Alex-Mobile4");
        assertEquals("ITI-Alex-Mobile4", myStack.getStackPeek());
    }

    @Test
    @DisplayName("Check Getting Stack Size functionality")
    @Disabled
    void testGetStackSize() {
        assertTrue(myStack.getCurrentStack().isEmpty());
        assertEquals(0,myStack.getSize());
        myStack.push("ITI-Alex-Mobile1");
        myStack.push("ITI-Alex-Mobile2");
        myStack.push("ITI-Alex-Mobile3");
        myStack.push("ITI-Alex-Mobile4");
        assertEquals(4, myStack.getSize());
    }
}
