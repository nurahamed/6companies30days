class TweetCounts {
    Map<String, List<Integer>> map;
    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        map.putIfAbsent(tweetName, new ArrayList<>());
        map.get(tweetName).add(time);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> times = map.get(tweetName);
        Collections.sort(times);
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        if (freq.equals("hour")) {
            for (int i = 0; i < times.size(); i++) {
                if (times.get(i) >= startTime && times.get(i) <= endTime) {
                    int index = (times.get(i) - startTime) / 3600;
                    m.put(index, m.getOrDefault(index, 0) + 1);
                }
            }
            int count = 0;
            for (int i = startTime; i <= endTime; i += 3600) {
                res.add(m.getOrDefault(count++, 0));
            }
        } else if (freq.equals("minute")) {
            for (int i = 0; i < times.size(); i++) {
                if (times.get(i) >= startTime && times.get(i) <= endTime) {
                    int index = (times.get(i) - startTime) / 60;
                    m.put(index, m.getOrDefault(index, 0) + 1);
                }
                
            }
            int count = 0;
            for (int i = startTime; i <= endTime; i += 60) {
                res.add(m.getOrDefault(count++, 0));
            }
        } else {
            for (int i = 0; i < times.size(); i++) {
                if (times.get(i) >= startTime && times.get(i) <= endTime) {
                    int index = (times.get(i) - startTime) / (3600 * 24);
                    m.put(index, m.getOrDefault(index, 0) + 1);
                }
            }
            int count = 0;
            for (int i = startTime; i <= endTime; i += (3600 * 24)) {
                res.add(m.getOrDefault(count++, 0));
            }
        }
        return res;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
