package gov.smartagro.api.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"success","total","data"})
@JsonInclude(Include.NON_NULL)
public class Response<R> extends BaseResponse {

	private ArrayList<R> data;
	private Integer total;

	public Response() {
		data = new ArrayList<>();
	}
		
	public Integer getTotal() {
		return total;		
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public ArrayList<R> getData() {
		return data;
	}
	public void setData(ArrayList<R> data) {
		this.data = data==null?new ArrayList<R>():data;
		if (data!=null)
			this.total = data.size();
		else
			this.total = 0;
	}
	
	@SuppressWarnings("unchecked")
	public void addToArrayList(Object object) {
		if(object != null)
			data.add((R) object);
		
		if (data!=null)
			this.total = data.size();
		else
			this.total = 0;
	}
}