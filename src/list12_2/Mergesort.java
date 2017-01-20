package list12_2;

import java.util.*;

public class Mergesort 
{
    public static void parallelMergeSort(int[] a, int NUM_THREADS)
    {
        if(NUM_THREADS <= 1)
        {
            mergeSort(a);
            return;
        }

        int mid = a.length / 2;

        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);

        Thread leftSorter = mergeSortThread(left, NUM_THREADS);
        Thread rightSorter = mergeSortThread(right, NUM_THREADS);

        leftSorter.start();
        rightSorter.start();

        try 
        {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e){}

        merge(left, right, a);
    }

    private static Thread mergeSortThread(int[] a, int NUM_THREADS)
    {
        return new Thread()
        {
            @Override
            public void run()
            {
                parallelMergeSort(a, NUM_THREADS / 2);
            }
        };
    }

    public static void mergeSort(int[] a)
    {
        if(a.length <= 1) return;

        int mid = a.length / 2;

        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, a);
    }


    private static void merge(int[] a, int[] b, int[] r)
    {
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length)
        {
            if(a[i] < b[j])
                r[k++] = a[i++];
            else
                r[k++] = b[j++];
        }

        while(i < a.length)
            r[k++] = a[i++];

        while(j < b.length)
            r[k++] = b[j++];
    }

    private static final Random RAND = new Random(99);
    
    public static void main(String[] args) {
        Mergesort test = new Mergesort();


        int[] tablica1 = new int[1000000];
        for (int i = 0; i < tablica1.length; i++)
        {
            tablica1[i] = RAND.nextInt(2137);
        }
        int[] tablica2 = Arrays.copyOf(tablica1,1000000); //1 mln


        long startTime1 = System.currentTimeMillis();
        test.mergeSort(tablica1);
        long endTime1 = System.currentTimeMillis();

        System.out.println("Czas wykonania normalnego merge "+(endTime1 - startTime1));
        System.out.println();
        //for(int k: tablica1)
        //{
         //   System.out.print(k+", ");
        //}

        System.out.println();

        long startTime2 = System.currentTimeMillis();
        test.parallelMergeSort(tablica2,4);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Czas wykonania wielowatkowego merge " +(endTime2 - startTime2));

        //for(int k: tablica2)
        //{
        //    System.out.print(k+", ");
        //}
    }
}







