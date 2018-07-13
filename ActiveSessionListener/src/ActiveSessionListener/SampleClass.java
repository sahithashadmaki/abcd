package ActiveSessionListener;

public class SampleClass {
	 private String username;
     private String id;
	private String date;
	private static int requests;
	private static int ErrorCount;
	
     public String getUserName() {
        return username;
	}

     public void setUserName(String newUserName) {
        username = newUserName;
	}

	/*public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
*/
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getErrorCount() {
		return ErrorCount;
	}

	public void setErrorCount(int errorCount) {
		ErrorCount = errorCount;
	}

	public int getRequests() {
		System.out.println("In getrequests method");
		return requests;
	}

	public void setRequests(int requests) {
		this.requests = requests;
	}
	public void increaseRequests(){
		
		requests++;
		
	//	setRequests(requests);
		System.out.println("In increaserequests method (requests)"+requests);
	}

public void increaseErrors(){
		
		
		ErrorCount++;
		System.out.println("In increaseErrors method(Errors)"+ErrorCount);
		
	}
}
