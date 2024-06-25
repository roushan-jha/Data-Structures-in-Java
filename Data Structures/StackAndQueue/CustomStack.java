
public class CustomStack {

   public int[] data;

   private static final int DEFAULT_SIZE = 10;

   int top = -1;

   public CustomStack() {
      this(DEFAULT_SIZE);
   }

   public CustomStack(int size) {
      this.data = new int[size];
   }

   public boolean push(int val) throws Exception {
      if(isFull()) {
         throw new Exception("Stack is Full");
      }

      data[++top] = val;

      return true;
   }

   public int pop() throws Exception {
      if(isEmpty()) {
         throw new Exception("Stack is Empty");
      }

      return data[top--];
   }

   public int peek() throws Exception {
      
      if(isEmpty()) {
         throw new Exception("Stack is Empty");
      }

      return data[top];
   }

   public boolean isFull() {
      return (top == data.length - 1);
   }

   public boolean isEmpty() {
      return (top == -1);
   }

   public static void main(String[] args) throws Exception {
      // CustomStack stack = new CustomStack(5);
      // DynamicStack stack = new DynamicStack(5);
      CustomStack stack = new DynamicStack(5);

      stack.push(5);
      stack.push(4);
      stack.push(9);
      stack.push(13);
      stack.push(7);
      System.out.println(stack.pop());
      stack.push(11);
      System.out.println(stack.peek());
      stack.push(22);
      stack.push(1);
      System.out.println(stack.peek());

   } 
}
