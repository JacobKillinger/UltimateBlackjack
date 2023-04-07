import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BlackjackView {
    private JFrame frame;
    private JButton btnHit;
    private JButton btnStay;
    private JButton btnReset;
    private JLabel lblDealerCard1;
    private JLabel lblDealerCard2;
    private JLabel lblDealerCard3;
    private JLabel lblDealerCard4;
    private JLabel lblDealerCard5;
    private JLabel lblPlayerCard1;
    private JLabel lblPlayerCard2;
    private JLabel lblPlayerCard3;
    private JLabel lblPlayerCard4;
    private JLabel lblPlayerCard5;
    private JLabel lblPlayerScore;
    private JTextField txtFieldBet;
    private JLabel lblBalance;
    private JLabel lblDealerScore;
    private JPanel mainPanel;
    private String cardPath;
    private String card;
    private String dealersHiddenCard;
    private Integer counter = 0;
    private Integer Score, dealerScore, betAmt;
    private Boolean pressed;
    BlackjackController gameController = new BlackjackController();
    public BlackjackView(Integer balance) {
        gameController.setBalance(balance);
        lblBalance.setText("$" + gameController.getBalance().toString());
        txtFieldBet.setText(gameController.getBet().toString());
        btnReset.setVisible(false);

        btnHit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ImageIcon icon = new ImageIcon();
                pressed = true;

                while(pressed == true){
                    btnHit.setEnabled(false);
                    if (counter == 0){
                        //Bets
                        try {
                            betAmt = Integer.parseInt(txtFieldBet.getText());
                            txtFieldBet.setEditable(false);
                            gameController.setBet(betAmt);
                            lblBalance.setText(gameController.getBalance().toString());
                        }
                        catch (Exception exception){
                            JOptionPane.showMessageDialog(frame, "Enter a valid bet!");
                            txtFieldBet.setText("");
                            pressed = false;
                            break;
                        }

                        //Deals hand for player
                        card = gameController.hit(true); //hit functions returns a string "suit-value"
                        cardPath = String.format("src/Playing Cards/card-%s.png", card);
                        icon = new ImageIcon(cardPath);
                        lblPlayerCard1.setIcon(icon);

                        card = gameController.hit(true);
                        cardPath = String.format("src/Playing Cards/card-%s.png", card);
                        icon = new ImageIcon(cardPath);
                        lblPlayerCard2.setIcon(icon);

                        counter++;

                        //Deals hand for dealer

                        dealersHiddenCard = gameController.hit(false); //saves dealers hidden card to be revealed when stay is called
                        cardPath = String.format("src/Playing Cards/card-back1.png");
                        icon = new ImageIcon(cardPath);
                        lblDealerCard1.setIcon(icon);

                        card = gameController.hit(false);
                        cardPath = String.format("src/Playing Cards/card-%s.png", card);
                        icon = new ImageIcon(cardPath);
                        lblDealerCard2.setIcon(icon);

                        btnHit.setText("Hit");
                        Score = gameController.getScore(true); //Calls getPlayerScore which returns an int of their current score
                        lblPlayerScore.setText(String.format("%d",Score));

                        pressed = false;
                    }
                    else{
                        card = gameController.hit(true);// Returns "suit-value" as string because card names are variations to "card-clubs-1.png"
                        Score = gameController.getScore(true);

                        cardPath = String.format("src/Playing Cards/card-%s.png", card);
                        icon = new ImageIcon(cardPath);

                        switch (counter) // Applies card images to labels
                        {
                            case 1:
                                lblPlayerCard3.setIcon(icon);
                                counter++;
                                break;

                            case 2:
                                lblPlayerCard4.setIcon(icon);
                                counter++;
                                break;

                            case 3:
                                lblPlayerCard5.setIcon(icon);
                                counter++;
                                break;

                            default:
                                counter = 0;
                        }
                        if(Score > 21)
                        {
                            lblPlayerScore.setText("Busted");
                            btnStay.doClick();
                        }
                        if(Score == 21)
                        {
                            lblPlayerScore.setText(String.format("%d", Score));
                            btnStay.doClick();
                        }
                        else
                        {
                            lblPlayerScore.setText(String.format("%d", Score));
                        }
                        pressed = false;
                    }
                }
                btnHit.setEnabled(true);
            }
        });

        btnStay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (counter != 0) {
                    btnStay.setEnabled(false);
                    btnHit.setEnabled(false);
                    btnReset.setVisible(true);


                    ImageIcon dealersIcon = new ImageIcon();
                    cardPath = String.format("src/Playing Cards/card-%s.png", dealersHiddenCard);
                    dealersIcon = new ImageIcon(cardPath);
                    lblDealerCard1.setIcon(dealersIcon);

                    dealerScore = gameController.getScore(false);
                    counter = 0;

                    while(dealerScore < 17)   //calls the hit function for dealer whenever the dealer score is less than 16
                    {
                        card = gameController.hit(false);
                        cardPath = String.format("src/Playing Cards/card-%s.png", card);
                        dealerScore = gameController.getScore(false);
                        dealersIcon = new ImageIcon(cardPath);

                        switch (counter) // Applies card images to labels
                        {
                            case 0:
                                lblDealerCard3.setIcon(dealersIcon);
                                counter++;
                                break;

                            case 1:
                                lblDealerCard4.setIcon(dealersIcon);
                                counter++;
                                break;

                            case 2:
                                lblDealerCard5.setIcon(dealersIcon);
                                counter++;
                                break;

                            default:
                                counter = 0;
                        }
                    }

                    if(dealerScore > 21){
                        lblDealerScore.setText("Busted");
                    }
                    else
                    {
                        lblDealerScore.setText(String.format("%d", dealerScore));
                    }

                    Enum outcome = gameController.stay();

                    if(outcome == BlackjackController.Outcome.Win){
                        int response = JOptionPane.showConfirmDialog(null, "Congrats you won $" + betAmt.toString() + "!\nDo you want to reset?", "Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(response == JOptionPane.YES_OPTION)
                        {
                            btnReset.doClick();
                        }
                    }
                    else if (outcome == BlackjackController.Outcome.Loss){
                        int response = JOptionPane.showConfirmDialog(null, "Nice try, you lost!\nDo you want to reset?", "Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(response == JOptionPane.YES_OPTION)
                        {
                            btnReset.doClick();
                        }
                    }
                    else if (outcome == BlackjackController.Outcome.Tie){
                        int response = JOptionPane.showConfirmDialog(null, "Tie, bet returned!\nDo you want to reset?", "Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(response == JOptionPane.YES_OPTION)
                        {
                            btnReset.doClick();
                        }
                    }



                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Please make a bet and deal first!");
                }

            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.reset();

                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
    }

    public void initializeView(BlackjackView view){
        Integer balance = gameController.getBalance();
        view = new BlackjackView(balance);
        frame = new JFrame("Blackjack");
        frame.setContentPane(view.mainPanel);
        frame.setSize(650,520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
