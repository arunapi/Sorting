# Sorting

## Merge Sort

Algorithm design technique used for merge sort is **divide-and-conquer** snd is recursive in structure.
This design technique involves 3 major steps:

**Divide** the problem into into a number of subproblems that are smaller instances of the same problem.

**Conquer** the subproblems by solving them recursssively

**Combine** the solutions to subproblems into the solution for the original problem.

###Algorithm

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
        

####Big-O
O(n lg n)        
        
##Heap Sort
##Benchmarking Performance

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
               