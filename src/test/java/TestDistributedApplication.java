import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestDistributedApplication {

    public static void getFileLocations() {
        HttpResponse<String> result = null;
        try {
            result = Unirest.get("http://localhost:8080/admin/filelocations")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        String str = result.getBody();
        System.out.println();
        System.out.println(str);
        System.out.println();
    }

    public static void reset() {
        HttpResponse<String> result = null;
        try {
            result = Unirest.get("http://localhost:8080/admin/flush")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        String str = result.getBody();
        System.out.println(str);
    }

    public static Client[] makeClients(int n){
        Client[] res = new Client[n];
        for(int i = 0; i < n; i ++){
            res[i] = new Client(i);
        }
        return res;
    }

    public static void Test1(){
        reset();
        Client[] clients = makeClients(2);
        clients[0].write("file1", "2");
    }

    public static void main(String[] args){
        Test1();
    }

}