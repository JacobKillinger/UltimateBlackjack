public class BlackjackController {
    private String card;
    private Integer score;
    private BlackjackView view;
    public void startView(){

    }
    public  String hit(Boolean isPlayer){
        card = "clubs-7";

        return card;
    }

    public Integer getScore(Boolean isPlayer){

        score = 1;
        return score;
    }

    public void setBet(Integer betAmt){

    }

    public void stay(){

    }
}
