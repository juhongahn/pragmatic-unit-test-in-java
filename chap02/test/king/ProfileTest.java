package king;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileTest {
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void create() {
        profile = new Profile("Bull Hockey, Inc.");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {

        // 프로필에 저장된(사용자의) 답변
        profile.add(new Answer(question, Bool.FALSE));

        // 표준답변
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
        boolean matches = profile.matches(criteria);

        // 표준답변은 가중치가 MustMatch이고 TRUE이다. 하지만 사용자의 답변은 False이다.
        assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        // 프로필에 저장된(사용자의) 답변
        profile.add(new Answer(question, Bool.FALSE));
        // 표준답변
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
        boolean matches = profile.matches(criteria);

        // 표준답변은 가중치가 DontCare이다. => 항상 true
        assertTrue(matches);
    }

}