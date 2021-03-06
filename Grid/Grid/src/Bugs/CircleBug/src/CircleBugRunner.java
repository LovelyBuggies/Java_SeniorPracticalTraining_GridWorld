package Bugs.CircleBug.src;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public final class CircleBugRunner {
	public static void main(String[] args) {
		// magic numbers
		final int x = 4, y = 2, side = 2;
		// construct the world
		ActorWorld world = new ActorWorld();
		// construct the bug 
		CircleBug bug = new CircleBug(side);
		// add CircleBug into the world
		world.add(new Location(x, y),bug);
		// show world
		world.show();

	}
}
