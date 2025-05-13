import heapq
import time

# Lista de cidades
cities = ["Campinas", "Ribeirão Preto", "Barrinha", "Bocaina", "Pitangueiras", "Taquaral", "Santana", "Jaboticabal"]

# Matriz de distâncias
distances = [
    [0,   223, 248, 209, 273, 273, 92,  253],
    [223, 0,   38,  143, 52,  85,  312, 57 ],
    [248, 38,  0,   140, 43,  46,  337, 19 ],
    [209, 143, 140, 0,   159, 146, 297, 127],
    [273, 52,  43,  159, 0,   29,  363, 33 ],
    [273, 85,  46,  146, 29,  0,   361, 24 ],
    [92,  312, 337, 297, 363, 361, 0,   340],
    [253, 57,  19,  127, 33,  24,  340, 0  ]
]

def prim_mst(dist_matrix):
    start_time = time.time()
    n = len(dist_matrix)
    visited = [False] * n
    min_heap = [(0, 0)]  # (cost, city)
    mst_cost = 0
    mst_edges = []
    prev_city = -1  # Inicia com um valor inválido

    while min_heap:
        cost, u = heapq.heappop(min_heap)
        if visited[u]:
            continue
        visited[u] = True
        mst_cost += cost
        if cost != 0:  # Ignora o custo da primeira cidade, que é 0
            mst_edges.append((prev_city, u, cost))

        for v in range(n):
            if not visited[v]:
                heapq.heappush(min_heap, (dist_matrix[u][v], v))
        prev_city = u

    # Conectar a última cidade de volta à cidade inicial
    first_city = 0  # Cidade inicial
    last_city = prev_city
    return_cost = dist_matrix[last_city][first_city]
    mst_edges.append((last_city, first_city, return_cost))
    mst_cost += return_cost

    end_time = time.time()
    total_cost_reais = mst_cost * 0.85
    return mst_edges, mst_cost, total_cost_reais, round(end_time - start_time, 6)

mst_edges, mst_km, mst_cost_reais, mst_time = prim_mst(distances)

mst_edges_named = [(cities[u], cities[v], d) for u, v, d in mst_edges]
mst_edges_named, mst_km, mst_cost_reais, mst_time

print("Árvore Geradora Mínima (MST) com retorno à cidade inicial:")
for edge in mst_edges_named:
    print(f"{edge[0]} - {edge[1]}: {edge[2]} km")
print(f"\nCusto total da MST: {mst_km} km")
print(f"Custo total em reais: R$ {mst_cost_reais:.2f}")
print(f"Tempo de execução: {mst_time} segundos")
