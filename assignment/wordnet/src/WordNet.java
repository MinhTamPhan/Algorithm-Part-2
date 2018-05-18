import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by MinhTam on 18/05/2018.
 */
public class WordNet {

    private Digraph G; // Graph

    private Map<String, ArrayList<Integer>> nouns = new HashMap<String, ArrayList<Integer>>();// List of nouns <noun, List<synsetIds>>
    private Map<Integer, String> synsets = new HashMap<Integer, String>(); // List of synsets <synsetId, List<nouns>>
    private Map<Integer, ArrayList<Integer>> edges = new HashMap<Integer, ArrayList<Integer>>(); // Edges between vertices


    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms){
        if(synsets == null || hypernyms == null)
            throw new java.lang.IllegalArgumentException();
        // Process data files
        processSynsets(synsets);
        processHypernyms(hypernyms);
    }

    private void processHypernyms(String hypernym) {
        In in = new In(hypernym);
        String line = null;
        ArrayList<Integer> edgeList;
        while ((line = in.readLine()) != null) {
            if (line.equals("")) {	continue;	}
            // split line
            String[] lineElements = line.split(",");
            if (edges.get(Integer.parseInt(lineElements[0])) != null) {
                edgeList = edges.get(Integer.parseInt(lineElements[0]));
            } else {
                edgeList = new ArrayList<Integer>();
            }
            for (int i = 1; i < lineElements.length; i++) {
                edgeList.add(Integer.parseInt(lineElements[i]));
            }
            edges.put(Integer.parseInt(lineElements[0]), edgeList);
        }
    }

    private void processSynsets(String synsets) {
        In in = new In(synsets);
        String line = null;
        ArrayList<Integer> currentNounsList = null;
        String currentSynsetNouns = null;

        while ((line = in.readLine()) != null) {
            if (line.equals("")) {	continue;	}
            String[] lineElements = line.split(","); // split line
            String[] nouns = lineElements[1].split(" "); // get the second field
            int synsetId = Integer.parseInt(lineElements[0]);
            for (String noun : nouns) {
                // check if noun exists in list
                if (this.nouns.containsKey(noun)) {
                    currentNounsList = this.nouns.get(noun);
                } else {
                    currentNounsList = new ArrayList<Integer>();
                }
                // check if synsetId exists in list
                if (this.synsets.containsKey(synsetId)) {
                    currentSynsetNouns = this.synsets.get(synsetId);
                } else {
                    currentSynsetNouns = new String();
                }
                currentNounsList.add(synsetId);
                currentSynsetNouns = lineElements[1];
                this.nouns.put(noun, currentNounsList);
                this.synsets.put(synsetId, currentSynsetNouns);
            }
            //this.graphLength++;
        }
    }

    // returns all WordNet nouns
    public Iterable<String> nouns(){

    }

    // is the word a WordNet noun?
    public boolean isNoun(String word){

    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB){
        if(!isNoun(nounA) || !isNoun(nounB))
            throw new java.lang.IllegalArgumentException();

    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB){
        if(!isNoun(nounA) || !isNoun(nounB))
            throw new java.lang.IllegalArgumentException();
    }

    // do unit testing of this class
    public static void main(String[] args){

    }
}
