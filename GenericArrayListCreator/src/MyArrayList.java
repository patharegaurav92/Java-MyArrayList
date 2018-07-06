import java.util.Arrays;
/**
 *
 * @author gauravpathare
 * @param <T>
 */
public class MyArrayList<T> {  
    private T []array;
    private int length=0; //Length Of Array
    private int size=0;  //Number of Elements in array  
    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialSize) {
       this.length=initialSize;
       if(initialSize>0) {
            array = (T[])new Object[initialSize];
        }       
        else {
            throw new IllegalArgumentException("Array Size Must be greater than zero \nInitial Size::"+initialSize);
        }
    }
    
    public int size() {
        return size; //Return number of elements in array
    }
    
    public int getlength() {
        return length;
    }
    
    public boolean isEmpty() {
            if(size==0) {
                return false;
            }       
        return true;      
    }
    
    public void add(int index,T element) {
        rangeCheckForAdd(index);   
        if(index==size){
            grow(size);
            array[index] = element;
        }
        else {
            grow(size);
            for(int i=size;i>index;i--) {
                array[i]=array[i-1];
            }
            array[index]=element;
        }
        size++; 
    }
    
    private void rangeCheckForAdd(int index) {
        if((index>size)||(index<0)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    public boolean add(T element) {
        grow(size);
        array[size] = element;
        size++;
        return true;
    }
    
    public void grow(int minCap) {
        if(minCap>length-1) {
            length=(int) ((1.5 * length) +1);
            array = Arrays.copyOf(array, length);
        }
        else if(size<minCap) {
            size=minCap;
        }
    }

    public T get(int index) {
        rangeCheck(index);
        T element=elementData(index);
        return element;
    }

    private void rangeCheck(int index) {
        if(index>size-1) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private T elementData(int index) {
        return array[index];
    }
    
    public T set(int index, T element) {
        if(index<length-1) {
            T currentVal=get(index);
            array[index] = element;
            return currentVal;
        }
        else {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    private String outOfBoundsMsg(int index) {
       String msg="";
       msg= "INDEX :: "+index+" Size :: "+size;
       return msg;
    }
    
    public T remove(int index) {
        if(index<size) {
            T currentvalue=array[index];
            for(int i=index;i<size-1;i++) {
                array[i] = array[i+1];
            }
            array[size-1]=null;
            size--;
            return currentvalue;
        }
        else {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        
    }
}

