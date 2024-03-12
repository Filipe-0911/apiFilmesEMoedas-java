import br.com.connectapi.models.coinConverter.Coin;
import br.com.connectapi.models.filme.Filme;

public class App {
    public static void main(String[] args) throws Exception {
        Filme filme = new Filme("the+matrix");
        System.out.println(filme);

        Coin moeda = new Coin("usd");
        System.out.println(moeda);

        
    }
}
