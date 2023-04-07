public class BlackjackController {
    private HandModel playerHand = new HandModel();
    private HandModel dealerHand = new HandModel();
    private Integer bet = 100, balance = 1000;
    enum Outcome{
        Win,
        Loss,
        Tie
    }
    public void startView(){
        BlackjackView newView = new BlackjackView(balance); //Creates the view window
        newView.initializeView(newView);
    }
    public  String hit(Boolean isPlayer){
        CardModel newCard = new CardModel();
        if(isPlayer == true){
            playerHand.addCard(newCard);
        }
        else{
            dealerHand.addCard(newCard);
        }

        String card = String.format("%s-%d", newCard.getSuit(), newCard.getFaceValue());
        return card;
    }

    public Integer getScore(Boolean isPlayer){

        if(isPlayer == true){
            return playerHand.getValue();
        }
        else
        {
            return dealerHand.getValue();
        }
    }

    public void setBet(Integer betAmt){
        bet = betAmt;
        balance = balance - bet;
    }
    public Integer getBet(){
        return bet;
    }

    public Outcome stay(){

        if(isPlayerBust() == true){
            return Outcome.Loss;
        }
        else if (isDealerBust() == true) {
            balance += (2 * bet);
            setBalance(balance);
            return Outcome.Win;
        }
        else if (isPlayerWin() == true && isPlayerBust() == false){
            balance += (2 * bet);
            setBalance(balance);
            return Outcome.Win;
        }
        else if(isDealerWin() == true && isDealerBust() == false){
            setBalance(balance);
            return Outcome.Loss;
        }
        else{
            balance += bet;
            setBalance(balance);
            return Outcome.Tie;
        }


    }

    public Integer getBalance()
    {
        return balance;
    }

    public void setBalance(Integer newBalance){
        balance = newBalance;
    }

    public boolean isPlayerBust(){
        if (playerHand.getValue() > 21){
            return true;
        }
        return false;
    }

    public boolean isDealerBust(){
        if(dealerHand.getValue() > 21){
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
    public void reset(){ //Creates new view when called
        startView();
        playerHand = new HandModel();
        dealerHand = new HandModel();
    }
}
