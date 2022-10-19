import java.math.BigDecimal;

public class PrimitivosVsObjetos {

    public void meuNome(String nome){
        System.out.println("Meu nome é " + nome);
    }

    public static void main(String[] args) {

        Boolean varBooleano = true;
        Boolean varBooleano2 = false;

        Character varChar = 'F';
        Character varChar2 = 'M';
        Character varChar3 = '1';
        Character varChar4 = '\u0000'; //Unicode = null

        Byte varByte = 127;
        Short varshort = 32767;
        Integer varInteger =  2_147_483_647;
        Integer inte =  2_147_483_647;
        Long varLong = 9_223_372_036_854_775_807L;

        Float varFloat = 1.0F;
        Double varDouble = 1.99;

        BigDecimal varDecimal = new BigDecimal("1.0");

        String nome = "Insira seu texto aqui, Leonardo !@$$%&&¨*BVJMVGHJ";

        /**
         * Nesse caso, agora temos os objetos, que são de uma API interna do java, com eles
         * podemos fazer ações prontas que iremos ver na prox aula
         * e tambem temos o objeto para criação de textos.
         */

    }
}
