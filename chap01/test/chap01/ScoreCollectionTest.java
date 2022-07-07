package chap01;



import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

class ScoreCollectionTest {

    @Test
    public void answersArithmeticMeanOfTwoNumbers() {
        // 준비
        ScoreCollection collection = new ScoreCollection();
        collection.add(()->5);
        collection.add(()->7);

        // 실행 -> 5와 7을 더하고 2로 나눔
        int actualResult = collection.arithmeticMean();

        // 어설트
        assertThat(actualResult, equalTo(6));

    }
}