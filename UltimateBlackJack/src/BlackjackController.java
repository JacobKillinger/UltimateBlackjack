public class BlackjackController {
    private String card;
    private Integer score = 7, balance = 1000; // added values for testing view

    public void startView(){
        BlackjackView newView = new BlackjackView(); //Creates the view window
        newView.initializeView(newView);
    }
    public  String hit(Boolean isPlayer){
        card = "clubs-7"; //added for testing view
        return card;
    }

    public Integer getScore(Boolean isPlayer){

        if(isPlayer == true){

        }
        else
        {
            score = score + 7; //added for testing view
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

    public void reset(){ //Creates new view when called
        startView();
    }
}
