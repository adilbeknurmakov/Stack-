/**
 *
 * @author adilbek
 */
public class Tester {
    public static void main(String[] args)
    {
        Stack curStack = new Stack();
        for (int i = 0; i < 10; ++i)
            curStack.push(i);
        
        System.out.println(curStack.getMaxSize());
        curStack.push(11);
        System.out.println(curStack.getMaxSize());
        System.out.println(curStack.getSize());
        System.out.println(curStack);
        curStack.clear();
        System.out.println(curStack.getSize());
        System.out.println(curStack);
        
        
        for (int i = 0; i < 12; ++i)
        {
            try {
                curStack.pop();
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println(curStack);
    }
}
