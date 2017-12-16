package projetoProgramacaoAvancada.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ValidacoesDeEntradas {

    public static boolean validarString(String texto) {
        return ((texto != null) && (texto.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü ]*$")) && (!texto.equals("")) && (texto.length() >= 2));
    }

    public static boolean validarClassificacao(String texto) {
        return texto.equalsIgnoreCase("a") || texto.equalsIgnoreCase("b");
    }

    public static boolean validarNumero(String texto) {
        return (texto.matches("^[0-9]*$"));
    }

    public static boolean validarNumeroInteiro(int inteiro) {
        return (inteiro > 0);
    }

    public static boolean validarNumeroString(String texto) {
        return ((texto != null) && (texto.matches("^[a-zA-Z-0-9 ]*$")) && (!texto.equals("")) && (texto.length() > 2));
    }

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("-", "");

        if (verificarNumerosIguais(cpf)) {
            return false;
        }

        int tamanhoCpf = cpf.length();
        if (tamanhoCpf == 11 && validarNumero(cpf)) {
            int contadorValido = 0;

            for (int i = 1; i <= 2; i++) {
                contadorValido += validarDigitosCpf(cpf, i);
            }

            return (contadorValido == 2);

        } else {
            return false;
        }
    }

    private static boolean verificarNumerosIguais(String cpf) {
        cpf = cpf.replaceAll(String.valueOf(cpf.charAt(0)), "");

        return cpf.equals("");
    }

    private static int validarDigitosCpf(String cpf, int digito) {

        int tamanhoCpf = cpf.length() - 2;
        if (digito == 2) {
            tamanhoCpf++;
        }

        int somaValidacaoCpf = 0;
        int cont = 10;
        if (digito == 2) {
            cont++;
        }

        String digitoVerificadoString = "";
        int digitoVerificado = 0;
        for (int i = 0; i < tamanhoCpf; i++) {
            String letraConvertidaParaString = String.valueOf(cpf.charAt(i));
            int letraConvertidaParaNumero = Integer.parseInt(letraConvertidaParaString);
            if (digito == 1) {
                if (i == 8) {
                    i++;
                    digitoVerificadoString = String.valueOf(cpf.charAt(i));
                    digitoVerificado = Integer.parseInt(digitoVerificadoString);
                }
            } else {
                if (i == 9) {
                    i++;
                    digitoVerificadoString = String.valueOf(cpf.charAt(i));
                    digitoVerificado = Integer.parseInt(digitoVerificadoString);
                }
            }
            somaValidacaoCpf += letraConvertidaParaNumero * cont;
            cont--;
        }
        return calculoCpf(somaValidacaoCpf, digitoVerificado);
    }

    private static int calculoCpf(int somaValidacaoCpf, int digitoVerificado) {

        int contador = 0;

        double restoCalculoCpf = ((somaValidacaoCpf * 10) % 11);
        if (restoCalculoCpf == 10) {
            restoCalculoCpf = 0;
        }
        if (restoCalculoCpf == digitoVerificado) {
            contador = 1;
        }
        return contador;
    }

    public static boolean validarDataNasc(String nasc) {
        Calendar nascimento = null;
        try {
            nascimento = getDataFromString(nasc);
        } catch (ParseException ex) {
            System.err.println("Erro no Calendar");
        }
        Calendar hoje = Calendar.getInstance();
        int anos = 0;
        while (hoje.after(nascimento)) {
            nascimento.add(Calendar.YEAR, +1);
            anos++;
        }
        return (anos-1) >= 18;
    }
    
    private static Calendar getDataFromString(String data) throws ParseException {
        data = Utils.retirarCaracterEspecial(data);
        String dataFormat = data.substring(0,2) + "/" + data.substring(2,4) + "/" + data.substring(4, 8);
        Date dataReserva = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataReserva);
        return calendar;
    }

}

