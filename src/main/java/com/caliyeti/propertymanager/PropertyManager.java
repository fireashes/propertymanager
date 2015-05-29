package com.caliyeti.propertymanager;

/**
 * Created by ashesdhakal on 5/29/15.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private Properties prop;
    private String pathAndFileName;

    public PropertyManager (String pathAndFileName) {
        prop = new Properties();
        this.pathAndFileName = pathAndFileName;
    }

    public String getProperty(String key) {
        FileInputStream in = null;

        String value = null;
        try {
            in = new FileInputStream(this.pathAndFileName);
            prop.load(in);
            value = prop.getProperty(key);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void updateProperty(String key, String value) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(this.pathAndFileName);
            prop.load(in);
            in.close();

            out = new FileOutputStream(this.pathAndFileName);
            prop.setProperty(key, value);
            prop.store(out, null);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setProperty (String key, String value) {
        updateProperty(key, value);
    }
}
