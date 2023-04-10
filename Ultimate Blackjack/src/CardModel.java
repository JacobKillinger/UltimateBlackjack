import java.util.Random;

public class CardModel {
    private int value;
    private int faceValue;
    private String  suit;
    private Random r;


    public CardModel(){

        this.r = new Random();
        int randomSuit = r.nextInt(4);
        int randomFaceValue = r.nextInt(13);

        if(randomSuit == 0){
            suit = "hearts";
        }
        else if(randomSuit == 1){
            suit = "diamonds";
        }
        else if(randomSuit == 2){
            suit = "clubs";
        }
        else if(randomSuit == 3){
            suit = "spades";
        }

        if(randomFaceValue == 0){
            faceValue = 1;
            value = 11;
        }
        else if(randomFaceValue == 1){
            faceValue = 2;
            value = 2;
        }
        else if(randomFaceValue == 2){
            faceValue = 3;
            value = 3;
        }
        else if(randomFaceValue == 3){
            faceValue = 4;
            value = 4;
        }
        else if(randomFaceValue == 4){
            faceValue = 5;
            value = 5;
        }
        else if(randomFaceValue == 5){
            faceValue = 6;
            value = 6;
        }
        else if(randomFaceValue == 6){
            faceValue = 7;
            value = 7;
        }
        else if(randomFaceValue == 7){
            faceValue = 8;
            value = 8;
        }
        else if(randomFaceValue == 8){
            faceValue = 9;
            value = 9;
        }
        else if(randomFaceValue == 9){
            faceValue = 10;
            value = 10;
        }
        else if(randomFaceValue == 10){
            faceValue = 11;
            value = 10;
        }
        else if(randomFaceValue == 11){
            faceValue = 12;
            value = 10;
        }
        else if(randomFaceValue == 12){
            faceValue = 13;
            value = 10;
        }
    }

    public int getValue(){
        return this.value;
    }

    public int getFaceValue(){
        return this.faceValue;
    }

    public String getSuit(){
        return this.suit;
    }

    public void setAceValue(){
        this.value = 1;
    }

}
