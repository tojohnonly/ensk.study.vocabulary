package com.ensk.study.vocabulary.config;

import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EsvConfig {

    public static Properties properties = getProperties();


    public static String dbPath = getDbPath();

    // Color
    public static Color bgColor = getBgColor();
    public static Color buttonBgColor = getButtonBgColor();
    public static Color buttonHoverColor = getButtonHoverColor();

    // Font
    public static Font buttonFont = new Font("Microsoft YaHei UI", Font.PLAIN, 15);
    public static Font wordFont = new Font("Microsoft YaHei UI", Font.PLAIN, 25);
    public static Font pronounceFont = new Font(Font.SERIF, Font.PLAIN, 17);
    public static Font translationFont = new Font("霞鹜文楷", Font.PLAIN, 19);
    public static Font exampleFont = new Font("霞鹜文楷", Font.PLAIN, 15);

    private static Properties getProperties() {
        String currentDir = System.getProperty("user.dir");
        String configFilePath = currentDir + "/esv.conf";
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(configFilePath);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static String getDbPath() {
        return properties.getProperty("db.path");
    }

    private static Color getBgColor() {
        Integer red = Integer.valueOf(properties.getProperty("bg.color.red"));
        Integer green = Integer.valueOf(properties.getProperty("bg.color.green"));
        Integer blue = Integer.valueOf(properties.getProperty("bg.color.blue"));
        return new Color(red, green, blue);
    }

    private static Color getButtonBgColor() {
        Integer red = Integer.valueOf(properties.getProperty("button.bg.color.red"));
        Integer green = Integer.valueOf(properties.getProperty("button.bg.color.green"));
        Integer blue = Integer.valueOf(properties.getProperty("button.bg.color.blue"));
        return new Color(red, green, blue);
    }

    private static Color getButtonHoverColor() {
        Integer red = Integer.valueOf(properties.getProperty("button.hover.color.red"));
        Integer green = Integer.valueOf(properties.getProperty("button.hover.color.green"));
        Integer blue = Integer.valueOf(properties.getProperty("button.hover.color.blue"));
        return new Color(red, green, blue);
    }











}
