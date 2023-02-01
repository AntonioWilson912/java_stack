import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Without You", "I can't breathe.");
        trackList.put("Teen Titans", "When there's trouble, you know who to call.");
        trackList.put("Best Day Ever", "Mr. Sun came up, and he smiled at me.");
        trackList.put("Lane Boy", "They say, 'Stay in your lane, boy.'");

        String lyrics = trackList.get("Teen Titans");
        System.out.println("Lyrics for Teen Titans: " + lyrics);

        Set<String> trackNames = trackList.keySet();
        for (String trackName : trackNames) {
            System.out.println(trackName + ": " + trackList.get(trackName));
        }
    }
}
