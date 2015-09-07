import com.wanikani.api.WaniKaniClient;
import com.wanikani.api.model.UserInformation;

public class Application {

  public static void main(String[] args) {
    WaniKaniClient client = new WaniKaniClient("4324c48c718adea16f77d23ae280d1d8");
    UserInformation info = client.getUserInformation();

    System.out.println(info.getUsername() + " was created on " + info.getCreationDate());
//    System.out.println(client.getStudyQueue());
//    System.out.println(client.getLevelProgression());
//    System.out.println(client.getSrsDistribution());
//    System.out.println(client.getRecentUnlocks());
//    System.out.println(client.getCriticalItems());
//    System.out.println(client.getRadicals());
//    System.out.println(client.getKanji());
//    System.out.println(client.getVocabulary());
//    System.out.println(client.getVocabulary(30));
  }
}
