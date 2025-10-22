package br.edu.ifpb.pweb2.util;

public class ValidadorUtil {
    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.chars().distinct().count() == 1) return false;

        int d1 = calcularDigito(cpf.substring(0, 9), 10);
        int d2 = calcularDigito(cpf.substring(0, 9) + d1, 11);

        return cpf.equals(cpf.substring(0, 9) + d1 + d2);
    }

    public static boolean validarCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14 || cnpj.chars().distinct().count() == 1) return false;

        int d1 = calcularDigitoCNPJ(cnpj.substring(0, 12));
        int d2 = calcularDigitoCNPJ(cnpj.substring(0, 12) + d1);

        return cnpj.equals(cnpj.substring(0, 12) + d1 + d2);
    }

    private static int calcularDigito(String base, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < base.length(); i++) {
            soma += (base.charAt(i) - '0') * (pesoInicial - i);
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }

    private static int calcularDigitoCNPJ(String base) {
        int[] pesos = base.length() == 12 ?
                new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2} :
                new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            soma += (base.charAt(i) - '0') * pesos[i];
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }

    public static void demo() {
        System.out.println("CPF válido? " + validarCPF("123.456.789-09")); // false
        System.out.println("CNPJ válido? " + validarCNPJ("12.345.678/0001-95")); // false

        // Exemplos reais válidos (substitua pelos seus para testar):
        System.out.println("CPF válido? " + validarCPF("111.444.777-35")); // true
        System.out.println("CNPJ válido? " + validarCNPJ("45.723.174/0001-10")); // true
    }

}
