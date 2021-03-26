package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesConversionTest {

    @Test
    void solution() {
        assertEquals(ParenthesesConversion.Solution("(()())()"), "(()())()");
        assertEquals(ParenthesesConversion.Solution(	")("), "()");
        assertEquals(ParenthesesConversion.Solution(	"()))((()"), "()(())()");
        assertEquals(ParenthesesConversion.Solution(		")))()((("), 	"()(()())");
    }
}