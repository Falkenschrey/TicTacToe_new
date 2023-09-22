import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    public static int ScoreCh;
    public static int ScoreCr;
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    ImageIcon Crusader = new ImageIcon("src/res/Malthese.png");
    ImageIcon Chaos = new ImageIcon("src/res/ChaosStar.png");


    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(239, 198, 144));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(24, 24, 24, 255));
        textfield.setForeground(new Color(140, 4, 4));
        textfield.setFont(new Font("Bodoni MT Condensed", Font.BOLD,32));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Warhammer: The Tic-Tac-Toe Heresy");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for (int i=0; i<9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,0));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0; i<9; i++) {
            if(e.getSource()==buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText()=="") {
                        buttons[i].setIcon(getResizedImageIcon(Crusader,180,180));
                        //buttons[i].setForeground(new Color(239, 125, 12));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("Chaos turn, let the Galaxy burn!");
                        check();
                    }
                    }else{
                    if (buttons[i].getText()=="") {
                        buttons[i].setIcon(getResizedImageIcon(Chaos,180,180));
                        //buttons[i].setForeground(new Color(68, 4, 23));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("Crusaders turn, for the Emperor!");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;

        if (random.nextInt(2)==0) {
            player1_turn = true;
            textfield.setText("Crusaders turn, for the Emperor!");
        } else {
            player1_turn = false;
            textfield.setText("Chaos turn, let the Galaxy burn!");
        }
    }

    public void Dialog() {
        int value = JOptionPane.showConfirmDialog(null, "The game is over, do you want to start a new game?\n"
                        + "Score:\n" + "Chaos: " + ScoreCh + " - Crusader: " + ScoreCr, "New Game?",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (value == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else if (value == JOptionPane.YES_OPTION) {
            this.frame.dispose();
            new TicTacToe();
        } else if (value == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }

    public void check() {
        // Chaos win-conditions
        if(
                (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")) {
            chWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")) {
            chWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")) {
            chWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")) {
            chWins(0,4,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")) {
            chWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")) {
            chWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")) {
            chWins(2,5,8);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")) {
            chWins(2,4,6);
        }
        // Crusader win-conditions
        if(
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")) {
            crWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")) {
            crWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")) {
            crWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")) {
            crWins(0,4,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")) {
            crWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")) {
            crWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")) {
            crWins(2,5,8);
        }
        if(
                (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")) {
            crWins(2,4,6);
        }
    }


    public void chWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(68, 4, 23));
        buttons[b].setBackground(new Color(68, 4, 23));
        buttons[c].setBackground(new Color(68, 4, 23));

        for (int i=0; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setFont(new Font("Chiller", Font.BOLD,32));
        textfield.setText("Chaos has won! Death to the false emperor!");
        ScoreCh++;
        Dialog();
        //Chiller
    }

    public void crWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(239, 125, 12));
        buttons[b].setBackground(new Color(239, 125, 12));
        buttons[c].setBackground(new Color(239, 125, 12));

        for (int i=0; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setFont(new Font("Old English Text MT", Font.BOLD,32));
        textfield.setText("Crusaders won! No Pity! No Remorse! No Fear!");
        ScoreCr++;
        Dialog();
        //Castellar
    }

    public static ImageIcon getResizedImageIcon(ImageIcon sourceImageIcon, int iRequiredWidth, int iRequiredHeight) {
        int iWidth = sourceImageIcon.getIconWidth();
        int iHeight = sourceImageIcon.getIconHeight();

        float fWidthResizeRatio = iWidth / (float) iRequiredWidth;
        float fHeightResizeRatio = iHeight / (float) iRequiredHeight;

        float fResizeRatio = Math.max(fWidthResizeRatio, fHeightResizeRatio);

        int iNewWidth = Math.round(iWidth / fResizeRatio);
        int iNewHeight = Math.round(iHeight / fResizeRatio);

        BufferedImage resizedImage = new BufferedImage(iNewWidth, iNewHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(sourceImageIcon.getImage(), 0, 0, iNewWidth, iNewHeight, null);
        g2.dispose();
        return (new ImageIcon(resizedImage, ""));
    }
}
