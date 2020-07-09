package iy.reznik;

import java.util.Random;

public class WordBase {
	public static String getRandomWord() {
		String[] words = {"test", "word", "tree", "house", "responsibility", "umbrella", "faith", "destiny", "luxury", "miracle", "glory", "jewellery", "figure", "determination", "language", "reason", "mentality", "spirit", "pillow", "tortoise", "throne", "longsleeve", "subject", "derivative", "weapon", "terrorist", "tournament", "potion", "legacy", "enthusiasm", "breath", "phenomenon", "statistics", "background", "handshake", "skyscraper", "neighbourhood"};
		Random random = new Random();
		int n = random.nextInt(words.length);
		return words[n];
	}
}
