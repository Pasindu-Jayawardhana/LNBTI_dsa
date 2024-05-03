public class BubbleSort{
    public static void main(String []args){
        int[] array={12,11,2,18,87,34,27,56,43,33};
        int i;
        int j;
        System.out.println("Before sort");
        for(i=0; i<array.length-1; i++){
            System.out.print(array[i]+",");
        }
        System.out.println("");
        for(i=1; i<array.length-1;i++){
            for(j=0; j<array.length-i;j++){
                 if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                     array[j+1]=temp;
                 }
            }
        }
        System.out.println("after sort");
        for(i=0; i<array.length-1; i++){
            System.out.print(array[i]+",");
        }
    }
}
