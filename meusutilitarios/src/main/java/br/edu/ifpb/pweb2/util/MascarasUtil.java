package br.edu.ifpb.pweb2.util;

public class MascarasUtil {
    public static String formatarCPF(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos.");
        }
        return String.format("%s.%s.%s-%s",
                cpf.substring(0, 3),
                cpf.substring(3, 6),
                cpf.substring(6, 9),
                cpf.substring(9, 11));
    }

    public static String formatarCNPJ(String cnpj) {
        if (cnpj == null || !cnpj.matches("\\d{14}")) {
            throw new IllegalArgumentException("CNPJ deve conter exatamente 14 dígitos.");
        }
        return String.format("%s.%s.%s/%s-%s",
                cnpj.substring(0, 2),
                cnpj.substring(2, 5),
                cnpj.substring(5, 8),
                cnpj.substring(8, 12),
                cnpj.substring(12, 14));
    }

    public static String formatarCEP(String cep) {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP deve conter exatamente 8 dígitos.");
        }
        return String.format("%s-%s", cep.substring(0, 5), cep.substring(5, 8));
    }

    public static void demo() {
        System.out.println("CPF: " + formatarCPF("12345678901"));
        System.out.println("CNPJ: " + formatarCNPJ("12345678000195"));
        System.out.println("CEP: " + formatarCEP("12345678"));
    }
}
