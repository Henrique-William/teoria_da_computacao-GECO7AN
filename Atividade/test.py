import random
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

# Parâmetros do algoritmo genético
POP_SIZE = 100
GENERATIONS = 500
MUTATION_RATE = 0.1

# Função de avaliação (fitness) - soma total das distâncias de um caminho
def calculate_distance(path):
    distance = 0
    for i in range(len(path)):
        distance += distances[path[i]][path[(i+1) % len(path)]]  # retorno ao início incluso
    return distance

# Inicializar população com caminhos aleatórios
def init_population(size, num_cities):
    population = []
    for _ in range(size):
        path = list(range(num_cities))
        random.shuffle(path)
        population.append(path)
    return population

# Seleção: Torneio binário
def selection(population):
    return min(random.sample(population, 2), key=calculate_distance)

# Cruzamento: Order Crossover (OX)
def crossover(parent1, parent2):
    size = len(parent1)
    start, end = sorted(random.sample(range(size), 2))
    child = [None]*size
    child[start:end] = parent1[start:end]
    
    ptr = end
    for gene in parent2:
        if gene not in child:
            if ptr >= size:
                ptr = 0
            child[ptr] = gene
            ptr += 1
    return child

# Mutação: Troca de duas cidades
def mutate(path):
    if random.random() < MUTATION_RATE:
        i, j = random.sample(range(len(path)), 2)
        path[i], path[j] = path[j], path[i]
    return path

# Algoritmo Genético
def genetic_algorithm():
    start_time = time.time()
    population = init_population(POP_SIZE, len(cities))
    best_path = min(population, key=calculate_distance)
    
    for _ in range(GENERATIONS):
        new_population = []
        for _ in range(POP_SIZE):
            parent1 = selection(population)
            parent2 = selection(population)
            child = crossover(parent1, parent2)
            child = mutate(child)
            new_population.append(child)
        
        population = new_population
        current_best = min(population, key=calculate_distance)
        if calculate_distance(current_best) < calculate_distance(best_path):
            best_path = current_best

    end_time = time.time()
    total_km = calculate_distance(best_path)
    total_reais = total_km * 0.85
    exec_time = round(end_time - start_time, 6)

    return best_path, total_km, total_reais, exec_time

# Executar
best_path, total_km, total_reais, exec_time = genetic_algorithm()

# Nomear cidades
named_path = [cities[i] for i in best_path]
named_path.append(named_path[0])  # retorno à cidade inicial

# Exibir resultado
print("Melhor rota encontrada (Algoritmo Genético):")
for i in range(len(named_path) - 1):
    print(f"{named_path[i]} -> {named_path[i + 1]}")
print(f"\nDistância total: {total_km} km")
print(f"Custo total: R$ {total_reais:.2f}")
print(f"Tempo de execução: {exec_time} segundos")
