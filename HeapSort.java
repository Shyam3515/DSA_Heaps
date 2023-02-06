package heaps;

//import sorting.MaxHeap;
//MAX HEAP...
public class HeapSort {
	static int i;
	void heapSort(int[] arr, int n)
	{
		int startIndex = n/2 - 1;//we are going to start heapify method from non-leaf            
		                         //method that is at (n/2-1)
		
		// building Max_heap from given array..
		for (i = startIndex; i >= 0; i--) { //building Max_heap means parent should be greater than child
			max_heapify(arr, n, i);
		}
	}
	
    void max_heapify(int[] arr, int n, int i) 
    {
		int largest = i;
		int l = 2*i+1;  // left child
		int r = 2*i+2;  // right child
		if(l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if(r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		// If largest is not root
		if (largest != i) {  // It means it has been updated,swaping i (current element) with largest element.
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
  
			// Recursively heapify the affected sub-tree
			max_heapify(arr, n, largest);//After swapping we need to adjust the tree
		}
	}
    
	void increaseKey(int arr[],int l,int key,int n){
			if(key>arr[l]) {
				arr[l]=key;
				while(l>0 && arr[(l-1)/2]<arr[l]) {//we used l>0, here to check whether
					int swap=arr[l];              //we reached the element under the root
					arr[l]=arr[(l-1)/2];          // then we can compare element with it's root.
					arr[(l-1)/2]=swap;
					l=(l-1)/2;
				}
			}
			else {
				System.out.println("Key should be higher than value...");
			}
	}
	
	void decreaseKey(int arr[],int d,int key,int n){
		if(key>arr[d]) {
			System.out.println("Key should be lower than value...");
		}
		else {
			arr[d]=key;
			max_heapify(arr, n, d);
		}
    }
	
	void extract(int[] arr, int n) {
		// One by one extract an element from heap.
		for(i = n-1; i >=0; i--) {
		    // Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp; //pushing max to end.
			// call max heapify on the reduced heap
			max_heapify(arr, i, 0); // passing i as array length, as we stored max at end, 
			                      // we can reduce array size as we are decrementing after extracting.
		}                         // 0 means starting index
		
	}
	
	void insert(int[] arr, int n,int key) {
		n=n+1;
		arr[n-1]=key;
		int l=n-1;
		while(l>0 && arr[(l-1)/2]<arr[l]) {
			int swap=arr[l];             
			arr[l]=arr[(l-1)/2];        
			arr[(l-1)/2]=swap;
			l=(l-1)/2;
		}
	}
	
	//Displaying Elements
	void display(int[] arr, int n) {
		for(i = 0; i < n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		System.out.println("Heap Sorting...");
	    int[] arr = {50,20,1,3,10,5,100};
		int n = arr.length;
		HeapSort heap=new HeapSort();
		heap.heapSort(arr,n);
		/*increase key*/
		int l=5;
		int key=25;
		heap.increaseKey(arr,l,key,n);
		/***************/
		/*decrease key*/
		int d=5;
		int key1=5;
		heap.decreaseKey(arr,d,key1,n);
		/***************/
		/*insert key*/
		int key2=115;
		//heap.insert(arr,n,key2);
		/***************/
		heap.extract(arr, n);
		heap.display(arr, n);
	}
}
