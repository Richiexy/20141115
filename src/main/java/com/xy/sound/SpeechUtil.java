package com.xy.sound;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * @Description: 32位jdk职能调用32位dll，64位jdk职能调用64位dll
 * @author: 俞根海
 * @date： 2014-11-25 下午12:55:59
 */
public class SpeechUtil {
//	message 是需要转换的文本信息，volume是声音大小，rate是读取速度。
public void speakMessage(String message, int volume, int rate) {
	
		ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
		Dispatch sapo = sap.getObject();
		try {
			
			sap.setProperty("Volume", new Variant(volume));
			sap.setProperty("Rate", new Variant(rate));
			Dispatch.call(sapo, "Speak", new Object[]{message});

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sapo.safeRelease();
			sap.safeRelease();
		}
	}

}
