package com.geekster.hospitalAPI.utils;

import com.geekster.hospitalAPI.model.DoctorEntity;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CommonUtils {

    public static boolean validateName(String name){
        String regularExpression= "^[A-Za-z][A-Za-z_]{2,15}$";
        if (name.matches(regularExpression)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateCity(String city){
        String regularExpression= "^[A-Za-z][A-Za-z]{2,19}$";
        if (city.matches(regularExpression)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");

        Matcher m = p.matcher(phoneNumber);
        return (m.find() && m.group().equals(phoneNumber));
    }

    public JSONObject setJson(DoctorEntity doctor) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Doctor_id",doctor.getId());
        jsonObject.put("Doctor_name",doctor.getName());
        jsonObject.put("Phone_number",doctor.getPhoneNumber());
        jsonObject.put("Email_id",doctor.getEmail());
        jsonObject.put("Speciality",doctor.getSpeciality().getSpecialityName());
        jsonObject.put("City",doctor.getCity());
        return jsonObject;
    }

    public JSONObject validateJsonDoctor(JSONObject requestJson) {
        JSONObject errorList = new JSONObject();

        if(requestJson.has("name")) {
            if(!CommonUtils.validateName(requestJson.getString("name"))){
                errorList.put("Invalid parameter","Min 3 characters should be there in name Eg: Rahul");
            }
        } else{
            errorList.put("Missing field","name");
        }

        if(requestJson.has("email")){
            if(!CommonUtils.isValidEmail(requestJson.getString("email"))){
                errorList.put("Invalid parameter","emailId");
            }
        }else{
            errorList.put("Missing field","email");
        }

        if(requestJson.has("phone_number")){
            if (!CommonUtils.isValidPhoneNumber(requestJson.getString("phone_number"))){
                errorList.put("Invalid parameter","phone_number");
            }
        }else{
            errorList.put("Missing field","phone_number");
        }

        if(requestJson.has("city")){
            String city = requestJson.getString("city");
            if(CommonUtils.validateCity(city)) {
                if (!city.equals("Delhi") && !city.equals("Noida") && !city.equals("Faridabad")) {
                    errorList.put("Please enter from this mentioned cities", "Delhi,Noida,Faridabad");
                }
            }
            else {
                errorList.put("Invalid parameter","City name should contain 3-20 characters");
            }
        }else{
            errorList.put("Missing Field","city");
        }

        if(!requestJson.has("speciality")){
            errorList.put("Missing field","speciality");
        }

        return errorList;
    }



}
