import br.com.connectapi.models.coinConverter.Coin;
import br.com.connectapi.models.filme.Filme;
import br.com.connectapi.models.receitasMeal.Comida;

public class App {
    public static void main(String[] args) throws Exception {
        Filme filme = new Filme("the+matrix");
        System.out.println(filme);
        System.out.println();
        
        Coin moeda = new Coin("usd");
        System.out.println(moeda);
        System.out.println();
        
        Comida comida = new Comida("Arrabiata");
        System.out.println(comida);
        System.out.println();

        
    }
}
