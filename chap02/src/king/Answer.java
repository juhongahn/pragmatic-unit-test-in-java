package king;

/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
 ***/

public class Answer {
    // int로 저장한 이유는 Bool.TRUE, FALSE 로 받는것 같다.(각각 1과 0) -> expected라고 보면 될듯..
    // 변수명을 너무 단순히 지어서 이해하기 힘듬..
    private int i;
    private Question question;

    public Answer(Question question, int i) {
        this.question = question;
        this.i = i;
    }

    public Answer(Question characteristic, String matchingValue) {
        this.question = characteristic;
        this.i = characteristic.indexOf(matchingValue);
    }

    public String getQuestionText() {
        return question.getText();
    }

    @Override
    public String toString() {
        return String.format("%s %s", question.getText(), question.getAnswerChoice(i));
    }

    public boolean match(int expected) {
        return question.match(expected, i);
    }

    public boolean match(Answer otherAnswer) {
        return question.match(i, otherAnswer.i);
    }

    public Question getCharacteristic() {
        return question;
    }
}