package utilites;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Helper {
    public static float ConvertByteToFloat(byte[] b) {
        ByteBuffer bb = ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN);
        return bb.getFloat();
    }
    public static byte[] floatToByteArray(float value) {
        int intBits =  Float.floatToIntBits(value);
        return new byte[] {
                (byte) (intBits >> 24), (byte) (intBits >> 16), (byte) (intBits >> 8), (byte) (intBits) };
    }
    public static int ConvertByteToInt(byte[] b)
    {
        int value= 0;
        for(int i=0;i<b.length;i++){
            int n=(b[i]<0?(int)b[i]+256:(int)b[i])<<(8*i);
            value+=n;
        }
        return value;
    }
    public static JSONObject mqttMessageToJsonObject(MqttMessage mqttMessage){
        JSONObject jsonObject = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        try {
            jsonObject = (JSONObject) jsonParser.parse(mqttMessage.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    public static boolean deleteFile(String pathname){
        try {
            File file = new File(pathname);
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Long convertLocalIdDeviceToGlobalIdDevice(Integer localIdDevice, Integer FarmId){
        return ((localIdDevice|0x0L)<<32) | FarmId;
    }
    public static Integer convertGlobalIdDeviceToLocalIdDevice(Long globalIdDevice){
        return Long.valueOf(globalIdDevice>>32).intValue();
    }
    public static void printShorts(Short[] a, int length){
        System.out.println("array:");
        for(int i = 0;i<length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static Integer convertDeviceIdToFarmId(Long deviceId){
        return (int)(deviceId&0x00000000FFFFFFFF);
    }
}
