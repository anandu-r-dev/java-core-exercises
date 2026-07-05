abstract class BaseMachine {
    protected String machineId;

    public BaseMachine(String machineId) {
        this.machineId = machineId;
    }

    public void activatePower() {
        System.out.println("Machine [" + machineId + "]: Internal power relays closed. Diagnostic check clear.");
    }

    public abstract void processJob();
}

class RobotArm extends BaseMachine {
    private final int axisCount;

    public RobotArm(String machineId, int axisCount) {
        super(machineId);
        this.axisCount = axisCount;
    }

    @Override
    public void processJob() {
        System.out.println("RobotArm [" + machineId + "]: Articulating " + axisCount + "-axis precision welding matrix.");
    }
}

public class FactoryAutomationWorkspace {

    public static void main(String[] args) {
        System.out.println("Initializing Factory Component Assembly Line...");
        System.out.println("-------------------------------------------------------");

        BaseMachine activeDevice = new RobotArm("ROBOT-ARM-X3", 6);

        activeDevice.activatePower();

        activeDevice.processJob();

        System.out.println("-------------------------------------------------------");
    }
}