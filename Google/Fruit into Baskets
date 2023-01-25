class Solution {
    public int totalFruit(int[] tree) {
	var total = 0;
	var map = new HashMap<Integer, Integer>();
	
	for (int right = 0, left = 0; right < tree.length; right++) {
		// increment key's frequency by 1
		map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
		while (map.size() > 2) {
			// decrement key's frequency by 1
			map.put(tree[left], map.get(tree[left]) -1);
			// key's frequency in the window becomes zero, so remove the key
			if (map.get(tree[left]) == 0)
				map.remove(tree[left]);
			// contract window from left
			left++;
		}
		total = Math.max(total, right - left + 1);
	}
	return total;
}
}
