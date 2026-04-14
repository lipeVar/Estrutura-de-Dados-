from dado import Dado

def inicializar_matriz(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            matriz[i][j] = 0

def exibir_matriz(matriz):
    for linha in matriz:
        for valor in linha:
            print(valor, end="\t")
        print()

def converter_matriz_lista(matriz):
    lista = []

    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            if matriz[i][j] != 0:
                lista.append(Dado(matriz[i][j], i, j))
    return lista

def exibir_lista(lista):
    for item in lista:
        print(item)

    print("------------------------------------")
    print("Total de elementos não nulos:", len(lista))