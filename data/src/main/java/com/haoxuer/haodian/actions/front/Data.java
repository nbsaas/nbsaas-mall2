package com.haoxuer.haodian.actions.front;

import java.io.Serializable;

public class Data implements Serializable {
	private static final long serialVersionUID = -1491499610244557029L;
	public static int CODE_SUCCESS = 0;
	public static int CODE_FAILURED = -1;
	public static String[] NOOP = new String[0];
	private int code;
	private String message;
	private Object data;

	private Data(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static final Data success(Object data) {
		return new Data(CODE_SUCCESS, "操作成功", data);
	}

	/**
	 * @deprecated
	 */
	public static final Data success(String message) {
		return new Data(CODE_SUCCESS, message, NOOP);
	}

	public static final Data success(String message, Object data) {
		return new Data(CODE_SUCCESS, message, data);
	}

	public static final Data failure(int code, String message) {
		return new Data(code, message, NOOP);
	}

	public static final Data failure(String message) {
		return failure(CODE_FAILURED, message);
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String toString() {
		return "{code:\"" + this.code + "\", message:\"" + this.message
				+ "\", data:\"" + this.data.toString() + "\"}";
	}
}