import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GitHubApp {
    public static void main(String[] args) {
        // Inicializar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Scanner scanner = new Scanner(System.in);

        // Getting a GitHub Username from the Console
        System.out.print("Enter GitHub username: ");
        String username = scanner.nextLine();

        // Get a list of the user's repositories
        Call<List<Repo>> reposCall = service.listRepos(username);

        try {
            // Get warehouse information and print it
            Response<List<Repo>> reposResponse = reposCall.execute();
            if (reposResponse.isSuccessful()) {
                List<Repo> repos = reposResponse.body();
                System.out.println("Repositories:");
                if (repos != null) {
                    for (Repo repo : repos) {
                        System.out.println(repo);
                    }
                }
            } else {
                System.out.println("Failed to fetch repositories for user: " + username);
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while fetching data from GitHub.");
        }
    }
}
