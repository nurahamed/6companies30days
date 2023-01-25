class Solution {
  public int totalFruit(int[] fruits) {
	var totalFruit = Integer.MIN_VALUE;
	var map = new HashMap<Integer, Integer>();

	for (int right = 0, left = 0, fruitTypes = 0; right < fruits.length; right++) {
		var rightFruit = fruits[right];

		map.compute(rightFruit, (key, val) -> val == null ? 1 : val + 1);
		if (map.get(rightFruit) == 1)
			fruitTypes++;
		if (fruitTypes <= 2)
			totalFruit = Math.max(totalFruit, right - left + 1);

		while (fruitTypes > 2) {
			var leftFruit = fruits[left++];
			map.put(leftFruit, map.get(leftFruit) - 1);
			if (map.get(leftFruit) == 0)
				fruitTypes--;
		}
	}
	return totalFruit == Integer.MIN_VALUE ? 0 : totalFruit;
}
}
