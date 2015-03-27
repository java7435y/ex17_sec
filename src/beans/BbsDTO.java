package beans;

import java.io.Serializable;

public class BbsDTO implements Serializable{
	private String updDate;
	private String usrid;
	private String msg;

	public String getUpdDate() {
		return updDate;
	}
	public void setUpdDate(String updDate) {
		StringBuffer ymd = new StringBuffer(updDate.substring(0, 4));
		ymd.append("年");
		ymd.append(updDate.substring(4, 6));
		ymd.append("月");
		ymd.append(updDate.substring(6, 8));
		ymd.append("日");
		ymd.append(updDate.substring(8, 10));
		ymd.append("時");
		ymd.append(updDate.substring(10, 12));
		ymd.append("分");
		this.updDate = ymd.toString();
	}

	public String getUsrid() {
		return usrid;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
