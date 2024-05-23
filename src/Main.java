import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        int asdasd = lengthOfLongestSubstring("asdasd");
        findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }


    }



    public static void aaaa(int[] arr){
        int a = arr.length;
        for (int i = 0; i < a; i++) {
            for (int j = 0 ; j < a- i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1){
            return n;
        }
        int r = 1;
        int length = 0;
        HashSet<Character> stringSet = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            stringSet.add(s.charAt(i));
            if (i > 0){
                stringSet.remove(s.charAt(i-1));
            }
            while(r < n && !stringSet.contains(s.charAt(r))){
                stringSet.add(s.charAt(r));
                r++;
            }
            length = Math.max(length, r-i);
            if (r == n || n-i <= length){
                return length;
            }
        }
        return length;
    }

    /**
     * 数组峰值
     * @param mountain
     * @return
     */
    public static List<Integer> findPeaks(int[] mountain) {
        if (mountain.length < 2) {
            return new ArrayList<>();
        }
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1;) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i);
                i+=2;
            }else {
                i++;
            }
        }
        return peaks;
    }


    /**
     * 获取两个有序数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length + nums2.length;
        if (m == 0){
            return 0.0;
        }
        int j1 = 0, j2 = 0;
        int a1 = 0, a2 = 0;
        for(int i = 0 ; i < m / 2 ; i++){
            if (nums1.length <= j1 && nums2.length <= j2){
                return 0.0;
            }
            if (nums1.length <= j1 && nums2.length > j2){
                a1 = nums2[j2++];
                continue;
            }
            if (nums2.length <= j2 && nums1.length > j1){
                a1 = nums1[j1++];
                continue;
            }
            if (nums1[j1] < nums2[j2]){
                a1 = nums1[j1++];
                continue;
            }
            a1 = nums2[j2++];
        }
        if (nums1.length <= j1 && nums2.length > j2){
            a2 = nums2[j2++];
            return m % 2 == 0 ? ((double) a1 + (double) a2) / 2.0 : a2;
        }
        if (nums2.length <= j2 && nums1.length > j1){
            a2 = nums1[j1++];
            return m % 2 == 0 ? ((double) a1 + (double) a2) / 2.0 : a2;
        }
        if (nums1[j1] < nums2[j2]){
            a2 = nums1[j1++];
            return m % 2 == 0 ? ((double) a1 + (double) a2) / 2.0 : a2;
        }
        a2 = nums2[j2++];
        return m % 2 == 0 ? ((double) a1 + (double) a2) / 2.0 : a2;

    }





}