package cn.sichu.graduate_practice.array;

public class BuildArrayfromPermutation {
    /**
     * Time: O(n)
     * <p>
     * Space: O(1), res 数组不计入复杂度
     * 
     * @param nums
     * @return
     */
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    /**
     * inplace 修改，不使用额外的 res 数组
     * 
     * @param nums
     * @return
     */
    public int[] buildArraySolution2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += (nums[nums[i]] % 1000) * 1000;
        }
        for (int j = 0; j < nums.length; j++) {
            nums[j] /= 1000;
        }
        return nums;
    }
}
