
public class ArrayListCreator {
	 private static <T> void Print(MyArrayList<T> list){
	        System.out.println("\nSize = " + list.size() + "\nlength = " + list.getlength());
	        for(int i=0;i<list.size();i++)
	            System.out.println(list.get(i));
	    }

	    public static void main(String[] args) {
	            MyArrayList<Integer> AL=new MyArrayList<>(5);
	            Print(AL);
	            System.out.println("\nAdding 5 ints");
	            for(int i=0;i<AL.getlength();i++)
	            AL.add(i);
	            Print(AL);
	            System.out.println("\nRemoving at 3");
	            int n=AL.remove(3);
	            Print(AL);
	            System.out.println("\nNumber removed ::"+ n);
	            System.out.println("\nAdding two ints");
	            AL.add(45);
	            AL.add(AL.get(1));
	            Print(AL);
	            System.out.println("\nAdd at position 6");
	            AL.add(6,new Integer(100));
	            Print(AL);
	            System.out.println("\nDeliberate error add at position 12");
	            AL.add(12, new Integer(99));
	    }  
}
