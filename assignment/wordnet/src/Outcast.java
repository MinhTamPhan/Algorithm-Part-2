/**
 * Created by MinhTam on  5/19/2018.
 */
public class Outcast {
    private WordNet worknet;

    public Outcast(WordNet wordnet) {
        this.worknet = wordnet;
    }

    public String outcast(String[] nouns) {
        String outcast = null;
        int max = 0;
        for(String noun : nouns) {
            int distance = 0;
            for(String noun2 : nouns) {
                if(noun != noun2) {
                    distance += this.worknet.distance(noun, noun2);
                }
            }
            if(distance > max) {
                max = distance;
                outcast = noun;
            }
        }
        return outcast;
    }
}
