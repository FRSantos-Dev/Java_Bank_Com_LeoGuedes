public class NotacaoPonto {
    public static void main(String[] args) {

        String nome = "leonardo";
        System.out.println(nome);
        String nomeAlterado = nome.toUpperCase();
        System.out.println(nomeAlterado);

        System.out.println(nome.replace("l","T"));

        System.out.println(nome.contains("l"));

        Integer inteiro = 10;

        System.out.println(inteiro.toString() + " Alterado para String");

        PrimitivosVsObjetos minhaVariavel = new PrimitivosVsObjetos();
        minhaVariavel.meuNome(nome);

    }
}
