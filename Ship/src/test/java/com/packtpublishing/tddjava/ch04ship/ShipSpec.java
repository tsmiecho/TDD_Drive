package com.packtpublishing.tddjava.ch04ship;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

@Test
public class ShipSpec {

    private Ship ship;
    private Location location;
    private Planet planet;

    @BeforeMethod
    public void beforeTest() {
        location = new Location(new Point(21, 13), Direction.NORTH);
        planet = new Planet(new Point(50, 50), new ArrayList<>());
        ship = new Ship(location, planet);
    }

    public void whenInitializationThenLocationIsSet() throws Exception {
        Assert.assertEquals(ship.getLocation(), location);
    }

    public void whenMoveForwardThenForward() throws Exception {
        final Location expected = this.location.copy();
        expected.forward();
        ship.moveForward();
        Assert.assertEquals(ship.getLocation(), expected);
    }

    public void whenMoveBackwardThenBackward() throws Exception {
        final Location expected = this.location.copy();
        expected.backward();
        ship.moveBackward();
        Assert.assertEquals(ship.getLocation(), expected);
    }

    public void whenTurnLeftThenLeft() throws Exception {
        final Location expected = this.location.copy();
        expected.turnLeft();
        ship.turnLeft();
        Assert.assertEquals(ship.getLocation(), expected);
    }

    public void whenTurnRightThenRight() throws Exception {
        final Location expected = this.location.copy();
        expected.turnRight();
        ship.turnRight();
        Assert.assertEquals(ship.getLocation(), expected);
    }

    public void whenReceiveCommandFThenForward() throws Exception {
        final Location expected = this.location.copy();
        expected.forward();
        ship.receiveCommands("f");
        Assert.assertEquals(ship.getLocation(), expected);
    }

    public void whenReceiveAllCommandsThenAllAreExecuted() throws Exception {
        final Location expected = this.location.copy();
        expected.turnLeft();
        expected.turnRight();
        expected.forward();
        expected.backward();
        ship.receiveCommands("lrfb");
        Assert.assertEquals(ship.getLocation(), expected);
    }

    public void whenInitializationThenPlanetIsSet() throws Exception {
        Assert.assertEquals(ship.getPlanet(), planet);
    }

    public void givenEasternDirectionWhenOverpassEastBoundaryThenMoveToWesternSideOfPlanet() throws Exception {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(planet.getMax().getX());
        ship.receiveCommands("f");
        Assert.assertEquals(ship.getLocation().getX(), 1);
    }

    public void givenWesternDirectionWhenOverpassWestBoundaryThenMoveToEasternSideOfPlanet() throws Exception {
        location.setDirection(Direction.WEST);
        location.getPoint().setX(1);
        ship.receiveCommands("f");
        Assert.assertEquals(ship.getLocation().getX(), planet.getMax().getX());
    }

    public void givenDirectionEAndXEquals1WhenReceiveCommandsBThenWrap() throws Exception {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(1);
        ship.receiveCommands("b");
        Assert.assertEquals(location.getX(), planet.getMax().getX());
    }

    public void whenMoveWithObsticlesThenReceiveErrorMessage() throws Exception {
        planet.setObstacles(Collections.singletonList(new Point(21, 12)));
        Assert.assertEquals(ship.receiveCommands("f"), "X");
    }
}
