package cn.yesomething.domain;

public class UrlGenerator {
    private static final long RANGE = 4294967296L;  //范围在[0,4294967295]
    private static long randomNumber;
    public static String generateUrl(String Operation,long sdkAppId,String userSig){
        randomNumber = (int)(Math.random() * RANGE);
        String result;
        result = "https://console.tim.qq.com/"
                + Operation
                + "?sdkappid="
                + Long.toString(sdkAppId)
                + "&identifier=administrator&usersig="
                + userSig
                + "&random="
                + Long.toString(randomNumber)
                + "&contenttype=json";
        return result;
    }
}
