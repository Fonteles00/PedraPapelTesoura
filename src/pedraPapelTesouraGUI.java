import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// frontend
public class pedraPapelTesouraGUI extends JFrame implements ActionListener{
    JButton botaoPedra, botaoPapel, botaoTesoura;

    JLabel escolhaComputador;

    JLabel pontuacaoComputadorLabel, pontuacaoJogadorLabel;

    pedraPapelTesoura pedraPapelTesoura;

    public pedraPapelTesouraGUI(){
        super("Pedra Papel Tesoura");

        setSize(450, 574);


        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        pedraPapelTesoura = new pedraPapelTesoura();

        addGuiComponents();
    }

    private void addGuiComponents(){
        pontuacaoComputadorLabel = new JLabel("Computador: 0");

        pontuacaoComputadorLabel.setBounds(0, 43, 450, 30);

        pontuacaoComputadorLabel.setFont(new Font("Dialog", Font.BOLD, 26));

        pontuacaoComputadorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(pontuacaoComputadorLabel);

        escolhaComputador = new JLabel("?");
        escolhaComputador.setBounds(175, 118, 98, 81);
        escolhaComputador.setFont(new Font("Dialog", Font.PLAIN, 18));
        escolhaComputador.setHorizontalAlignment(SwingConstants.CENTER);

        escolhaComputador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(escolhaComputador);

        pontuacaoJogadorLabel = new JLabel("Jogador: 0");
        pontuacaoJogadorLabel.setBounds(0, 317, 450, 30);
        pontuacaoJogadorLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        pontuacaoJogadorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(pontuacaoJogadorLabel);


        botaoPedra = new JButton("Pedra");
        botaoPedra.setBounds(40, 387, 105, 81);
        botaoPedra.setFont(new Font("Dialog", Font.PLAIN, 18));
        botaoPedra.addActionListener(this);
        add(botaoPedra);

        botaoPapel = new JButton("Papel");
        botaoPapel.setBounds(165, 387, 105, 81);
        botaoPapel.setFont(new Font("Dialog", Font.PLAIN, 18));
        botaoPapel.addActionListener(this);
        add(botaoPapel);

        botaoTesoura = new JButton("Tesoura");
        botaoTesoura.setBounds(290, 387, 105, 81);
        botaoTesoura.setFont(new Font("Dialog", Font.PLAIN, 18));
        botaoTesoura.addActionListener(this);
        add(botaoTesoura);
    }

    // displays a message dialog which will show the winner and a try again button to play again
    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this, "Resultado", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        JButton tryAgainButton = new JButton("De novo?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escolhaComputador.setText("?");

                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand().toString();

        String result = pedraPapelTesoura.playpedraPapelTesoura(playerChoice);

        escolhaComputador.setText(pedraPapelTesoura.getEscolhaComputador());

        pontuacaoComputadorLabel.setText("Computador: " + pedraPapelTesoura.getPontuacaoComputador());
        pontuacaoJogadorLabel.setText("Jogador: " + pedraPapelTesoura.getPontuacaoJogador());

        showDialog(result);
    }
}










