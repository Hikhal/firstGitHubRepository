import java.util.*;
public class DListSentinel<E> implements List<E> {
    private static class DListNode<E> {
        public E data;
        public DListNode<E> next;
        public DListNode<E> previous; 
    }


    private DListNode<E> nil;
    private int size = 0;

    //Constructor initializing the sentinel node nil.
    public DListSentinel(){
        nil = new DListNode<E>();
        nil.previous = nil; // tail of the list
        nil.next = nil; // head of the list
        nil.data = null;
        size = 0;
    }

    /* Adds the element to the front of the list. The method checks whether the list is empty or not.
    If the list is empty then both the head and the tail of the list is the set to be the new element.
    */
    public void addFirst(E value){
        DListNode<E> x = new DListNode<E>();
        x.data = value;
        if(size == 0){
            nil.next = nil.previous = x; 
        }  
        else{
            x.next = nil.next;
            x.previous = nil;
            nil.next.previous = x;
            nil.next = x;
        }
        size++;
           
    }

    /* Adds the element to the end of the list. The method checks whether the list is empty or not.
    If the list is empty then both the head and the tail of the list is the set to be the new element.
    */
    public void addLast(E value){
        DListNode<E> x = new DListNode<E>();
        x.data = value;

        if(size == 0){
            nil.next = nil.previous = x; 
        }  
        else{
            nil.previous.next = x;
            x.previous = nil.previous;
            nil.previous = x;
            x.next = nil;
        }
        size++;
    }
     
    //Returns the data stored in the head of the list as the head points to the first element.
    public E getFirst(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        return nil.next.data;
    }

    public E getLast(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        return nil.previous.data;
    }

    public E removeFirst(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        if(size == 1){
            nil.next = nil.previous = nil;
        }
        E data = getFirst();
        nil.next = nil.next.next;
        nil.next.previous = nil;
        size--;
        return data;
    }

    public E removeLast(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        if(size == 1){
            nil.next = nil.previous = nil;
        }
        E data = getLast();
        nil.previous  = nil.previous.previous;
        nil.previous.next = nil;
        size--;
        return data;
    }

    public E get(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        DListNode<E> temp = nil.next; //setting temp equal to the head of the linkedlist.
        int count = 0;

        while(count < index){
            count++;
            temp = temp.next;
        }

        return temp.data;
    }

    public E set(int index, E value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        DListNode<E> temp = nil.next; 
        int count = 0;

        while(count < index){
            count++;
            temp = temp.next;
        }
        E data = temp.data;
        temp.data = value;
        return data;
    }

    //Returns true only if the indexOf(Object obj) does not return -1.
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }


    //This method returns the count (The number of steps taken) to find a particular element in the list by using a temporary pointer and returns -1 if the element is not in the list.
    public int indexOf(Object obj){
        int count = 0;
        DListNode<E> temp = nil.next;
        while(temp!= nil){
           if(temp.data.equals(obj)){
                return count;
           }
           count++;
           temp = temp.next;
        }
        return -1;
    }

    public int size(){
        return size;
    }


    //toString method checks the size as well to avoid an null pointer exception also prints a standard message of the list being empty to inform the user.
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Iterator<E> it= this.iterator();
        if(size == 1){
            sb.append(it.next());
        }else if(size == 0){
            sb.append( "The List Is Empty");
        }
        else{
            while (it.hasNext()){
                sb.append(it.next()+" ");
            }
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
       return new DListIterator();  
    }

    private class DListIterator implements Iterator<E> {
        private DListNode<E> pointer = nil.next;

        public DListIterator(){
            if(nil.next ==nil){
                pointer = nil;
            }
            else{
                pointer = nil;
            }
        }
        
        @Override
        public boolean hasNext() {
            return pointer.next!=nil;
        }

        @Override
        public E next() {
            pointer=pointer.next;
            return pointer.data; 

        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(int index, E element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }




    public static void main(String [] args){
        DListSentinel<String> list = new DListSentinel<>();
        DListSentinel<String> list1 = new DListSentinel<>();

        //Testing the addFirst/addLast methods.
        list.addFirst("c");
        list.addFirst("b");
        list.addFirst("a");
        list.addLast("d");
        list.addLast("e");

        list1.addFirst("c");
        list1.addFirst("b");
        list1.addFirst("a");
        list1.addLast("d");
        list1.addLast("e");

        System.out.println(list1.toString());
        System.out.println(list.toString());
        System.out.println();

        //testing the set method.
        list.set(0,"x");
        list.set(1, "y");
        list.set(2, "z");

        System.out.println("list after changing values with the set method: " + list.toString());
        System.out.println();
        
        //testing the get method.
        System.out.println(list1.get(0)); // should print a
        System.out.println(list1.get(1)); // should print b
        System.out.println();

        //testing the removeFirst and removeLast methods
        list.removeFirst();
        list.removeLast();
        System.out.println("updated list: " + list);

        System.out.println();

        list1.removeFirst();
        list1.removeLast();
        System.out.println("updated list1: " + list1);

        System.out.println(list1.contains("c")); // should print true
        System.out.println(list.contains("w")); //should print false

        //Testing the iterator.
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        // creating a list with size of 1, to test the conditions of the removeLast and removeFirst methods.
        DListSentinel<String> x = new DListSentinel<>();
        x.addFirst("y");
        //x.addFirst("z");
        System.out.println(x.toString());

        x.removeFirst();
        System.out.println(x.toString());
    }
}
