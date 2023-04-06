import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(){
        cards = new ArrayList<Card>();
    }
    public void addCard(Card card){
        cards.add(card);
    }

    public int getValue(){
        int returnValue = 0;
        for(int i = 0; i < cards.size(); i++){
            returnValue = returnValue + cards.get(i).getValue();
        }
        return returnValue;
    }

    public boolean containsAce(){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getFaceValue() == 0){
                return true;
            }
        }
        return false;
    }
}
