import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.similarity.precompute.example.GroupLensDataModel;
import java.io.File;
import java.util.List;

public class UserCF {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\ASUS\\Desktop\\movies\\ml-10M100K\\ratings.dat");

        DataModel dataModel = new GroupLensDataModel(file);

        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);

        UserNeighborhood neighborhood = new NearestNUserNeighborhood(100,similarity,dataModel);

        Recommender recommender = new GenericUserBasedRecommender(dataModel,neighborhood,similarity);

        List<RecommendedItem> list = recommender.recommend(5,10);

        for (RecommendedItem item : list){
            System.out.println(item);
        }








    }

}
