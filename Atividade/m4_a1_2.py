def selecionar_atividades(atividades):
    atividades_ordenadas = sorted(atividades, key=lambda x: x[1])
    
    atividades_selecionadas = []
    fim_ultima = -1
    
    for inicio, fim in atividades_ordenadas:
        if inicio >= fim_ultima:
            atividades_selecionadas.append((inicio, fim))
            fim_ultima = fim
    
    return atividades_selecionadas


atividades = [(1, 4), (3, 5), (0, 6), (5, 7), (8, 9), (5, 9)]

nome = "Henrique William Oliveira da Silva"
ra = "220021662"
print(f"\nNome: {nome} - RA: {ra}")

resultado = selecionar_atividades(atividades)
print("Atividades selecionadas:", resultado)
