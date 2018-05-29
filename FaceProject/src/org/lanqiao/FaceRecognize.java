package org.lanqiao;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

//进行人脸识别的工具(基于百度AI)
public class FaceRecognize {
	//百度AI的API_ID、API_KEY、SECRET_KEY值
	public static final String API_ID = "10560341";
	public static final String API_KEY = "RcTBE8XO3O0HyBRdsG61sjdT";
	public static final String SECRET_KEY = "lCgdGUYf1zsj9Ajk6uz8HMU5AMHuxPM2";
	
	//通过调用百度AI提供的API进行人脸识别
	public static Object faceRecognize(String imgPath) { //imgPath:待检测的人脸照片
		//初始化一个AipFace,用于与百度AI应用进行连接
		AipFace client = new AipFace(API_ID, API_KEY, SECRET_KEY);
		//可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(20000);
		client.setSocketTimeoutInMillis(60000);
		//设置识别的参数
		HashMap<String,String> options = new HashMap<String,String>();
		//参数：检测的人脸个数
		options.put("max_face_num", "1");
		//参数：颜值、年龄
		options.put("face_fields", "age,beauty");
		//开始检测
		JSONObject response = client.detect(imgPath, options);
		System.out.println(response);
		return response;
	}
}
