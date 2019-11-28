package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 */
	public String reverse(String string) {
		
		String reverseString = "";
		
		for(int i=string.length()-1; i>=0; i--) {
			reverseString=reverseString + string.charAt(i);
		}
		return reverseString;
	}
	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String cleanPhrase = phrase.replaceAll("-", " ");
		String[] words = cleanPhrase.split(" ");
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < words.length; i++) {
			sb.append(words[i].charAt(0));
		}
		String acronym = sb.toString().toUpperCase();
		return acronym;
	}
	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}
		
		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if((sideOne==sideTwo) && (sideTwo==sideThree)){
				return true;
			} else {
				return false;
			}
		}

		public boolean isIsosceles() {
			if (sideOne==sideTwo) {
				return true;
			}else if (sideTwo==sideThree) {
				return true;
			} else if (sideOne==sideThree) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isScalene() {
			if((sideOne!=sideTwo) && (sideOne!=sideThree)) {
				 return true;
				} else {
					return false;
				}
		}
	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	
	public int getScrabbleScore(String string) {
		HashMap<String, Integer>letterMap = new HashMap<String, Integer>();
		letterMap.put("A", 1);
		letterMap.put("E", 1);
		letterMap.put("I", 1);
		letterMap.put("O", 1);
		letterMap.put("O", 1);
		letterMap.put("U", 1);
		letterMap.put("L", 1);
		letterMap.put("N", 1);
		letterMap.put("R", 1);
		letterMap.put("S", 1);
		letterMap.put("T", 1);
		
		letterMap.put("D", 2);
		letterMap.put("G", 2);
		
		letterMap.put("B", 3);
		letterMap.put("C", 3);
		letterMap.put("M", 3);
		letterMap.put("P", 3);
		
		letterMap.put("F", 4);
		letterMap.put("H", 4);
		letterMap.put("V", 4);
		letterMap.put("W", 4);
		letterMap.put("Y", 4);
		
		letterMap.put("K", 5);
		letterMap.put("J", 8);
		letterMap.put("X", 8);
		letterMap.put("Z", 10);
		letterMap.put("Q", 10);
		
		String[] arr = string.split("");
		int sum = 0; 
		for(String c : arr) {
            //look up the current char in the alphabet and add it's value to sum
			sum += letterMap.get(c.toUpperCase());
        }
        return sum;
	}
	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
		string = string.replaceAll("[^\\d]", "");
		if (string.length() == 10) {
			return string;
		} else {
			throw new IllegalArgumentException();
		}
	}
	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> map = new HashMap<String, Integer> ();
		  
		String[] separateWords = string.split("\\W+"); // removes non-alphaNum char

		for (String s : separateWords) {
		    
		    if (!map.containsKey(s)) {  // 1st time we see string
		      map.put(s, 1);
		    }
		    else {
		      int count = map.get(s);
		      map.put(s, count + 1);
		    }
		  }
		  return map;
	}
	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not )found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}
	}
	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String changeWord(String word) { // applied to each word in the String[]
		String vowels = "aeiou";
		String changed = "";

		for(int i = 0, j = 1; j < word.length(); j++) {
			String chr = word.substring(i, j);

			if(chr.equals("q")) {
				return word.substring(2) + word.substring(0,2)+ "ay";
			}
			if(vowels.contains(chr)) { // checks to see if there vowels at beginning of word
				return word.substring(i) + word.substring(0, i) + "ay";
			}else {
				i++;
			}
		}
		return changed;
	}
	public  String toPigLatin(String string) {
		String answer = "";
		String[] arr = string.split(" "); // splits string into separate words ...to loop through
		int i =0;
		// loop through each word and change it with changeWord() method above ^
		for(String s : arr) {
			if(i == arr.length -1) {
				answer += changeWord(s); 
			}else {
				answer += changeWord(s) + " ";
			}
			i++;
		}
		return answer;
	}
	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		
		if (input % 10 == input) {
			return true; // this immediately checks if input is 1-digit number
		}
		int firstTemp = input; 
		int numOfDigits = 0; 
			while (firstTemp >= 1) {  
				numOfDigits += 1; 
				firstTemp/=10; // this removes last digit, continue loop
			}
		int power = numOfDigits; //this is what we will put as the POWER for e. digit.
		int secondTemp = input;
		int digit = 0;
		int answer = 0;
		while (secondTemp >= 1) {
			digit = secondTemp % 10; 
			answer += Math.pow(digit, power);
			secondTemp /= 10; // this removes last digit, continue loop
		}
		if(answer == input) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factors = new ArrayList<Long>();
		for(long f = 2; f<=l; f++) {
			while(l % f == 0) {
				factors.add(f);
				l /= f;
			}
		}
		return factors;
	}
	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		

		public int getKey() {
			return key;
		}

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String encryptedMsg = "";
			for(int i=0; i<string.length(); i++) {
				char ch = string.charAt(i);
				if(Character.isLetter(ch)) {
					if(Character.isLowerCase(ch)) {
						char codeLetter = (char) (ch + this.getKey());
						// checking if 'codeLetter' is out of bounds so that it goes back to 'z' re: ASCII Char #
						if(codeLetter>'z') {
							encryptedMsg += (char) (ch - (26 - this.getKey())); // CHECK
						} else {
							encryptedMsg += codeLetter; // if codeLetter < 'z', within bounds, fine.
						}
						// copied code for UpperCase letter...
					} else if (Character.isUpperCase(ch)) {
						char codeLetter = (char) (ch + this.getKey());
					
						if(codeLetter>'Z') { 
							encryptedMsg += (char) (ch - (26 - this.getKey()));
						} else {
							encryptedMsg += codeLetter;
						}
					}
				} else {
					encryptedMsg += ch;
				}
			}
			return encryptedMsg;
		}
		
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int k) {
		if(k==0) {
			throw new IllegalArgumentException();
		}
		int num=1;
		int count=0;
		int i;
		while (count < k){
		      num=num+1;
		      for (i = 2; i <= num; i++){
		        if (num % i == 0) {
		          break;
		        }
		      }
		      if ( i == num){
		        count = count+1;
		      }
		    }
		    return num;
	}
	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			HashMap<Character, Character> hm = new HashMap<Character, Character>();
			string=string.toLowerCase();
			string=string.replaceAll("[-+.^:,]","");
			string=string.replace(" ","");
			hm.put('a','z');
			hm.put('b', 'y');
			hm.put('c', 'x');
			hm.put('d', 'w');
			hm.put('e', 'v');
			hm.put('f', 'u');
			hm.put('g', 't');
			hm.put('h', 's');
			hm.put('i', 'r');
			hm.put('j', 'q');
			hm.put('k', 'p');
			hm.put('l', 'o');
			hm.put('m', 'n');
			hm.put('n', 'm');
			hm.put('o', 'l');
			hm.put('p', 'k');
			hm.put('q', 'j');
			hm.put('r', 'i');
			hm.put('s', 'h');
			hm.put('t', 'g');
			hm.put('u', 'f');
			hm.put('v', 'e');
			hm.put('w', 'd');
			hm.put('x', 'c');
			hm.put('y', 'b');
			hm.put('z', 'a');
			hm.put('1', '1');
			hm.put('2', '2');
			hm.put('3', '3');
			int i =0;
			StringBuilder sb=new StringBuilder("");
			for(i=0;i<string.length();i++) {
				char letter=string.charAt(i);
				sb.append(hm.get(letter));
			}
			for(i=5;i<sb.length();i=i+6) {
				sb.insert(i," ");
			}
			String resultString=sb.toString();
			return resultString;
			}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String decodedString = "";
			string = string.replaceAll(" ", "");
			for(int i=0; i<string.length(); i++) {
				char ch = string.charAt(i);
				if(Character.isLowerCase(ch)) {
					// using ASCII Dec number of char to check if in or out of bounds
					if(ch <= 'm') {
						char newLetter = (char) ('z' - (ch - 'a'));
						decodedString += newLetter;
					} else {
						char newLetter = (char) ('a' + ('z' - ch));
						decodedString += newLetter;
					}
				} else if(Character.isUpperCase(ch)) {
					if(ch <= 'M') {
						char newLetter = (char) ('Z' - (ch - 'A'));
						decodedString += newLetter;
					} else {
						char newLetter = (char) ('A' + ('Z' - ch));
						decodedString += newLetter;
					}
				} else {
					decodedString += ch;
				}
			}
			return  decodedString;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		string = string.replaceAll("-", "");
		if(string.length() != 10) {
			return false;
		// gatekeeps length	
			
		} else if(string.matches("^[X0-9]+$")) { //checks for INVALID CHARACTERS
			int sum =0;
			for(int i=0; i<9; i++) {
				int digit = Integer.parseInt(string.substring(i, i+1));
				sum += (digit * (10 - i));
			} // parses chars to digits, multiplies them in decreasing order from 10...
			
			String checkX = Integer.toString((11 - (sum % 11)) % 11);
			// This checks that total sum is 0
			if("10".equals(checkX)) {
				checkX = "X";  // the last dig is either 0, or it is 10 if there is X
			}	
			return checkX.equals(string.substring(9));// isolates the last digit --> 
			//it is either 10 because there's X, or 0 because !X :)	
		} else {
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * grammar, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		String cleanString = string.replaceAll("[^A-Za-z]", "");
		if(cleanString.length() < 26) { 
			return false;
		} else if (string.equals("")) {
			return false;
		} else {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if(cleanString.indexOf(ch) < 0) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		LocalDateTime ldt;
		long gigaSeconds = 1_000_000_000L;
		if(given instanceof LocalDate) { // checking whether give is instance of LocalDate interface.
			ldt = ((LocalDate) given).atTime(00, 00, 00); // Casting given to LocalDate
		} else {
			ldt = (LocalDateTime) given; // casting given to LocalDateTime
		}
		
		return ldt.plusSeconds(gigaSeconds);
	}
	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		Set<Integer> hs= new HashSet<Integer>(); 
		int k=0;
		int j=0;
		int num=0;
		for(j=0;j<set.length;j++) {
			num=set[j];
		for(k=1;num*k<i;k++) {
				int product=num*k;
				hs.add(product);
			}
		}
		int sum = hs.stream().mapToInt(Integer::intValue).sum();
		return sum;
	}
	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isLuhnValid(String string) {
		string=string.replace(" ", "");
		string=string.replace("([a-z]","");
		int[] numbers=new int[string.length()];
		int i;
		for(i=0;i<string.length();i++) {
			numbers[i]=Character.getNumericValue(string.charAt(i));
		}
		for(i=numbers.length-2;i>=0;i-=2) {
			numbers[i]=numbers[i]*2;
			if(numbers[i]>9) {							
				numbers[i]=numbers[i]-9;	
		}
		}
		int sum=0;
		for(i=0;i<numbers.length;i++) {
			sum=sum+numbers[i];
		}
		if(sum%10==0) {
			return true;
		}		
		return false;
	}
	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public static int solveWordProblem(String string) {
		if(string.contains("?")) {
			string=string.replace("?", "");
		}
		String[] split=string.split(" ");
		int[] nums=new int[2];
		int i=0;
		for(String s:split) {
			if(s.matches("-?\\d+(\\.\\d+)?")) {
				int num=Integer.parseInt(s);
				nums[i]=num;
				i++;
			}
		}
		String check = "";
			if(string.contains("plus")) {
				check+="plus";
			}else if(string.contains("minus")) {
				check+="minus";
			}else if(string.contains("divided")) {
				check+="divided";
			}else if(string.contains("multiplied")) {
				check+="multiplied";
			}
			switch(check) {
			case "plus":
				return nums[0]+nums[1];
			case "minus":
				return nums[0]-nums[1];
			case "divided":
				return nums[0]/nums[1];
			case "multiplied":
				return nums[0]*nums[1];
		}
		return -1;
	}
}