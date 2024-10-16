import java.util.Scanner;

public class Fan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BuildFan fan1 = new BuildFan(3,true,"yellow",10);
        BuildFan fan2 = new BuildFan(2,false,"blue",5);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
    public static class BuildFan {
        private final int SLOW = 1;
        private final int MEDIUM = 2;
        private final int FAST = 3;
        private int speed = 1;
        private boolean on = false;
        private String color = "blue";
        private double radius = 5;

        public int getSLOW() {
            return SLOW;
        }
        public int getMEDIUM() {
            return MEDIUM;
        }
        public int getFAST() {
            return FAST;
        }
        public int getSpeed() {
            return speed;
        }
        public void setSpeed(int speed) {
            this.speed = speed;
        }
        public boolean isOn() {
            return on;
        }
        public void setOn(boolean on) {
            this.on = on;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public double getRadius() {
            return radius;
        }
        public void setRadius(double radius) {
            this.radius = radius;
        }

        public BuildFan() {

        }

        public BuildFan(int speed,boolean on,String color,double radius) {
            this.speed = speed;
            this.on = on;
            this.color = color;
            this.radius = radius;
        }
        @Override
        public String toString() {
            String state = "";
            if (this.isOn()) {
                state += ("Fan is on\n");
                state += ("Speed: " + this.speed + "\n");
            }else {
                state += ("Fan is off\n");
            }
            state += ("Color: " + this.color + "\n");
            state += ("Radius: " + this.radius + "\n");
            return state;
        }

    }
}
