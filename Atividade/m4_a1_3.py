capacidade = 50
cidade_atual = 'A'
cidades = [
    {'nome': 'B', 'distancia': 10, 'peso': 10, 'valor': 60},
    {'nome': 'C', 'distancia': 15, 'peso': 20, 'valor': 100},
    {'nome': 'D', 'distancia': 5,  'peso': 30, 'valor': 120},
    {'nome': 'E', 'distancia': 20, 'peso': 10, 'valor': 40}
]

for cidade in cidades:
    cidade['valor_por_kg'] = cidade['valor'] / cidade['peso']

entregas = []
peso_total = 0

while True:
    opcoes_validas = [c for c in cidades if c['peso'] + peso_total <= capacidade]

    if not opcoes_validas:
        break

    opcoes_validas.sort(key=lambda x: (x['distancia'], -x['valor_por_kg']))

    melhor = opcoes_validas[0]
    entregas.append(melhor['nome'])
    peso_total += melhor['peso']
    cidades.remove(melhor)

nome = "Henrique William Oliveira da Silva"
ra = "220021662"
print(f"\nNome: {nome} - RA: {ra}")
print("Ordem de entrega:", ' -> '.join(entregas))