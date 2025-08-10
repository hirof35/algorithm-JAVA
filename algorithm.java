import java.util.*;
 class Algo{
    private int Gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    private int Lcm(int a,int b){
        return (a * b)/Gcd(a , b);
    }
    private int Gcd_array(int[] array){
        int gcd=array[0];
        for(int i=1;i<array.length;i++){
            gcd=Gcd(gcd,array[i]);
        }
        return gcd;
    }
    private int Lcm_array(int[] array){
        int lcm=array[0];
        for(int i=1;i<array.length;i++){
            lcm=Lcm(lcm,array[i]);
        }
        return lcm;
    }
    private void hanoi(int n, int from, int to, int temp) {
        if (n > 0) {
            hanoi(n - 1, from, temp, to);
            System.out.println(from + "から" + to + "に移動");
            hanoi(n - 1, temp, to, from);
        }
    }
    private void quick_sort(int[] array,int left,int right){
        if(left<right){
            int pivot=partition(array,left,right);
            quick_sort(array,left,pivot-1);
            quick_sort(array,pivot+1,right);
        }
    }
    private void merge_sort(int[] array,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            merge_sort(array,left,mid);
            merge_sort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }
    private void merge(int[] array,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++){}
    }
    private void heapify(int[] array,int i,int n){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n && array[left]>array[largest]){}
    }
    private void selection_sort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int min_index=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min_index]){}
            }
        }
    }
    private void insertion_sort(int[] array){
        for(int i=1;i<array.length;i++){
            int key=array[i];
            int j=i-1;
            while(j>=0 && array[j]>key){}
        }
    }
    private void bubble_sort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){}
            }
        }
    }
    
    private int linear_search(int[] array,int key){
        for(int i=0;i<array.length;i++){
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }
    private int binary_search(int[] array,int key){
        int left=0;
        int right=array.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(array[mid]==key){
                return mid;
            }
            else if(array[mid]<key){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
    private void count_sort(int[] array,int exp){
        int n=array.length;
        int[] output=new int[n];
        int[] count=new int[10];
        for(int i=0;i<n;i++){
            count[(array[i]/exp)%10]++;
        }
        for(int i=1;i<10;i++){
            count[i]+=count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            output[count[(array[i]/exp)%10]-1]=array[i];
        }
    }
    private void radix_sort(int[] array){
        int max=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        for(int exp=1;max/exp>0;exp*=10){
            count_sort(array,exp);
        }
    }
    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i + 1;
    }
    private void heap_sort(int[] array){
        for(int i=array.length/2-1;i>=0;i--){
            heapify(array,i,array.length);
        }
        for(int i=array.length-1;i>=0;i--){
            int temp=array[0];
            array[0]=array[i];
            array[i]=temp;
            heapify(array,0,i);
        }
    }
    private void shell_sort(int[] array){
        int n=array.length;
        for(int gap=n/2;gap>0;gap/=2){
            for(int i=gap;i<n;i++){
                int temp=array[i];
                int j;
                for(j=i;j>=gap && array[j-gap]>temp;j-=gap){
                    array[j]=array[j-gap];
                }
                array[j]=temp;
            }
        }
    }
    private void bucket_sort(int[] array){
        int n=array.length;
        int max=array[0];
        int min=array[0];
        for(int i=1;i<n;i++){
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }
        int bucket_count=(max-min)/n+1;
        ArrayList<ArrayList<Integer>> buckets=new ArrayList<>(bucket_count);
        for(int i=0;i<bucket_count;i++){
            buckets.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int bucket_index=(array[i]-min)/n;
            buckets.get(bucket_index).add(array[i]);
        }
        for(int i=0;i<bucket_count;i++){
            Collections.sort(buckets.get(i));
        }
        int index=0;
        for(int i=0;i<bucket_count;i++){
            for(int j=0;j<buckets.get(i).size();j++){
                array[index++]=buckets.get(i).get(j);
            }
        }
    }
    private void counting_sort(int[] array){
        int n=array.length;
        int max=array[0];
        int min=array[0];
        for(int i=1;i<n;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        int[] count=new int[max+1];
        for(int i=0;i<n;i++){
            count[array[i]]++;
        }
        for(int i=1;i<=max;i++){
            count[i]+=count[i-1];
        }
        int[] output=new int[n];
        for(int i=n-1;i>=0;i--){
            output[count[array[i]]-1]=array[i];
            count[array[i]]--;
        }
        for(int i=0;i<n;i++){
            array[i]=output[i];
        }
    }
    public void Show(){
        Scanner scan=new Scanner(System.in);
            // ... GCD, LCM の部分
            System.out.println("GCD, LCM の部分");
            System.out.println("整数a:");
            int a=scan.nextInt();
            System.out.println("整数b:");
            int b=scan.nextInt();
            System.out.println("Gcd:"+Gcd(a,b));
            System.out.println("Lcm:"+Lcm(a,b));
            // Quick Sort
            int[] quickArray = {5, 3, 8, 4, 2};
            quick_sort(quickArray, 0, quickArray.length - 1);
            System.out.println("quick_sort:" + Arrays.toString(quickArray));
        
            // Merge Sort
            int[] mergeArray = {5, 3, 8, 4, 2};
            merge_sort(mergeArray, 0, mergeArray.length - 1);
            System.out.println("merge_sort:" + Arrays.toString(mergeArray));
        
            // Linear Search (戻り値が必要なため、メソッドも修正が必要です)
            int[] searchArray = {5, 3, 8, 4, 2};
            int foundIndex = linear_search(searchArray, 3);
            if (foundIndex != -1) {
                System.out.println("linear_search: 3はインデックス" + foundIndex + "で見つかりました。");
            } else {
                System.out.println("linear_search: 3は見つかりませんでした。");
            }
        
            // Hanoi
            System.out.println("hanoi:");
            hanoi(3, 1, 3, 2);
        
            scan.close();
        }
}

public class ma {
    public static void main(String[] args) throws Exception {
        Algo algo=new Algo();
        algo.Show();
    }

}
