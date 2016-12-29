package com.packtpublishing.tddjava.ch04ship;

public class Ship {

    private final Location location;
    private final Planet planet;

    public Ship(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
    }

    public boolean moveForward() {
        return location.forward(planet.getMax(), planet.getObstacles());
    }

    public boolean moveBackward() {
        return location.backward(planet.getMax(), planet.getObstacles());
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public String receiveCommands(String commands) {
        StringBuilder returnMessage = new StringBuilder();
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'f':
                    returnMessage(moveForward(), returnMessage);
                    break;
                case 'b':
                    returnMessage(moveBackward(), returnMessage);
                    break;
                case 'l':
                    turnLeft();
                    break;
                case 'r':
                    turnRight();
                    break;
            }
        }
        return returnMessage.toString();
    }

    private void returnMessage(final boolean success, final StringBuilder returnMessage) {
        if(success) returnMessage.append("O");
        else returnMessage.append("X");
    }

    public Location getLocation() {
        return location;
    }

    public Planet getPlanet() {
        return planet;
    }
}
