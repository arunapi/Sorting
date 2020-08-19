# Sorting
This is project explaining different kinds of Sorting algorithms mentioned in the book [Introduction to Algorithms](https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844)

Contents below are my learnings from the book and Code examples are my own.
 
## Merge Sort

Algorithm design technique used for merge sort is **divide-and-conquer** snd is recursive in structure.
This design technique involves 3 major steps:

**Divide** the problem into into a number of subproblems that are smaller instances of the same problem.

**Conquer** the subproblems by solving them recursssively

**Combine** the solutions to subproblems into the solution for the original problem.

### Algorithm


    mergeSort(arr)
        1. divide(arr,0,arr.length-1)
        
    divide(arr,start,end)
        1. if start>=end
        2.  return
        3. middle = (end - start) / 2
        4. divide(arr, start, middle) //conquer left
        5. divide(arr, middle+1, end) //conquer right
        6. combine(arr, start, middle, end)
        
    combine(arr,start, middle, end)
        1. sizeOfLeftArray = middle - start + 1
        2. sizeOfRightArray = end - middle
        3. set leftArray[sizeOfLeftArray] = arr[start...middle]
        4. set rightArray[sizeOfRightArray] = arr[middle+1...end]
        5. i=0, j=0
        6. from k=start to end
        7.  if i<sizeOfLeftArray AND j<sizeOfRightArray
        8.      if leftArray[i] < rightArray[j]
        9.          arr[k] = leftArray[i]
        10.         i=i+1
        11.     else
        12.         arr[k] = rightArray[j]
        13.         j=j+1
        14. else if i<sizeOfLeftArray
        15.     arr[k] = leftArray[i]
        16.     i=i+1
        17. else
        18.     arr[k] = rightArray[j]
        19.     j=j+1
        

#### Big-O

O(n lg n)        

## Heap Sort
### Heap Data Structure
The (binary) heap data structure can be represented as an array with two attributes

*1. length attribute*

A.length = n.

A[0...n-1]

*2. Heap Size attribute*

0 <= A.heapSize <= n

**Nodes mapping to array index**

A(0) is the root element of the heap. Given an index i, we can use the below method to find it's neighboring nodes on the heap.

PARENT(i) = i/2  //O(1) calculation. Shift binary representation of i one step to right

LEFT(i) = 2i //O(1) calculation. Shift binary representation of i one step to left

RIGHT(i) = 2i + 1

**Types of Heap**

There are two types of heap, defined by their heap propery.

1. max-heap

A[PARENT(i)] >=A[i]

2. min-heap

A[PARENT(i)] <= A[i]

Height of a node in a Heap:
It is the number of edges on the longest simple downward path from the node to a leaf.

Height of a Heap: It is the height of the root node.
If a heap has n-elements, the height of the heap is O(n lg n).(Due to balanced binary tree)

For an array of size n. The height of the heap is lg n. Or in other words, the number of 2s in n.

Remember high school math lg n = heightOfHeap => n = 2^heightOfHeap.

How can we prove this? For a minute imagine that you are creating a heap by simply adding elements.

| Step      | Insert      | Height of Heap(root node) | Height of node |
|-----------|-------------|---------------------------|----------------|
|1| root node|0|0 at Step 1, 1 at Step 2, and this follows height of heap|
|2| node 1|1|0 at Step 2, 1 at Step 4 (Remember LEFT(i) = 2i) and Step 5 (Right(i) = 2i + 1|
|3| node 2|1|0 at Step 3, 1 at Step 6, 3 at Step 8 ...|
|4| node 3|2|0 at Step 4, 1 at Step 8, ...|
|5| node 3|2|0 at Step 5, ...|
|6| node 3|2|0 ...|
|7| node 3|2|0 ...|
|8| node 3|3|0 ...|
|...|...|...|...|
|n| node n|number of 2s in n| 0 at Step n |

## Benchmarking Performance

    mvn clean install

    java -jar target/benchmarks.jar

This repo is created using jmh-java-benchmark maven archetype.

     mvn archetype:generate \
               -DinteractiveMode=false \
               -DarchetypeGroupId=org.openjdk.jmh \
               -DarchetypeArtifactId=jmh-java-benchmark-archetype \
               -DgroupId=com.arunapi \
               -DartifactId=Sorting \
               -Dversion=0.0.1

# Resources and References

The code to print array and tree is referred from here.
http://www.newthinktank.com/2013/04/java-heap-tutorial/

This video tutorial from Derek Banas also has some influence on the code.
https://www.youtube.com/playlist?list=PLGLfVvz_LVvReUrWr94U-ZMgjYTQ538nT

               