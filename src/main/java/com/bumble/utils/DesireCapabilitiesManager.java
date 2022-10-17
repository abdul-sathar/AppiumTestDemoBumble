package com.bumble.utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.util.HashMap;

public class DesireCapabilitiesManager {

    /**
     * This method parse the json file
     *
     * @param jsonLocation path of json file
     * @return json data in array
     *
     * @developer: Abdul Sathar Beigh
     */
    private static JSONArray parseJSON(String jsonLocation) throws Exception {
        JSONParser jsonParser = new JSONParser();
        return (JSONArray) jsonParser.parse(new FileReader(jsonLocation));
    }

    /**
     * This method fetch all the desired capabilities from json file based on capability name
     *
     * @param  capabilityName name of capability which is set in capabilities.json i.e "name"
     * @param jsonLocation path of json file
     * @return json object
     *
     * @developer: Abdul Sathar Beigh
     */
    private static JSONObject getCapability(String capabilityName, String jsonLocation) throws Exception {
        JSONArray capabilitiesArray = parseJSON(jsonLocation);
        for (Object jsonObj : capabilitiesArray) {
            JSONObject capability = (JSONObject) jsonObj;
            if (capability.get("name").toString().equalsIgnoreCase(capabilityName)) {
                JSONObject caps=(JSONObject) capability.get("caps");
                String appPath= (String) caps.get("app");
                caps.replace("app",appPath,System.getProperty("user.dir")+appPath);
                return caps;
            }
        }
        return null;
    }

    /**
     * This method convert all the desired capabilities from json file to key value pair using HashMap
     *
     * @param  capabilityName name of capability which is set in capabilities.json i.e "name"
     * @param jsonLocation path of json file
     * @return json object
     *
     * @developer: Abdul Sathar Beigh
     */
    private static HashMap<String, Object> convertCapsToHashMap(String capabilityName, String jsonLocation) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(getCapability(capabilityName, jsonLocation).toString(), HashMap.class);
    }

    /**
     * This method fetch all the desired capabilities from json file based on capability name
     *
     * @param  capabilityName name of capability which is set in capabilities.json i.e "name"
     * @param capsContentRootLocation relative path of json file
     * @return DesiredCapabilities
     *
     * @developer: Abdul Sathar Beigh
     */
    public static DesiredCapabilities getDesiredCapabilities(String capabilityName, String capsContentRootLocation) throws Exception {
        String jsonLocation = System.getProperty("user.dir") + "/" + capsContentRootLocation;
        HashMap<String, Object> caps = convertCapsToHashMap(capabilityName, jsonLocation);
        return new DesiredCapabilities(caps);
    }
}

