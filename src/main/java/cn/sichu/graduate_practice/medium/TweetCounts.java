package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/tweet-counts-per-frequency/
 * <p>
 * 题解:https://leetcode-cn.com/problems/tweet-counts-per-frequency/solution/ordered-mapsi-xiang-yong-hu-tui-wen-shi-jian-tui-w/
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class TweetCounts {
    // key 用户->推文时间->该时间推文发布数目
    private Map<String, TreeMap<Integer, Integer>> userTweetMap;

    public TweetCounts() {
        userTweetMap = new HashMap<String, TreeMap<Integer, Integer>>();
    }

    // 发布推文
    public void recordTweet(String tweetName, int time) {
        // 当前用户推文集合
        TreeMap<Integer, Integer> tweetMap =
            userTweetMap.computeIfAbsent(tweetName, k -> new TreeMap<Integer, Integer>());
        // 推文时间记录，比之前次数多1
        tweetMap.put(time, tweetMap.getOrDefault(time, 0) + 1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<Integer>();
        if (!userTweetMap.containsKey(tweetName)) {
            res.add(0);
            return res;
        }

        int freqTime = 1;
        if ("minute".equals(freq)) {
            freqTime = 60;
        } else if ("hour".equals(freq)) {
            freqTime = 3600;
        } else if ("day".equals(freq)) {
            freqTime = 86400;
        }

        // 用户的全部推文时间集合
        TreeMap<Integer, Integer> tweetMap = userTweetMap.get(tweetName);
        int start = startTime;
        int end = Math.min(start + freqTime, endTime + 1);
        while (start <= endTime) {
            int count = 0;
            // 找到发文时间大于等于start的推文
            Map.Entry<Integer, Integer> entry = tweetMap.ceilingEntry(start);
            while (entry != null && entry.getKey() < end) {
                // 推文数累加
                count += entry.getValue();
                // 找比当前大的推文时间
                entry = tweetMap.higherEntry(entry.getKey());
            }
            res.add(count);
            start = end;
            end = Math.min(end + freqTime, endTime + 1);
        }
        return res;
    }
}

// Your TweetCounts object will be instantiated and called as such:
// TweetCounts obj = new TweetCounts();
// obj.recordTweet(tweetName,time);
// List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
