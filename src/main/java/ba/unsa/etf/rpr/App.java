package ba.unsa.etf.rpr;


public class App 
{
    public static void main( String[] args ) {
      /*  if (args.length == 0)

        else if (args.length > 1)

        else {
            try {
                ExpressionEvaluator e = new ExpressionEvaluator();
                double result = e.evaluate(args[0]);
                System.out.println(args[0] + " = " + result);
            } catch (Exception i) {

                System.out.println(i.getMessage());
            }
        }*/
        StringBuilder st = new StringBuilder();
        for(int i=0;i<args.length;++i){
            if(i!=0){
                st.append(" ");
            }
            st.append(args[i]);
        }
        String argu=st.toString();

        try {

            System.out.println("The result is: " + ExpressionEvaluator.evaluate(argu));
        }catch(RuntimeException e){
            System.out.println("Your arithmetic expression is not valid!");
        }
    }
}
