// 17 March 
// Question Majority Element
// BruteForce approach
class Solution2 {
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            int count = 0;
            for(int j = 0;j<n;j++){
                if(nums[i] == nums[j]) count++;
            }
            if(count > majorityCount) return nums[i];
        }
        return -1;
    }
}


// Optimised approach using HashMap
class Solution1 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(hs.getOrDefault(nums[i], -1) != -1){
                hs.put(nums[i], hs.get(nums[i])+1);
            }
            else{
                hs.put(nums[i], 1);
            }
        }
        int majorityFreq = hs.get(nums[0]);
        int e = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(hs.get(nums[i]) > majorityFreq){
                majorityFreq = hs.get(nums[i]);
                e = nums[i];
            }
        }
        return e;
    }
}
