lista_glicemica = []
nome_arquivo = 'glicemia.txt'

lista_dicionarios_glicemica = []

with open(nome_arquivo, 'r', encoding='utf8') as leitor:
    for linha in leitor:
        valor, data, hora = linha.split(',')
        dados = {
            "valor": int(valor),
            "data": data,
            "hora": hora
        }
        if dados not in lista_dicionarios_glicemica:
                lista_dicionarios_glicemica.append(dados)


def calcular_media(lista):
        soma = 0
        for item in lista:
            soma += int(item["valor"])

        return int(soma/len(lista))

def calcular_mediana(lista):
     valores_ordenados = sorted([item["valor"] for item in lista])
     n = len(valores_ordenados)
     meio = n//2

     if n%2!=0:
          return valores_ordenados[meio]
     else:
          v1 = valores_ordenados[meio-1]
          v2 = valores_ordenados[meio]
          return (v1 + v2)/2


print('Quantidade de dados lidos:', len(lista_dicionarios_glicemica))
for item in lista_dicionarios_glicemica:
    print(item)


media = calcular_media(lista_dicionarios_glicemica)
mediana = calcular_mediana(lista_dicionarios_glicemica)

print(f'Media de Glicemia: {media:.2f}')
print(f'Mediana de glicemia: {mediana:.2f}')
