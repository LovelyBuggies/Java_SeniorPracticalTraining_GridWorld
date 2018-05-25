import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug{
	//记录已走的次数
	private int steps;
	//记录z字形的边长
    private int sideLength;
    //判断ZBug正在Z字形的哪一部分
    private int zPart;

    //默认构造函数传入一个z字形边长的参数
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        zPart = 0;
        //最开始方向是east方向
        setDirection(Location.EAST);
    }

    //控制ZBug移动的函数
    public void act()
    {
    	//先判断是否走完了z字形的某个边
    	if(steps == sideLength) {
    		//z字形的最低端
    		if(zPart == 2) {
    			return;
    		}
    		//z字形的最上端
    		else if(zPart == 0)
            {
            	setDirection(getDirection() + Location.SOUTHEAST);
                zPart = 1;
                steps = 0;
            //z字形的斜边
            }else {
            	setDirection(getDirection() - Location.SOUTHEAST);
                zPart = 2;
            	steps = 0;
            }
    	}
    	//如果没有走完该边
    	else{
    		//且不能移动的话将一直停留并且不转向
    		if(!canMove()) {
    			return;
    		}
    		move();
    		steps++;
        }
        
    }
}
