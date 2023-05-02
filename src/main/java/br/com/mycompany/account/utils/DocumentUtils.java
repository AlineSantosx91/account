package br.com.mycompany.account.utils;

import static java.util.Objects.isNull;

public abstract  class DocumentUtils {

    public static String getCPFCNPJObfuscate(String documentNumber) {
        if(isNull(documentNumber) || documentNumber.trim().isEmpty()) {
            return documentNumber;
        }
        if(documentNumber.length() > 8 && documentNumber.length() < 12){
            return getObfuscatedCpf(documentNumber.substring(documentNumber.length()-8, documentNumber.length()-2));
        }else if (documentNumber.length() == 14){
            return getObfuscatedCnpj(documentNumber.substring(2, 12));
        }
        return documentNumber;
    }

    private static String getObfuscatedCpf(String cpf) {
        return new StringBuilder().append("***").append(cpf).append("**").toString();
    }

    private static String getObfuscatedCnpj(String cnpj) {
        return new StringBuilder().append("**").append(cnpj).append("**").toString();
    }
}
