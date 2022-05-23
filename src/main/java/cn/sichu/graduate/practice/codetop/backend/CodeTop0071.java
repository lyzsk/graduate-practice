package cn.sichu.graduate.practice.codetop.backend;

/**
 * TODO
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0071 {
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        // 初始化大顶堆
        for (int i = (length - 2) / 2; i >= 0; i--) {
            maxHeapify(nums, i, length);
        }

        // 每次取堆顶元素与堆尾元素交换，再重新调整成大顶堆
        for (int i = length - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            maxHeapify(nums, 0, i);
        }
        return nums;
    }

    private static void maxHeapify(int[] nums, int top, int length) {
        int temp = nums[top]; // 暂存堆顶元素
        // 比较左右子树根结点，从大的子树向下遍历调整堆
        for (int i = 2 * top + 1; i < length; i = i * 2 + 1) {
            // 保证i为较大的子树下标
            if (i < length - 1 && nums[i] < nums[i + 1]) {
                i++;
            }
            if (temp > nums[i]) {
                break;
            }
            nums[top] = nums[i];
            top = i;// 向下搜索
        }
        nums[top] = temp;
    }
}
