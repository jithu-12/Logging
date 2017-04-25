package loggingfinal;

import java.sql.Date;
import java.util.UUID;

import loggingfinal.Log.LogType;

public class InputData {
	UUID tid;
	String payload;
	LogType logtype;
	UUID lsn;
	Date starttime;
	Date endtime;
}

