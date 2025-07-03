package com.ifpr.Projeto_Adocao.Util;

public class Util {

    public static Boolean validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()){ // verifica se está vazio e retira os espaços e verifica o resultado final
            return false ;
        }
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){ // verifica se corresponde ao formato do email !matches
           return false;
        }
        return true;
    }

    public static Boolean validarNome(String nome){
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }
        if (nome.length() < 3 || nome.length() > 50 ){ // Verifica se o tamanho do nome correspode a quantidade de caracteres necessária
            return false;
        }
        return true;
    }

    public static Boolean validarEmail(String email){
        if (email == null || email.trim().isEmpty()){
          return false;
        }
        if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")){
            return false;
        }
        return true;
    }
}
