package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		//List<String> sourceWords=getTokens([a-zA-Z]); //it seems i can't use this method in document pakage.
		String[] wordArray=sourceText.split("\\s+");
		starter=wordArray[0];
		String nextWord;
		
		for(int i=0;i<wordArray.length;i++) {
			// arrayindexoutofbounds
			if(i==wordArray.length-1) {
				nextWord=wordArray[0];
			}else {
				nextWord=wordArray[i+1];
			}
			boolean it=false;
			//ListNode newWord=new ListNode(starter);
			//check if starter word is already in the wordList
			for (ListNode node: wordList) {  
				if (node.getWord().equals(starter)) {
					node.addNextWord(nextWord);
					it=true;	
				}
			}
			//starter word not in the wordList then add new ListNode
			if(it==false) {
				ListNode newWord=new ListNode(starter);
				newWord.addNextWord(nextWord);
				wordList.add(newWord);
			}
			starter=nextWord;
		}
		
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		//List<String> generatedText=new LinkedList<String>();
		String output="";
		String currWord=starter;//can currword be randomly chose?
		output=output.concat(currWord+" ");
		//System.out.println(starter);
		//System.out.println(output);
		for(int i=1;i<numWords;i++) {
			String nextWord = null;
			for(ListNode node: wordList) {
				if(node.getWord().equals(currWord)) {
					nextWord=node.getRandomNextWord(rnGenerator);
				}
			}
			output=output.concat(nextWord+" ");
			currWord=nextWord;
		}
		
		return output;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
		starter="";
		wordList=new LinkedList<ListNode>();
		train(sourceText);
		
		
		
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		/*
		// check train method
		gen.train("hi ther hi Leo");
		System.out.println(gen.toString());
		//System.out.println(gen.starter);
		System.out.println(gen.generateText(4));
		*/
		
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		//String textString = "hello.  hello there.  This is a test.  hello there.  hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		String nextWord;
		int x=generator.nextInt(nextWords.size());
		nextWord=nextWords.get(x);
	    return nextWord;
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


