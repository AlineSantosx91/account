package br.com.mycompany.account.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DocumentUtilsTest {

    @Test
    public void setCPFCNPJObfuscate() {
        assertEquals(DocumentUtils.getCPFCNPJObfuscate("11122233000166"), "**1222330001**");
    }

    @Test
    public void setCPFCNPJObfuscate11Digits() {
        assertEquals(DocumentUtils.getCPFCNPJObfuscate("33322211100"), "***222111**");
    }

    @Test
    public void setCPFCNPJObfuscate10Digits() {
        assertEquals(DocumentUtils.getCPFCNPJObfuscate("3320011100"), "***200111**");
    }

    @Test
    public void setCPFCNPJObfuscate9Digits() {
        assertEquals(DocumentUtils.getCPFCNPJObfuscate("320011100"), "***200111**");
    }

    @Test
    public void setCPFCNPJObfuscateNull() {
        assertEquals(DocumentUtils.getCPFCNPJObfuscate(null), null);
    }

    @Test
    public void setCPFCNPJObfuscateEmpty() {
        assertEquals(DocumentUtils.getCPFCNPJObfuscate(""), "");
    }

    @Test
    public void setCPFCNPJObfuscateBlank() {
        assertEquals(DocumentUtils.getCPFCNPJObfuscate(" "), " ");
    }

}