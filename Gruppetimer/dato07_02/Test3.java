
public class Test {
	public static void main(String[] args){
		try{
			metode(-1);
		} catch(MinException e){
			System.out.println(e.getMsg());
			e.systemExit();
		}
		System.out.println("det gikk");
	}
	private static void metode(int i) throws MinException {
		if(i<0) throw new MinException("I mindre enn null",true);
	}

}
