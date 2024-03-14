 import java.util.*;

  class BucketSort{
    /**
     * @param arr
     * @param noOfBuckets
     */
    static void bucketSort( int[] arr, int noOfBuckets) {
      boolean isNegativePresent = false;
      int offset = Integer.MAX_VALUE;
      for(int i : arr) {
        if ( i < offset) offset = i;
       
        if (i < 0) isNegativePresent = true;

      }
      int globeMax = Integer.MIN_VALUE;
      int globeMin = Integer.MAX_VALUE;
      for (int i=0; i<arr.length; i++) {
      arr[i] -= offset;
      globeMax = Math.max(arr[i], globeMax);
      globeMin = Math.min(arr[i], globeMin);
      }
      int range = globeMax-globeMin;
      int bucketRange = (int)Math.ceil((double) range/noOfBuckets);
      
      List<Integer>[] buckets = new List[noOfBuckets];
      for(int i=0; i< noOfBuckets; i++) {
        buckets[i] = new LinkedList<>();

      }
      for( int num : arr) {
        buckets[hash(num, bucketRange, noOfBuckets)].add (num);
      }
      for( List <Integer> bucket:buckets) { Collections.sort (bucket);}
      int idx = 0;
      for(List <Integer> bucket:buckets ) {
        for(int num: bucket) {
          arr[idx++] = num;
        }
      }
      if(isNegativePresent ) {
        for(int i=0; i<arr.length; i++) {
          arr[i] += offset;
        }
      }
    }
    private static int hash( int num, int hashValue, int noOfBuckets) {
      int bucketnumber = num / hashValue;
      if(bucketnumber == noOfBuckets) {
      bucketnumber--; 
      }
      

      return bucketnumber;
    
    }
      public static void main(String[] args) {
        // Example usage of bucketSort method
        int[] arr = {54, 3, 1, -4, 4};
        int noOfBuckets = 5;
        bucketSort(arr, noOfBuckets);

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));
     
    }
  }
 
