/**
 * GridlandMetro Created by dortega on 19/04/2017.
 */

import java.io.File;
import java.util.*;

public class Solution2 {


    public static class Interval implements Comparable{

        private final int c1;
        private final int c2;

        public Interval(int c1, int c2) {
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public boolean equals(Object obj) {
            return ((Interval)obj).getC1() == getC1() && ((Interval)obj).getC2() == getC2();
        }

        @Override
        public int hashCode() {
            return 17*c1-3*c2;
        }

        public int getC1() {
            return c1;
        }

        public int getC2() {
            return c2;
        }

        @Override
        public String toString() {
            return c1 +" -> " + c2;
        }


        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         * <p>
         * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
         * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
         * <tt>y.compareTo(x)</tt> throws an exception.)
         * <p>
         * <p>The implementor must also ensure that the relation is transitive:
         * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
         * <tt>x.compareTo(z)&gt;0</tt>.
         * <p>
         * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
         * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
         * all <tt>z</tt>.
         * <p>
         * <p>It is strongly recommended, but <i>not</i> strictly required that
         * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
         * class that implements the <tt>Comparable</tt> interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         * <p>
         * <p>In the foregoing description, the notation
         * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
         * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
         * <tt>0</tt>, or <tt>1</tt> according to whether the value of
         * <i>expression</i> is negative, zero or positive.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         */
        @Override
        public int compareTo(Object o) {
            Interval other = (Interval)o;
            if(c1<other.c1){
                return 1;
            }else if(c1==other.c1){
                return 0;
            }else{
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        Map<Integer,Set<Interval>> mySet = new HashMap<>();
        long count = n*m;
        for(int i=1;i<=k;i++){
            int r = in.nextInt();
            int c1 = in.nextInt();
            int c2 = in.nextInt();

            if(!mySet.containsKey(r)){
                mySet.put(r,null);
            }

            Set<Interval> a=mySet.get(r);
            if(a==null){
                a = new TreeSet<>();
                mySet.put(r,a);
            }
            a.add(new Interval(c1,c2));

        }

        for(Set<Interval> intervals : mySet.values()){
            mergeIntervals(intervals);
        }

        System.out.println(count);
    }

    public static void mergeIntervals(Set<Interval> intervals){

    }

}