
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.List;

public interface GitHubService {
    @GET("users/{username}/repos")
    Call<List<Repo>> listRepos(@Path("username") String username);
}

