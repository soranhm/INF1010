
public class MinException extends Exception {
	MinException(String msg, boolean exit){
		this.msg=msg;
		this.exit = exit;
	}
	private String msg;
	private boolean exit;
	
	public String getMsg(){
		return msg;
	}
	public boolean getExit(){
		return exit;
	}
	public void systemExit(){
		if(exit){
			System.out.println("Fatal error:");
			System.out.println(msg);
			System.exit(0);
		}
	}
       
}
