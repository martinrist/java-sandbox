package com.martinrist.thinkingInJava.innerClasses.controller;


public class GreenhouseControls extends Controller {

    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";


    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("In LightOn.action()");
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }


    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("In LightOff.action()");
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }


    public class WaterOn extends Event {

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("In WaterOn.action()");
            water = true;
        }

        @Override
        public String toString() {
            return "Water is on";
        }
    }


    public class WaterOff extends Event {

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("In WaterOff.action()");
            water = false;
        }

        @Override
        public String toString() {
            return "Water is off";
        }
    }


    public class ThermostatDay extends Event {

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("In ThermostatDayOn.action()");
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }


    public class ThermostatNight extends Event {

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("In ThermostatNight.action()");
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }


    public class Bell extends Event {

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }


    public class Restart extends Event {

        private Event[] events;

        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
            for (Event e : events) {
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e : events) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }


    public static class Terminate extends Event {

        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

}
