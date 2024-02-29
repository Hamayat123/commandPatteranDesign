package commanddesignpattern;

import java.util.ArrayList;
import java.util.List;

// Command interface
interface Command {
    void execute();
}

// Concrete command 1
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Concrete command 2
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

// Invoker
class RemoteControl {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void pressButton(int index) {
        if (index >= 0 && index < commands.size()) {
            commands.get(index).execute();
        } else {
            System.out.println("Invalid button");
        }
    }
}

// Client
public class commanddesignpattern {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.addCommand(lightOn);
        remote.addCommand(lightOff);

        remote.pressButton(0); // Turns light on
        remote.pressButton(1); // Turns light off
        remote.pressButton(2); // Invalid button
    }
}
