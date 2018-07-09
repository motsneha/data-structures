import java.util.Arrays;

public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex){ return 2 * parentIndex + 1;}
    private int getRightChildIndex(int parentIndex){return 2 * parentIndex + 2;}
    private int getParentIndex(int childIndex){return (childIndex -1)/ 2;}

    private boolean hasParent(int index){ return getParentIndex(index) >= 0;}
    private boolean hasLeftChild(int index){ return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index){ return  getRightChildIndex(index) < size;}

    private int getLeftChild(int index){return items[getLeftChildIndex(index)];}
    private int getRightChild(int index){ return items[getRightChildIndex(index)];}
    private int parent(int index){return items[getParentIndex(index)];}

    private void swap(int index1, int index2){
     int temp = items[index1];
     items[index1] = items[index2];
     items[index2] = temp;
    }

    private void ensureCapacity(){
        if(capacity == size){
            items = Arrays.copyOf(items, capacity *2);
            capacity = capacity * 2;
        }
    }

    private int peek(){
        if (size == 0 ) throw new IllegalStateException();
        return items[0];
    }

    private int poll(){
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyDown(){
        int index = 0;
        while (hasLeftChild(index)){
            int smallerIndex  = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) > items[index]){
                smallerIndex = getRightChildIndex(index);
            }

            if(items[index] > items[smallerIndex]){
                break;
            }else{
                swap(smallerIndex, index);

            }
            index = smallerIndex;
        }
    }

    public void heapifyUp(){
        int index = size -1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index) , index);
            index  =  getParentIndex(index);
        }
    }

    public static void main(String[] args) {
        MinIntHeap minIntHeap = new MinIntHeap();
        minIntHeap.add(1);
        minIntHeap.add(2);
        minIntHeap.add(2);
        minIntHeap.add(3);
        minIntHeap.add(4);
        minIntHeap.add(3);
        minIntHeap.add(4);


    }


}
