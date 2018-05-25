import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.util.Random;

public final class DancingBugRunner {
	public static void main(String[] args) {
		// layout size
		final int x = 4, y = 4;
		// construct world
		ActorWorld world = new ActorWorld();
		// the turn array
		int[] turn = new int[5];
		for(int i = 0; i < 5; i++) {
			Random ran = new Random();
			turn[i] = ran.nextInt(8);
		}
		// construct Dancing bug
		DancingBug bug = new DancingBug(turn);
		// add the bug to the world
		world.add(new Location(x, y),bug);
		// show world
		world.show();
	}

}
