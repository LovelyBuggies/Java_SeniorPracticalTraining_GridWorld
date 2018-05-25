import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public final class ZBugRunner {
	public static void main(String[] args) {
		//magic number
		final int x = 0, y = 5, side = 4;
		//默认构造器构造world
		ActorWorld world = new ActorWorld();
		//构造一个边长为side的ZBug
		ZBug bug = new ZBug(side);
		//将该ZBug加到world里面
		world.add(new Location(x, y),bug);
		//显示物体
		world.show();
	}
}
