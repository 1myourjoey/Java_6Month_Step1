package ex.string;

public class StringTest1 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		
		long time1=System.currentTimeMillis();
		for (int i=0;i<100000l; i++) {
			sb.append("a");
		}
		long time2=System.currentTimeMillis();
		System.err.println("연산시간: "+(time2-time1)+" msec" );
	}

}
