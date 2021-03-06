package com.text.analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpURLConnectionExample {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        HttpURLConnectionExample http = new HttpURLConnectionExample();

        String wordToSearch = "geometry";

        http.searchSynonym(wordToSearch);
        getSynonyms(wordToSearch);
    }



    private void searchSynonym(String wordToSearch) throws Exception {
        System.out.println("Sending request...");

        String url = "https://api.datamuse.com/words?rel_syn=" + wordToSearch;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending request to: " + url);
        System.out.println("JSON Response: " + responseCode + "\n");

        // ordering the response
        StringBuilder response;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            // converting JSON array to ArrayList of words
            ArrayList<Word> words = mapper.readValue(
                response.toString(),
                mapper.getTypeFactory().constructCollectionType(ArrayList.class, Word.class)
            );

            System.out.println("Synonym word of '" + wordToSearch + "':");
            if(words.size() > 0) {
                for(Word word : words) {
                    System.out.println((words.indexOf(word) + 1) + ". " + word.getWord() + "");
                }
            }
            else {
               System.out.println("none synonym word!");
            }
        }
        catch (IOException e) {
            e.getMessage();
        }
    }
    
    public static String[] getSynonyms(String wordInput) {
        String[] resultArray = {};
        if (wordInput.equals("")) {
            return resultArray;
        }
        try {
            URL url = new URL("https://www.thesaurus.com/browse/" + wordInput);
            URLConnection yc = url.openConnection();
            String foundWords;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()))) {
                String inputLine;
                foundWords = "";
                boolean foundListStart = false;
                while ((inputLine = in.readLine()) != null) {
                    String iLine = inputLine.trim();
                    if (iLine.equals("<div class=\"relevancy-list\">")) {
                        foundListStart = true;
                    }
                    if (foundListStart) {
                        if (iLine.equals("</div>")) {
                            foundListStart = false;
                            break;
                        }
                        if (iLine.startsWith("<li><a href=")) {
                            String[] codeLines = iLine.split(" ");
                            int index = codeLines[1].lastIndexOf('/');
                            String word = codeLines[1].substring(index + 1, codeLines[1].length());
                            word = word.replace("%27", "'").replace("%20", " ").replace("\"", "");
                            if (foundWords.equals("")) {
                                foundWords += word;
                            } else {
                                foundWords += "," + word;
                            }
                        }
                    }
                }
            }
            // Convert built comma delimited string to String Array
            if (!foundWords.equals("")) {
                resultArray = foundWords.split(",");
            }
        } catch (MalformedURLException ex) {
            // Do what you want with exception
            ex.printStackTrace();
        } catch (IOException ex) {
            // Do what you want with exception
            ex.printStackTrace();
        }
        return resultArray;
    }

    // word and score attributes are from DataMuse API
    static class Word {
        private String word;
        private int score;

        public String getWord() {return this.word;}
        public int getScore() {return this.score;}
    }
}