package components;

import Connector.MQTTConnector;
import Utilities.Helper;
import components.autoController.MPC;
import components.controller.Controller;
import components.controller.CycleController;
import components.controller.LoopController;
import org.json.simple.JSONObject;

public class ControllingDataSender {
    private Controller controller;
    public ControllingDataSender() {
//        MPC mpc = new MPC();
//        mpc.process();
        controller = new LoopController(90194313217L);
        final MQTTConnector mqttConnector;
        mqttConnector = new MQTTConnector();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mqttConnector.connect();
        final String topic = "/iot_agriculture/controlling/"+ Helper.convertDeviceIdToFarmId(controller.getDeviceId());
        controller.setOnControlListener(new OnControlListener() {
            @Override
            public void onReceivedControllingData(Boolean status) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status",status);
                jsonObject.put("deviceId",controller.getDeviceId());
                mqttConnector.publishMessage(jsonObject.toJSONString(),topic);
            }

            @Override
            public void onReceivedControllingData(Float amountOfWater) {
                JSONObject jsonObject = new JSONObject();
                System.out.println("onReceivedControllingData with amountOfWater");
                System.out.println("amountOfWater: " + amountOfWater);
                System.out.println("timeToWater: " + amountOfWater/1F);
                System.out.println("deviceId: " + controller.getDeviceId());
                jsonObject.put("timeToWater",amountOfWater/1F);
                jsonObject.put("deviceId",controller.getDeviceId());
                // Todo: Add info to table Controlling
                mqttConnector.publishMessage(jsonObject.toJSONString(),topic);
            }
        });
        controller.start();
    }
}
