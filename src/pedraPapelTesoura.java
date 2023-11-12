import java.util.Random;

// backend
public class pedraPapelTesoura {
    private static final String[] escolhasComputador = {"Pedra", "Papel", "Tesoura"};

    public String getEscolhaComputador() {
        return escolhaComputador;
    }

    public int getPontuacaoComputador() {
        return pontuacaoComputador;
    }

    public int getPontuacaoJogador() {
        return pontuacaoJogador;
    }

    private String escolhaComputador;

    private int pontuacaoComputador, pontuacaoJogador;

    private Random random;

    public pedraPapelTesoura(){
        random = new Random();
    }


    public String playpedraPapelTesoura(String escolhaJogador){
        escolhaComputador = escolhasComputador[random.nextInt(escolhasComputador.length)];

        String result;

        if(escolhaComputador.equals("Pedra")){
            if(escolhaJogador.equals("Papel")){
                result = "Você venceu";
                pontuacaoJogador++;
            }else if(escolhaJogador.equals("Tesoura")){
                result = "Computador Venceu";
                pontuacaoComputador++;
            }else{
                result = "Empate";
            }
        }else if(escolhaComputador.equals("Papel")){
            if(escolhaJogador.equals("Tesoura")){
                result = "Você venceu";
                pontuacaoJogador++;
            }else if(escolhaJogador.equals("Pedra")){
                result = "Computador Venceu";
                pontuacaoComputador++;
            }else{
                result = "Empate";
            }
        }else{
            if(escolhaJogador.equals("Pedra")){
                result = "Você venceu";
                pontuacaoJogador++;
            }else if(escolhaJogador.equals("Papel")){
                result = "Computador Venceu";
                pontuacaoComputador++;
            }else{
                result = "Empate";
            }
        }

        return result;
    }
}












