import random

def gerar_matriz(linhas, colunas, inicio):
    matriz = []
    for i in range(linhas):
        linha = []
        for j in range(colunas):
            if (i, j) == inicio:
                linha.append(0)
            else:
                linha.append(1 if random.random() < 0.3 else 0)
        matriz.append(linha)

    while True:
        x = random.randint(0, linhas - 1)
        y = random.randint(0, colunas - 1)
        if (x, y) != inicio and matriz[x][y] == 0:
            final = (x, y)
            break

    return matriz, final

def posicao_valida(matriz, visitado, x, y):
    return (0 <= x < len(matriz) and 0 <= y < len(matriz[0]) and
            matriz[x][y] == 0 and not visitado[x][y])

def encontrar_melhor_caminho(matriz, inicio, fim):
    linhas, colunas = len(matriz), len(matriz[0])
    visitado = [[False] * colunas for _ in range(linhas)]
    melhor_caminho = {"tamanho": float("inf"), "caminho": []}

    def backtrack(x, y, caminho):
        if len(caminho) >= melhor_caminho["tamanho"]:
            return
        if (x, y) == fim:
            melhor_caminho["tamanho"] = len(caminho)
            melhor_caminho["caminho"] = caminho[:]
            return

        visitado[x][y] = True
        direcoes = [(1,0), (0,1), (-1,0), (0,-1)]
        for dx, dy in direcoes:
            nx, ny = x + dx, y + dy
            if posicao_valida(matriz, visitado, nx, ny):
                caminho.append((nx, ny))
                backtrack(nx, ny, caminho)
                caminho.pop()
        visitado[x][y] = False

    backtrack(inicio[0], inicio[1], [inicio])
    return melhor_caminho

def main():
    linhas = int(input("Digite o número de linhas: "))
    colunas = int(input("Digite o número de colunas: "))

    while True:
        x_inicial = int(input("Digite a linha da posição inicial: "))
        y_inicial = int(input("Digite a coluna da posição inicial: "))
        
        if 0 <= x_inicial < linhas and 0 <= y_inicial < colunas:
            break
        else:
            print("❌ Posição inicial fora dos limites da matriz. Tente novamente.\n")

    inicio = (x_inicial, y_inicial)
    matriz, fim = gerar_matriz(linhas, colunas, inicio)

    print("\nMatriz gerada:")
    for i in range(linhas):
        linha_formatada = []
        for j in range(colunas):
            if (i, j) == inicio:
                linha_formatada.append("I")
            elif (i, j) == fim:
                linha_formatada.append("F")
            else:
                linha_formatada.append(str(matriz[i][j]))
        print(" ".join(linha_formatada))

    melhor = encontrar_melhor_caminho(matriz, inicio, fim)

    if melhor["tamanho"] == float("inf"):
        print("\n❌ Não há caminho possível.")
    else:
        print("\n✅ Melhor caminho encontrado ({} passos):".format(melhor["tamanho"]))
        for passo in melhor["caminho"]:
            print(passo)
            
        print("\nNome: Henrique William Oliveira da Silva ---- RA: 220021662\nNome: João V. Cardoso de Souza -------------- RA: 210018674\nNome: Larissa Motta Carrara ----------------- RA: 220019902\nNome: Matheus Duarte ------------------------ RA: 220020531\nNome: Matheus Henrique de Oliveira ---------- RA: 220019916")
        
if __name__ == "__main__":
    main()