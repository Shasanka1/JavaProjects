import java.util.*;

public class RollableWithStringTester {

	public static void main(String[] args) {
		RollableWithStringTester rwst = new RollableWithStringTester();
		Rollable rand = new Die(30);
		String s = rwst.getRolls(rand,10 );
		System.out.println(s);
//		rwst.testFindComma();
//		rwst.testNextInt();
		rwst.testInARow();
		//rwst.testLongestRuns();
	}

	private String getRolls(Rollable rand, int i) {
		String s = "";
		s+=rand.toss();
		for(int e = 0; e < i-1;e++){
			int g = rand.toss();
			s+= ',';
			s+= Integer.toString(g);
		}



		return s;
	}

	private int nextInt(String s, int i) {

		if(s.substring(i, i+1).equals(",")){
			return -1;
		}

		String str = s.substring(i, findComma(s,i));
		return Integer.parseInt(str);

	}

	private int inARow(String s, int i) {

		//		int count =0;
		//		
		//		ArrayList<String> letters = new ArrayList<String>();
		//		for(int z = s.length()-1; z>i;z--){
		//			if(!(s.substring(i, i+1).equals(","))){
		//				letters.add(0,s.substring(i, i+1));
		//			}
		//		}
		//		
		//		for(int g = 0; g<letters.size();g++)
		//		{
		//			if(letters.get(g).equals(letters.get(g+1))){
		//				count++;
		//			}
		//			else{
		//				retu
		//			}
		//		}
		//		
		//		return count;







//				int counter=1;
//				for(int z = i; z< s.length()-1;z++){
//					if(s.substring(i+1, i+2).equals(",")){
//						if(s.substring(i+2,i+3).equals(s.substring(i, i+1))){
//							counter++;
//						}
//					}
//					else if(s.substring(i, i+1).equals(s.substring(i+1, i+2))){
//						counter++;
//					}
//				else{
//					return counter;
//				}
//					
//				}
//				
//				if(s.substring(i, i+1).equals(",")){
//					return counter;
//				}
//				return counter;
		
		int counter = 1;
		if(nextInt(s,i)==-1){
			return 0;

		}
		int c = findComma(s,i);
		for(int g = i; g<s.length();g++){
			if(c==i+1){
				if(s.substring(c, c+1).equals(s.substring(i+1, i+2))){
					counter=+1;
				}
			}
			if(s.substring(i, i+1).equals(s.substring(g, g+1))){
				counter=+1;
			}
			else{
				break;
			}
		}
		return counter;

	}

	private List<Integer> longestRuns(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	private int findComma(String s, int i) {
		if(i<=s.length()) {
			int x = s.substring(i).indexOf(",");
			if(x>-1)
				return x+i;
		}
		return -1;
	}

	private void testLongestRuns() {
		String s = "3,12,136,6,6,29,3,47,47,47,12";
		List<Integer> list  = longestRuns(s);
		System.out.println("longestRuns(s) "+list);
		list  = longestRuns(s.substring(7));
		System.out.println("longestRuns(s.substring(7)) "+list);
		list  = longestRuns(s.substring(13,20));
		System.out.println("longestRuns(s.substring(13,20)) "+list);

	}


	private void testInARow() {
		String s = "12,12,12,6,6,29,3,47,47,47,12";
		int n = inARow(s,0);
		System.out.println("inARow(s,0) "+n);
		n =inARow(s,1);
		System.out.println("inARow(s,1); "+n);
		n =inARow(s,9);
		System.out.println("inARow(s,9); "+n);
		n =inARow(s,7);
		System.out.println("inARow(s,7); "+n);
		n =inARow(s,10);
		System.out.println("inARow(s,10); "+n);
	}


	private void testNextInt() {
		String s = "3,12,136,6,6,29,3,47,47,47,12";
		int n = nextInt(s,0);
		System.out.println("nextInt(s,0) "+n);
		n =nextInt(s,1);
		System.out.println("nextInt(s,1); "+n);
		n =nextInt(s,5);
		System.out.println("nextInt(s,5); "+n);
		n =nextInt(s,6);
		System.out.println("nextInt(s,6); "+n);
		n =nextInt(s,21);
		System.out.println("nextInt(s,21); "+n);
	}
	private void testFindComma() {
		String s = "3,12,136,6,6,29,3,47,47,47,12";
		int n = findComma(s,0);
		System.out.println("findComma(s,0) "+n);
		n =findComma(s,3);
		System.out.println("findComma(s,3); "+n);
		n =findComma(s,4);
		System.out.println("findComma(s,4); "+n);
		n =findComma(s,27);
		System.out.println("findComma(s,27); "+n);
	}
}
interface Rollable{
	int toss();
}
class Die implements Rollable{
	int sides;
	public Die(int i) {
		sides = i;
	}
	@Override
	public int toss() {
		return (int) (Math.random()*sides);
	}
}
