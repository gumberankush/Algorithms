// Java program to find an element
// in an almost sorted array
class SearchInAlmostSorted
{
	int binarySearch(int arr[], int start, int end, int x)
	{
		while(start <= end){
          int mid = start + (end-start)/2;
          
          if(arr[mid]  == x){
          	return mid;
          }else if(mid-1 >= start && arr[mid-1] == x){
          	return mid-1;
          }else if(mid+1 <= end && arr[mid+1] == x){
          	return mid+1;
          }
          
          if(arr[mid] < x){
          	start = mid + 2;
          }
          if(arr[mid] > x){
          	end = mid - 2;
          }
        }
      return -1;
	}

	// Driver code
	public static void main(String args[])
	{
		SearchInAlmostSorted ob = new SearchInAlmostSorted();
		int arr[] = {3, 2, 10, 4, 40};
		int n = arr.length;
		int x = 4;
		int result = ob.binarySearch(arr, 0, n - 1, x);
		if(result == -1)
			System.out.println("Element is not present in array");
		else
			System.out.println("Element is present at index " +
								result);
	}
}
