def mochila_gulosa(itens, capacidade):
    itens_ordenados = sorted(itens, key=lambda x: x['valor']/x['peso'], reverse=True)
    
    peso_total = 0
    valor_total = 0
    itens_selecionados = []

    for item in itens_ordenados:
        if peso_total + item['peso'] <= capacidade:
            itens_selecionados.append(item['nome'])
            peso_total += item['peso']
            valor_total += item['valor']

    return itens_selecionados, peso_total, valor_total

itens = []
capacidade = float(input("Capacidade da mochila (kg): "))
n = int(input("Quantos itens deseja cadastrar? "))

for _ in range(n):
    nome = input("Nome do item: ")
    peso = float(input(f"Peso do item {nome}: "))
    valor = float(input(f"Valor do item {nome}: "))
    itens.append({"nome": nome, "peso": peso, "valor": valor})

selecionados, peso_final, valor_final = mochila_gulosa(itens, capacidade)

print("\nItens selecionados:", selecionados)
print("Peso total:", peso_final)
print("Valor total:", valor_final)
