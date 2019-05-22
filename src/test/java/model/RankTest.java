package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {

    Rank rank;

    @Before
    public void setUp(){
        rank = Rank.THIRD;
    }

    @Test
    public void enum_CountTest(){
        assertEquals(6, Rank.FIRST.getCountOfMatch());
        assertEquals(5, Rank.SECOND.getCountOfMatch());
        assertEquals(5, Rank.THIRD.getCountOfMatch());
        assertEquals(4, Rank.FOURTH.getCountOfMatch());
        assertEquals(3, Rank.FIFTH.getCountOfMatch());
        assertEquals(0, Rank.MISS.getCountOfMatch());
    }

    @Test
    public void enum_MoneyTest(){
        assertEquals(2000000000, Rank.FIRST.getWinningMoney());
        assertEquals(30000000, Rank.SECOND.getWinningMoney());
        assertEquals(1500000, Rank.THIRD.getWinningMoney());
        assertEquals(50000, Rank.FOURTH.getWinningMoney());
        assertEquals(5000, Rank.FIFTH.getWinningMoney());
        assertEquals(0, Rank.MISS.getWinningMoney());
    }

    @Test
    public void valueOfTest_보너스통과(){
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
        assertEquals(Rank.THIRD, Rank.valueOf(4, true)); //countOfMatch, matchBonus
        assertEquals(Rank.FOURTH, Rank.valueOf(3, true));
        assertEquals(Rank.FIFTH, Rank.valueOf(2, true));
     }

    @Test
    public void valueOfTest_보너스통과못함(){
        assertEquals(Rank.THIRD, Rank.valueOf(5, false)); //countOfMatch, matchBonus
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
    }

    @Test
    public void valueOFTest_상금없음(){
        assertEquals(Rank.MISS, Rank.valueOf(1, true));
        assertEquals(Rank.MISS, Rank.valueOf(1, false));
        assertEquals(Rank.MISS, Rank.valueOf(2, false));
        assertEquals(Rank.MISS, Rank.valueOf(0, true));
        assertEquals(Rank.MISS, Rank.valueOf(0, false));
    }
}