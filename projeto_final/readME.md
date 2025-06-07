# Objetivo

<p style="text-align: justify;">
    Desenvolver um algoritmo que encontre o menor caminho possível em um labirinto gerado aleatoriamente, respeitando as regras de movimentação (cima, baixo, esquerda, direita), e evitando paredes. A solução precisa aplicar backtracking e pode combinar com outros paradigmas como programação dinâmica, força bruta ou algoritmos gulosos.
</p>

# Algoritmos Utilizados

<ul>
    <li><b>Backtracking</b></li>
    <p style="text-align: justify;">
        Backtracking é uma técnica de exploração de todos os caminhos possíveis, retornando quando um caminho inválido é encontrado. Neste projeto, utilizamos a lógica de backtracking de forma implícita ao rastrear os pais de cada célula visitada na matriz. Isso nos permite reconstruir o caminho completo de trás para frente, o que caracteriza o uso da técnica de "voltar e explorar outras possibilidades", ou seja, backtracking aplicado de forma iterativa.
    </p>
</ul>
<ul>
    <li style="text-align: justify;"><b> Busca Gulosa com BFS (Busca em Largura) </b></li>
    <p style="text-align: justify;">
        A busca principal do algoritmo foi implementada utilizando BFS (Breadth-First Search), que é uma abordagem gulosa para encontrar o menor caminho em grafos não ponderados (como o labirinto). O algoritmo expande os nós em camadas, garantindo que o primeiro caminho encontrado para o destino seja o mais curto.
    </p>
</ul>

# Por que não usar somente o Backtracking?

<p style="text-align: justify;">
     Em versões anteriores do código, o backtracking foi implementado de forma recursiva pura, mas isso causou estouro de pilha  ao processar labirintos grandes (ex: 100x100), o que compromete a viabilidade da solução. Para manter a corretude, desempenho e respeitar as limitações do Python, optamos por uma abordagem iterativa mais eficiente com a lógica de backtracking preservada por meio de registro dos caminhos visitados.
</p>

# Benefícios da Solução Final

<ul>
    <li><b>Rapidez: </b>encontra soluções em milissegundos para matrizes grandes.</li>
    <li><b>Completude: </b>garante sempre o menor caminho possível se existir.</li>
    <li><b>Evita erros de stack overflow: </b>solução iterativa é segura para qualquer tamanho de entrada.</li>
    <li><b>Simples de entender e manter: </b>o código é claro e direto separado por funções bem definidas.</li>
</ul>