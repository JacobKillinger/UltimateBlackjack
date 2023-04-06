public class Blackjack {
    private Hand playerHand;
    private Hand dealerHand;
    private int balance;

    private int bet;

    public Blackjack(){
        balance = 10000;
        playerHand = new Hand();
        dealerHand = new Hand();
        bet = 10;
    }

    public void deal(){
        playerHand.addCard(new Card());
        playerHand.addCard(new Card());
        dealerHand.addCard(new Card());
        dealerHand.addCard(new Card());
    }

    public void hit(){
        playerHand.addCard(new Card());
    }

    public void stand(){
        while(dealerHand.getValue() < 17){
            dealerHand.addCard(new Card());
        }
    }

    public void reset(){
        playerHand = new Hand();
        dealerHand = new Hand();
    }

    public int getPlayerHandValue(){
        return playerHand.getValue();
    }

    public int getDealerHandValue(){
        return dealerHand.getValue();
    }

    public boolean isPlayerBust(){
        if (playerHand.getValue() > 21){
            return true;
        }
        return false;
    }

    public boolean isDealerBust(){
        if(playerHand.getValue() > 21){
            return true;
        }
        return false;
    }

    public boolean isPlayerWin(){
        if(playerHand.getValue() > dealerHand.getValue()){
            return true;
        }
        return false;
    }

    public boolean isDealerWin(){
        if(dealerHand.getValue() > playerHand.getValue()){
            return true;
        }
        return false;
    }

    public boolean isTie(){
        if(dealerHand.getValue() == playerHand.getValue()){
            return true;
        }
        return false;
    }

    public void addBalance(int bet){
        balance = balance + bet;
    }

    public void setBet(int bet){
        this.bet = bet;
    }
}
