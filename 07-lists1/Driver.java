public class Driver{
		public static void main(String[] args) {
				LList l = new LList();
				l.add("hello");
				l.add("world");
				for (int i=0;i<5;i++){
						l.add(""+i);
				}
				System.out.println(l);
		}
}
