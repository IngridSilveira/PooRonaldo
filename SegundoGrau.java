class Delta_negativo extends Exception{
    public  Delta_negativo() {
        super();
    }
}
 
public class SegundoGrau {
 
    public static void main(String[] args) {
        int d,a=1,b=4,c=3;
        double x1,x2;
        try {
            d= delta(a,b,c);
            if(d<0) throw new Delta_negativo();
            else {
                x1= raizesn(a,b,d);
                x2=raizesp(a,b,d);
                System.out.println("As raizes sao "+x1+" "+x2);
                 
            }
        }
        catch(Delta_negativo e) {
            System.out.println("Nao possui raizes");
        }
         
         
    }
    public static int delta(int a, int b,int c) {
        return (b*b)-(4*a*c);
    }
    public static double raizesp(int a,int b,int c) {
        return (double) ((-b+Math.sqrt(c))/(2*a));
    }
    public static double raizesn(int a,int b,int c) {
        return (double) ((-b-Math.sqrt(c))/(2*a));
    }
}