import info.gridworld.actor.Bug;

public class SpiralBug extends Bug{
	//记录已走的次数
	private int steps;
	//记录最开始的边长
    private int sideLength;

    //默认构造函数，传入的参数是最开始的边长
    public SpiralBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    //控制bug移动行为的函数    
    public void act()
    {
    	//判断已走步数是否达到此时最大边长
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        //否则将转弯
        else
        {
            turn();
            turn();
            steps = 0;
            //Bug每次转弯sideLength将会增长
            sideLength++;
        }
    }
}
