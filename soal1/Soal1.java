import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Soal1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Team Name: ");
        String teamName = sc.nextLine();
        System.out.print("Year: ");
        String year = sc.nextLine();

        int totalGoal1 = getTotalGoal(teamName, year, true);
        int totalGoal2 = getTotalGoal(teamName, year, false);
        System.out.println("\nTotal Goals oleh " + teamName + " di tahun " + year + " di Team 1: " + totalGoal1);
        System.out.println("Total Goals oleh " + teamName + " di tahun " + year + " di Team 2: " + totalGoal2);
        System.out.println("\nTotal Goals oleh " + teamName + " di tahun " + year + ": " + (totalGoal1 + totalGoal2));

        sc.close();
    }

    public static Integer getTotalGoal(String teamName, String year, boolean isTeamA) {
        int totalGoal = 0;
        String team = "";
        String teamGoal = "";

        if (isTeamA) {
            team = "&team1=";
            teamGoal = "team1goals";
        } else {
            team = "&team2=";
            teamGoal = "team2goals";
        }

        try {
            String apiUrlFirst = "https://jsonmock.hackerrank.com/api/football_matches?year="
                    + year + team + teamName + "&page=1";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requestFirst = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrlFirst))
                    .build();

            HttpResponse<String> responseFirst = client.send(requestFirst, HttpResponse.BodyHandlers.ofString());

            // Parse JSON response
            JsonObject jsonObject = JsonParser.parseString(responseFirst.body()).getAsJsonObject();

            // Ambil field total_pages
            int totalPages = jsonObject.get("total_pages").getAsInt();

            // Loop semua halaman berdasarkan total pages
            for (int page = 1; page <= totalPages; page++) {
                String apiUrl = "https://jsonmock.hackerrank.com/api/football_matches?year="
                        + year + team + teamName + "&page=" + page;

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(apiUrl))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                JsonObject pageJson = JsonParser.parseString(response.body()).getAsJsonObject();

                // Ambil array "data"
                JsonArray dataArray = pageJson.getAsJsonArray("data");

                // Loop tiap objek dalam data[]
                for (JsonElement element : dataArray) {
                    JsonObject match = element.getAsJsonObject();
                    int goals = match.get(teamGoal).getAsInt();
                    totalGoal += goals;
                }
            }

        } catch (Exception e) {
            System.out.println("Terjadi error: " + e.getMessage());
        }

        return totalGoal;
    }
}