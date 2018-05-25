import java.util.Arrays;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class DancingBug extends Bug{
	//代表已走的步数
	private int steps;
	//代表转身的次数
    private int[] turnTime;
    //代表存储转身次数的数组的长度
    private int maxStep;

    //默认构造函数，传入一个数组指挥每次的转身次数
    public DancingBug(int[] turn) {
    	turnTime = Arrays.copyOf(turn, turn.length); ;
    	steps = 0;
    	maxStep = turn.length;
    }

    //判断dancingbug的行为
    public void act()
    {
    	//这里先改变bug的方向再判断是否移动
    	//考虑到steps没有清零，可能会超过maxStep，所以采用求余数的方式
        setDirection(getDirection() + Location.HALF_RIGHT * turnTime[steps % maxStep]);
        steps++;
        if(canMove()) {
        	move();
        }
            
    }
}
