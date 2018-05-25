package Jumper.test;
import static org.junit.Assert.*; 
import org.junit.Test;
import info.gridworld.actor.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class JumperTest {
    public ActorWorld world = new ActorWorld();
    public Jumper jumper = new Jumper(Color.YELLOW);
    public Jumper partner = new Jumper(Color.ORANGE);
    public Rock rock = new Rock();
    public Flower flower = new Flower();
    public Bug bug = new Bug();
    /* normal move*/
    @Test
    public void testMove() {
        world.add(new Location(6, 8), jumper);
        jumper.act();
        Location loc = jumper.getLocation();
        Location destination = new Location(4, 8);
        assertEquals(loc, destination);
    }
    /* jump over an obstacle*/
    @Test
    public void testJump() {
        world.add(new Location(7, 4), jumper);
        world.add(new Location(6, 4), rock);
        jumper.act();
        int direc = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location destination = new Location(5, 4);
        assertTrue(loc.equals(destination) && direc == Location.NORTH);
    }
    /* jump to an obstacle*/
    @Test
    public void testBlockRock() {
        world.add(new Location(5, 9), jumper);
        world.add(new Location(3, 9), rock);
        jumper.act();
        int direc = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location destination = new Location(5, 9);
        assertTrue(loc.equals(destination) && direc == Location.NORTHEAST);
    }
    /* flower in the destination*/
    @Test
    public void testBlockFlower() {
        world.add(new Location(5, 3), jumper);
        world.add(new Location(3, 3), flower);
        jumper.act();
        int direc = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location destination = new Location(5, 3);
        assertTrue(loc.equals(destination) && direc == Location.NORTHEAST);
    }
    /* a bug in the destination*/
    @Test
    public void testBlockBug() {
        world.add(new Location(8, 4), jumper);
        world.add(new Location(6, 4), bug);
        jumper.act();
        int direc = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location destination = new Location(8, 4);
        assertTrue(loc.equals(destination) && direc == Location.NORTHEAST);
    }
    /* jumper meet*/
    @Test
    public void testFacingJumper1() {
        world.add(new Location(3, 5), jumper);
        partner.setDirection(Location.SOUTH);
        world.add(new Location(1, 5), partner);
        jumper.act();
        partner.act();
        int direc = jumper.getDirection();
        int direc2 = partner.getDirection();
        Location loc = jumper.getLocation();
        Location destination = partner.getLocation();
        Location locr = new Location(3, 5);
        Location locr2 = new Location(1, 5);
        assertTrue(loc.equals(locr) && direc == Location.NORTHEAST);
        assertTrue(destination.equals(locr2) && direc2 == Location.SOUTHWEST);
    }
    /* jump over another jumper*/
    @Test
    public void testFacingpartner() {
        world.add(new Location(3, 5), jumper);
        partner.setDirection(Location.SOUTH);
        world.add(new Location(2, 5), partner);
        jumper.act();
        partner.act();
        int direc = jumper.getDirection();
        int direc2 = partner.getDirection();
        Location loc = jumper.getLocation();
        Location destination = partner.getLocation();
        Location locr = new Location(1, 5);
        Location locr2 = new Location(4, 5);
        assertTrue(loc.equals(locr) && direc == Location.NORTH);        
        assertTrue(destination.equals(locr2) && direc2 == Location.SOUTH);
    }
    /* jump out of the bound*/
    @Test
    public void testOutOfGrid() {
        world.add(new Location(1, 1), jumper);
        jumper.act();
        int direc = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location destination = new Location(1, 1);
        assertTrue(loc.equals(destination) && direc == Location.NORTHEAST);
    }
    /* near the wall*/
    @Test
    public void testFacingGrid() {
        world.add(new Location(0, 3), jumper);
        jumper.act();
        int direc = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location destination = new Location(0, 3);
        assertTrue(loc.equals(destination) && direc == Location.NORTHEAST);
    }

}
