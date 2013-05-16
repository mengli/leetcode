Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

    public int minDistance(String word1, String word2) {
		if (word1.length() == 0 || word2.length() == 0)
			return word1.length() == 0 ? word2.length() : word1.length();
		int[][] arr = new int[word2.length() + 1][word1.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			arr[0][i] = 0;
		}
		for (int j = 0; j <= word2.length(); j++) {
			arr[j][0] = 0;
		}
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					arr[j][i] = arr[j - 1][i - 1];
				} else {
					int dis = Math.min(arr[j - 1][i], arr[j][i - 1]);
					arr[j][i] = Math.min(arr[j - 1][i - 1], dis) + 1;
				}
			}
		}
		return arr[word2.length()][word1.length()];
	}