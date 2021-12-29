package components.controller;

public class LoopController extends Controller {
    public int timeLoop;
    Float amountOfWater;
    public LoopController(long deviceId, int timeLoop) {
        super(deviceId);
        this.timeLoop = timeLoop;
    }

    public LoopController(long deviceId) {
        super(deviceId);
        this.timeLoop = 60000;
    }

    protected void setAmountOfWater(Float amountOfWater){
        this.amountOfWater=amountOfWater;
        onControlListener.onReceivedControllingData(amountOfWater);
    }
    public void start(){
        Boolean currentStatus = false;
        while(true) {
            try {
                Thread.sleep(timeLoop);
//                System.out.println("Using Loop controller");
                float waterIdle = 1.5F;
                float resultWater = getResultWater(waterIdle);
                setAmountOfWater(resultWater);
//                setAmountOfWater(2F);
                //currentStatus = !currentStatus;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public Float getResultWater(Float waterIdle) {
        Float range = 0.3F;
        int attainableAccuracy = 2;
        Float max = waterIdle + range;
        Float min = waterIdle - range;
        Float result = (float) ((Math.random() * (max - min)) + min);
        Double scale = Math.pow(10, attainableAccuracy);
        Double resultRound = (Math.round(result * scale) / scale);
        return resultRound.floatValue();
    }
}
