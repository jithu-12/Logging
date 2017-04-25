package loggingfinal;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Log {
	UUID tid;
	UUID lsn;
	Date time_stamp;
	public enum LogType {EVENT,DATABASE,POLICY,DEVICE};//change
	LogType type;
	String payload;
	Log prev;
	Log next;
	
	
	 public Log(UUID tid, UUID lsn, Date time_stamp, LogType type, String payload, Log prev, Log next) {
		super();
		this.tid = tid;
		this.lsn = lsn;
		this.time_stamp = time_stamp;
		this.type = type;
		this.payload = payload;
		this.prev = prev;
		this.next = next;
	}

	public UUID getTid() {
		return tid;
	}

	public void setTid(UUID tid) {
		this.tid = tid;
	}

	public UUID getLsn() {
		return lsn;
	}

	public void setLsn(UUID lsn) {
		this.lsn = lsn;
	}

	public Date getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}

	public LogType getType() {
		return type;
	}

	public void setType(LogType type) {
		this.type = type;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public Log getPrev() {
		return prev;
	}

	public void setPrev(Log prev) {
		this.prev = prev;
	}

	public Log getNext() {
		return next;
	}

	public void setNext(Log next) {
		this.next = next;
	}

}
