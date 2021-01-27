package helpers;



import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public abstract class HelperAppiumService {

    
    

    public static AppiumDriverLocalService configAppiumService(String appiumMainjsPath, String nodeExePath){
        return  AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExePath))
                        .withAppiumJS(new File(appiumMainjsPath))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File(System.getProperty("user.dir") + "/src/test/resources/logs/Appium.log")));
    }


    public static AppiumDriverLocalService appiumServiceInitialize(){
        String appiumMainjsPath;
        String nodeExePath;
        String os = System.getProperty("os.name").toUpperCase();
        if(os.contains("MAC")){
            appiumMainjsPath = "/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js";
            nodeExePath = "/usr/local/bin/node";
        }else if(os.contains("NIX") || os.contains("AIX") || os.contains("NUX")){
            appiumMainjsPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
            nodeExePath = "/usr/local/bin/node";
        }else {
            appiumMainjsPath = System.getProperty("user.home")+"\\node_modules\\appium\\build\\lib\\main.js";
            nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
        }
        
        return configAppiumService(appiumMainjsPath,nodeExePath);
    }
    
   
}
