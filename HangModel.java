package iy.reznik;

import java.util.ArrayList;
import java.util.Random;

import com.google.appengine.api.datastore.Entity;

public class HangModel {
	protected String word;
	protected ArrayList<Character> allLetters = new ArrayList<Character>();

	public HangModel() {
		this.word = WordBase.getRandomWord().toLowerCase();
	}
	public HangModel(String s) {
		this.word = s.toLowerCase();
	}
	public HangModel(Entity entity) {
		this.word = (String) entity.getProperty("word");
		String s = (String) entity.getProperty("requests");
		for(int i = 0; i < s.length(); i++) {
			this.allLetters.add(s.charAt(i));
		}
	}

	public String getState() {
	    String s = "";
	    for (int i: allLetters) {
	      s += (char)i;
	    }
	    return s;
	  }
	public boolean makeMove(char c) {
		c = Character.toLowerCase(c);
		if(c < 'a' || c > 'z') {
			return false;
		}
		if (allLetters.contains(c) == false) {
			allLetters.add(c);
		}
		return true;
	}

	public String getUserView() {
		String s = "";
		for (int i = 0; i < word.length(); i++) {
			if (allLetters.contains(word.charAt(i)) == false) {
				s += "_ ";
			} else {
				s += word.charAt(i) + " ";
			}
		}
		return s;
	}

	public ArrayList getMissedLetters() {
		ArrayList missedLetters = new ArrayList();
		label: for (int i = 0; i < allLetters.size(); i++) {
			for (int j = 0; j < word.length(); j++) {
				if (word.charAt(j) == allLetters.get(i)) {
					continue label;
				}
			}
			missedLetters.add(allLetters.get(i));
		}
		return missedLetters;
	}

	public int getMistakes() {
		int mistakes = 0;
		label: for (int i = 0; i < allLetters.size(); i++) {
			for (int j = 0; j < word.length(); j++) {
				if (word.charAt(j) == allLetters.get(i)) {
					continue label;
				}
			}
			mistakes++;
		}
		return mistakes;
	}

	public boolean isVictory() {
		if (getUserView().replaceAll(" ", "").equals(word)) {
			return true;
		}
		return false;
	}

}
