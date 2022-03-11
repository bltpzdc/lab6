public class TestMain {
    public static void main(String[] args){
        /*var env = System.getenv();
        File fileName = new File(env.get("PROCESSOR_ARCHITECTURE") + ".json");
        List<String> filesLines = new ArrayList<>();
        try {
            String jsonHelper;
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while((jsonHelper = reader.readLine())!=null){
                filesLines.add(jsonHelper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json="";
        for (String i:filesLines){
            json+=i;
        }
        Gson gson = new GsonBuilder()
                .setDateFormat("dd/MM/yyyy").create();
        Type movieTypes = new TypeToken<CustomVector<Movie>>(){}.getType();
        CustomVector<Movie> movieList /*= new CustomVector<Movie>() ;
        movieList = gson.fromJson(json, movieTypes);
        Collections.sort(movieList);
        Invoker invoker = new Invoker(new HelpCommand(), new InfoCommand(movieList), new ShowCommand(movieList), new AddCommand(movieList));
        //invoker.help();
        //invoker.info();
        //invoker.show();
        invoker.add();
        invoker.info();
        //System.out.println(movieList);*/
    }
}
