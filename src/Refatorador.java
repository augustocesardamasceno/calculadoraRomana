import java.util.HashMap;
import java.util.Map;

public class Refatorador {

    public static String realRomano(int numero) {
        if (numero <= 0 || numero > 3999) {
            return "Número fora do formato";
        }

        StringBuilder resultado = new StringBuilder();

        while (numero >= 1000) {
            numero -= 1000;
            resultado.append("M");
        }

        if (numero >= 900) {
            numero -= 900;
            resultado.append("CM");
        }

        while (numero >= 500) {
            numero -= 500;
            resultado.append("D");
        }

        if (numero >= 400) {
            numero -= 400;
            resultado.append("CD");
        }

        while (numero >= 100) {
            numero -= 100;
            resultado.append("C");
        }

        if (numero >= 90) {
            numero -= 90;
            resultado.append("XC");
        }

        while (numero >= 50) {
            numero -= 50;
            resultado.append("L");
        }

        if (numero >= 40) {
            numero -= 40;
            resultado.append("XL");
        }

        while (numero >= 10) {
            numero -= 10;
            resultado.append("X");
        }

        if (numero >= 9) {
            numero -= 9;
            resultado.append("IX");
        }

        while (numero >= 5) {
            numero -= 5;
            resultado.append("V");
        }

        if (numero >= 4) {
            numero -= 4;
            resultado.append("IV");
        }

        while (numero >= 1) {
            numero -= 1;
            resultado.append("I");
        }

        return resultado.toString();
    }



    private static final Map<Character, Integer> valores = new HashMap<>();

    static {
        valores.put('I', 1);
        valores.put('V', 5);
        valores.put('X', 10);
        valores.put('L', 50);
        valores.put('C', 100);
        valores.put('D', 500);
        valores.put('M', 1000);
    }

    public static int romanoReal(String romano) {
        romano = romano.toUpperCase();
        int resultado = 0;

        for (int i = 0; i < romano.length(); i++) {
            char caractere = romano.charAt(i);
            int valorAtual = obterValor(caractere);

            //Ao inserir o caractere romano, a string vai entrar dentro desse laço, onde será percorrido cada uma das letras inseridas
            // e atribuído o respectivo valor do caractere. Ele vai checar os respectivos valores vindos do Map para cada uma dos algarismos romanos


            if (i < romano.length() - 1) {

            //Aqui o laço verifica se existe um próximo caractere, caso exista, a variável próximo valor recebe o valor do caractere seguinte,
            //caso ele seja menor do que do que o atual, o resultado final vai ser a soma dele mesmo com a subtração do próximo valor pelo valor atual.
            //exemplo: o número XXIV (24) -> A string entra no laço e checa o primeiro "X" e atribui seu valor, verifica que tem um próximo valor e que ele
            //não é menor que o atual, então, o resultado que inicia valendo 0 vai receber a soma dele pelo valor atual, que resulta em 10;
            //Em seguida o laço chega no 2º "X" e faz o mesmo trajeto, tendo em vista que o próximo valor é 5 e ainda é menor que o atual;
            //A soma no resultado pelo valor atual resulta em 20 e o laço continua chegando no valor V (5);
            //Agora o valor atual é menor que o próximo, e por isso o resultado precisa ser a soma feita até agora R (20) + (1 - 5);
            //Isso se faz necessário pois valores menores à esquerda indicam subtração.

                char proximoCaractere = romano.charAt(i + 1);
                int valorProximo = obterValor(proximoCaractere);

                if (valorAtual < valorProximo) {
                    resultado += valorProximo - valorAtual;
                    i++; 
                } else {
                    resultado += valorAtual;
                }
            } else {
                resultado += valorAtual;
            }
        }

        return resultado;
    }

    private static int obterValor(char algarismo) {
        return valores.getOrDefault(algarismo, -1);
    }


}
