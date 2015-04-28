package com.opr.utils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Test {

	String writeToJson() {
		
		//{"CALLS":[],"SMS":[{"content":"Your birthdate says a lot about you. Want to know what? Try it now. SMS DOB with your birthday and send it to 56060. Eg: DOB 13 Jan. Rs.3\/sms","id":"1","number":"VL-611111","time":"12:49:09","type":"incoming_messages","date":"07-08-2014","status":"pending"}]}
		
		
		
		JSONObject parentObj = new JSONObject();
		JSONArray smsList = new JSONArray();

		// -------------Set Values to json--------------
		//for (int i = 0; i < 3; i++) {

			JSONObject smsobj = new JSONObject();
			smsobj.put("content", "Your birthdate says a lot about you.");
			smsobj.put("id", "1");
			smsobj.put("number","VL-611111");
			smsobj.put("time","12:49:09");
			smsobj.put("type","incoming_messages");
			smsobj.put("date","07-08-2014");
			smsobj.put("status","pending");
			smsList.add(smsobj);
			
			JSONObject smsobj1 = new JSONObject();
			smsobj1.put("content", "Your birthdate says a lot about you.");
			smsobj1.put("id", "1");
			smsobj1.put("number","VL-611111");
			smsobj1.put("time","12:49:09");
			smsobj1.put("type","incoming_messages");
			smsobj1.put("date","07-08-2014");
			smsobj1.put("status","pending");
			smsList.add(smsobj);

		
	//	}
		parentObj.put("SMS", smsList);
		return parentObj.toJSONString();
	}

        
        
	public static void main(String[] args) {
		System.out.println();
	}
}
