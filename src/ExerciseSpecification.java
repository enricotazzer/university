public class ExerciseSpecification {

    /* PRE:
        a != null, a.length >=1
       POST:
        modifies a
        for each i index of a, if a[i] > m then a'[i] = m

       MISSION:
        replace each element of the array that is greater than with m
     */
    private static void boundArray(int[] a, int m){
        for(int i = 0; i < a.length; i++){
            if(a[i] > m){
                swap(a,i,m);
            }
        }
    }

    private static void swap(int[] a, int i, int m){
        a[i] = m;
    }
    public static void main(String[] args) {

    }
}
