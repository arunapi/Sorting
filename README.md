# Sorting
This is project explaining different kinds of Sorting algorithms mentioned in the book [Introduction to Algorithms](https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844)

Contents below are my learnings from the book and Code examples are my own.
## Insertion Sort

The book says

    Insertion sort works the way many people sort a hand of playing cards. We start with an empty left hand and the cards face down on the table.
    To find the correct position for a card, we compare it with each of the cards already in hand, from right to left. 
    At all times the cards held in the left hand are sorted, and these cards were originally the top cards of the pile on the table.

    The algorithm sorts the input numbers in place: it rearranges the numbers within array A, with at most a constant number of them sorted outside the array at any time. 

Read is my thought experiment before writing the algorithm [here](https://dev.to/arunapi/learning-algorithms-384c)

### Algorithm: Insertion Sort
*When do I know I am ready! You never know. It's just a leap of faith. - Spiderman-Intro to Spiderverse*

**Step 1:** Move the 2nd card you want to compare into the `place holder`

**Step 2:** Set the position of the card you are going to compare against previous cards into `position of the card to be sorted`. 
Set `position of the card to be sorted` as 2

**Step 3:** Set `position of the previous card to be compared` = `position of the card to be sorted` - 1

**Step 4:** Check if `position of the previous card to be compared` > 0. There is at least one previous card to compare.
else, go to Step 9.

**Step 4:** Compare the card in your `place holder` against the card in `position of the previous card to be compared`. 
If the value in `place holder` is less, go to Step 5, else go to Step 

**Step 5:** Shift the card you just compared to the `position of the previous card to be compared`. 

A[`position of the previous card to be compared`+1] = A[`position of the previous card to be compared`] 

**Step 6:** Decrement the value of `position of the previous card to be compared` in order to compare the card in your `place holder` with the one before.
        
`position of the previous card to be compared` = `position of the previous card to be compared` - 1', and go to Step 4

**Step 7:** You found the position where the card needs to be inserted and shifted all the cards greater than the current card value.
Insert the card after the `position of the previous card to be compared`.

A[`position of the previous card to be compared`+1] = `place holder`

**Step 8:** if next card exists `position of the card to be sorted`+1 < array size, move the next card in the `place holder` else, you've finished sorting, go to Step 10.

**Step 9:** Set the position of the card you are going to compare against previous cards into `position of the card to be sorted`.  Go to Step 3.

**Step 10:** End

I took the leap of faith, focused on re-usability of the steps, reduced my chatter, and arrived at the above steps after several re-writes.

This is not a tutorial for the Insertion Sort algorithm. The algorithm above is one of several ways and can even be optimized. 
If at all you want to take away one thing from this blog, it is just that, 
while trying to learn algorithms, slowing yourself down and writing down your thoughts really help.

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

### Building a Max-Heap

Remember, Heap -> an array of nodes

Remember, Tree in a Heap -> an array of nodes, each node at `i` may have PARENT at `i/2`, LEFT at `2i` and RIGHT at `2i+1`


In order to build a max heap from an array, we need to make sure, any tree in the array is not violating the max heap property.

Given an array and node at i, make sure it's tree (NODE, LEFT, RIGHT), follows the max heap property.

#### Algorithm to recursively max-heapify a tree represented in an array

*Step 1:* largest = i

*Step 2:* Check if left node exists, node at largest < left node, go to Step 3 else Step 4

*Step 3:* largest = left node index

*Step 4:* Check if right node exists, node at largest < right node, go to Step  else Step 7

*Step 6:* largest = right node index

*Step 7:* if largest != i, oh man the tree is wrong, correct it. Go to Step 8 else all good, go to Step 10

*Step 8:* Swap largest and i. Ok we got one right.

*Step 9:* let's repeat to make sure the node at largest is correct in its new position, Set i = largest and go to Step 1

*Step 10:* END

So we figured out a way to correct the tree and repeat the process until all trees are corrected in the array, but where do we start?

Given an n node array A[0,1,2....n-1] = {node 1, node 2, .....node n}
and the derived tree (PARENT,NODE(leaf, if no left or right),LEFT(leaf of tree),RIGHT(leaf of tree)) representation of heap, 
note that the leaves of the tree are nodes indexed by n/2 + 1, n/2 + 2,....,n

So all the elements in A[n/2 + 1, n/2 + 2,...., n-1] are leaf nodes.

We will start at the bottom right tree (n/2). 

Not clear? draw out a 8 node tree, we will start at index 4

#### Algorithm
Step 1: for i=heapSize/2 to 1
Step 2: max-heapify(A,i)    

## Bubble Sort

With the help of some crazy visualization. Your array of n elements is scattered on the bottom of a calm pond.

Bubble up the largest value to the top of the pond.(end of the array). This job is done by the in inner for loop.

Repeat this for all elements in the bottom of the pond (counting backwards from n). This is done by the outer for loop.

Core logic is this:

```
        for(int j=arr.length-1;j>0;j--){
            for(int i=0;i<j;i++){
                if(arr[i]>arr[i+1]){
                    //swap
                    int temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
```

#### Big-O
O(n^2)
 
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

               