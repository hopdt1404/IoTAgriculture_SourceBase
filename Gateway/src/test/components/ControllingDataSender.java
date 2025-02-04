package test.components;

import Connector.MQTTConnector;
import utilites.Helper;
import test.components.controller.Controller;
import test.components.controller.LoopController;
import org.json.simple.JSONObject;

public class ControllingDataSender implements Runnable{
    private Controller controller;
    public ControllingDataSender() {
        controller = new LoopController(1685555620347905L);
        final MQTTConnector mqttConnector;
        mqttConnector = new MQTTConnector();
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
                jsonObject.put("timeToWater",amountOfWater/0.75F);
                jsonObject.put("deviceId",controller.getDeviceId());
                mqttConnector.publishMessage(jsonObject.toJSONString(),topic);
            }
        });

    }

    @Override
    public void run() {
        controller.start();
    }
}
