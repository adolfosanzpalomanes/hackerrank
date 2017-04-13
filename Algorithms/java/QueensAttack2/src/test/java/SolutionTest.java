import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yrch on 13/4/17.
 */
public class SolutionTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void couldAttack01() throws Exception {
        int n = 4;
        int k = 0;
        Solution.Cell queenPosition = new Solution.Cell(4,4);


        Map<String,Solution.Cell> obstacleList = new HashMap<>(k);

        Assert.assertEquals(9,Solution.couldAttack(n,queenPosition,obstacleList));


    }

    @org.junit.Test
    public void couldAttack02() throws Exception {
        int n = 5;
        int k = 3;
        Solution.Cell queenPosition = new Solution.Cell(4,3);


        Map<String,Solution.Cell> obstacleList = new HashMap<>(k);
        obstacleList.put(new Solution.Cell(5,5).toString(),new Solution.Cell(5,5));
        obstacleList.put(new Solution.Cell(4,2).toString(),new Solution.Cell(4,2));
        obstacleList.put(new Solution.Cell(2,3).toString(),new Solution.Cell(2,3));

        Assert.assertEquals(1,Solution.getVerticalTop(n,queenPosition,obstacleList));
        Assert.assertEquals(1,Solution.getVerticalBottom(queenPosition,obstacleList));
        Assert.assertEquals(0,Solution.getHorizontalLeft(queenPosition,obstacleList));
        Assert.assertEquals(2,Solution.getHorizontalRight(n,queenPosition,obstacleList));

        Assert.assertEquals(1,Solution.getDiagonalUpperLeft(n,queenPosition,obstacleList));
        Assert.assertEquals(1,Solution.getDiagonalUpperRight(n,queenPosition,obstacleList));
        Assert.assertEquals(2,Solution.getDiagonalBottomLeft(queenPosition,obstacleList));
        Assert.assertEquals(2,Solution.getDiagonalBottomRight(n,queenPosition,obstacleList));

        Assert.assertEquals(10,Solution.couldAttack(n,queenPosition,obstacleList));

    }

}