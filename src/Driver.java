/**
 * DoubleOrderedList testing area.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
public class Driver {
    public static void main(String [] args) {
        DoubleOrderedList list = new DoubleOrderedList<>();
        //RA: These are _extremely_ simple tests - do not use them when doing
        //    your writeup.
        
        list.add(23);
        list.add(24);	
        list.add(16);
        list.add(3);	
        list.add(7);
        list.add(17);	
        list.add(9);	
        list.add(13);	
        list.add(14);	
        list.add(1);

        System.out.println(list);
        
        System.out.println(list.remove(7));
        System.out.println(list);
        System.out.println(list.removeFirst());
        System.out.println(list);
        System.out.println(list.remove(17));
        System.out.println(list);
        System.out.println(list.removeLast());
        System.out.println(list);
        System.out.println(list.remove(14));
        System.out.println(list);
        System.out.println( list.removeLast());
        System.out.println(list);
        
        System.out.println(list);
        
        
        /* Test Results:
            1 3 7 9 13 14 16 17 23 24 
            3 9 13 16 
        */
        
        // My Tests
        
        System.out.println("My tests:" );
        list = new DoubleOrderedList<>();
        
        list.add(1);
        System.out.println(list.removeFirst());
        list.add(2);
        System.out.println(list.removeLast());
        
        try {
        	list.add(1);
        	list.add('1');
        }
        catch(NonComparableElementException e) {
        	System.out.println(e);;
        }
    
        
    }
}
