import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unrecognized attributes
public class Repo {

    String name;
    String description;
    int stargazers_count;

    @Override
    public String toString() {
        return "Repo Name: " + name + "\nDescription: " + (description != null ? description : "No description") +
                "\nStars: " + stargazers_count + "\n";
    }
}
