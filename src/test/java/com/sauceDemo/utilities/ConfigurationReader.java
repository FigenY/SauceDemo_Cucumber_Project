package com.sauceDemo.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

     static {

        try {
            //properties nesnesinin içini hangi bilgilerle dolduracağım
            String path = "configuration.properties";
            //dosyayı Javaya okut... pathi kullanarak
            FileInputStream input = new FileInputStream(path);
            //properties objem üzerine data depolayabilir...key value sistemini kullanır
            properties = new Properties();
            //properties objeme javaya okuttuğum dosyayı yüklüyorum
            properties.load(input);
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String get (String keyName){
       return properties.getProperty(keyName);
    }
}
