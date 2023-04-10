import java.util.ArrayList;

public class HandModel {
    private ArrayList<CardModel> cards;

    public HandModel(){
        cards = new ArrayList<CardModel>();
    }
    public void addCard(CardModel card){
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
            if(cards.get(i).getFaceValue() == 1){
                return true;
            }
        }
        return false;
    }

    public void changeAce(){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getValue() == 11){
                if(this.getValue() > 21){
                    cards.get(i).setAceValue();
                }
            }
        }
    }
}
