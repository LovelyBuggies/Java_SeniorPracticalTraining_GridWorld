package Bugs.SpiralBug.src;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public final class SpiralBugRunner {
	public static void main(String[] args) {
		//magic number
		final int x = 2, y = 4, side = 5;
		//调用UnboundGrid默认构造函数制造一个无边界的网格
		UnboundedGrid<Actor> indefinitGrid = new UnboundedGrid<Actor>();
		//用该无边界网格构造一个World
		ActorWorld world = new ActorWorld(indefinitGrid);
		//用自定义的边长构造一个SpiralBug
		SpiralBug bug = new SpiralBug(side);
		//将该Bug加入到World中
		world.add(new Location(x, y),bug);
		//显示图形界面
		world.show();

	}
}
