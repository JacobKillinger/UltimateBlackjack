public class BlackjackController {
    private String card;
    private Integer score = 7, balance = 1000; // added for testing purposes

    public void startView(){
        BlackjackView newView = new BlackjackView();
        newView.initializeView(newView);
    }
    public  String hit(Boolean isPlayer){
        card = "clubs-7";

        return card;
    }

    public Integer getScore(Boolean isPlayer){

        if(isPlayer == true){

        }
        else
        {
            score = score + 7;
        }
        return score;
    }

    public void setBet(Integer betAmt){

    }

    public void stay(){

    }

    public Integer getBalance()
    {

        return balance;
    }

    public void setBalance(Integer newBalance){
        balance = newBalance;
    }

    public void reset(){

        startView();
    }
}
