package contatoJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class cadastroContatoGUI extends JFrame {
    private ArrayList<Contato> contatos = new ArrayList<>();
    private DefaultListModel<Contato> listModel = new DefaultListModel<>();
    private JList<Contato> listaContatos = new JList<>(listModel);
    
    private JTextField campoNome = new JTextField(15);
    private JTextField campoTelefone = new JTextField(15);
    private JTextField campoEmail = new JTextField(15);

    public cadastroContatoGUI() {
        setTitle("Cadastro de Contatos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de Formulário
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(4, 2, 5, 5));
        painelFormulario.add(new JLabel("Nome:"));
        painelFormulario.add(campoNome);
        painelFormulario.add(new JLabel("Telefone:"));
        painelFormulario.add(campoTelefone);
        painelFormulario.add(new JLabel("Email:"));
        painelFormulario.add(campoEmail);

        // Botão Adicionar
        JButton botaoAdicionar = new JButton("Adicionar Contato");
        botaoAdicionar.addActionListener(new AdicionarContatoAction());

        // Painel de Botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoAdicionar);

        // Painel Principal
        add(new JScrollPane(listaContatos), BorderLayout.CENTER);
        add(painelFormulario, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    // Ação do botão de adicionar contato
    private class AdicionarContatoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = campoNome.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();

            // Verifica se os campos estão preenchidos
            if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            } else {
                // Cria o contato e adiciona à lista
                Contato contato = new Contato(nome, telefone, email);
                contatos.add(contato);
                listModel.addElement(contato);
                JOptionPane.showMessageDialog(null, "Contato adicionado!");

                // Limpa os campos
                campoNome.setText("");
                campoTelefone.setText("");
                campoEmail.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	cadastroContatoGUI frame = new cadastroContatoGUI();
            frame.setVisible(true);
        });
    }
}
