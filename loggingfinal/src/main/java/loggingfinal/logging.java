package loggingfinal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import loggingfinal.Log.LogType;

//import loggingfinal.Log.Type;


 
@Path("/logging")
public class logging 
{
	Map<UUID,Log> map = new HashMap(); 
	@GET
	@Path("/beginTr")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTid()
	{
		UUID tid = java.util.UUID.randomUUID();
		//return Response.status(200).entity(output).build();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tid", tid.toString());
		return jsonObject;
	}
	
	@PUT
	@Path("/write_log")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject write_log(InputData inputdata)
	{
		
		String output = "Write logs";
		
		String result = create_log(inputdata);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", result);
		
		return jsonObject;
	}
	
	private String create_log(InputData inputdata)
	{
		Boolean isTransaction = false;
		if(inputdata != null)
		{
			if (inputdata.payload == null)
			{
				return "Payload absent";
			}
			if(inputdata.tid != null)
			{
				isTransaction = true; 
			}
			if(inputdata.logtype == null)
			{
				return "Invalid log type";
			}
			
		UUID lsn = java.util.UUID.randomUUID();
		Date date = new Date();
		Log obj1 = new Log(inputdata.tid,lsn,date,inputdata.logtype,inputdata.payload,null,null);
		map.put(lsn, obj1);
		return lsn.toString();
		}
		else
		{
			return "Invalid input";
		}
		
	}
	@DELETE
	@Path("/delete_log")
	public String delete_log()
	{
		String output = "delete logs";
		//return Response.status(200).entity(output).build();
		return output;
	}
	@PUT
	@Path("/flush_log")
	public String flush_log()
	{
		String output = "flush logs";
		//return Response.status(200).entity(output).build();
		return output;
	}
	@GET
	@Path("/query_log")
	public String query_log()
	{
		String output = "query logs";
		//return Response.status(200).entity(output).build();
		return output;
	}
}

