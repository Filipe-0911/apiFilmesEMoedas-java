## Conexões com API OMDb, TheMealDb e ExchangeGenerate

Fiz este projeto para treinar conexões com APIs utilizando a linguagem Java.
Nele, ao receber a resposta da API, utilizei a lib jackson para manipular a resposta JSON da API.

## Folder Structure

O workspace contém 2 pastas por padrão, onde:

- `src`: contém os arquivos fonte;
- `lib`: contém as bibliotecas externas utilizadas no projeto (Jackson);
- `br/com/conectaapi`: contém as pastas principais do projeto tais como: interfaces, models, ConexaoAPis, filme e receitasMeal;
- `br/com/conectaapi/interfaces`: contém as duas interfaces utilizadas no projeto, uma para as conexoes com as APIs e outras para as classes Filme, Comida e Coin;
- `br/com/conectaapi/models`: contém as classes utilizadas no projeto separadas por outras 4 pastas;
- `br/com/conectaapi/models/coinConverter`: contém as classes relativas à criação de comparações da moeda escolhida com o real;
- `br/com/conectaapi/models/ConexaoAPis`: contém as classes relativas à criação de conexões com as API's;
- `br/com/conectaapi/models/filme`: contém as classes relativas à criação de filmes;
- `br/com/conectaapi/models/receitasMeal`: contém as classes relativas à criação de receitas;


Enquanto isso, os arquivos de saída compilados serão gerados na pasta `bin` por padrão.