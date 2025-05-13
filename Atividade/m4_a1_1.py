# Nome: Henrique William Oliveira da Silva
# RA: 220021662

def calcular_troco(valor):
    moedas = [1.00, 0.50, 0.25, 0.10, 0.05, 0.01]
    troco = round(valor, 2) 
    resultado = []

    for moeda in moedas:
        quantidade = int(troco // moeda)
        if quantidade > 0:
            resultado.append((quantidade, moeda))
            troco = round(troco - quantidade * moeda, 2) 

    return resultado

nome = "Henrique William Oliveira da Silva"
ra = "220021662"
valor_troco = float(input("Digite o valor do troco: R$"))

resultado = calcular_troco(valor_troco)
print(f"\nNome: {nome} - RA: {ra}")
print(f"Troco para R${valor_troco:.2f}:")
for qtd, moeda in resultado:
    print(f"{qtd} moeda(s) de R${moeda:.2f}")