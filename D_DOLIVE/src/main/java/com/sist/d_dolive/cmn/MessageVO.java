/**
 *<pre>
 * com.sist.ehr.cmn
 * Class Name : MessageVO.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-04-22           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-04-22 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */

package com.sist.d_dolive.cmn;

/**
 * @author sist
 *
 */
public class MessageVO extends DTO {

	/**
	 * 메세지Id
	 */
	private String msgId;
	
	/**
	 * 메세지
	 */
	private String msgMsg;
	
	public MessageVO() {}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgMsg() {
		return msgMsg;
	}

	public void setMsgMsg(String msgMsg) {
		this.msgMsg = msgMsg;
	}
	
	@Override
	public String toString() {
		return "MessageVO [msgId=" + msgId + ", msgMsg=" + msgMsg + ", toString()=" + super.toString() + "]";
	}
	
}
