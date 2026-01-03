package com.mycompany.data.structures;

public class RadixSort {
    public static int getMax(int[] arr){
        int greatest = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(greatest < arr[i]){
                greatest = arr[i];
            }
        }
        return greatest;
    }
    
    public static void radixSort(int[] arr){
        int max = getMax(arr);
        List<Integer>[] lists = new List[10];
        for(int j = 0; j < 10; j++){
            lists[j] = new List<>();
        }
        
        for(int i = 1; max / i > 0; i *= 10){
            for (int j = 0; j < 10; j++)
                lists[j].clear();
            
            for(int j = 0; j < arr.length; j++){
                lists[(arr[j]/i) % 10].append(arr[j]);
            }
            
            int count = 0;
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < lists[j].getSize(); k++){
                    arr[count++] = (int) lists[j].getItem(k);
                }
            }
        }
    }
}
