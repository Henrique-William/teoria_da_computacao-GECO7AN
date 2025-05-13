custos = [{'custo': 5, 'medalhas': 10}, {'custo': 3, 'medalhas': 6}, {'custo': 2, 'medalhas': 3}]
custos_sorted = sorted(custos, key=lambda item: item['custo'], reverse=True)

orcamento = 8
atual_orcamento = orcamento
soma_total_medalhas = 0

for item in custos_sorted:
    custo_item = item['custo']
    if custo_item <= atual_orcamento:
        atual_orcamento = atual_orcamento - custo_item
        medalhas_item = item['medalhas']
        soma_total_medalhas += medalhas_item
        print(f"Custo: {custo_item}, Medalhas Adicionadas: {medalhas_item}, Novo Orçamento: {atual_orcamento}")

print(f"\nSoma Total de Medalhas Adquiridas: {soma_total_medalhas}")