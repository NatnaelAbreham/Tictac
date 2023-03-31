package tictactoy;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class TicTacToy extends JFrame {

    JButton[][] toy = new JButton[3][3];
    int[][] xvalue = new int[3][3]; //storing which position 2 for system 1 for user 
    int ii = 0, jj = 0;//take the first toy user entered 
    int random1 = 0, random2 = 0; //sore random number generated from Math class
    static JFrame frame;

    TicTacToy() {
        JPanel p1 = new JPanel(new GridLayout(3, 3, 3, 3));
        p1.setBorder(new LineBorder(Color.CYAN, 10));
        p1.setBackground(Color.CYAN);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                toy[i][j] = new JButton("");
                toy[i][j].setBackground(new Color(10, 110, 91));
                toy[i][j].setFont(new Font("Serif", Font.BOLD, 100));
                toy[i][j].setForeground(Color.WHITE);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                p1.add(toy[i][j]);
            }
        }
        
        add(p1);

        ToyListener listener = new ToyListener();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                toy[i][j].addActionListener(listener);
            }
        }
    }

    class ToyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String s = "X";

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (toy[i][j] == e.getSource()) {
                        //used for detecting if a button not to be pressed more than one 
                        //if it pressed,it will return withe out changing the button
                        for (int x = 0; x < 3; x++) {
                            for (int y = 0; y < 3; y++) {
                                if (xvalue[i][j] == 1 || xvalue[i][j] == 2) {
                                    return;
                                }
                            }
                        }
                        ii = i;
                        jj = j;
                        xvalue[i][j] = 1;
                        toy[i][j].setText("x");
                        toy[i][j].setForeground(Color.PINK);
                        if ((xvalue[0][0] == 1 && xvalue[0][1] == 1 && xvalue[0][2] == 1) || (xvalue[1][0] == 1 && xvalue[1][1] == 1 && xvalue[1][2] == 1) || (xvalue[2][0] == 1 && xvalue[2][1] == 1 && xvalue[2][2] == 1)
                                || (xvalue[0][0] == 1 && xvalue[1][0] == 1 && xvalue[2][0] == 1) || (xvalue[0][1] == 1 && xvalue[1][1] == 1 && xvalue[2][1] == 1) || (xvalue[0][2] == 1 && xvalue[1][2] == 1 && xvalue[2][2] == 1)
                                || (xvalue[0][0] == 1 && xvalue[1][1] == 1 && xvalue[2][2] == 1) || (xvalue[0][2] == 1 && xvalue[1][1] == 1 && xvalue[2][0] == 1)) {
                            JOptionPane.showMessageDialog(null, "you win !!");
                            restartTicTac();
                        } else if ((xvalue[0][0] == 2 && xvalue[0][1] == 2 && xvalue[0][2] == 2) || (xvalue[1][0] == 2 && xvalue[1][1] == 2 && xvalue[1][2] == 2) || (xvalue[2][0] == 2 && xvalue[2][1] == 2 && xvalue[2][2] == 2)
                                || (xvalue[0][0] == 2 && xvalue[1][0] == 2 && xvalue[2][0] == 2) || (xvalue[0][1] == 2 && xvalue[1][1] == 2 && xvalue[2][1] == 2) || (xvalue[0][2] == 2 && xvalue[1][2] == 2 && xvalue[2][2] == 2)
                                || (xvalue[0][0] == 2 && xvalue[1][1] == 2 && xvalue[2][2] == 2) || (xvalue[0][2] == 2 && xvalue[1][1] == 2 && xvalue[2][0] == 2)) {
                            JOptionPane.showMessageDialog(null, "you Loss !!");
                            restartTicTac();
                        } else if ((xvalue[0][0] == 2 && xvalue[2][2] == 2 && xvalue[1][1] == 0) || (xvalue[0][2] == 2 && xvalue[2][0] == 2 && xvalue[1][1] == 0)) {
                            xvalue[1][1] = 2;
                            toy[1][1].setText("O");
                        } else if (xvalue[0][0] == 2 && xvalue[0][1] == 2 && xvalue[0][2] == 0) {
                            xvalue[0][2] = 2;
                            toy[0][2].setText("O");
                        } else if (xvalue[0][0] == 2 && xvalue[0][1] == 0 && xvalue[0][2] == 2) {
                            xvalue[0][1] = 2;
                            toy[0][1].setText("O");
                        } else if (xvalue[0][0] == 0 && xvalue[0][1] == 2 && xvalue[0][2] == 2) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        } else if (xvalue[1][0] == 2 && xvalue[1][1] == 2 && xvalue[1][2] == 0) {
                            xvalue[1][2] = 2;
                            toy[1][2].setText("O");
                        } else if (xvalue[1][0] == 0 && xvalue[1][1] == 2 && xvalue[1][2] == 2) {
                            xvalue[1][0] = 2;
                            toy[1][0].setText("O");
                        } else if (xvalue[1][0] == 2 && xvalue[1][1] == 0 && xvalue[1][2] == 2) {
                            xvalue[1][1] = 2;
                            toy[1][1].setText("O");
                        } else if (xvalue[2][0] == 2 && xvalue[2][1] == 2 && xvalue[2][2] == 0) {
                            xvalue[2][2] = 2;
                            toy[2][2].setText("O");
                        } else if (xvalue[2][0] == 2 && xvalue[2][1] == 0 && xvalue[2][2] == 2) {
                            xvalue[2][1] = 2;
                            toy[2][1].setText("O");
                        } else if (xvalue[2][0] == 0 && xvalue[2][1] == 2 && xvalue[2][2] == 2) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        } else if (xvalue[0][0] == 2 && xvalue[1][0] == 2 && xvalue[2][0] == 0) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        } else if (xvalue[0][0] == 2 && xvalue[1][0] == 0 && xvalue[2][0] == 2) {
                            xvalue[1][0] = 2;
                            toy[1][0].setText("O");
                        } else if (xvalue[0][0] == 0 && xvalue[1][0] == 2 && xvalue[2][0] == 2) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        } else if (xvalue[0][1] == 2 && xvalue[1][1] == 2 && xvalue[2][1] == 0) {
                            xvalue[2][1] = 2;
                            toy[2][1].setText("O");
                        } else if (xvalue[0][1] == 2 && xvalue[1][1] == 0 && xvalue[2][1] == 2) {
                            xvalue[1][1] = 2;
                            toy[1][1].setText("O");
                        } else if (xvalue[0][1] == 0 && xvalue[1][1] == 2 && xvalue[2][1] == 2) {
                            xvalue[0][1] = 2;
                            toy[0][1].setText("O");
                        } else if (xvalue[0][2] == 2 && xvalue[1][2] == 2 && xvalue[2][2] == 0) {
                            xvalue[2][2] = 2;
                            toy[2][2].setText("O");
                        } else if (xvalue[0][2] == 2 && xvalue[1][2] == 0 && xvalue[2][2] == 2) {
                            xvalue[1][2] = 2;
                            toy[1][2].setText("O");
                        } else if (xvalue[0][2] == 0 && xvalue[1][2] == 2 && xvalue[2][2] == 2) {
                            xvalue[0][2] = 2;
                            toy[0][2].setText("O");
                        } else if (xvalue[0][0] == 2 && xvalue[2][2] == 0 && xvalue[1][1] == 2) {
                            xvalue[2][2] = 2;
                            toy[2][2].setText("O");
                        } else if (xvalue[0][0] == 0 && xvalue[2][2] == 2 && xvalue[1][1] == 2) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        } else if (xvalue[2][0] == 0 && xvalue[0][2] == 2 && xvalue[1][1] == 2) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        } else if (xvalue[2][0] == 2 && xvalue[0][2] == 0 && xvalue[1][1] == 2) {
                            xvalue[0][2] = 2;
                            toy[0][2].setText("O");
                        }
                        
                       
                        else if (xvalue[0][0] == 0 && xvalue[1][1] == 1 && xvalue[2][2] == 1) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        }else if (xvalue[0][0] == 1 && xvalue[0][1] == 1 && xvalue[0][2] == 0) {
                            xvalue[0][2] = 2;
                            toy[0][2].setText("O");
                        } else if (xvalue[0][0] == 1 && xvalue[0][1] == 0 && xvalue[0][2] == 1) {
                            xvalue[0][1] = 2;
                            toy[0][1].setText("O");
                        } else if (xvalue[0][0] == 0 && xvalue[0][1] == 1 && xvalue[0][2] == 1) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        }//oooooooooooo
                        else if (xvalue[1][0] == 1 && xvalue[1][1] == 1 && xvalue[1][2] == 0) {
                            xvalue[1][2] = 2;
                            toy[1][2].setText("O");
                        } else if (xvalue[1][0] == 0 && xvalue[1][1] == 1 && xvalue[1][2] == 1) {
                            xvalue[1][0] = 2;
                            toy[1][0].setText("O");
                        } else if (xvalue[1][0] == 1 && xvalue[1][1] == 0 && xvalue[1][2] == 1) {
                            xvalue[1][1] = 2;
                            toy[1][1].setText("O");
                        } else if (xvalue[2][0] == 1 && xvalue[2][1] == 1 && xvalue[2][2] == 0) {
                            xvalue[2][2] = 2;
                            toy[2][2].setText("O");
                        } else if (xvalue[2][0] == 1 && xvalue[2][1] == 0 && xvalue[2][2] == 1) {
                            xvalue[2][1] = 2;
                            toy[2][1].setText("O");
                        } else if (xvalue[2][0] == 0 && xvalue[2][1] == 1 && xvalue[2][2] == 1) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        } else if (xvalue[0][0] == 1 && xvalue[1][0] == 1 && xvalue[2][0] == 0) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        } else if (xvalue[0][0] == 1 && xvalue[1][0] == 0 && xvalue[2][0] == 1) {
                            xvalue[1][0] = 2;
                            toy[1][0].setText("O");
                        } else if (xvalue[0][0] == 0 && xvalue[1][0] == 1 && xvalue[2][0] == 1) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        } else if (xvalue[0][1] == 1 && xvalue[1][1] == 1 && xvalue[2][1] == 0) {
                            xvalue[2][1] = 2;
                            toy[2][1].setText("O");
                        } else if (xvalue[0][1] == 1 && xvalue[1][1] == 0 && xvalue[2][1] == 1) {
                            xvalue[1][1] = 2;
                            toy[1][1].setText("O");
                        } else if (xvalue[0][1] == 0 && xvalue[1][1] == 1 && xvalue[2][1] == 1) {
                            xvalue[0][1] = 2;
                            toy[0][1].setText("O");
                        } else if (xvalue[0][2] == 1 && xvalue[1][2] == 1 && xvalue[2][2] == 0) {
                            xvalue[2][2] = 2;
                            toy[2][2].setText("O");
                        } else if (xvalue[0][2] == 1 && xvalue[1][2] == 0 && xvalue[2][2] == 1) {
                            xvalue[1][2] = 2;
                            toy[1][2].setText("O");
                        } else if (xvalue[0][2] == 0 && xvalue[1][2] == 1 && xvalue[2][2] == 1) {
                            xvalue[0][2] = 2;
                            toy[0][2].setText("O");
                        } else if (xvalue[0][0] == 1 && xvalue[2][2] == 0 && xvalue[1][1] == 1) {
                            xvalue[2][2] = 2;
                            toy[2][2].setText("O");
                        } else if (xvalue[0][0] == 0 && xvalue[2][2] == 1 && xvalue[1][1] == 1) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        } else if (xvalue[2][0] == 0 && xvalue[0][2] == 1 && xvalue[1][1] == 1) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        } else if (xvalue[2][0] == 1 && xvalue[0][2] == 0 && xvalue[1][1] == 1) {
                            xvalue[0][2] = 2;
                            toy[0][2].setText("O");
                        } else if (xvalue[0][1] == 1 && xvalue[1][0] == 1 && xvalue[0][0] == 0) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        } else if (xvalue[2][0] == 0 && xvalue[1][0] == 1 && xvalue[2][1] == 1) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        } else if (xvalue[2][1] == 1 && xvalue[1][2] == 1 && xvalue[2][2] == 0) {
                            xvalue[2][2] = 2;
                            toy[2][2].setText("O");
                        } else if (xvalue[0][1] == 1 && xvalue[1][2] == 1 && xvalue[0][2] == 0) {
                            xvalue[0][2] = 2;
                            toy[0][2].setText("O");
                        } else if (xvalue[0][0] == 1 && xvalue[1][2] == 1 && xvalue[0][1] == 0) {
                            xvalue[0][1] = 2;
                            toy[0][1].setText("O");
                        } else if (xvalue[2][0] == 1 && xvalue[0][1] == 1 && xvalue[0][0] == 0) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        }   else if (xvalue[2][0] == 1 && xvalue[1][2] == 1 && xvalue[2][2] == 0) {
                            xvalue[2][2] = 2;
                            toy[2][2].setText("O");
                        } else if ((xvalue[0][2] == 1 && xvalue[1][1] == 2 && xvalue[2][0] == 1 && xvalue[0][1] == 0)) {
                            xvalue[0][1] = 2;
                            toy[0][1].setText("O");
                        } else if ((xvalue[0][0] == 1 && xvalue[2][2] == 1 && xvalue[1][1] == 0) || (xvalue[0][2] == 1 && xvalue[2][0] == 1 && xvalue[1][1] == 0)) {
                            xvalue[1][1] = 2;
                            toy[1][1].setText("O");
                        }else if ((xvalue[1][0] == 1 && xvalue[1][1] == 1 && xvalue[1][2] == 0)) {
                            xvalue[1][2] = 2;
                            toy[1][2].setText("O");
                        }else if ((xvalue[2][2] == 1 && xvalue[1][0] == 1 && xvalue[2][0] == 0)) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        } else if ((xvalue[1][0] == 1 && xvalue[0][2] == 1 && xvalue[1][2] == 2 && xvalue[0][0] == 0)) {
                            xvalue[0][0] = 2;
                            toy[0][0].setText("O");
                        } 
                        
                        else if ((xvalue[0][0] == 1 && xvalue[2][1] == 1 && xvalue[2][0] == 0)) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        }else if ((xvalue[0][2] == 1 && xvalue[2][1] == 1 && xvalue[2][0] == 0)) {
                            xvalue[2][0] = 2;
                            toy[2][0].setText("O");
                        }else if ((xvalue[0][1] == 1 && xvalue[2][2] == 1 && xvalue[0][2] == 0)) {
                            xvalue[0][2] = 2;
                            toy[0][2].setText("O");
                        }else {
                             
                            boolean trvalue = false;
                            for (int m = 0; m < 3; m++) {
                                for (int n = 0; n < 3; n++) {
                                    if (xvalue[m][n] == 1 || xvalue[m][n] == 2) {
                                        
                                    } else {

                                        if (ii != 1 && jj != 1) {
                                            jj = 1;
                                            ii = 1;
                                        } else if (ii == jj) {
                                            if (ii > 1) {
                                                ii = 0;
                                                jj = 0;
                                            } else if (ii < 1) {
                                                ii = 2;
                                                jj = 2;
                                            } else {
                                                ii = 2;
                                                jj = 0;
                                            }
                                        } else if (ii == 0 && jj == 1) {
                                            jj = 2;
                                            ii = 1;
                                        } else if (ii == 2 && jj == 1) {
                                            jj = 0;
                                            ii = 1;
                                        } else if (ii == 1 && jj == 0) {
                                            ii = 2;
                                            jj = 1;
                                        } else if (ii == 1 && jj == 2) {
                                            ii = 0;
                                            jj = 1;
                                        }

                                        // used for check if priviously assigned 
                                        if (xvalue[jj][ii] == 2 || xvalue[jj][ii] == 1) {
                                            boolean tv = false;
                                            for (int x = 0; x < 3; x++) {
                                                for (int y = 0; y < 3; y++) {
                                                    if (xvalue[x][y] != 2 && xvalue[x][y] != 1) {
                                                        xvalue[x][y] = 2;
                                                        toy[x][y].setText("O");
                                                        tv = true;
                                                        break;
                                                    }
                                                }
                                                if (tv) {
                                                    break;
                                                }
                                            }
                                        } else {
                                            xvalue[jj][ii] = 2;
                                            toy[jj][ii].setText("O");
                                        }

                                        trvalue = true;
                                        break;
                                    }
                                }
                                if (trvalue) {
                                    break;
                                }
                            }
                        }

                        if ((xvalue[0][0] == 2 && xvalue[0][1] == 2 && xvalue[0][2] == 2) || (xvalue[1][0] == 2 && xvalue[1][1] == 2 && xvalue[1][2] == 2) || (xvalue[2][0] == 2 && xvalue[2][1] == 2 && xvalue[2][2] == 2)
                                || (xvalue[0][0] == 2 && xvalue[1][0] == 2 && xvalue[2][0] == 2) || (xvalue[0][1] == 2 && xvalue[1][1] == 2 && xvalue[2][1] == 2) || (xvalue[0][2] == 2 && xvalue[1][2] == 2 && xvalue[2][2] == 2)
                                || (xvalue[0][0] == 2 && xvalue[1][1] == 2 && xvalue[2][2] == 2) || (xvalue[0][2] == 2 && xvalue[1][1] == 2 && xvalue[2][0] == 2)) {
                            JOptionPane.showMessageDialog(null, "you Loss !!");
                            restartTicTac();
                        }
                        int counter = 0;
                        for (int m = 0; m < 3; m++) {
                            for (int n = 0; n < 3; n++) {
                                if (xvalue[m][n] != 0) {
                                    counter++;
                                }
                            }
                        }
                        if (counter == 9) {
                            JOptionPane.showMessageDialog(null, "try again");
                            restartTicTac();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        frame = new TicTacToy();

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //used for clearing the frame
    void restartTicTac() {

        ii = 0;
        jj = 0;
        random1 = 0;
        random2 = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                toy[i][j].setText("");
                toy[i][j].setBackground(new Color(10, 110, 91));
                toy[i][j].setFont(new Font("Serif", Font.BOLD, 100));
                toy[i][j].setForeground(Color.WHITE);
                xvalue[i][j] = 0;
            }
        }
    }
}
