package pl.mesayah.lsystems;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;

import java.util.Collection;
import java.util.Stack;

public class Turtle {

    private static double angleOffset = -90.0;

    private State state;

    private double stepSize;

    private double angleIncrement;

    private Canvas canvas;

    private Stack<State> stateStack;


    public Turtle(double stepSize, double angleIncrement, Canvas canvas) {

        state = new State();
        state.x = canvas.getWidth() / 2;
        state.y = canvas.getHeight() / 2;
        state.heading = angleOffset;
        this.canvas = canvas;
        this.stepSize = stepSize;
        this.angleIncrement = angleIncrement;
        stateStack = new Stack<>();
    }

    public void resetState() {

        state.heading = angleOffset;
        state.x = canvas.getWidth() / 2;
        state.y = canvas.getHeight() / 2;
    }

    public State getState() {

        return state;
    }

    public void setState(State state) {

        this.state = state;
    }

    public double getStepSize() {

        return stepSize;
    }

    public void setStepSize(double stepSize) {

        this.stepSize = stepSize;
    }

    public double getAngleIncrement() {

        return angleIncrement;
    }

    public void setAngleIncrement(double angleIncrement) {

        this.angleIncrement = angleIncrement;
    }

    public Canvas getCanvas() {

        return canvas;
    }

    public void setCanvas(Canvas canvas) {

        this.canvas = canvas;
    }

    public Stack<State> getStateStack() {

        return stateStack;
    }

    public void setStateStack(Stack<State> stateStack) {

        this.stateStack = stateStack;
    }

    public void interprete(String string) {

        for (int i = 0; i < string.length(); i++) {

            Character character = string.charAt(i);

            if (character.toString().matches("[A-Z]")) {
                drawForward(canvas);
            } else {
                switch (string.charAt(i)) {
                    case 'f':
                        moveForward();
                        break;
                    case '+':
                        turnRight();
                        break;
                    case '-':
                        turnLeft();
                        break;
                    case '[':
                        pushState();
                        break;
                    case ']':
                        state = popState();
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
    }

    public void drawForward(Canvas canvas) {

        Point2D old = new Point2D(state.x, state.y);
        Point2D current = moveForward();

        canvas.getGraphicsContext2D().strokeLine(old.getX(), old.getY(), current.getX(), current.getY());
    }

    public Point2D moveForward() {

        state.x += stepSize * Math.cos(Math.toRadians(state.heading));
        state.y += stepSize * Math.sin(Math.toRadians(state.heading));

        return new Point2D(state.x, state.y);
    }

    public void turnLeft() {

        state.heading += angleIncrement;
    }

    public void turnRight() {

        state.heading -= angleIncrement;
    }

    public void pushState() {

        State currState = new State();
        currState.x = state.x;
        currState.y = state.y;
        currState.heading = state.heading;

        stateStack.push(currState);
    }

    public State popState() {

        return state = stateStack.pop();
    }

    class State {

        private double x;

        private double y;

        private double heading;

        public double getX() {

            return x;
        }

        public void setX(double x) {

            this.x = x;
        }

        public double getY() {

            return y;
        }

        public void setY(double y) {

            this.y = y;
        }

        public double getHeading() {

            return heading;
        }

        public void setHeading(double heading) {

            this.heading = heading;
        }
    }
}
