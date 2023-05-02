package br.com.mycompany.account.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DocumentNumberUtilsTest {

    @Test
    public void setCPFCNPJObfuscate() {
        assertEquals(DocumentNumberUtils.getCPFCNPJObfuscate("11122233000166"), "**1222330001**");
    }

    @Test
    public void setCPFCNPJObfuscate11Digits() {
        assertEquals(DocumentNumberUtils.getCPFCNPJObfuscate("33322211100"), "***222111**");
    }

    @Test
    public void setCPFCNPJObfuscate10Digits() {
        assertEquals(DocumentNumberUtils.getCPFCNPJObfuscate("3320011100"), "***200111**");
    }

    @Test
    public void setCPFCNPJObfuscate9Digits() {
        assertEquals(DocumentNumberUtils.getCPFCNPJObfuscate("320011100"), "***200111**");
    }

    @Test
    public void setCPFCNPJObfuscateNull() {
        assertEquals(DocumentNumberUtils.getCPFCNPJObfuscate(null), null);
    }

    @Test
    public void setCPFCNPJObfuscateEmpty() {
        assertEquals(DocumentNumberUtils.getCPFCNPJObfuscate(""), "");
    }

    @Test
    public void setCPFCNPJObfuscateBlank() {
        assertEquals(DocumentNumberUtils.getCPFCNPJObfuscate(" "), " ");
    }

    @Test
    public void setFormattedCPFDocument(){
        assertEquals(DocumentNumberUtils.getDocumentNumberWithoutFormatting("333.666.999-88"), "33366699988");
    }

    @Test
    public void setFormattedCNPJDocument(){
        assertEquals(DocumentNumberUtils.getDocumentNumberWithoutFormatting("11.122.233/0001-66"), "11122233000166");
    }

    @Test
    public void setNullDocumentNumber(){
        assertEquals(DocumentNumberUtils.getDocumentNumberWithoutFormatting(null), null);
    }

    @Test
    public void setBlankDocumentNumber(){
        assertEquals(DocumentNumberUtils.getDocumentNumberWithoutFormatting(""), "");
    }

}